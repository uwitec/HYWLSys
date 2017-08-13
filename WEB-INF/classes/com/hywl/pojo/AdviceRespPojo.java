package com.hywl.pojo;

import java.sql.Date;
//意见反馈数据模型
public class AdviceRespPojo {
	private String sideano;//标识
	private String sideatitle;//标题
	private String sideamsg;//内容
	private String sputouter;//发布人
	private String sputoutrole;//发布人身份
	private String sputoutend;//处理结果
	private String sputoutsovler;//处理人	
	private Date sputout_time;//发布时间
	private boolean sputoutmode;//处理状态
	private Date  sputoutsover_time;//处理时间
	public String getSideatitle() {
		return sideatitle;
	}
	public void setSideatitle(String sideatitle) {
		this.sideatitle = sideatitle;
	}
	public String getSideamsg() {
		return sideamsg;
	}
	public void setSideamsg(String sideamsg) {
		this.sideamsg = sideamsg;
	}
	public String getSputouter() {
		return sputouter;
	}
	public void setSputouter(String sputouter) {
		this.sputouter = sputouter;
	}
	public String getSputoutrole() {
		return sputoutrole;
	}
	public void setSputoutrole(String sputoutrole) {
		this.sputoutrole = sputoutrole;
	}
	public String getSputoutend() {
		return sputoutend;
	}
	public void setSputoutend(String sputoutend) {
		this.sputoutend = sputoutend;
	}
	public String getSputoutsovler() {
		return sputoutsovler;
	}
	public void setSputoutsovler(String sputoutsovler) {
		this.sputoutsovler = sputoutsovler;
	}
	public String getSideano() {
		return sideano;
	}
	public void setSideano(String sideano) {
		this.sideano = sideano;
	}
	public Date getSputout_time() {
		return sputout_time;
	}
	public void setSputout_time(Date sputout_time) {
		this.sputout_time = sputout_time;
	}
	public boolean isSputoutmode() {
		return sputoutmode;
	}
	public void setSputoutmode(boolean sputoutmode) {
		this.sputoutmode = sputoutmode;
	}
	public Date getSputoutsover_time() {
		return sputoutsover_time;
	}
	public void setSputoutsover_time(Date sputoutsover_time) {
		this.sputoutsover_time = sputoutsover_time;
	}
	

}
