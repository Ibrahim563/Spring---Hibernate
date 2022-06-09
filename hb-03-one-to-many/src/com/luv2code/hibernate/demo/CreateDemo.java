package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            Instructor tempIns = new Instructor("Ibrahim", "Hany", "himahany1368@gmail.com");
            InstructorDetail insDt = new InstructorDetail("Channel","Football");
            tempIns.setInstructorDetail(insDt);
            
            session.save(tempIns);
            
            
            
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
