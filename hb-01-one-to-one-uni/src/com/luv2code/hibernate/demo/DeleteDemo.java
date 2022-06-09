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
            
//            get instructor ny id
            
            int id;
            System.out.println("enter Entity id you want to delete ");
            id = in.nextInt();
            Instructor temp = session.get(Instructor.class, id);
            
            
            if(temp!=null) {
                session.delete(temp);
                
                System.out.println("Instructor Deleted");
            }
            else {
                System.out.println("Instructor not found");
            }
//            delete instructor
            
            session.getTransaction().commit();
            
            System.out.println("Done");
        } catch (Exception e) {

        }
        finally {
            factory.close();
        }

    }

}
