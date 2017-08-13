package com.hywl.pojo;

import java.sql.Date;

/**
 * 
 * @author liucaifeng
 *
 */
//积分记录表
public class ScoreChangePojo {
	private String id;//标识
	private String name;//兑换物
	private String gift;//礼品

	private int value;//分值
	private Date exchangeTime;//兑换时间
	private  int quantity;//数量
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Date getExchangeTime() {
		return exchangeTime;
	}
	public void setExchangeTime(Date exchangeTime) {
		this.exchangeTime = exchangeTime;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
