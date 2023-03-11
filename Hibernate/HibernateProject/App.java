package Hibernate.HibernateProject;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {

	private static Scanner scan=new Scanner(System.in);
	
//Method to Login
static void toLogin(Session session) {
	System.out.println("Enter the Login UserName: ");
	String username=scan.nextLine();
	System.out.println("Enter the Login Password: ");
	String password=scan.nextLine();
	// method call to check the login details
	DBoperations.toCheckLogin(username,password,session);
}

static void toPerformOperations(Session session) {
	int choice;
	do {
		choice=scan.nextInt();

		switch(choice) {
		case 1:
			// method call to add the books
			DBoperations.toAddBooks(session);
			break;
		case 2:
			// method call to update the book details
			DBoperations.toUpdateById(session);
			break;
		case 3:
			// method call to delete the books
			DBoperations.toDeleteById(session);
			break;
		case 4:
			// method call to search the books by BookId
			DBoperations.toSearchById(session);
			break;
		case 5:
			// method call to display all the books
			DBoperations.toDisplayAll(session);
			break;
		case 6: 
			// method call to logout
			DBoperations.toLogout();
			break;
		}}
	while(choice!=6);
}

	public static void main(String[] args) {
     
		try {
				Configuration configuration=new Configuration().configure().addAnnotatedClass(LibraryManagement.class);
				SessionFactory sessionFact=configuration.buildSessionFactory();
				Session session=sessionFact.openSession();
				toLogin(session);
			}
			catch(HibernateException  exceptionObj) {
				System.out.println(exceptionObj); 
			}

	}
}





