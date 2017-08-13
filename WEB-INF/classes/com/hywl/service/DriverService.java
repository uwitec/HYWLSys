package com.hywl.service;
import java.util.List;
import com.hywl.pojo.DriverPojo;
public interface DriverService{
	public void add(DriverPojo driver) throws Exception;
	public void update(DriverPojo driver) throws Exception;
	public void delete(DriverPojo driver) throws Exception;
	public void queryByName(String str) throws Exception;
	public boolean queryByPhone(DriverPojo Driver) throws Exception;
	public boolean queryByPhone(String str)throws Exception;
	public List<DriverPojo> all(DriverPojo driver)throws Exception;
}
