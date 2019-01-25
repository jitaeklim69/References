package org.study.mgr.jdbc;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class TestJdbcConn {

	@Test
	public void testJdbcConn() {
		String jdbcUrl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hibtester";
		String pass = "1234334";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
			assertNotNull(myConn);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Connection failed");
		}
	}

}
