package com.hywl.pojo;

import java.sql.Date;

/**
 * 
 * @author liucaifeng
 *
 */
//推送消息表
public class DriverSendInfoPojo {
	private String id;//标识
	private String goodssource;//货源
	private String goodsOwner;//货主
	private String status;//状态

	private Date time;//时间 
	public String getGoodssource() {
		return goodssource;
	}
	public void setGoodssource(String goodssource) {
		this.goodssource = goodssource;
	}
	public String getGoodsOwner() {
		return goodsOwner;
	}
	public void setGoodsOwner(String goodsOwner) {
		this.goodsOwner = goodsOwner;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	

}
