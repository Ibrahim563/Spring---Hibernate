package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Instructor ins = new Instructor("Ibrahim","Hany","HM@1368");
			
			InstructorDetail insDt = new InstructorDetail("HM1368@youtube","Football");
			
			ins.setInstructorDetail(insDt);
			
			session.save(ins);

//			Instructor ins = session.get(Instructor.class, 1);
//			
//			session.delete(ins);
//			
			session.getTransaction().commit();
				
			System.out.println("Done");
		} catch (Exception e) {
		
		}
		finally {
			factory.close();
		}
	}
}
