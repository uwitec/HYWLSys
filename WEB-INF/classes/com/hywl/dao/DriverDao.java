package com.hywl.dao;

import java.sql.SQLException;

import com.hywl.basedao.BaseDao;
import com.hywl.pojo.DriverPojo;

public interface DriverDao extends BaseDao<DriverPojo>{

	boolean queryByPhone(String phone) throws SQLException;


}
