package Hibernate.HibernateProject;


	import java.util.Scanner;
	import org.hibernate.Session;
	import com.mysql.cj.Query;


	public class DBoperations {

		private static	LibraryManagement LibraryObj;
		private static Scanner scan=new Scanner(System.in);
		
		// method to check the login details
			static void toCheckLogin(String username,String password,Session session) {
				if(username.equals("LibraryManagement") && password.equals("library@123")) {
					System.out.println("Logged In Successfully");
					System.out.println();
					System.out.println("Enter a number from the below options");
					System.out.print("1.Add the books"+ '\n'+"2.Update By BookId" +'\n'+ "3.Delete a book"+'\n'+"4.Search a book" +'\n'+"5.Display All" + '\n' +"6.Exit" );

					App.toPerformOperations(session);
				}
				else {
					System.out.println("Please Enter the correct Login Credentials!");
				}}

		// method to add the books
		static void toAddBooks(Session session) {

			LibraryObj=new LibraryManagement();

			System.out.println("Enter the BookID: ");
			LibraryObj.setBookId(scan.nextInt());

			System.out.println("Enter the BookName: ");
			LibraryObj.setBookName(scan.next());

			System.out.println("Enter the AuthorName: ");
			LibraryObj.setAuthorName(scan.next());

			System.out.println("Enter the Journal: ");
			LibraryObj.setJournal(scan.next());

			System.out.println("Enter the Edition: ");
			LibraryObj.setEdition(scan.nextInt());

			System.out.println("Enter the NoOfCopies: ");
			LibraryObj.setNoOfCopies(scan.nextInt());

			session.beginTransaction();
			session.save(LibraryObj);
			session.getTransaction().commit();
		}

		// method to update the book details by bookId
		static void toUpdateById(Session session) {

			System.out.println("Enter the BookId you need to update: ");
			LibraryObj=session.get(LibraryManagement.class,scan.nextInt());

			if(LibraryObj!= null) {
				//System.out.println("BookId: " +LibraryObj.getNoOfCopies());
				System.out.println("Enter the updated NoOfCopies: ");
				LibraryObj.setNoOfCopies(scan.nextInt());

				session.beginTransaction();
				session.update(LibraryObj);
				session.getTransaction().commit();
			}
			else {
				System.out.println("Book not found");
			}
		}

		// method to delete the book by BookId
		static void toDeleteById(Session session) {

			System.out.println("Enter the BookId you want to delete: ");
			LibraryObj = session.get(LibraryManagement.class, scan.nextInt());

			if(LibraryObj != null) {
				session.beginTransaction();
				session.delete(LibraryObj);
				//session.update(LibraryObj);
				session.getTransaction().commit();
			}
			else {
				System.out.println("Book not found");
			}	
		}

		// method to search the book by BookId
		static void toSearchById(Session session) {

			System.out.println("Enter the BookId you want to search: ");
			LibraryObj = session.get(LibraryManagement.class, scan.nextInt());

			if(LibraryObj != null) {
				//session.beginTransaction();
				System.out.println(LibraryObj);
				//session.getTransaction().commit();
			}
			else {
				System.out.println("Book not found");
			}
		}

		// method to delete the books by BookId
		static void toDisplayAll(Session session) {

			System.out.println("Enter the BookId you want to display: ");
			LibraryObj = session.get(LibraryManagement.class, scan.nextInt());

			if(LibraryObj != null) {
				System.out.println(LibraryObj);
			}
			else {
				System.out.println("Book not found");
			}

		}

		static void toLogout() {
			System.out.println("Logged Out Successfully ");
			System.out.println("Thank you for visiting");
		}

	}



