package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 

/**
 * @title 测试驱动JAR包连接数据库 
 * @author Zain.Luo
 * @version 1.0<br>
 * history<br>
 * 2016年10月9日 Zain.Luo create file<br>
 * Id:TestConnect.java,v1.0 2016年10月9日 下午4:09:07
 */
public class TestConnect {
	public static void main(String[] args) {
		Connection conn = null;
		String sql ="";
		
		String url="jdbc:mysql://115.29.96.82:3306/zain?user=zain&password=xian244231&useUnicode=true&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =  DriverManager.getConnection(url);
			Statement st = conn.createStatement();
			sql = "select * from test";
			ResultSet rs =  st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt(1)+"-"+rs.getString(2)+"-"+rs.getString(3));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
