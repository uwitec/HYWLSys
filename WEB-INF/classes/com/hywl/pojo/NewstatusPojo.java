package com.hywl.pojo;

import java.sql.Timestamp;
//新闻状态表
public class NewstatusPojo {
	private String id;//标识
	private String newsno;//新闻编号
	private String status;//状态
	private Timestamp status_time;//状态日期
	public String getNewsno() {
		return newsno;
	}
	public void setNewsno(String newsno) {
		this.newsno = newsno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getEntry_time() {
		return status_time;
	}
	public void setEntry_time(Timestamp entry_time) {
		this.status_time = entry_time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getStatus_time() {
		return status_time;
	}
	public void setStatus_time(Timestamp status_time) {
		this.status_time = status_time;
	}
	
	
	

}
