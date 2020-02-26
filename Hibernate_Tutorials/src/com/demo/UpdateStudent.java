package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")	
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			

			session.beginTransaction();
			
		//	int studentId = 2;
		//	Student theStudent = session.get(Student.class, studentId);		
		//	theStudent.setLastName("Kishor");
			
			
			System.out.println("Updating the foo@gmail.com to all..");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			
			session.getTransaction().commit();
			System.out.println("Done...................");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
