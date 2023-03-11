package Hibernate.HibernateProject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class LibraryManagement {

	//primary key-->BookId
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bookId;
	private String bookName;
	private String authorName;
	private String journal;
	private Integer edition;
	private Integer noOfCopies;


	//public getter and setter for the above mentioned attributes
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public Integer getEdition() {
		return edition;
	}
	public void setEdition(Integer edition) {
		this.edition = edition;
	}
	public Integer getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	// to print the values---->toString() is an inbuilt method of an object class
	@Override
	public String toString() {
		return "LibraryManagement [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName
				+ ", journal=" + journal + ", edition=" + edition + ", noOfCopies=" + noOfCopies + "]";
	}


}




