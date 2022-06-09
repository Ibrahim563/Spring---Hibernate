

package com.luv2code.hibernate.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import entity.Instructor;
import entity.InstructorDetail;

public class DeleteDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Scanner in = new Scanner(System.in);
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            
           int id = 6;
            
            InstructorDetail insD = session.get(InstructorDetail.class, id); 
            
            System.out.println(insD);
            
//            System.out.println(insD.getInstructor());
            
//            insD.getInstructor().setInstructorDetail(null);
            
            session.delete(insD);
            System.out.println("Instructor Details deleted");
            

            session.getTransaction().commit();
            
            System.out.println("Done");
        } catch (Exception e) {

        }
        finally {
            factory.close();
        }

    }

}
