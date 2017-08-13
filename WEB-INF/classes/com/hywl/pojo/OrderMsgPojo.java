package com.hywl.pojo;

import java.sql.Date;
//订单消息
public class OrderMsgPojo {
	private String id;//标识
	private String sordermsgid;//订单消息编号
	private String sorderid;//订单编号
	private String sordermsgmode;//订单状态
	private String sordermsgsort;//类别
	private Date  sordermsg_time;//订单时间
	public String getSordermsgid() {
		return sordermsgid;
	}
	public void setSordermsgid(String sordermsgid) {
		this.sordermsgid = sordermsgid;
	}
	public String getSorderid() {
		return sorderid;
	}
	public void setSorderid(String sorderid) {
		this.sorderid = sorderid;
	}
	public String getSordermsgmode() {
		return sordermsgmode;
	}
	public void setSordermsgmode(String sordermsgmode) {
		this.sordermsgmode = sordermsgmode;
	}
	public String getSordermsgsort() {
		return sordermsgsort;
	}
	public void setSordermsgsort(String sordermsgsort) {
		this.sordermsgsort = sordermsgsort;
	}
	public Date getSordermsg_time() {
		return sordermsg_time;
	}
	public void setSordermsg_time(Date sordermsg_time) {
		this.sordermsg_time = sordermsg_time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

}
