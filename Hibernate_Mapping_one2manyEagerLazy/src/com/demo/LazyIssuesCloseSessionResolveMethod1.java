package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstuctorDetail;

public class LazyIssuesCloseSessionResolveMethod1 {

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
			Instructor theInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Kishor>>>>>Displaying the Instructor.."+theInstructor);
			
			System.out.println("Kishor>>>>>Displaying the Courses : "+theInstructor.getCourses());
			
			session.getTransaction().commit();

			session.close();
			
			System.out.println("Session is closed here..");
			
			System.out.println("Kishor>>>>>Displaying the Courses : "+theInstructor.getCourses());
			
			
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
