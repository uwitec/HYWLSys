package com.hywl.pojo;

import java.sql.Date;
//订单数据模型
public class OrderInfoPojo {
	private String id;//标识
	private String sorderid;//订单编码
	private String sordergoods;//货源
	private String sorderdriver;//司机
	private String sordermode;//订单状态
	private float sorderprice;//成交价格
	private String sorder_modetime;//状态时间
	private String sorder_time;//创建时间
	public String getSorderid() {
		return sorderid;
	}
	public void setSorderid(String sorderid) {
		this.sorderid = sorderid;
	}
	public String getSordergoods() {
		return sordergoods;
	}
	public void setSordergoods(String sordergoods) {
		this.sordergoods = sordergoods;
	}
	public String getSorderdriver() {
		return sorderdriver;
	}
	public void setSorderdriver(String sorderdriver) {
		this.sorderdriver = sorderdriver;
	}
	public String getSordermode() {
		return sordermode;
	}
	public void setSordermode(String sordermode) {
		this.sordermode = sordermode;
	}
	public float getSorderprice() {
		return sorderprice;
	}
	public void setSorderprice(float sorderprice) {
		this.sorderprice = sorderprice;
	}
	public String getSorder_modetime() {
		return sorder_modetime;
	}
	public void setSorder_modetime(String sorder_modetime) {
		this.sorder_modetime = sorder_modetime;
	}
	public String getSorder_time() {
		return sorder_time;
	}
	public void setSorder_time(String sorder_time) {
		this.sorder_time = sorder_time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
