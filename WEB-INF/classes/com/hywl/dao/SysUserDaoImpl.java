package com.hywl.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.huel.tools.dbutil.DataBaseConn;
import com.hywl.pojo.NewsPojo;
import com.hywl.pojo.SystemUsersPojo;

import java.sql.PreparedStatement;

public class SysUserDaoImpl implements SysUserDao{

	PreparedStatement pstmt=null;
	Statement stmt=null;
	Connection conn=null;
	DataBaseConn db;
	@Override
	public void add(SystemUsersPojo obj){
		// TODO Auto-generated method stub
		db=new DataBaseConn();
		String sql="insert into t_systemusers values(?,?,?,?,?,?,?,?)";
		conn=DataBaseConn.openConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, obj.getId());
			pstmt.setString(2, obj.getName());
			pstmt.setString(3, obj.getPwd());
			pstmt.setInt(4, obj.getAge());
			pstmt.setString(5, obj.getEmail());
			pstmt.setString(6, obj.getTel());
			pstmt.setString(7, obj.getBuildtime());
			pstmt.setString(8, obj.getAccount());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();
		}
		
		
	}

	@Override
	public void update(Object... params) {
		// TODO Auto-generated method stub
		db=new DataBaseConn();
		String sql="update t_systemusers set name=? and pwd=? and age=? and email=? and tel=? and buildtime=? and account=?";
		conn=DataBaseConn.openConn();
		try {
			pstmt=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pstmt.setObject(i+1, params[i]);
			}
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();
		}
		
	}

	@Override
	public void delete(SystemUsersPojo obj) throws Exception {
		// TODO Auto-generated method stub
		db=new DataBaseConn();
		String sql="delete from t_systemusers where acount=?";
		conn=DataBaseConn.openConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, obj.getAccount());			
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();
		}
	}

	//根据账号判断用户是否存在
	@Override
	public boolean queryById(String account) throws Exception {
		// TODO Auto-generated method stub
		db=new DataBaseConn();
		String sql="select from t_systemusers where acount=?";
		conn=DataBaseConn.openConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, account);			
		    ResultSet rs=pstmt.executeQuery();
		    if(rs.next()){
		    	return true;
		    }		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();
		}
		return false;
	}

	public List<SystemUsersPojo> queryForList(String sql) {
		// TODO Auto-generated method stub
		List<SystemUsersPojo> list=new ArrayList<SystemUsersPojo>();
		conn=DataBaseConn.openConn();
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				SystemUsersPojo s=new SystemUsersPojo();
				s.setAccount(rs.getString("account"));
				s.setAge(rs.getInt("age"));
				s.setBuildtime(rs.getString("buildtime"));
				s.setEmail(rs.getString("email"));
				s.setName(rs.getString("name"));
				s.setTel(rs.getString("tel"));
				list.add(s);
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
	public List<SystemUsersPojo> queryAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from t_systemusers";
		return queryForList(sql);
	}

	//分页查询
	@Override
	public List<SystemUsersPojo> queryListByPage(String sql, int start, int end)
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
	public List<SystemUsersPojo> queryListByParamPage(String sql,
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

	
	@Override
	public void update(SystemUsersPojo obj) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
