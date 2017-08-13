package com.hywl.service;

import java.util.List;

import com.hywl.pojo.OrderInfoPojo;

public interface OrderService {
	
	public void add(OrderInfoPojo o);
	public void delete(OrderInfoPojo o);
	public List<OrderInfoPojo> query(String c,OrderInfoPojo o);
	public void update(OrderInfoPojo o);
}
