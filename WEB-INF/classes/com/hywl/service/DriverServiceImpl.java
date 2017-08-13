package com.hywl.service;

import java.util.List;

import com.hywl.dao.DriverDaoImpl;
import com.hywl.pojo.DriverPojo;

public class DriverServiceImpl implements DriverService{
	
	public DriverDaoImpl driverDao;
	
	public DriverServiceImpl() {
		driverDao=new DriverDaoImpl();
	}

	@Override
	public void add(DriverPojo driver) throws Exception {
		// TODO Auto-generated method stub
		driverDao.add(driver);
	}

	@Override
	public void update(DriverPojo driver) throws Exception {
		// TODO Auto-generated method stub
		driverDao.update(driver);
	}

	@Override
	public void delete(DriverPojo driver) throws Exception {
		// TODO Auto-generated method stub
		driverDao.delete(driver);
	}

	@Override
	public void queryByName(String str) throws Exception {
		// TODO Auto-generated method stub
		//driverDao.queryByName(str);
	}

	

	@Override
	public boolean queryByPhone(String str) throws Exception {
		// TODO Auto-generated method stub
		return driverDao.queryByPhone(str);
		
	}

	@Override
	public boolean queryByPhone(DriverPojo Driver) throws Exception {
		
		// TODO Auto-generated method stub
		return driverDao.queryByPhone(Driver);
	}

	@Override
	public List<DriverPojo> all(DriverPojo driver) throws Exception {
		// TODO Auto-generated method stub
		return driverDao.queryAll(driver);
	}

}
