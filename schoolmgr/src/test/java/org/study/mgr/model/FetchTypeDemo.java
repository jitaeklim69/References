package org.study.mgr.model;

import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class FetchTypeDemo {

	@Test
	public void testFetchTypeEager() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();
			int theId = 1;

			Instructor tempInstructor = session.get(Instructor.class, theId);
			// HERE, toggle the break point for debug
			System.out.println(tempInstructor);

			System.out.println(tempInstructor.getCourses());

			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to get an object...");
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

}
