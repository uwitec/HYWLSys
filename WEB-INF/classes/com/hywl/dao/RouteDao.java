package com.hywl.dao;

import java.sql.SQLException;
import java.util.List;

import com.hywl.basedao.BaseDao;
import com.hywl.pojo.DriverRoutePojo;

public interface RouteDao extends BaseDao<DriverRoutePojo>{
	public List<DriverRoutePojo> queryByRoute(String startplace,String destination)throws SQLException;

}
