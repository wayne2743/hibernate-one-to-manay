package com.luv2code.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		//create sessioin
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to sqve Java object
			
			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Daffy","Duck", "daffy@luv2code.com");
			
			
			//start a  transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saveing th student...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			//My new code
			
			//ind out the student's id: primary key
			System.out.println("Saved student. Generate id : " + tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id:　" + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
						
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
