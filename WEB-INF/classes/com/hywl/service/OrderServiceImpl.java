package com.hywl.service;

import java.util.List;

import com.hywl.dao.OrderDaoImpl;
import com.hywl.pojo.OrderInfoPojo;
import com.hywl.util.DateUtil;
import com.hywl.util.UuidValues;

public class OrderServiceImpl implements OrderService{

	private OrderDaoImpl order=null;

	public OrderServiceImpl() {
		order=new OrderDaoImpl ();
	}

	@Override
	public void add(OrderInfoPojo o) {
		// TODO Auto-generated method stub
		String id=UuidValues.generateShortUuid();//生成唯一标识
		String orderid=String.valueOf(System.currentTimeMillis());//编号
		String time=DateUtil.getDateTime();//操作时间
		o.setId(id);
		o.setSorder_time(time);
		o.setSorderid(orderid);
		try {
			order.add(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(OrderInfoPojo o) {
		// TODO Auto-generated method stub
		try {
			order.delete(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderInfoPojo> query(String c, OrderInfoPojo o) {
		// TODO Auto-generated method stub
		List<OrderInfoPojo> list=null;
		try {
			list= order.queryByUser(c, o.getSordergoods());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(OrderInfoPojo o) {
		// TODO Auto-generated method stub
		
	}
	
}
