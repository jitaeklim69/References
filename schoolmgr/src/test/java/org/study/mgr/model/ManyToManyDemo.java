package org.study.mgr.model;

import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class ManyToManyDemo {

	@Test
	public void testCreateCourseAndStudents() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")

				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();

			Course tempCourse = new Course("Pacman - How to Score One Million Points");

			session.save(tempCourse);

			Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");

			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			session.save(tempStudent1);
			session.save(tempStudent2);

			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to save an object...");
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

	@Test
	public void testAddCoursesForStudent() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")

				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();

			String theId = "STX_00002";
			Student tempStudent = session.get(Student.class, theId);

			System.out.println(tempStudent);
			System.out.println(tempStudent.getCourses());

			Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
			Course tempCourse2 = new Course("Atari 2600 - Game Development");

			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);

			session.save(tempCourse1);
			session.save(tempCourse2);

			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to save an object...");
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

	@Test
	public void testGetCoursesFromStudent() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")

				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();

			String theId = "STX_00002";
			Student tempStudent = session.get(Student.class, theId);

			System.out.println(tempStudent);
			System.out.println(tempStudent.getCourses());

			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to save an object...");
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

	@Test
	public void testDeleteCourse() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")

				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();

			int courseId = 11;
			Course tempCourse = session.get(Course.class, courseId);

			session.delete(tempCourse);

			// commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("fail to save an object...");
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}
}
