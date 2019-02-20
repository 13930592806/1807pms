package com.zs.pms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.dao.UserDao;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.Tuser;
import com.zs.pms.service.UserService;
import com.zs.pms.util.MD5;
import com.zs.pms.vo.QueryUser;

@Service
@Transactional
public class UserServiceimpl implements UserService {
	@Autowired
	UserDao dao;
	@Override
	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("hello spring");
	}

	@Override
	public List<TPermission> queryByUid(int id) {
		// TODO Auto-generated method stub
		return dao.queryByUid(id);
	}

	@Override
	public List<TPermission> genMenu(List<TPermission> pers) {
		// TODO Auto-generated method stub
		// 创建新容器
		List<TPermission> list = new ArrayList<TPermission>();
		// 遍历权限列表
		for (TPermission per : pers) {
			// 一级菜单
			if (per.getLev() == 1) {
				// 加载改一级菜单下的二级菜单
				// 遍历
				for (TPermission per2 : pers) {
					// 二级权限的上级id=一级id
					if (per2.getPid() == per.getId()) {
						// 添加子权限
						per.addChild(per2);
					}
				}
				// 加到新的集合中
				list.add(per);
			}
		}
		return list;
	}
	@Override
	public List<Tuser> queryByCon(QueryUser query){
		return dao.queryByCon(query);
		
	}
	@Override
	public void deleteByIds(int [] ids) {
		dao.deleteByIds(ids);
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateUser(Tuser user) {
		// TODO Auto-generated method stub
		int q=1/0;
		dao.updateUser(user);
	}


	@Override
	//该方法只有有异常就回滚
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(Tuser user)throws AppException {
		//模拟业务异常
		if ("admin".equals(user.getLoginname())) {
			throw new AppException(1003,"登录名不能是admin");
		}
		MD5 md5=new MD5();
		user.setPassword(md5.getMD5ofStr(user.getPassword()));
		//新增
		dao.insertUser(user);
		//int a=1/0;//产生异常
		//dao.insertUser(user);
		//返回主键
		return user.getId();
	}
	@Override
	/**
	 * 获得分页记录
	 * page：当前页
	 * query:查询条件
	 */
	public List<Tuser>queryByPage(int page,QueryUser query){
		/*
		 * 通过当前页计算起始数和截至数
		 */
		//起始数从一开始
		int start =(page-1)*com.zs.pms.util.Constants.PAGECONT-1;
		//截止数
		int end=page*com.zs.pms.util.Constants.PAGECONT;
		
		query.setStart(start);
		query.setEnd(end);
		
		return dao.queryByPage(query);
		
	}
	//计算总页数
	public int queryPageCont(QueryUser query) {
		//通过总条数计算总页数
		int cont=dao.queryCount(query);
		//能整除
		if (cont%com.zs.pms.util.Constants.PAGECONT==0) {
			return cont/com.zs.pms.util.Constants.PAGECONT;
		}else {
			return cont/com.zs.pms.util.Constants.PAGECONT+1;
		}
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	@Override
	public Tuser queryById(int id) {
		return dao.queryById(id);
	}
}
