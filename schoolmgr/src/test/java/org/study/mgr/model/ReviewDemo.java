package org.study.mgr.model;

import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class ReviewDemo {

	@Test
	public void testCreateCourseAndReview() {
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
			tempCourse.addReview(new Review("Great course ... loved it!"));
			tempCourse.addReview(new Review("Cool"));
			tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

			session.save(tempCourse);

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
	public void testGetCourseAndReview() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();

			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);

			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());

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
	public void testDeleteCourseAndReview() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")

				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();

			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);

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
