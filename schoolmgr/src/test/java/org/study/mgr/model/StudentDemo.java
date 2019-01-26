package org.study.mgr.model;

import static org.junit.Assert.*;

import java.util.List;

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
	
	@Test
	public void testQueryStudent() {
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			// start a transaction
			session.beginTransaction();
			
			List<Student> theStudents = null;
			/*List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}*/
			
			/*theStudents = session.createQuery("from Student s where s.lastName='Duck'", Student.class).getResultList();
			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}*/
			
			theStudents = session.createQuery("from Student s where" 
						+ " s.email LIKE '%gmail.com'", Student.class).getResultList();
			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to query an object...");
		} finally {
			factory.close();
		}
	}

	@Test
	public void testUpdateStudent() {
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			String studentId = "STX_00001";
			// start a transaction
			session.beginTransaction();
			Student theStudent = session.get(Student.class, studentId);
			log.info(theStudent);
			
			theStudent.setFirstName("Daisy");
			
			session.createQuery("update Student set email='foo@gmail.com'"
							+ " where id = 'STX_00112'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			

		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to update an object...");
		} finally {
			factory.close();
		}
	}
	
	@Test
	public void testDeleteStudent() {
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			String studentId = "STX_00082";
			// start a transaction
			session.beginTransaction();
			/*Student theStudent = session.get(Student.class, studentId);
			log.info(theStudent);
			
			session.delete(theStudent);*/
			
			session.createQuery("delete from Student where id = 'STX_00092'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			

		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to delete an object...");
		} finally {
			factory.close();
		}
	}
}
