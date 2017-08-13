package com.hywl.service;

import com.hywl.dao.SysUserDaoImpl;
import com.hywl.pojo.SystemUsersPojo;

public class SystemUserServiceImpl implements SystemUserService{
	private SysUserDaoImpl sysuser;

	public SystemUserServiceImpl() {
		sysuser=new SysUserDaoImpl();
	}
	
	@Override
	public void add(SystemUsersPojo sys){
		sysuser.add(sys);
	}

	@Override
	public boolean queryByAccount(String account) {
		// TODO Auto-generated method stub
		try {
			if(sysuser.queryById(account)){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void query(SystemUsersPojo s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SystemUsersPojo s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SystemUsersPojo s) {
		// TODO Auto-generated method stub
		
	}

	
}
