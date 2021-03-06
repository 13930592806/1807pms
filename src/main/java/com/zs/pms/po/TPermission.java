package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TPermission implements Serializable {

	/**
	 * 
	 */
	//子权限集
		private List<TPermission> children=new ArrayList<TPermission>();
		//添加一个子权限
		public void addChild(TPermission per) {
			children.add(per);
		}
	private static final long serialVersionUID = -7512049132416900243L;
	private int id;
	private String pname;
	private int pid;
	private int lev;
	private int isleaf;
	private String npic;
	private String url;
	
	//子权限集
	public String getNpic() {
		return npic;
	}
	public void setNpic(String npic) {
		this.npic = npic;
	}
	public List<TPermission> getChildren() {
		return children;
	}
	public void setChildren(List<TPermission> children) {
		this.children = children;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {}
	public int getIsleaf() {
		return isleaf;
	}
	public void setIsleaf(int isleaf) {
		this.isleaf = isleaf;
	}
	public String getnpic() {
		return npic;
	}
	public void setnpic(String npic) {
		this.npic = npic;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
 }
