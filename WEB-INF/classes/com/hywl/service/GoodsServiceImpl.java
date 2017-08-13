package com.hywl.service;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONArray;

import com.hywl.dao.GoodsDaoImpl;
import com.hywl.pojo.GoodsPojo;
import com.hywl.util.DateUtil;
import com.hywl.util.UuidValues;

public class GoodsServiceImpl implements GoodsService{
	private GoodsDaoImpl goods=null;

	public GoodsServiceImpl() {
		goods=new GoodsDaoImpl();
	}

	@Override
	public void add(GoodsPojo g) {
		// TODO Auto-generated method stub
		String id=UuidValues.generateShortUuid();//生成唯一标识
		String goodid=String.valueOf(System.currentTimeMillis());//新闻编号
		String time=DateUtil.getDateTime();//操作时间
		g.setId(id);
		g.setSgoodid(goodid);
		g.setSgood_time(time);
		goods.add(g);
	}

	@Override
	public void delete(GoodsPojo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GoodsPojo> select(GoodsPojo t, String culname, String flag) {
		String sql="select * from t_news where "+culname+"='"+flag+"'";
		List<GoodsPojo> list=goods.queryForList(sql);

		return list;
	}
	
	public List<GoodsPojo> selectByPage(int m, int n) throws SQLException {
		List<GoodsPojo> list=goods.queryListByPage("",m,n);
      
		return list;
	}
	
	public List<GoodsPojo> selectAll() throws SQLException {
	
		return goods.queryAll();
	}
	
	public GoodsPojo getById(String id){
		return goods.getById(id);
	}
	public JSONArray getJSON(String start,String end){
		return goods.getArray(start, end);		
	}
	
	public JSONArray getAllJSON(){
		return goods.getAllJSONArray();	
	}
}
