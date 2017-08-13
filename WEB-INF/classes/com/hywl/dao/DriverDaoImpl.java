package com.hywl.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.huel.tools.dbutil.DataBaseConn;
import com.hywl.pojo.DriverPojo;
import com.hywl.util.DateUtil;
import com.hywl.util.UuidValues;

public class DriverDaoImpl implements DriverDao{
	

	@Override
	public void add(DriverPojo obj) throws Exception {
		// TODO Auto-generated method stub
		   StringBuffer sql= new StringBuffer();
	       sql.append("insert into d_driver(d_id,d_name,d_passwd,d_phone,d_registtime) values(");
	       sql.append("'"+UuidValues.generateShortUuid()+"',");
	       sql.append("'"+obj.getName()+"',");
	       sql.append("'"+obj.getPasswd()+"',");
	       sql.append("'"+obj.getPhone()+"',");
	       sql.append("'"+DateUtil.getDateTime()+"')");	       
		   PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		   preparedStatement.execute();
		   DataBaseConn.closeConn();
	}
	
	public String queryIdByPhone(String str) throws SQLException{
		String id;
		StringBuffer sql= new StringBuffer();
		sql.append("select d_id from d_driver where d_phone=?");	
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		preparedStatement.setString(1, str);
		ResultSet rs=preparedStatement.executeQuery();
		if(rs.next()){
			 id=rs.getString("d_id");
			 return id;
		}
		return str;		
	}

	@Override
	public void update(DriverPojo obj) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql= new StringBuffer();	
		String id=queryIdByPhone(obj.getPhone());
		System.out.println(id);
		sql.append("update d_driver set d_id='"+id+"'");		
		if(!obj.getName().equals("")){
			sql.append(",d_name='"+obj.getName()+"'");			
		}
		if(!obj.getPasswd().equals("")){
			sql.append(",d_passwd='"+obj.getPasswd()+"'");					
		}
		if(obj.getIntegral()!=-1){
			sql.append(",d_integral='"+obj.getIntegral()+"'");

		}
		if(!obj.getChangePhone().equals("")){
			sql.append(",d_phone='"+obj.getChangePhone()+"'");
		}
		if(obj.getVolum()!=-1){
			sql.append(",d_volum='"+obj.getVolum()+"'");
		}
		if(obj.getStar()!=-1){
			sql.append(",d_star='"+obj.getStar()+"'");
		}
		if(obj.getGoodreview()!=-1){
			sql.append(",d_goodreview='"+obj.getGoodreview()+"'");
		}
		sql.append("where d_id='"+id+"'");
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		preparedStatement.executeUpdate();
		DataBaseConn.closeConn();
	}

	@Override
	public void delete(DriverPojo obj) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql= new StringBuffer();
		sql.append("delete from d_driver where d_phone=?");
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		preparedStatement.setString(1, obj.getPhone());
		preparedStatement.executeUpdate();
	}

	@Override
	public boolean queryById(String id) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql= new StringBuffer();
		sql.append("delete from d_driver where d_phone='"+id+"'");
		Statement stmt;
		try {
			stmt = DataBaseConn.openConn().createStatement();
			ResultSet rs=stmt.executeQuery(sql.toString());
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

	@Override
	public List<DriverPojo> queryAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DriverPojo> queryListByPage(String sql, int start, int end)
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
	public List<DriverPojo> queryListByParamPage(String sql, Object[] params,
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
	public boolean queryByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("select * from d_driver where d_phone=?");		
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		preparedStatement.setString(1, phone);
		ResultSet rs=preparedStatement.executeQuery();
		if(rs.next()){
			return false;
		}
		return true;
	}
	
	public  boolean queryByPhone(DriverPojo driver) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("select * from d_driver where d_phone=? and d_passwd=?");		
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		preparedStatement.setString(1, driver.getPhone());
		preparedStatement.setString(2, driver.getPasswd());
		ResultSet rs=preparedStatement.executeQuery();
		if(rs.next()){
			return true;
		}
		return false;
	}
	
	
	public List<DriverPojo> queryForList(StringBuffer sql) {
		// TODO Auto-generated method stub
		//StringBuffer sql=new StringBuffer();
		List<DriverPojo> list=new ArrayList<DriverPojo>();
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		try {
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()){
				DriverPojo t=new DriverPojo();
				t.setName(rs.getString("d_name"));
				t.setPhone(rs.getString("d_phone"));
				t.setIntegral(rs.getInt("d_integral"));
				t.setStar(rs.getInt("d_star"));
				t.setGoodreview(rs.getFloat("d_goodreview"));
				t.setVolum(rs.getInt("d_volum"));
				t.setRegisttime(rs.getDate("d_registtime"));
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
	
	
	public List<DriverPojo> queryAll(DriverPojo obj) throws SQLException {
		// TODO Auto-generated method stub
		int i=0;
		StringBuffer sql=new StringBuffer();
		sql.append("select * from d_driver");
		if(!obj.getPhone().equals("")){
			if(i==0){
			    sql.append(" where d_phone='"+obj.getPhone()+"'");
			i=1;
			}
		}
		if(!obj.getName().equals("")){
			if(i==0){
			sql.append(" where d_name='"+obj.getName()+"'");	
			i=1;
			}else{
				sql.append("and d_name='"+obj.getName()+"'");	
			}
		}
		
		if(obj.getIntegral()!=-1){
			if(i==0){
				sql.append(" where d_integral='"+obj.getIntegral()+"'");
				i=1;
			}else{
				sql.append("and d_integral='"+obj.getIntegral()+"'");
			}
		}
		if(obj.getVolum()!=-1){
			if(i==0){
			sql.append(" where d_volum='"+obj.getVolum()+"'");
			}else{
				sql.append("and d_volum='"+obj.getVolum()+"'");
			}
		}
		if(obj.getStar()!=-1){
			if(i==0){
			sql.append(" where d_star='"+obj.getStar()+"'");
			i=1;
			}else{
				sql.append("and d_star='"+obj.getStar()+"'");
			}
		}
		if(obj.getGoodreview()!=-1){
			if(i==0){
			sql.append(" where d_goodreview='"+obj.getGoodreview()+"'");
			i=1;
			}else{
				sql.append("and d_goodreview='"+obj.getGoodreview()+"'");
			}
		}
		return queryForList(sql);
	}

	@Override
	public void update(Object... params) {
		// TODO Auto-generated method stub
		
	}

}
