package com.hywl.service;

import java.sql.SQLException;
import java.util.List;

import com.hywl.dao.RouteDaoImpl;
import com.hywl.pojo.DriverRoutePojo;

public class RouteServiceImpl implements RouteService{
	public RouteDaoImpl routedao;
	public RouteServiceImpl(){
		routedao=new RouteDaoImpl();
	}

	@Override
	public void add(DriverRoutePojo route) throws Exception {
		// TODO Auto-generated method stub
		routedao.add(route);
	}

	@Override
	public void update(DriverRoutePojo route) throws Exception {
		// TODO Auto-generated method stub
		routedao.update(route);
	}

	@Override
	public void delete(String driverphone) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<DriverRoutePojo> queryAll() throws Exception {
		// TODO Auto-generated method stub
		return routedao.queryAll();
	}

	@Override
	public List<DriverRoutePojo> queryByRoute(String startplace,
			String destination) throws SQLException {
		// TODO Auto-generated method stub
		return routedao.queryByRoute(startplace, destination);
	}

	@Override
	public List<DriverRoutePojo> queryByPhone(String phone) throws Exception {
		// TODO Auto-generated method stub
		return routedao.queryByPhone(phone);
	}

}
