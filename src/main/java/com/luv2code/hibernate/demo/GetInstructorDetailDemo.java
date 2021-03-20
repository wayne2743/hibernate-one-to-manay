
package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.Instructor;



public class GetInstructorDetailDemo {

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
			
			// get the instructor detail object
			int theId = 99;
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			// print the instrctor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			
			// print the associated instructor
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
