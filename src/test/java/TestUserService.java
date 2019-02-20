
import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.Tuser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUserService {
	@Autowired
	UserService us;

	

	public void testlogin() {
		List<TPermission> list1 = us.queryByUid(1314);
		for (TPermission per:list1) {
			System.out.println(per.getPname());
	}
		System.out.println("--------整理后的---------");
		for(TPermission per1:us.genMenu(list1)) {
			System.out.println(per1.getPname());
			for(TPermission per2:per1.getChildren()){
				System.out.println("----"+per2.getPname());
			}
		}
	}

	public void testQuery() {
	//创建查询对象
	QueryUser query=new QueryUser();
	query.setLoginname("");
	query.setPassword("1234");
	query.setSex("男");
	for(Tuser user:us.queryByPage(1, query)) {
		System.out.println(user.getId()+"、"+user.getLoginname());
	}
	System.out.println("共"+us.queryPageCont(query)+"页");
	}
	public void testDeletes() {
		int [] ids= {3109};
		us.deleteByIds(ids);
	}
	@Test
	public void testUpdate() {
		Tuser user=new Tuser();
		TDep dep=new TDep();
		dep.setId(6);
		user.setDep(dep);
		user.setEmail("insert@123.com");
		user.setIsenabled(-1);
		user.setLoginname("insert123");
		user.setPassword("insert123");
		user.setpic("insert123.jpg");
		user.setRealname("修改数据123");
		user.setSex("男");
		user.setUpdator(1000);
		user.setBirthday(new Date(0));
		user.setId(3430);
		us.updateUser(user);
		
	}
	
	public void testinsert() {
		
	}
/*	@Test
	public void testQueryCon() {
		QueryUser user=new QueryUser();
		user.setLoginname("zhiming");
		us.queryByCon(user);
	}*/
	
}
