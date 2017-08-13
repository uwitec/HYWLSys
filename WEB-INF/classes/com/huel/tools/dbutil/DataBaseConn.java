package com.huel.tools.dbutil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
public class DataBaseConn {
	public static Connection conn = null;
	public static String driverClass = "";
	public static String dbURL = "";
	public static String dbUser = "";
	public static String dbPwd = "";
	private static PreparedStatement preparedStatement;

	static {
		loadProperty();
	}

	public static boolean loadProperty() {
		Properties properties = new Properties();
		try {
			properties.load(DataBaseConn.class
					.getResourceAsStream("db.properties"));
			driverClass = properties.getProperty("drivername");
			dbURL = properties.getProperty("dburl");
			dbUser = properties.getProperty("username");
			dbPwd = properties.getProperty("password");
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public static Connection openConn() {
		try {
			Class.forName(driverClass).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			
		}

		try {
			conn = DriverManager.getConnection(dbURL, dbUser, dbPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}
	  public static PreparedStatement createPreparedStatement(String sql){
		  try {
		     if(conn==null){
				 conn=openConn();
			 }
		     preparedStatement = conn.prepareStatement(sql);
		     
		  }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return preparedStatement;
	  }

}
