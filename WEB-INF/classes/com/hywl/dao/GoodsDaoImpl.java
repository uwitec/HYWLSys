package com.hywl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.huel.tools.dbutil.DataBaseConn;
import com.hywl.pojo.GoodsPojo;
import com.hywl.util.UuidValues;

public class GoodsDaoImpl implements GoodsDao{
	private Statement stmt=null;
	private PreparedStatement pstmt = null;
	private static Connection conn = null;
	@Override
	public void add(GoodsPojo t){
		
		String sql="insert into s_goods (id,sgoodstart,sgoodend,sgood_time,sgood_valid_time,sgoodsort,sgoodphone,sgoodprice,shipperid,sgoodid) values(?,?,?,?,?,?,?,?,?,?)";
		conn=DataBaseConn.openConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,t.getId());
			pstmt.setString(2,t.getSgoodstart());
			pstmt.setString(3,t.getSgoodend());
			pstmt.setString(4, t.getSgood_time());
			pstmt.setString(5, t.getSgood_valid_time());
			pstmt.setString(6,t.getSgoodsort());
			pstmt.setString(7,t.getSphone());
			pstmt.setFloat(8,t.getSgoodprice());
			pstmt.setString(9,t.getShipperid());
			pstmt.setString(10, t.getSgoodid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();//关闭数据库
		}
		
		
	}

	@Override
	public void update(GoodsPojo obj){
		
		String sql="update s_goods set ";
		conn=DataBaseConn.openConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(0, UuidValues.generateShortUuid());
			//......待补充
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();//关闭数据库
		}
	}

	@Override
	public void delete(GoodsPojo obj){
		
		String sql="delete from s_goods where ";
		conn=DataBaseConn.openConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(0, UuidValues.generateShortUuid());
			//......待补充
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();//关闭数据库
		}
	}

	@Override
	public boolean queryById(String id){
		
		String sql="select * from s_goods where sgoodid=?";
		conn=DataBaseConn.openConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(0, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();//关闭数据库
		}
		return false;
	}
	
public GoodsPojo getById(String id){
		
		String sql="select * from s_goods where sgoodid='"+id+"'";
		
		return queryForList(sql).get(0);
	}


	public List<GoodsPojo> queryForList(String sql) {
		// TODO Auto-generated method stub
		List<GoodsPojo> list=new ArrayList<GoodsPojo>();
		
		conn=DataBaseConn.openConn();
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				GoodsPojo t=new GoodsPojo();
		        t.setId(rs.getString("id"));
		        t.setSgoodid(rs.getString("sgoodid"));
		        t.setSgoodstart(rs.getString("sgoodstart"));
		        t.setSgoodend(rs.getString("sgoodend"));
		        t.setSgood_time(rs.getString("sgood_time"));
		        t.setSgoodsort(rs.getString("sgoodsort"));
		        t.setSgood_valid_time(rs.getString("sgood_valid_time"));
		        t.setSphone(rs.getString("sgoodphone"));
		        t.setShipperid(rs.getString("shipperid"));
				list.add(t);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();//关闭数据库
		}
		return list;
	}

	@Override
	public List<GoodsPojo> queryAll() {
		// TODO Auto-generated method stub
		String sql="select * from s_goods";
		return queryForList(sql);
	}

	//分页查询
	@Override
	public List<GoodsPojo> queryListByPage(String sql1, int start, int end) throws SQLException{
		// TODO Auto-generated method stub
		List<GoodsPojo> list=new ArrayList<GoodsPojo>();
		String sql="select * from s_goods limit ?,?";	
		//System.out.println(start+","+end);
		conn=DataBaseConn.openConn();
	
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				GoodsPojo t=new GoodsPojo();
		        t.setId(rs.getString("id"));
		        t.setSgoodid(rs.getString("sgoodid"));
		        t.setSgoodstart(rs.getString("sgoodstart"));
		        t.setSgoodend(rs.getString("sgoodend"));
		        t.setSgood_time(rs.getString("sgood_time"));
		        t.setSgoodsort(rs.getString("sgoodsort"));
		        t.setSgood_valid_time(rs.getString("sgood_valid_time"));
		        t.setSphone(rs.getString("sgoodphone"));
		        t.setShipperid(rs.getString("shipperid"));
				list.add(t);
				}
			
			System.out.println("size:"+list.size());
			return list;
		
		//System.out.println("size1:"+list.size());
		
		
	}

	@Override
	public int queryListByPageCount(String sql) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GoodsPojo> queryListByParamPage(String sql, Object[] params,
			int start, int end) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryListByParamPageCount(String sql, Object[] params)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public void update(Object... params) {
		// TODO Auto-generated method stub
		
	}

	//将list转换为JASON对象值
	@Override
	public JSONArray getArray(String start,String end) {
		// TODO Auto-generated method stub
		String sql="select * from s_goods where sgoodstart='"+start+"' and sgoodend='"+end+"'";
		return getJSONArray(sql);
	}
	
	public JSONArray getAllJSONArray(){
		String  sql="select * from s_goods ";
		return getJSONArray(sql);
	}
	public JSONArray getJSONArray(String sql) {
		// TODO Auto-generated method stub
		JSONArray array=new JSONArray();
		List<GoodsPojo> list=queryForList(sql);
		for(GoodsPojo g:list){
			JSONObject obj=new JSONObject();
			obj.put("name", g);
			array.add(obj);
		}
		return array;
	}
		
	
}
