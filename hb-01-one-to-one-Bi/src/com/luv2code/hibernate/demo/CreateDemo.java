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

            int id = 40 ;


            InstructorDetail insDt = session.get(InstructorDetail.class, id);
            System.out.println(insDt);
            System.out.println(insDt.getInstructor());



            //			Instructor ins = session.get(Instructor.class, 1);
            //			
            //			session.delete(ins);
            //			
            session.getTransaction().commit();

            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();

        }
    }
}
