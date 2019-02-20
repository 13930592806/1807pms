package com.zs.mvc.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.awt.geom.CubicCurve2D;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.mvc.Bean.UserBean;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.Tuser;
import com.zs.pms.service.UserService;
import com.zs.pms.util.MD5;
import com.zs.pms.vo.QueryUser;

/**
 * 控制器
 * @author 孟珏
 *
 */
@Controller//表示是一个控制器
public class LoginController {
		
	@Autowired
	UserService us;
	
	//去登录页
		@RequestMapping("/tologin.do")
		public String toLogin() {
			return "login";
		}
		//主页
		@RequestMapping("/login.do")
		public String Login(com.zs.pms.vo.QueryLogin login,HttpSession session) {
			//1、验证验证码
				String ocode=(String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			//生成的验证码和页面的验证码不相等
				if (!ocode.equals(login.getChkcode())) {
					model().attribute("MSG", "验证码写错了笨蛋！");
					return "login";
				}
			//2、验证账号和密码
			//装载数据
				
				QueryUser query=new QueryUser();
				query.setLoginname(login.getUsername());//登录名
				//MD5加密
				MD5 md5=new MD5();
				query.setPassword(md5.getMD5ofStr(login.getPassword()));//密码
				query.setIsenabled(1);//设置可用
				//返回登陆的用户
				List<Tuser> users=us.queryByCon(query);
				//登陆失败
				if (users==null||users.size()!=1) {
					model().attribute("MSG", "仔细看看用户名和密码哪个写错了，猪！");
					return "login";
				}
			
			
			//登陆成功装session
				session.setAttribute("CUSER", users.get(0));
			return "main";//去主界面
		}
		//顶端
		@RequestMapping("/top.do")
		public String toTop(ModelMap model) {
			//将当前时间返回页面
			return "top";
		}
		
		//菜单
		@RequestMapping("/menu.do")
		public String left(HttpSession session,ModelMap model) {
			//获得当前登陆用户
			Tuser cu=(Tuser)session.getAttribute("CUSER");
			//获得该用户的权限l列表
			List<TPermission> list1=us.queryByUid(cu.getId());
			//返回菜单
			model.addAttribute("MENU",us.genMenu(list1));
			return "menu";
		}
		//起始页
		@RequestMapping("/main.do")
		public String Main() {
			return "left";
		}
}
