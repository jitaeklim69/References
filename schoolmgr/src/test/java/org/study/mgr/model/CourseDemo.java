package org.study.mgr.model;

import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CourseDemo {

	@Test
	public void testCreateInstructor() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();

			Instructor tempInstructor = new Instructor("Susan", "Public", "susan@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com/susan", "Video game");
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			session.save(tempInstructor);

			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to create an object...");
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

	@Test
	public void testCreateCourse() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");

			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);

			session.save(tempCourse1);
			session.save(tempCourse2);
			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to create an object...");
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

	@Test
	public void testGetInstructorCourses() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println(tempInstructor);
			System.out.println(tempInstructor.getCourses());

			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to create an object...");
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

	@Test
	public void testDeleteCourse() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			int theId = 1;
			Course tempCourse = session.get(Course.class, theId);

			session.delete(tempCourse);

			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to create an object...");
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}
}
