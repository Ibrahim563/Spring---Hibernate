package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class GetInstructorCourses {

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

            int id = 1;
            Instructor temp ;
            
            temp =  session.get(Instructor.class, id);
            
            System.out.println("instructor :"+ temp);
            
            System.out.println("instructor Courses:"+ temp.getCourses());
            
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
