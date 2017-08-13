package com.hywl.service;

import com.hywl.pojo.SystemUsersPojo;

public interface SystemUserService {
	
	public void add(SystemUsersPojo s);//添加系统内部人员
	public void query(SystemUsersPojo s);//查看人员信息
	public void delete(SystemUsersPojo s);//删除系统内部人员
	public void update(SystemUsersPojo s);//更新人员信息
	public boolean queryByAccount(String account);
}
