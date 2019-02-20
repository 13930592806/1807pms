package com.zs.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.Tuser;
import com.zs.pms.service.DepService;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

import freemarker.core.Macro;

@Controller
public class UserController {
@Autowired
UserService us;
@Autowired
DepService ds;

@RequestMapping("/user/toadd.do")
public String toAdd(ModelMap map) {
//返回一级部门
	map.addAttribute("DLIST",ds.queryByPid(0));
	return "user/add";
}
public String list(String page,QueryUser query,ModelMap map) {
	
	if(page==null) {
		page="1";
	}
	//返回分页数据
	map.addAttribute("LIST",us.queryByPage(Integer.parseInt(page), query));
	//返回总页数
	map.addAttribute("PAGECONT",us.queryPageCont(query));
	//当前页数
	map.addAttribute("PAGE",page);
	//条件
	map.addAttribute("QUERY", query);
	return "user/user_list";
}
@RequestMapping("/user/add.do")
public String Add(Tuser user,HttpSession session,ModelMap map) throws AppException {
	Tuser cu=(Tuser)session.getAttribute("CUSER");
//装载数据
user.setIsenabled(1);//可用
user.setCreator(cu.getId());//新增人
user.setpic("");
us.insertUser(user);
//跳转url
return "redirect:list.do";
}
@RequestMapping("/user/delete.do")
public String delete(int id) {
	us.deleteById(id);;
	//跳转url
	return "redirect:list.do";
}
public String get(int id,ModelMap map) {
	//返回用户信息
	map.addAttribute("USER",us.queryById(id));
	//返回一级部门
	map.addAttribute("DLIST", ds.queryByPid(0));
	return "/user/update";
}
}