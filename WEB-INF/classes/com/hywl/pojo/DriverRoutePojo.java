package com.hywl.pojo;
/**
 * 
 * @author liucaifeng
 *
 */
//车源表
public class DriverRoutePojo {
	private String startPlace;//出发地
	private String destination;//目的地
	private String id;//标识
	private String drivername;
	private String driverphone;
	private String carno;
	private float carweigth;
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public float getCarweigth() {
		return carweigth;
	}
	public void setCarweigth(float carweigth) {
		this.carweigth = carweigth;
	}
	public float getCarlength() {
		return carlength;
	}
	public void setCarlength(float carlength) {
		this.carlength = carlength;
	}
	private float carlength;
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public String getDriverphone() {
		return driverphone;
	}
	public void setDriverphone(String driverphone) {
		this.driverphone = driverphone;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

 
}
