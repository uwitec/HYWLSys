package com.hywl.dao;

import net.sf.json.JSONArray;

import com.hywl.basedao.BaseDao;
import com.hywl.pojo.GoodsPojo;

public interface GoodsDao extends BaseDao<GoodsPojo>{

	public JSONArray getArray(String start,String end);
}
