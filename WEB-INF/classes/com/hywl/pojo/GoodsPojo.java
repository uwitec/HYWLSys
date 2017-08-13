package com.hywl.pojo;

import java.sql.Date;

/**
 * 
 * @author liucaifeng
 *
 */
//货源数据库模表
public class GoodsPojo {
	
	
	private String id;//标识
	private String sgoodid;//货源编号
	private String sgoodstart;//出发地
	private String sgoodend;//目的地
	private String shipperid;//货主编号
	private String sgoodsort;//货物类型
	private String sphone;//发布人电话
	private String sorderid;//订单编号
	private String sgood_time;//发布时间
	private String sgood_valid_time;//货物有效期
	private float sgoodweigh;//货物总量
	private float sgoodprice;//意愿价格
	public String getSgoodstart() {
		return sgoodstart;
	}
	public void setSgoodstart(String sgoodstart) {
		this.sgoodstart = sgoodstart;
	}
	
	public String getSgoodend() {
		return sgoodend;
	}
	public void setSgoodend(String sgoodend) {
		this.sgoodend = sgoodend;
	}
	

	public String getSgoodsort() {
		return sgoodsort;
	}
	public void setSgoodsort(String sgoodsort) {
		this.sgoodsort = sgoodsort;
	}
	
	public String getSgoodid() {
		return sgoodid;
	}
	public void setSgoodid(String sgoodid) {
		this.sgoodid = sgoodid;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getSorderid() {
		return sorderid;
	}
	public void setSorderid(String sorderid) {
		this.sorderid = sorderid;
	}
	public String getSgood_time() {
		return sgood_time;
	}
	public void setSgood_time(String sgood_time) {
		this.sgood_time = sgood_time;
	}
	public String getSgood_valid_time() {
		return sgood_valid_time;
	}
	public void setSgood_valid_time(String sgood_valid_time) {
		this.sgood_valid_time = sgood_valid_time;
	}
	public float getSgoodweigh() {
		return sgoodweigh;
	}
	public void setSgoodweigh(float sgoodweigh) {
		this.sgoodweigh = sgoodweigh;
	}
	
	public void setSgoodprice(float sgoodprice) {
		this.sgoodprice = sgoodprice;
	}
	public float getSgoodprice() {
		return sgoodprice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShipperid() {
		return shipperid;
	}
	public void setShipperid(String shipperid) {
		this.shipperid = shipperid;
	}
	
	

}
