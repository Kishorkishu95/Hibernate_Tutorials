package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstuctorDetail;

public class CreateCourseDemo {

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
			
			Course course1 = new Course("Data Science");
			Course course2 = new Course("Machine Learning");
			Course course3 = new Course("Artificial Intelligence");
			
			// Adding Courses to the Instructor
			System.out.println("Courses Added...");
			theInstructor.add(course1);
			theInstructor.add(course2);
			theInstructor.add(course3);
			
			System.out.println("Courses Saved...");
			// Saving the Courses
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			session.getTransaction().commit();
			
			System.out.println("Done...");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			session.close();
			factory.close();
		}

	}

}
