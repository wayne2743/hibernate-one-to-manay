package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.Instructor;



public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		//create sessioin
		Session session = factory.getCurrentSession();
		
		try {
			//create the objecs
/*
			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			InstructorDetail tempInsructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code !!!");
*/
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			InstructorDetail tempInsructorDetail = new InstructorDetail("http://www.youtube.com", "Guiter");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInsructorDetail); 
			
			
			
			//start a  transaction
			session.beginTransaction();
			
			// save the student object
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
