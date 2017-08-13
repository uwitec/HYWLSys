package com.hywl.service;

import java.util.List;

import com.hywl.pojo.NewsPojo;

public interface NewsService{
	
	public void add(NewsPojo t);
	public void delete(NewsPojo t);
	public void updateStatus(String n,String s);
	public List<NewsPojo> select(NewsPojo t, String culname, String flag);
}
