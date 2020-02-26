package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating 2 new  student object");
			Student std1 = new Student("anusha", "Anu", "lovefor@gmail.com");
			Student std2 = new Student("Ranga", "kc", "ranga95@gmail.com");

			session.beginTransaction();
			
			System.out.println("Saving.....");
			session.save(std1);
			session.save(std2);
			
			session.getTransaction().commit();
			System.out.println("Done...................");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
