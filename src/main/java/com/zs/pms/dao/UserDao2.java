package com.zs.pms.dao;


import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.zs.pms.po.Tuser;
import com.zs.pms.vo.QueryUser;
@Repository
public interface UserDao2 {
	@Select("Select * from tuser1 WhereSqlNode sex=#{sex}")
	public List<Tuser>queryByCon(QueryUser query);
}
