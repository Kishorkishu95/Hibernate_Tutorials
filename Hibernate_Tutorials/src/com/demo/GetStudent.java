package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class GetStudent {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")	
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Student theStudent = session.get(Student.class, 100);
		
		System.out.println("Student here : "+theStudent);
		
		session.getTransaction().commit();
		
		System.out.println("Done...");

	}

}
