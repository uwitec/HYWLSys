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
import com.hywl.util.UuidValues;

/**
 * 新闻操作DAO
 * @author Administrator
 *
 * @param <T>
 */
public class NewsDaoImpl implements NewsDao{

	private Statement stmt=null;
	private PreparedStatement pstmt = null;
	private static Connection conn = null;
	@Override
	public void add(NewsPojo t){
		
		String sql="insert into t_news (id,newsno,title,classify,abs,content,date,pname,source,status) values(?,?,?,?,?,?,?,?,?,?)";
		conn=DataBaseConn.openConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,t.getId());
			pstmt.setString(2,t.getNewsno());
			pstmt.setString(3,t.getTitle());
			pstmt.setString(4, t.getClassify());
			pstmt.setString(5, t.getAbs());
			pstmt.setString(6,t.getContent());
			pstmt.setString(7,t.getDate());
			pstmt.setString(8,t.getPname());
			pstmt.setString(9, t.getScourse());
			pstmt.setString(10, t.getStatus());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();//关闭数据库
		}
		
		
	}

	@Override
	public void update(NewsPojo obj){
		
		String sql="update t_news set ";
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
	public void delete(NewsPojo obj){
		
		String sql="delete from t_news where ";
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
		
		String sql="select * from t_news where newsno=?";
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

	public NewsPojo getById(String id){
		String sql="select * from t_news where newsno='"+id+"'";
		return queryForList(sql).get(0);
	}
	
	public List<NewsPojo> queryForList(String sql) {
		// TODO Auto-generated method stub
		List<NewsPojo> list=new ArrayList<NewsPojo>();
		
		conn=DataBaseConn.openConn();
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				NewsPojo t=new NewsPojo();
				t.setNewsno(rs.getString("newsno"));//新闻编号
				t.setDate(rs.getString("date"));//时间
				t.setTitle(rs.getString("title"));//标题
				t.setClassify(rs.getString("classify"));//类型
				t.setAbs(rs.getString("abs"));//摘要
				t.setPname(rs.getString("pname"));//操作人
				t.setStatus(rs.getString("status"));//状态
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
	public List<NewsPojo> queryAll() {
		// TODO Auto-generated method stub
		String sql="select * from t_news";
		return queryForList(sql);
	}

	//分页查询
	@Override
	public List<NewsPojo> queryListByPage(String sql1, int start, int end){
		// TODO Auto-generated method stub
		String sql="select * from t_news limit"+start+","+end+"";//语法不确定		
		return queryForList(sql);
	}

	@Override
	public int queryListByPageCount(String sql) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<NewsPojo> queryListByParamPage(String sql, Object[] params,
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
	
	//更新新闻状态
	public void updateStatus(String n,String s) {
		// TODO Auto-generated method stub
		String sql="update t_news set status='"+n+"' where newsno='"+s+"'";
		conn=DataBaseConn.openConn();
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseConn.closeConn();//关闭数据库
		}
		
		
	}
	
	

}
