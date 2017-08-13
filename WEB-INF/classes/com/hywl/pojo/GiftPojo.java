package com.hywl.pojo;
/**
 * 
 * @author liucaifeng
 *
 */
//礼品数据模型
public class GiftPojo {
	private String id;//标识
	private String sgiftid;//礼品编号
	private String sgiftname;//礼品名
	private int sgiftscore;//积分值
	private boolean sgiftmode;//礼品状态
	public String getSgiftid() {
		return sgiftid;
	}
	public void setSgiftid(String sgiftid) {
		this.sgiftid = sgiftid;
	}
	public String getSgiftname() {
		return sgiftname;
	}
	public void setSgiftname(String sgiftname) {
		this.sgiftname = sgiftname;
	}
	public int getSgiftscore() {
		return sgiftscore;
	}
	public void setSgiftscore(int sgiftscore) {
		this.sgiftscore = sgiftscore;
	}
	public boolean isSgiftmode() {
		return sgiftmode;
	}
	public void setSgiftmode(boolean sgiftmode) {
		this.sgiftmode = sgiftmode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
