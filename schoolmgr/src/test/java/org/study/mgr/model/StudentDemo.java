package org.study.mgr.model;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class StudentDemo {

	Logger log = Logger.getLogger(StudentDemo.class);
	
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
	
	@Test
	public void testReadStudent() {
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
			Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find out the student's id: primary key
			String studentId = tempStudent.getId();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student recStudent = session.get(Student.class, studentId);
			
			session.close();
			
			log.debug(recStudent);
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to save an object...");
		} finally {
			factory.close();
		}
	}

}
