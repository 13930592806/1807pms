package com.zs.pms.po;

import java.io.Serializable;
import java.sql.Date;


public class Tuser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6591331141410084675L;
	private int id;
	private String loginname;
	private String realname;
	private String sex;
	private Date birthday;
	private String password;
	private TDep dep;
	private String email;
	private int isenabled;
	private int creator;
	private  Date cteatime;
	private int updator;
	private Date updatime;
	private String pic;
	//显示字段
	private String sexTxt;
	private String isenabledTxt;
	//用于显示
	private String birthdayTxt;
	
	public int getIsenabled() {
		return isenabled;
	}
	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}
	public String getpic() {
		return pic;
	}
	public void setpic(String pic) {
		this.pic = pic;
	}
	public String getSexTxt() {
		return sexTxt;
	}
	public void setSexTxt(String sexTxt) {
		this.sexTxt = sexTxt;
	}
	public String getIsenabledTxt() {
		if (isenabled==1) {
			return "可用";
		}
		else {
			return "不可用";
		}
	}
	public String getBirthdayTxt() {
		return birthdayTxt;
	}
	public void setIsenabledTxt(String isenabledTxt) {
		this.isenabledTxt = isenabledTxt;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public void setBirthdayTxt(String birthdayTxt) {
		this.birthdayTxt = birthdayTxt;
	}
	public void setDep(TDep dep) {
		this.dep = dep;
	}
	public void setCteatime(Date cteatime) {
		this.cteatime = cteatime;
	}
	public void setUpdatime(Date updatime) {
		this.updatime = updatime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	
	public int getUpdator() {
		return updator;
	}
	public TDep getDep() {
		return dep;
	}
	public Date getCteatime() {
		return cteatime;
	}
	public Date getUpdatime() {
		return updatime;
	}
	public void setUpdator(int updator) {
		this.updator = updator;
	}
	public void getUpdate(Tuser user) {
		// TODO Auto-generated method stub
		
	}
	
	
}
