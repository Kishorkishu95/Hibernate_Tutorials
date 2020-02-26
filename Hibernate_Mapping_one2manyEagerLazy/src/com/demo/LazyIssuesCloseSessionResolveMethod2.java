package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstuctorDetail;

public class LazyIssuesCloseSessionResolveMethod2 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")	
								.addAnnotatedClass(InstuctorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			
			int theId = 1;
			
			Query<Instructor> theQuery = session.createQuery("select i from Instructor i " 
						+ "join fetch i.courses " + "where i.id=:theInstructorId" , 
						Instructor.class);
			
			
			// Setting parameter on Query
			theQuery.setParameter("theInstructorId", theId);
			
			// Execute and get the Instructor
			
			Instructor tempInstructor= theQuery.getSingleResult();
			System.out.println("Getting the instructor : " +tempInstructor);
			System.out.println("Getting the instructor : " +tempInstructor.getCourses());

			
			session.getTransaction().commit();

			session.close();
			
			System.out.println("Session is closed here..");
			
			System.out.println("Getting the instructor : " +tempInstructor.getCourses());

			
			
			System.out.println("Done...");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			factory.close();
		}

	}

}
