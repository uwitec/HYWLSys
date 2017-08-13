package com.hywl.pojo;
//栏目表
public class ColumnPojo {
	private String id;//栏目编号
	private String newsno;//新闻编号
	private String name;//栏目名称
	private int sid;//新闻序号
	private String sname;//处理人
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNewsno() {
		return newsno;
	}
	public void setNewsno(String newsno) {
		this.newsno = newsno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	

}
