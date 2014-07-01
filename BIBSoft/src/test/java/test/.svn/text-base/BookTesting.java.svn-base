package test;

import static org.junit.Assert.*;

import java.util.Date;
import logic.Book;
import org.junit.Test;

public class BookTesting {
	
	
	//public Book(Date yearEdition, String publicationPlace, String title,String genre, String author, String iSBN, String publisher)

	@Test
	public void testISBN1() {
		Date d = new Date();
		Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
	}
	
	@Test
	public void testISBN2() {
		Date d = new Date();
		Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","9781234567891","school");
	}
	
	
	@Test
	public void testISBN3() {
		Date d = new Date();
		Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1-2345-6789-1","school");
	}

}
