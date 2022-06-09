package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class DeleteCourseDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            int id = 10;
            
            Course temp = session.get(Course.class, id);

            
            session.delete(temp);

            session.getTransaction().commit();

            System.out.println("Done");
        } catch (Exception e) {
               e.printStackTrace();
        }
        finally {
            factory.close();
        }

    }

}
