package logic;

import java.util.Date;


public class Book extends Product {
	
	private String author,iSBN, publisher;
	private int bookID;
	
	


	
	
	
	
	
	//validate ISBN format 978-xxxxxxxxxx/978xxxxxxxxxx/978-x-xxxx-xxxx-x   
			public static boolean validateISBN( String iSBN )
			   {
			      return iSBN.matches( "((978)[-]{0,1}|)[0-9]{10}|((978)[-]|)[0-9]{1}[-][0-9]{3}[-][0-9]{5}[-]([0-9]{1}|[X]{1})|((978)[-]|)[0-9]{1}[-][0-9]{4}[-][0-9]{4}[-]([0-9]{1}|[X]{1})|((978)[-]|)[0-9]{1}[-][0-9]{5}[-][0-9]{3}[-]([0-9]{1}|[X]{1})" );
			   } 

	//validate Author		
			public static boolean validateAuthor( String author )
			   {
			      return author.matches( "[a-zA-Z]{2,35}+([,.-;]{0,1}[ ][a-zA-Z]+)*|^$" );
			   }	
	//validate Publisher
			public static boolean validatePublisher( String publisher){
				return publisher.matches("[a-zA-Z]{1,35}+([,.-;]{0,1}[ ][a-zA-Z]+)*|^$");
			}
			
			
			
			
			
			
	//boek zonder id
	public Book(Date yearEdition, String publicationPlace, String title,
			String genre, String author, String iSBN, String publisher) {
		super(yearEdition, publicationPlace, title, genre);
		this.author = author;
		//if(validateAuthor(author)==false)
		//	System.out.println("Author is niet correct ingevuld");
		//else System.out.println("Author is correct ingevuld");
		
		this.iSBN = iSBN;
		//if(validateISBN(iSBN)==false)
		//	System.out.println("ISBN is niet correct ingevuld");
		//else System.out.println("ISBN is correct ingevuld");
		
		this.publisher = publisher;
		//if(validatePublisher(iSBN)==false)
		//	System.out.println("publisher is niet correct ingevuld");
		//else System.out.println("ISBN is correct ingevuld");
	}

	//volledige bestaande boeken
	public Book(Date yearEdition, String publicationPlace, String title,
			String genre, String author, String iSBN, String publisher,
			int bookID) {
		super(yearEdition, publicationPlace, title, genre);
		this.author = author;
		this.iSBN = iSBN;
		this.publisher = publisher;
		this.bookID = bookID;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getISBN() {
		return iSBN;
	}


	public void setISBN(String iSBN) {
		this.iSBN = iSBN;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}




	public int getBookID() {
		return bookID;
	}
	
	
	
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

}