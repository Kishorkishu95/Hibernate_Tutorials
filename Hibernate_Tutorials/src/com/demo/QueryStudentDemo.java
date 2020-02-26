package com.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")	
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();

			System.out.println("Querying the students and displaying the same..");
//			List<Student> theStudents = session.createQuery("from Student").getResultList();
//		    List<Student> theStudents = session
//									.createQuery("from Student s where s.lastName='Anu'")
//									.getResultList();
//			List<Student> theStudents = session
//					.createQuery("from Student s where" + " s.firstName='Kish' or s.lastName='Anu'")
//					.getResultList();
//			List<Student> theStudents = session
//					.createQuery("from Student s where" + " s.email='kishorkishu.b@outlook.com'")
//					.getResultList();
			List<Student> theStudents = session
					.createQuery("from Student s where" + " s.email like '%@gmail.com'")
					.getResultList();
			
			
			System.out.println("Loop through the List..");
			displayStudents(theStudents);
			
			session.getTransaction().commit();
			System.out.println("Done...................");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student s: theStudents) {
			System.out.println(s);
		}
	}

}
