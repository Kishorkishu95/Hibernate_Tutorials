package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")	
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			

			session.beginTransaction();
			
			System.out.println("Deleting the student..");
			
//			int studentId = 101;
//			Student theStudent = session.get(Student.class, studentId);		
//			session.delete(theStudent);
			
			
			session.createQuery("delete from Student where id=100").executeUpdate();
			
			
			session.getTransaction().commit();
			System.out.println("Done...................");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
