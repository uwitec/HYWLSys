package com.hywl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.huel.tools.dbutil.DataBaseConn;
import com.hywl.pojo.DriverRoutePojo;
import com.hywl.util.UuidValues;
public class RouteDaoImpl implements RouteDao{

	@Override
	public void add(DriverRoutePojo obj) throws Exception {
		// TODO Auto-generated method stub
		   StringBuffer sql= new StringBuffer();
	       sql.append("insert into d_route(d_id,drivername,driverphone,carno,carweigth,carlength,d_startplace,d_destination) values(");
	       sql.append("'"+UuidValues.generateShortUuid()+"',");
	       sql.append("'"+obj.getDrivername()+"',");
	       sql.append("'"+obj.getDriverphone()+"',");
	       sql.append("'"+obj.getCarno()+"',");
	       sql.append("'"+obj.getCarweigth()+"',");
	       sql.append("'"+obj.getCarlength()+"',");
	       sql.append("'"+obj.getStartPlace()+"',");
	       sql.append("'"+obj.getDestination()+"')");	       
		   PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		   preparedStatement.execute();
		   DataBaseConn.closeConn();
	}

	@Override
	public void update(DriverRoutePojo obj) throws Exception {
		// TODO Auto-generated method stub
		 StringBuffer sql= new StringBuffer();
		 sql.append("update d_route set d_startplace=? and d_destination=?");
		 PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		 preparedStatement.setString(1, obj.getStartPlace());
		 preparedStatement.setString(2, obj.getDestination());
		 preparedStatement.executeUpdate();
		 DataBaseConn.closeConn();
	}


	@Override
	public void delete(DriverRoutePojo obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean queryById(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DriverRoutePojo> queryAll() throws Exception {
		// TODO Auto-generated method stub
		List<DriverRoutePojo> list=new ArrayList<DriverRoutePojo>();
		StringBuffer sql= new StringBuffer();
		sql.append("select * from d_route");
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()){
			DriverRoutePojo drp=new DriverRoutePojo();
			drp.setStartPlace(rs.getString("d_startplace"));
			drp.setDestination(rs.getString("d_destination"));
			drp.setCarweigth(rs.getFloat("carweigth"));
			drp.setCarlength(rs.getFloat("carlength"));
			drp.setCarno(rs.getString("carno"));
			drp.setDriverphone(rs.getString("driverphone"));
			drp.setDrivername(rs.getString("drivername"));
			list.add(drp);
		}
		System.out.println("list3"+list.size());
		return list;
	}

	@Override
	public List<DriverRoutePojo> queryListByPage(String sql, int start, int end)
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
	public List<DriverRoutePojo> queryListByParamPage(String sql,
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
	public void update(Object... params){
		// TODO Auto-generated method stub
	}

	@Override
	public List<DriverRoutePojo> queryByRoute(String startplace,
			String destination) throws SQLException {
		// TODO Auto-generated method stub
		List<DriverRoutePojo> list=new ArrayList<DriverRoutePojo>();
		StringBuffer sql= new StringBuffer();
		sql.append("select * from d_route where d_startplace=? and d_destination=?");
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		preparedStatement.setString(1, startplace);
		preparedStatement.setString(2, destination);
		ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()){
			DriverRoutePojo drp=new DriverRoutePojo();
			drp.setDriverphone(rs.getString("driverphone"));
			drp.setDrivername(rs.getString("drivername"));
			drp.setStartPlace(rs.getString("d_startplace"));
			drp.setDestination(rs.getString("d_destination"));
			drp.setCarno(rs.getString("carno"));
			drp.setCarweigth(rs.getFloat("carweigth"));
			drp.setCarlength(rs.getFloat("carlength"));
			list.add(drp);
		}
		return list;
	}

	public List<DriverRoutePojo> queryByPhone(String phone) throws SQLException {
		// TODO Auto-generated method stub
		List<DriverRoutePojo> list=new ArrayList<DriverRoutePojo>();
		StringBuffer sql= new StringBuffer();
		sql.append("select * from d_route where driverphone=?");
		PreparedStatement preparedStatement=DataBaseConn.createPreparedStatement(sql.toString());
		preparedStatement.setString(1, phone);
		ResultSet rs=preparedStatement.executeQuery();
		while(rs.next()){
			DriverRoutePojo drp=new DriverRoutePojo();
			drp.setDriverphone(rs.getString("driverphone"));
			drp.setDrivername(rs.getString("drivername"));
			drp.setStartPlace(rs.getString("d_startplace"));
			drp.setDestination(rs.getString("d_destination"));
			drp.setCarno(rs.getString("carno"));
			drp.setCarweigth(rs.getFloat("carweigth"));
			drp.setCarlength(rs.getFloat("carlength"));
			list.add(drp);
		}
		return list;
	}	
}
