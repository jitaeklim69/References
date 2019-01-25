package org.study.mgr.model;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class StudentDemo {

	@Test
	public void testCreateStudent() {
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			
			// create a student object
			Student tempStudent = new Student("연주", "임", "yeonju@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to save an object...");
		} finally {
			factory.close();
		}
	}

}
