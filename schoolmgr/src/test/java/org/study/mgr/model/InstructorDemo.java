package org.study.mgr.model;

import static org.junit.Assert.fail;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class InstructorDemo {

	@Test
	public void testCreateInstructor() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// create a object
			Instructor tempInstructor = new Instructor("david", "lee", "david@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.demo.com/david-tube", "cooking");
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the student object
			// NOTE: this will ALSO save the details object because of CascasdeType.ALL
			session.save(tempInstructor);

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
	public void testDeleteInstructor() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();

			// get instructor by the primary key / id
			int theId = 3;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			// delete the instructor
			if (tempInstructor != null) {
				// NOTE: will ALSO delete associate "detail" object
				session.delete(tempInstructor);
			}

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
	public void testGetInstructorDetail() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();
			int theId = 2;

			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			Instructor tempInstructor = tempInstructorDetail.getInstructor();

			System.out.println(tempInstructor);

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

	@Test
	public void testDeleteInstructorDetail() {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save Java object

			// start a transaction
			session.beginTransaction();
			int theId = 3;

			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			Instructor tempInstructor = tempInstructorDetail.getInstructor();

			// remove the associated object reference
			// break bi-directional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);

			session.delete(tempInstructorDetail);

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
