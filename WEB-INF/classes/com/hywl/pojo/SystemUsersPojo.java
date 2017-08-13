package com.hywl.pojo;
//系统内用户表

public class SystemUsersPojo {
	private String id;//标识
	private String account;//账号
	private String pwd;//密码
	private String name;//姓名
	private String email;//邮箱
	private String tel;//手机
	private int age;//年龄
	private String buildtime;//创建日期
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	public String getBuildtime() {
		return buildtime;
	}
	public void setBuildtime(String buildtime) {
		this.buildtime = buildtime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
