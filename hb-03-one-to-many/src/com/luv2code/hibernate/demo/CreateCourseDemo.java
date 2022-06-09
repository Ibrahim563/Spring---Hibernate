package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class CreateCourseDemo {

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
            
            Course course = new Course("Data Structure");
            Course course1 = new Course("Algorithms");
            
            temp.add(course);
            temp.add(course1);
            
            session.save(course);
            session.save(course1);
            
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
