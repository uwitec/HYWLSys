package com.hywl.service;

import java.util.List;

import com.hywl.dao.ShipperDao;
import com.hywl.dao.ShipperDaoImpl;
import com.hywl.pojo.ShipperPojo;

public class ShipperServiceImpl implements ShipperService {
	
	public ShipperDaoImpl shipperDao;
	
	public ShipperServiceImpl() {
		shipperDao=new ShipperDaoImpl();
	}

	@Override
	public void add(ShipperPojo shipper) throws Exception {
		// TODO Auto-generated method stub
		shipperDao.add(shipper);

	}

	@Override
	public void update(ShipperPojo shipper) throws Exception {
		// TODO Auto-generated method stub
		shipperDao.update(shipper);

	}

	@Override
	public void delete(ShipperPojo shipper) throws Exception {
		// TODO Auto-generated method stub
		shipperDao.delete(shipper);

	}

	@Override
	public void queryByName(String str) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean queryByPhone(ShipperPojo shipper) throws Exception {
			
		// TODO Auto-generated method stub
		return shipperDao.queryByPhone(shipper);

	}

	@Override
	public boolean queryByPhone(String str) throws Exception {
		// TODO Auto-generated method stub
		return shipperDao.queryByPhone(str);
	}

	@Override
	public List<ShipperPojo> all(ShipperPojo shipper) throws Exception {
		return shipperDao.queryAll(shipper);
	}

}
