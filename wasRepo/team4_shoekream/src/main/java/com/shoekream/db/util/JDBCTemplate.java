package com.shoekream.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTemplate {
	
	// Connection
	public static Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String id = "C##SHOEKREAM";
	    String pwd = "1234";
		
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		conn.setAutoCommit(false);
		return conn;
	}
	
	// close(conn)
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.close();
			}
		} catch(Exception e) {
			
		}
	}
	
	// close(stmt)
	public static void close(Statement stmt) {
		try {
			if(stmt!=null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch(Exception e) {
			
		}
	}
	
	// close(rs)
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed()) {
				rs.close();
			}
		} catch(Exception e) {
			
		}
	}
	
	// commit
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.commit();
			}
		} catch(Exception e) {
			
		}
	}
	
	// rollback
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch(Exception e) {
			
		}
	}
}
