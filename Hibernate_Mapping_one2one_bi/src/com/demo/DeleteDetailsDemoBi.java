package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstuctorDetail;

public class DeleteDetailsDemoBi {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")	
								.addAnnotatedClass(InstuctorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			
			int theId = 4;
			
			InstuctorDetail theInstructorDetail = session.get(InstuctorDetail.class, theId);
			
			System.out.println("Details of Instructor is : "+theInstructorDetail);
			System.out.println("Instructor primary details getting from InstructorDetail : "+theInstructorDetail.getInstructor());
			
			// Breaking the link
			theInstructorDetail.getInstructor().setInstuctorDetail(null);
			
			System.out.println("Deleting all with respect to the id ");
			session.delete(theInstructorDetail);
			
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
