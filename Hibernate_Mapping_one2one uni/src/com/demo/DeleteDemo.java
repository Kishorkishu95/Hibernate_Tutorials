package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstuctorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")	
								.addAnnotatedClass(InstuctorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			
			// Getting the instructor to delete by id
			int theId = 2;
			Instructor theInstuctor = session.get(Instructor.class, theId);
			
			session.delete(theInstuctor);
			
			session.getTransaction().commit();
			
			System.out.println("Done...");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
