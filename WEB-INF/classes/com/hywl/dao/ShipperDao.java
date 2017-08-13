package com.hywl.dao;

import java.sql.SQLException;

import com.hywl.basedao.BaseDao;
import com.hywl.pojo.ShipperPojo;
public interface ShipperDao extends BaseDao<ShipperPojo>{

	boolean queryByPhone(String phone) throws SQLException;
}
