package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")	
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating the student object");
			Student std = new Student("Kish", "kishuu", "kishorkishu.b@outlook.com");
			
			session.beginTransaction();
			System.out.println("Saving.....");
			session.save(std);
			session.getTransaction().commit();
			System.out.println("Done...................");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
