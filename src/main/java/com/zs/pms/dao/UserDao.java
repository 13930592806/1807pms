package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TPermission;
import com.zs.pms.po.Tuser;
import com.zs.pms.vo.QueryUser;

public interface UserDao {
	//根据用户id获得权限列表
	public List<TPermission> queryByUid(int id);
	//根据条件查询、
	public List<Tuser> queryByCon(QueryUser query);
	//新增 返回主键
	public int insertUser(Tuser user);
	//批量删除
	public void deleteByIds(int[] ids);
	//修改
	public void updateUser(Tuser user);
	//分页查询
	public List<Tuser>queryByPage(QueryUser query);
	//获得的总条数
	public int queryCount(QueryUser query);
	//删除
	public void deleteById(int id);
	//获取主键读取
	public Tuser queryById(int id);
}
