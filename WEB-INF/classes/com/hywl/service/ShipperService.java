package com.hywl.service;
import java.util.List;

import com.hywl.pojo.ShipperPojo;

public interface ShipperService {
	public void add(ShipperPojo shipper) throws Exception;
	public void update(ShipperPojo shipper) throws Exception;
	public void delete(ShipperPojo shipper) throws Exception;
    public void queryByName(String str) throws Exception;
    public boolean queryByPhone(ShipperPojo shipper) throws Exception;
    public boolean queryByPhone(String str)throws Exception;
    public List<ShipperPojo> all(ShipperPojo shipper)throws Exception;

}
