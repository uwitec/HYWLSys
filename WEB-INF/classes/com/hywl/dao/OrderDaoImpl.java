package com.hywl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.huel.tools.dbutil.DataBaseConn;
import com.hywl.pojo.NewsPojo;
import com.hywl.pojo.OrderInfoPojo;
import com.hywl.util.UuidValues;

public class OrderDaoImpl implements OrderDao{

	private Statement stmt=null;
	private PreparedStatement pstmt = null;
	private static Connection conn = null;
	@Override
	public void add(OrderInfoPojo t) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into s_order values(?,?,?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,t.getId());
			pstmt.setString(2,t.getSorderid());
			pstmt.setString(3,t.getSordergoods());
			pstmt.setString(4, t.getSorderdriver());
			pstmt.setFloat(5, t.getSorderprice());
			pstmt.setString(6,t.getSordermode());
			pstmt.setString(7,t.getSorder_modetime());
			pstmt.setString(8,t.getSorder_time());
			
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();//关闭数据库
		}
		
	}

	///更改订单状态
	@Override
	public void update(OrderInfoPojo obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update s_order set sordermode=? where sorderid=?";
		conn=DataBaseConn.openConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,obj.getSordermode());
			pstmt.setString(2,obj.getSorderid());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();//关闭数据库
		}
	}

	@Override
	public void update(Object... params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OrderInfoPojo obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from s_order where sorderid=?";
		conn=DataBaseConn.openConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,obj.getSorderid());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();//关闭数据库
		}
	}

	public List<OrderInfoPojo> queryByUser(String column,String user) throws Exception {
		// TODO Auto-generated method stub
List<OrderInfoPojo> list=new ArrayList<OrderInfoPojo>();
		String sql="select * from s_order where"+column+"= '"+user+"'";
		conn=DataBaseConn.openConn();
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				OrderInfoPojo t=new OrderInfoPojo();
				t.setSorderid(rs.getString("sorderid"));//编号
				t.setSordergoods(rs.getString("sordergoods"));//
				t.setSorderdriver(rs.getString("sorderdriver"));//
				t.setSordermode(rs.getString("sordermode"));//
				t.setSorder_time(rs.getString("sorder_time"));//
				t.setSorder_time(rs.getString("sorder_time"));//
				t.setSorderprice(rs.getFloat("sorderprice"));//
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
	public boolean queryById(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderInfoPojo> queryAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderInfoPojo> queryListByPage(String sql, int start, int end)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryListByPageCount(String sql) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderInfoPojo> queryListByParamPage(String sql,
			Object[] params, int start, int end) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryListByParamPageCount(String sql, Object[] params)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
