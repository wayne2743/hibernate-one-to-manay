
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.Instructor;



public class DeleteDemo {

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
						
			//start a  transaction
			session.beginTransaction();
			
			// get instructor by primary key / id
			int theId =1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			
			// delete the instructor
			System.out.println("Saving instructor: " + tempInstructor);
			session.delete(tempInstructor);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
