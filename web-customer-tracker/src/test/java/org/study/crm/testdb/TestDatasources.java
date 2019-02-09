package org.study.crm.testdb;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
// @Transactional
public class TestDatasources {

	@Inject
	private DataSource dataSource;

	@Inject
	private SessionFactory sessionFactory;

	@Test
	public void testDataSource() {
		try {
			Connection conn = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("can't get database connection!");
		}
	}

	@Test
	public void testSessionFactory() {
		Session session = sessionFactory.getCurrentSession();

		assertNotNull(session);

	}

}
