package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstuctorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")	
								.addAnnotatedClass(InstuctorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
//			Instructor tempInstructor = new Instructor("Kishor", "B", "kishorb299@gmail.com");
//			InstuctorDetail tempInstructorDetail = new InstuctorDetail("https://www.youtube.com/channel/UCfRWYPK6CK_4PINdbrV7SpA?view_as=subscriber", "Playing cricket");
			
			Instructor tempInstructor = new Instructor("Anusha", "T", "anukishu95@gmail.com");
			InstuctorDetail tempInstructorDetail = new InstuctorDetail("https://www.youtube.com/channel/UCfRWYPK6CK_4PINdbrV7SpA?view_as=subscriber", "love forever");
		
			
			tempInstructor.setInstuctorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			System.out.println("Saving both the details...");
			session.save(tempInstructor);

			session.getTransaction().commit();
			System.out.println("Done...");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
