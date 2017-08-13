package com.hywl.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.huel.tools.dbutil.DataBaseConn;

public class PojoDaoImpl {

	private PreparedStatement pstmt = null;
	private static Connection conn = null;

	public void add(String sql, Object... args) {
		// TODO Auto-generated method stub
		alter(sql, args);
	}


	public void update(String sql, Object... args) throws Exception {
		// TODO Auto-generated method stub
		alter(sql, args);
	}

	
	public void delete(String sql, Object... args) throws Exception {
		// TODO Auto-generated method stub
		alter(sql, args);
	}

	
	
	public boolean queryById(String sql, Object... args) throws Exception {
		// TODO Auto-generated method stub
		conn = new DataBaseConn().openConn();
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				pstmt.setObject(i + 1, args[i]);
			}
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new DataBaseConn().closeConn();// �ر���ݿ�����
		}
		return false;
	}

	/**
	 * 查询所有记录
	 */
	public <T> List<T> queryAll(Class<T> clazz, String sql, Object... args) {
		List<T> list = new ArrayList<>();
		ResultSet rs = null;
		conn = new DataBaseConn().openConn();
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				pstmt.setObject(i + 1, args[i]);
			}
			rs = pstmt.executeQuery();
			List<Map<String, Object>> values = handleResultSetToMapList(rs);
			list = transformMapToBeanList(clazz, values);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new DataBaseConn().closeConn();
		}

		return list;
	}


	public <T> List<T> queryListByPage(Class<T> clazz, String sql,
			Object... args) throws Exception {
		// TODO Auto-generated method stub
		List<T> list = queryAll(clazz, sql, args);
		return list;
	}

	
	public <T> int queryListByPageCount(Class<T> clazz, String sql,
			Object... args) throws Exception {
		// TODO Auto-generated method stub
		List<T> list = queryAll(clazz, sql, args);
		return list.size();
	}


	public <T> List<T> queryListByParamPage(Class<T> clazz, String sql,
			Object... args) throws Exception {
		// TODO Auto-generated method stub
		List<T> list = queryAll(clazz, sql, args);
		return list;
	}


	public <T> int queryListByParamPageCount(Class<T> clazz, String sql,
			Object... args) throws Exception {
		// TODO Auto-generated method stub
		List<T> list = queryAll(clazz, sql, args);
		return list.size();
	}

	public void alter(String sql, Object... args) {
		conn = new DataBaseConn().openConn();
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				pstmt.setObject(i + 1, args[i]);
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			new DataBaseConn().closeConn();// �ر���ݿ�����
		}
	}

	private <T> List<T> transformMapToBeanList(Class<T> clazz,
			List<Map<String, Object>> values) throws InstantiationException,
			IllegalAccessException, InvocationTargetException {
		T bean = null;
		List<T> list = new ArrayList<>();
		if (values.size() > 0) {
			for (Map<String, Object> m : values) {
				bean = clazz.newInstance();
				for (Map.Entry<String, Object> entry : m.entrySet()) {
					String name = entry.getKey();
					Object value = entry.getValue();
					BeanUtils.setProperty(bean, name, value);// 为实类属性赋值
				}
				list.add(bean);
			}
		}

		return list;
	}

	/**
	 * 
	 * @param rSet
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	private List<Map<String, Object>> handleResultSetToMapList(ResultSet rSet)
			throws Exception, SQLException {
		List<String> columnLabels = getColumnLable(rSet);
		Map<String, Object> map = null;
		List<Map<String, Object>> values = new ArrayList<>();
		while (rSet.next()) {
			map = new HashMap<String, Object>();
			for (String columnLabel : columnLabels) {
				Object value = rSet.getObject(columnLabel);
				map.put(columnLabel, value);
			}
			values.add(map);
		}
		return values;
	}

	
	private List<String> getColumnLable(ResultSet rs) throws Exception {
		List<String> labels = new ArrayList<>();

		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			String columnLabel = rsmd.getColumnLabel(i + 1);
			//System.out.println("列名："+columnLabel);
			labels.add(columnLabel);
		}
		return labels;
	}

}
