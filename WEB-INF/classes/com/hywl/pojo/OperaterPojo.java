package com.hywl.pojo;

import java.sql.Timestamp;

/**
 * 
 * @author Administrator
 *
 */
//新闻操作表
public class OperaterPojo {
	private String id;//标识
	private String newsno;//新闻编号
	private Timestamp entry_time;//录入时间
	private String operater;//操作人
	private String status;//状态
	private Boolean stick;//是否置顶
	public String getNewsno() {
		return newsno;
	}
	public void setNewsno(String newsno) {
		this.newsno = newsno;
	}
	public Timestamp getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Timestamp entry_time) {
		this.entry_time = entry_time;
	}
	public String getOperater() {
		return operater;
	}
	public void setOperater(String operater) {
		this.operater = operater;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Boolean getStick() {
		return stick;
	}
	public void setStick(Boolean stick) {
		this.stick = stick;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	

}
