package org.study.crm.testdb;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class TestDBConnection {

	private final String jdbcUrl = "jdbc:oracle:thin:@192.168.219.88:1521:xe";
	private final String user = "springtester";
	private final String password = "1234";

	@Test
	public void testDBConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("connection failed...");
		}
	}

}
