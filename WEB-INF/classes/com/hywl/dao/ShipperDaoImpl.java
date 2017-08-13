package com.hywl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.huel.tools.dbutil.DataBaseConn;
import com.hywl.pojo.ShipperPojo;
import com.hywl.util.DateUtil;
import com.hywl.util.UuidValues;


public class ShipperDaoImpl implements ShipperDao{
	@Override
	public void add(ShipperPojo obj) throws Exception {
		// TODO Auto-generated method stub
		   StringBuffer sql= new StringBuffer();
	       sql.append("insert into s_shipper(id,sname,spassword,sphone,sregister_time) values(");
	       sql.append("'"+UuidValues.generateShortUuid()+"',");
	       sql.append("'"+obj.getSname()+"',");
	       sql.append("'"+obj.getSpassword()+"',");
	       sql.append("'"+obj.getSphone()+"',");
	       sql.append("'"+DateUtil.getDateTime()+"')");	       
		   PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		   preparedStatement.execute();
		   DataBaseConn.closeConn();
	}
	public String queryIdByPhone(String str) throws SQLException{
		String id;
		StringBuffer sql= new StringBuffer();
		sql.append("select id from s_shipper where sphone=?");	
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		preparedStatement.setString(1, str);
		ResultSet rs=preparedStatement.executeQuery();
		if(rs.next()){
			 id=rs.getString("id");
			 return id;
		}
		return str;		
	}
	@Override
	public void update(ShipperPojo obj) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql= new StringBuffer();
		System.out.println(obj.getSphone());
		String id=queryIdByPhone(obj.getSphone().trim());
		System.out.println(id);
		//String id="DyFRRJfk";
		sql.append("update s_shipper set id='"+id+"'");		
		if(!obj.getSname().equals("")){
			sql.append(",sname='"+obj.getSname()+"'");			
		}
		if(!obj.getSpassword().equals("")){
			sql.append(",spassword='"+obj.getSpassword()+"'");					
		}
		if(obj.getSscore()!=-1){
			sql.append(",sscore='"+obj.getSscore()+"'");

		}
		if(!obj.getChangePhone().equals("")){
			sql.append(",sphone='"+obj.getChangePhone()+"'");
		}
		if(obj.getSsumnumber()!=-1){
			sql.append(",ssumnumber='"+obj.getSsumnumber()+"'");
		}
		if(obj.getSstar()!=-1){
			sql.append(",sstar='"+obj.getSstar()+"'");
		}
		if(obj.getSnicerate()!=-1){
			sql.append(",snicerate='"+obj.getSnicerate()+"'");
		}
		sql.append("where id='"+id+"'");
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		preparedStatement.executeUpdate();
		DataBaseConn.closeConn();
	}
	@Override
	public void delete(ShipperPojo obj) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql= new StringBuffer();
		sql.append("delete from s_shipper where sphone=?");
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		preparedStatement.setString(1, obj.getSphone());
		preparedStatement.executeUpdate();
	}
	@Override
	public boolean queryById(String id) {
		// TODO Auto-generated method stub
		StringBuffer sql= new StringBuffer();
		sql.append("delete from s_shipper where sphone='"+id+"'");
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
	public List<ShipperPojo> queryAll() throws Exception {		
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ShipperPojo> queryListByPage(String sql, int start, int end)
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
	public List<ShipperPojo> queryListByParamPage(String sql, Object[] params,
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
		sql.append("select * from s_shipper where sphone=?");		
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		preparedStatement.setString(1, phone);
		ResultSet rs=preparedStatement.executeQuery();
		if(rs.next()){
			return false;
		}
		return true;
	}
	public  boolean queryByPhone(ShipperPojo shipper) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer();
		sql.append("select * from s_shipper where sphone=? and spassword=?");		
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		preparedStatement.setString(1, shipper.getSphone());
		preparedStatement.setString(2, shipper.getSpassword());
		ResultSet rs=preparedStatement.executeQuery();
		if(rs.next()){
			return true;
		}
		return false;
	}
		
	public List<ShipperPojo> queryForList(StringBuffer sql) {
		// TODO Auto-generated method stub
		//StringBuffer sql=new StringBuffer();
		List<ShipperPojo> list=new ArrayList<ShipperPojo>();
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		try {
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()){
				ShipperPojo t=new ShipperPojo();
				t.setSname(rs.getString("sname"));
				t.setSphone(rs.getString("sphone"));
				t.setSscore(rs.getInt("sscore"));
				t.setSstar(rs.getInt("sstar"));
				t.setSnicerate(rs.getFloat("snicerate"));
				t.setSsumnumber(rs.getInt("ssumnumber"));
				t.setSregister_time(rs.getDate("sregister_time"));
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
	public List<ShipperPojo> queryAll(ShipperPojo obj) throws SQLException {
		// TODO Auto-generated method stub
		int i=0;
		StringBuffer sql=new StringBuffer();
		sql.append("select * from s_shipper");
		if(!obj.getSphone().equals("")){
			if(i==0){
			    sql.append(" where sphone='"+obj.getSphone()+"'");
			i=1;
			}
		}
		if(!obj.getSname().equals("")){
			if(i==0){
			sql.append(" where sname='"+obj.getSname()+"'");	
			i=1;
			}else{
				sql.append("and sname='"+obj.getSname()+"'");	
			}
		}
		
		if(obj.getSscore()!=-1){
			if(i==0){
				sql.append(" where sscore='"+obj.getSscore()+"'");
				i=1;
			}else{
				sql.append("and sscore='"+obj.getSscore()+"'");
			}
		}
		if(obj.getSsumnumber()!=-1){
			if(i==0){
			sql.append(" where ssumnumber='"+obj.getSsumnumber()+"'");
			}else{
				sql.append("and ssumnumber='"+obj.getSsumnumber()+"'");
			}
		}
		if(obj.getSstar()!=-1){
			if(i==0){
			sql.append(" where sstar='"+obj.getSstar()+"'");
			i=1;
			}else{
				sql.append("and sstar='"+obj.getSstar()+"'");
			}
		}
		if(obj.getSnicerate()!=-1){
			if(i==0){
			sql.append(" where snicerate='"+obj.getSnicerate()+"'");
			i=1;
			}else{
				sql.append("and snicerate='"+obj.getSnicerate()+"'");
			}
		}
		return queryForList(sql);
	}
	@Override
	public void update(Object... params) {
		// TODO Auto-generated method stub
		
	}
	
	
}
