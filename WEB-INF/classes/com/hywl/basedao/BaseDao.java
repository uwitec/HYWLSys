package com.hywl.basedao;

import java.util.List;

import net.sf.json.JSONArray;

public interface BaseDao<T>{
    public void add(T obj) throws Exception;
	
	public void update(T obj) throws Exception;
	
	public void update(Object...params);
	
	public void delete(T obj) throws Exception;
	
	public boolean queryById(String id) throws Exception;
	
	public List<T> queryAll()throws Exception;
	
    public List<T> queryListByPage(String sql,int start,int end) throws Exception;
	
	public int queryListByPageCount(String sql) throws Exception;

	public List<T> queryListByParamPage(String sql,Object[] params,int start,int end) throws Exception;
	
	public int queryListByParamPageCount(String sql,Object[] params) throws Exception;

}
