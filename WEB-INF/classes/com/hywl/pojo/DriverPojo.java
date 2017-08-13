package com.hywl.pojo;
/**
 * 
 * @author liquefying
 *
 */
import java.sql.Date;
//司机注册表
public class DriverPojo {
	private String id;//标识
	private String name;//姓名
	private String phone;//手机号码
	private String passwd;//密码	
	private int integral;//积分
	private Date registtime;//注册时间      	
	private int volum;//平台交易率
	private int star;//星级
	private float goodreview;//好评率	
	private String role;//角色
	private String changePhone;//确认手机号
	
	public String getChangePhone() {
		return changePhone;
	}
	public void setChangePhone(String changePhone) {
		this.changePhone = changePhone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd= passwd;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	
	public Date getRegisttime() {
		return registtime;
	}
	public void setRegisttime(Date registtime) {
		this.registtime = registtime;
	}
	public int getVolum() {
		return volum;
	}
	public void setVolum(int volum) {
		this.volum = volum;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public float getGoodreview() {
		return goodreview;
	}
	public void setGoodreview(float goodreview) {
		this.goodreview = goodreview;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
