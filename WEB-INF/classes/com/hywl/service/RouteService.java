package com.hywl.service;

import java.sql.SQLException;
import java.util.List;

import com.hywl.pojo.DriverRoutePojo;

public interface RouteService {
	public void add(DriverRoutePojo route) throws Exception;
	public void update(DriverRoutePojo route) throws Exception;
	public void delete(String driverphone);
	public List<DriverRoutePojo> queryByRoute(String startplace,String destination) throws SQLException;
	public List<DriverRoutePojo> queryAll() throws Exception;
	public List<DriverRoutePojo> queryByPhone(String phone) throws Exception;

}
