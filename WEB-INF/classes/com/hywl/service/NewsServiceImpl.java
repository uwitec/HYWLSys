package com.hywl.service;

import java.util.List;


import com.hywl.dao.NewsDaoImpl;
import com.hywl.pojo.NewsPojo;
import com.hywl.util.DateUtil;
import com.hywl.util.UuidValues;

public class NewsServiceImpl implements NewsService{

	private NewsDaoImpl newsDB;
//	private  date;
	
	public NewsServiceImpl(){
		newsDB=new NewsDaoImpl();
	}
	
	@Override
	public void add(NewsPojo t) {
		// TODO Auto-generated method stub		
		String id=UuidValues.generateShortUuid();//生成唯一标识
		String newsno=String.valueOf(System.currentTimeMillis());//新闻编号
		String time=DateUtil.getDateTime();//操作时间
		t.setId(id);
		t.setNewsno(newsno);
		t.setDate(time);
		newsDB.add(t);
	}

	@Override
	public void delete(NewsPojo t) {
		// TODO Auto-generated method stub
		newsDB.delete(t);
	}

	@Override
	public List<NewsPojo> select(NewsPojo t,String culname,String flag) {
		// TODO Auto-generated method stub
		String sql="select * from t_news where "+culname+"='"+flag+"'";
		List<NewsPojo> list=newsDB.queryForList(sql);

		return list;
	}

	@Override
	public void updateStatus(String n,String s) {
		// TODO Auto-generated method stub
		newsDB.updateStatus(n, s);
		
	}
	
	public NewsPojo getById(String id){
		return newsDB.getById(id);
	}

	
	
}
