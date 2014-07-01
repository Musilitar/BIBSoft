/*
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logic.BookCopy;
import dao.DatabaseConnection;



import java.util.ArrayList;

import logic.Book;



package test;

import static org.junit.Assert.*;
import logic.Adress;
import logic.Librarian;
import logic.Login;
import logic.Member;
import logic.Person;

import org.junit.Test;

public class Rename {

public static void main(String[] args) {
		
		ArrayList<Book> b1 = searchBookByAuthor("Me");
		for(Book b : b1){
			System.out.print(b.getAuthor());
		}
	
	}

	
		@Test
		//public Member(String name, String surname, String telnr, Adress adress, String lidID)
		//public Adress(String bus, String street, String city, int houseNr,int zipcode)
		
		//public Login(String staffID, String password)
		//public Librarian(String name, String surname, String function, Login login)
		public void testmember(){
			//Adress a1 = new Adress("17","kingstreet","belgium",16,1070);
			//Member m1 = new Member("lienhard", "thomas", "0544", a1,"676");
			Login l1= new Login("1","lol");
			Librarian li1= new Librarian("lol","lolipop","hehe",l1);
			//li1.addMember(m1);
			li1.searchMemberName("lienhard");
			//mijn eigen adres word niet toegevoegd!!!
			li1.searchMemberAdress("Denderbelle");
			
		}
		

		
		
		@Test
		public void testmembermaken(){
			Adress a1 = new Adress("17","kingstreet","belgium",16,1070);
			Member m1 = new Member("lienhard", "thomas", "0544", a1);
		}
		
		
		
		
		 deze gaan momenteel maar moeten errors geven (dus van groen naar rood)
		 1-lege input zou verboden moeten worde
		 2-bij vb naam alleen letters en '-' toelaten (dus geen cijfers %+=...)
		 3-verplichte minimum aantal input bijvoegen (naam "l" is ook geldig)
		 4-Bij telnummer misschien werken met REGEX(kan de methode van 00,+32,-,aanmekaar checken)
		 5-Bij postcode verplichten om 4cijfers te hebben
		 
		 extra- moet postcode ook .bis hebben ?
		 extra2- bus zou niet verplicht ingevuld moeten worden
		 
		
		@Test
		public void testmember1(){
			
			Adress a1 = new Adress("17","kingstreet","Anderlecht",16,1070);
			Member m1 = new Member("", "sirtus", "047947299", a1);}
		
		
		@Test
		public void testmember2(){
			
			Adress a1 = new Adress("17","kingstreet","Anderlecht",16,1070);
			Member m1 = new Member("i2+l", "sirtus", "047947299", a1);}
		
		
	   @Test
       public void testmember3(){
			
			Adress a1 = new Adress("17","kingstreet","Anderlecht",16,1070);
			Member m1 = new Member("l", "sirtus", "047947299", a1);}
	   
	   
	   
	   @Test
       public void testmember4(){
			
			Adress a1 = new Adress("17","kingstreet","Anderlecht",16,1070);
			Member m1 = new Member("lienhard", "sirtus", "9", a1);}
	   
	   
	   @Test
       public void testmember5(){
			
			Adress a1 = new Adress("17","kingstreet","Anderlecht",16,10);
			Member m1 = new Member("i2+l", "sirtus", "047947299", a1);
	}
	   
}

	
	 * extra in transaction: 
	 * Date out is kleiner dan date in boek 
	 * ook "afwezig worden" dus exemplar -1
	 * transaction fail indien klant al teveel boeken heeft
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 FOR DANY
	 
	 
	 public static ArrayList<BookCopy> searchBookByAuthor(String author){
		conn = DatabaseConnection.getConnection();
		
		ArrayList<BookCopy> booksc = new ArrayList<BookCopy>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Books, BookCopies WHERE author LIKE ? or author LIKE ?");
			stmnt.setString(1, author + "%");
			stmnt.setString(2, "% " + author + "%");
			
			
			
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				//public BookCopy(Date yearEdition, String publicationPlace, String title,String genre, String author, String iSBN, String publisher,int bookID, int edition, Boolean lendable)
				//Date yearEdition, String publicationPlace, String title String genre, String author, String iSBN, String publisher,int bookID
				bc = new BookCopy(res.getDate("year"),res.getString("place_of_publication"),res.getString("title"),res.getString("genre"),res.getString("author"),res.getString("iSBN"),res.getString("publisher"),res.getInt("book_id"),res.getInt("edition"),res.getBoolean("lendable"));
				
				booksc.add(bc);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}finally{
				try{
					conn.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
		}
		return booksc;
	}
	 
	 
	 
	 
	 
*/