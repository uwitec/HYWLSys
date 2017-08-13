package com.hywl.service;

import java.util.List;

import com.hywl.pojo.GoodsPojo;

public interface GoodsService {
	
	public void add(GoodsPojo g);
	public void delete(GoodsPojo t);
	
	public List<GoodsPojo> select(GoodsPojo t, String culname, String flag);
}
