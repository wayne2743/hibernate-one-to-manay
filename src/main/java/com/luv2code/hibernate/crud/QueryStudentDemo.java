package com.luv2code.hibernate.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class QueryStudentDemo {

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

			
			//start a  transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displyaStudents(theStudents);
			// query students : lastName="Dow"
			theStudents = session.createQuery("from Student s where s.lastName='Dow'").getResultList();
			
			
			//display the students
			System.out.println("\n\nStudents who have last name of Dow");
			displyaStudents(theStudents);
			
			// query students: lastName='Dow' OR firstName='Daffy'
			theStudents = session.createQuery("from Student s where "
												+ "s.lastName='Dow' OR s.firstName='Daffy'").getResultList();

			//display the students
			System.out.println("\n\nStudents who have last name of Dow or first name of Daffy");
			displyaStudents(theStudents);
			
			// query students where email LIKE '&luv2code.com'
			theStudents = session.createQuery("from Student s where "
												+ "s.email LIKE '%luv2code.com'").getResultList();
			//display the students
			System.out.println("\n\nStudents who email ends with luv2code.com");
			displyaStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
	
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

	private static void displyaStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
