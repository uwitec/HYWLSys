package com.hywl.pojo;

import java.sql.Date;
//货主数据模型
public class ShipperPojo {
	private String id;//货主编号
	private String sphone;//手机号
	private String spassword;//密码
	private String sname;//姓名
	private String srole;//角色
	private int sscore;//积分
	private int sstar;//星级
	private int ssumnumber;//平台交易笔数
	private float snicerate;//好评率
	private Date sregister_time;//注册时间
	private String changePhone;
	public String getChangePhone() {
		return changePhone;
	}
	public void setChangePhone(String changePhone) {
		this.changePhone = changePhone;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSrole() {
		return srole;
	}
	public void setSrole(String srole) {
		this.srole = srole;
	}
	public int getSscore() {
		return sscore;
	}
	public void setSscore(int sscore) {
		this.sscore = sscore;
	}
	public int getSstar() {
		return sstar;
	}
	public void setSstar(int sstar) {
		this.sstar = sstar;
	}
	public int getSsumnumber() {
		return ssumnumber;
	}
	public void setSsumnumber(int ssumnumber) {
		this.ssumnumber = ssumnumber;
	}
	public float getSnicerate() {
		return snicerate;
	}
	public void setSnicerate(float snicerate) {
		this.snicerate = snicerate;
	}
	public Date getSregister_time() {
		return sregister_time;
	}
	public void setSregister_time(Date sregister_time) {
		this.sregister_time = sregister_time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
