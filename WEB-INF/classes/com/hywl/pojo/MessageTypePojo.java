package com.hywl.pojo;

import java.sql.Date;
//消息数据模型
public class MessageTypePojo {
	private String smsgid;//标识
	private String smsgdetail;//内容
	private String smsgputouter;//推送人
	private String smsgrecevier;//接收人
	private String smsgsort;//分类
	private Date smsgput_time;//推送时间
	public String getSmsgid() {
		return smsgid;
	}
	public void setSmsgid(String smsgid) {
		this.smsgid = smsgid;
	}
	public String getSmsgdetail() {
		return smsgdetail;
	}
	public void setSmsgdetail(String smsgdetail) {
		this.smsgdetail = smsgdetail;
	}
	public String getSmsgputouter() {
		return smsgputouter;
	}
	public void setSmsgputouter(String smsgputouter) {
		this.smsgputouter = smsgputouter;
	}
	public String getSmsgrecevier() {
		return smsgrecevier;
	}
	public void setSmsgrecevier(String smsgrecevier) {
		this.smsgrecevier = smsgrecevier;
	}
	public String getSmsgsort() {
		return smsgsort;
	}
	public void setSmsgsort(String smsgsort) {
		this.smsgsort = smsgsort;
	}
	public Date getSmsgput_time() {
		return smsgput_time;
	}
	public void setSmsgput_time(Date smsgput_time) {
		this.smsgput_time = smsgput_time;
	}
	
	
   
}
