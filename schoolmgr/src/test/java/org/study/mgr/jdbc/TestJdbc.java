package org.study.mgr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hibtester";
		String pass = "1234";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
