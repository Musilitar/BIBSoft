package test;

import static org.junit.Assert.*;

import java.util.Date;

import logic.Adress;
import logic.Book;
import logic.BookCopy;
import logic.Login;
import logic.Manager;
import logic.Member;
import logic.Person;
import logic.Product;
import logic.Staff;

import org.junit.Test;

public class Equals {

	
		@Test
		public void test1() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Adress a2 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			assertEquals(a1.getAdressID(),a2.getAdressID());
		}
		
		@Test
		public void test1a() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Adress a2 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			assertEquals(a1.getBus(),a2.getBus());
		}
		
		@Test
		public void test1b() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Adress a2 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			assertEquals(a1.getCity(),a2.getCity());
		}
		
		@Test
		public void test1c() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Adress a2 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			assertEquals(a1.getHouseNr(),a2.getHouseNr());
		}
		
		@Test
		public void test1d() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Adress a2 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			assertEquals(a1.getStreet(),a2.getStreet());
		}
		
		@Test
		public void test1e() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Adress a2 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			assertEquals(a1.getZipcode(),a2.getZipcode());
		}
		
		
		@Test
		public void test2() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1080,17);
			Adress a2 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			assertEquals(a1.getZipcode(),a2.getZipcode());
		}
		
		@Test
		public void test3() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,18);
			Adress a2 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			assertEquals(a1.getAdressID(),a2.getAdressID());
		}
		
		// hier zien we dat het wel karakter gevoelig is, zou niet mogen
		@Test
		public void test4() {
			Adress a1 = new Adress("17","Kingstreet","anderlecht","16",1070,18);
			Adress a2 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			assertEquals(a1.getCity(),a2.getCity());
		}
		
		@Test
		public void test4a() {
			Adress a1 = new Adress("17","Kingstreet","munnenberg","16",1070,18);
			Adress a2 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			assertEquals(a1.getCity(),a2.getCity());
		}
		
		@Test
		public void test5() {
			Adress a1 = new Adress("171","Kingstreet","Anderlecht","16",1070,18);
			Adress a2 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			assertEquals(a1.getBus(),a2.getBus());
		}
		
		
		@Test
		public void testBook() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			Book b2 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getAuthor(),b2.getAuthor());
		}
		
		@Test
		public void testBooka() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			Book b2 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getBookID(),b2.getBookID());
		}
		
		@Test
		public void testBookb() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			Book b2 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getGenre(),b2.getGenre());
		}
		
		@Test
		public void testBookc() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			Book b2 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getISBN(),b2.getISBN());
		}
		
		@Test
		public void testBookd() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			Book b2 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getPublicationPlace(),b2.getPublicationPlace());
		}
		
		@Test
		public void testBooke() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			Book b2 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getPublisher(),b2.getPublisher());
		}
		
		@Test
		public void testBookf() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			Book b2 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getTitle(),b2.getTitle());
		}
		
		@Test
		public void testBookg() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			Book b2 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getYearEdition(),b2.getYearEdition());
		}
		
		
		
		//hier zullen de hoofletters karakters ook problemen stellen
		@Test
		public void testBook1() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","oO Funda","horror","Jan janneke","978-1234567891","school");
			Book b2 = new Book(d,"antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getPublicationPlace(),b2.getPublicationPlace());
		}
		
		
		@Test
		public void testBook1a() {
			Date d = new Date();
			Book b1 = new Book(d,"munneberg","oO Funda","horror","Jan janneke","978-1234567891","school");
			Book b2 = new Book(d,"antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getPublicationPlace(),b2.getPublicationPlace());
		}
		
		
		@Test
		public void testBook2() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan jann","978-1234567891","school");
			Book b2 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getAuthor(),b2.getAuthor());
		}
		
		//hier zouden de isbn gelijk moeten zijn hoewel ze verschillen
		@Test
		public void testBook3() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","9781234567891","school");
			Book b2 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getISBN(),b2.getISBN());
		}
		
		@Test
		public void testBook4() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","schOol");
			Book b2 = new Book(d,"antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getPublisher(),b2.getPublisher());
		}
		
		
		@Test
		public void testBook4a() {
			Date d = new Date();
			Book b1 = new Book(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","tomEnCo");
			Book b2 = new Book(d,"antwerpen","OO funda","horror","Jan janneke","978-1234567891","school");
			assertEquals(b1.getPublisher(),b2.getPublisher());
		}
		
		
		
		@Test
		public void testCopy(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getAuthor(),bc2.getAuthor());
		}
		
		@Test
		public void testCopya(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getBookID(),bc2.getBookID());
		}
		
		@Test
		public void testCopyb(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getCopyId(),bc2.getCopyId());
		}
		
		@Test
		public void testCopyc(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getEdition(),bc2.getEdition());
		}
		
		@Test
		public void testCopyd(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getGenre(),bc2.getGenre());
		}
		
		@Test
		public void testCopye(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getISBN(),bc2.getISBN());
		}
		
		@Test
		public void testCopyf(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getPublicationPlace(),bc2.getPublicationPlace());
		}
		
		@Test
		public void testCopyg(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getPublisher(),bc2.getPublisher());
		}
		
		@Test
		public void testCopyh(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getTitle(),bc2.getTitle());
		}
		
		@Test
		public void testCopyi(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getYearEdition(),bc2.getYearEdition());
		}
		//idem hier zou hooflettergevoelig niet moeten zijn
		@Test
		public void testCopy1(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getPublicationPlace(),bc2.getPublicationPlace());
		}
		
		@Test
		public void testCopy2(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","oO funda","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getTitle(),bc2.getTitle());
		}
		
		@Test
		public void testCopy2a(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","C++","horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getTitle(),bc2.getTitle());
		}
		
		@Test
		public void testCopy3(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","Horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getGenre(),bc2.getGenre());
		}
		
		@Test
		public void testCopy3a(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","Fantasy","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getGenre(),bc2.getGenre());
		}
		
		
		@Test
		public void testCopy4(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","Horror","jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getAuthor(),bc2.getAuthor());
		}
		
		@Test
		public void testCopy4a(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","Horror","Jan jan","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getAuthor(),bc2.getAuthor());
		}
		
		@Test
		public void testCopy5(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","Horror","Jan janneke","9781234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getISBN(),bc2.getISBN());
		}
		
		@Test
		public void testCopy6(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","Horror","Jan janneke","978-1234567891","School", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 1);
		assertEquals(bc1.getPublisher(),bc2.getPublisher());
		}
		
		@Test
		public void testCopy7(){
		Date d = new Date();
		BookCopy bc1 = new BookCopy(d,"Antwerpen","OO funda","Horror","Jan janneke","978-1234567891","school", 1);
		BookCopy bc2 = new BookCopy(d,"Antwerpen","OO funda","horror","Jan janneke","978-1234567891","school", 2);
		assertEquals(bc1.getEdition(),bc2.getEdition());
		}
		
		@Test
		public void testLogin(){
		Login l1= new Login("t1mm2", "ik8eneenpass!");
		Login l2= new Login("t1mm2", "ik8eneenpass!");
		assertEquals(l1.getPassword(),l2.getPassword());
		}
		
		@Test
		public void testLogina(){
		Login l1= new Login("t1mm2", "ik8eneenpass!");
		Login l2= new Login("t1mm2", "ik8eneenpass!");
		assertEquals(l1.getStaffID(),l2.getStaffID());
		}
		
		@Test
		public void testLogin1(){
		Login l1= new Login("t1mm", "ik8eneenpass!");
		Login l2= new Login("t1mm2", "ik8eneenpass!");
		assertEquals(l1.getStaffID(),l2.getStaffID());
		}
		
		@Test
		public void testLogin2(){
		Login l1= new Login("t1mm2", "ikeneenpass!");
		Login l2= new Login("t1mm2", "ik8eneenpass!");
		assertEquals(l1.getPassword(),l2.getPassword());
		}
		
		
		@Test
		public void testManager(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Manager m1= new Manager("thomas", "lienhard", "Manager",  l1);
		Manager m2= new Manager("thomas", "lienhard", "Manager",  l1);
		assertEquals(m1.getFunction(),m2.getFunction());
		}
		
		@Test
		public void testManagera(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Manager m1= new Manager("thomas", "lienhard", "Manager",  l1);
		Manager m2= new Manager("thomas", "lienhard", "Manager",  l1);
		assertEquals(m1.getLogin(),m2.getLogin());
		}
		
		@Test
		public void testManagerb(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Manager m1= new Manager("thomas", "lienhard", "Manager",  l1);
		Manager m2= new Manager("thomas", "lienhard", "Manager",  l1);
		assertEquals(m1.getName(),m2.getName());
		}
		
		@Test
		public void testManagerc(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Manager m1= new Manager("thomas", "lienhard", "Manager",  l1);
		Manager m2= new Manager("thomas", "lienhard", "Manager",  l1);
		assertEquals(m1.getSurname(),m2.getSurname());
		}
		
		
		@Test
		public void testManager1(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Manager m1= new Manager("thomas", "lienhard", "Manager",  l1);
		Manager m2= new Manager("Thomas", "lienhard", "Manager",  l1);
		assertEquals(m1.getName(),m2.getName());
		}
		
		@Test
		public void testManager1a(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Manager m1= new Manager("joske", "lienhard", "Manager",  l1);
		Manager m2= new Manager("Thomas", "lienhard", "Manager",  l1);
		assertEquals(m1.getName(),m2.getName());
		}
		
		
		
		@Test
		public void testManager2(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Manager m1= new Manager("thomas", "lienhard", "Manager",  l1);
		Manager m2= new Manager("thomas", "Lienhard", "Manager",  l1);
		assertEquals(m1.getSurname(),m2.getSurname());
		}
		
		
		@Test
		public void testManager2a(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Manager m1= new Manager("thomas", "alberke", "Manager",  l1);
		Manager m2= new Manager("thomas", "Lienhard", "Manager",  l1);
		assertEquals(m1.getSurname(),m2.getSurname());
		}
		
		@Test
		public void testManager3(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Manager m1= new Manager("thomas", "lienhard", "Manager",  l1);
		Manager m2= new Manager("thomas", "lienhard", "manager",  l1);
		assertEquals(m1.getFunction(),m2.getFunction());
		}
		
		
		@Test
		public void testManager3a(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Manager m1= new Manager("thomas", "lienhard", "nietmanager",  l1);
		Manager m2= new Manager("thomas", "lienhard", "manager",  l1);
		assertEquals(m1.getFunction(),m2.getFunction());
		}
		
		
		@Test
		public void testManager4(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Login l2 = new Login("t1mm", "ik8eneenpass!"); 
		Manager m1= new Manager("thomas", "lienhard", "Manager",  l1);
		Manager m2= new Manager("thomas", "lienhard", "Manager",  l2);
		assertEquals(m1.getLogin(),m2.getLogin());
		}
		
		@Test
		public void testMember() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			Member m2 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			assertEquals(m1.getAdress(),m2.getAdress());
		}
		
		@Test
		public void testMembera() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			Member m2 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			assertEquals(m1.getLidID(),m2.getLidID());
		}
		
		@Test
		public void testMemberb() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			Member m2 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			assertEquals(m1.getName(),m2.getName());
		}
		
		@Test
		public void testMemberc() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			Member m2 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			assertEquals(m1.getSurname(),m2.getSurname());
		}
		
		@Test
		public void testMemberd() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			Member m2 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			assertEquals(m1.getTelnr(),m2.getTelnr());
		}
		
		@Test
		public void testMember1() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("thomas", "De smeth", "047947299", a1, 17);
			Member m2 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			assertEquals(m1.getName(),m2.getName());
		}
		
		@Test
		public void testMember1a() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("roeland", "De smeth", "047947299", a1, 17);
			Member m2 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			assertEquals(m1.getName(),m2.getName());
		}
		
		@Test
		public void testMember2() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Thomas", "de Smeth", "047947299", a1, 17);
			Member m2 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			assertEquals(m1.getSurname(),m2.getSurname());
		}
		
		@Test
		public void testMember2a() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Thomas", "joske", "047947299", a1, 17);
			Member m2 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			assertEquals(m1.getSurname(),m2.getSurname());
		}
		
		
		@Test
		public void testMember3() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Thomas", "De smeth", "0479472999", a1, 17);
			Member m2 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			assertEquals(m1.getTelnr(),m2.getTelnr());
		}
		
		@Test
		public void testMember4() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Thomas", "De smeth", "047947299", a1, 18);
			Member m2 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			assertEquals(m1.getLidID(),m2.getLidID());
		}

		

		@Test
		public void testMember5() {
			Adress a1 = new Adress("17","Kingstreet","Anderlecht","16",1070,17);
			Adress a2 = new Adress("18","Kingstreet","Anderlecht","16",1070,17);
			Member m1 = new Member("Thomas", "De smeth", "047947299", a1, 17);
			Member m2 = new Member("Thomas", "De smeth", "047947299", a2, 17);
			assertEquals(m1.getAdress(),m2.getAdress());
		}
		
		@Test
		public void testStaff(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Staff m1= new Staff("thomas", "lienhard", "Staff",  l1);
		Staff m2= new Staff("thomas", "lienhard", "Staff",  l1);
		assertEquals(m1.getFunction(),m2.getFunction());
		}
		
		@Test
		public void testStaffa(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Staff m1= new Staff("thomas", "lienhard", "Staff",  l1);
		Staff m2= new Staff("thomas", "lienhard", "Staff",  l1);
		assertEquals(m1.getLogin(),m2.getLogin());
		}
		
		@Test
		public void testStaffb(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Staff m1= new Staff("thomas", "lienhard", "Staff",  l1);
		Staff m2= new Staff("thomas", "lienhard", "Staff",  l1);
		assertEquals(m1.getName(),m2.getName());
		}
		
		@Test
		public void testStaffc(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Staff m1= new Staff("thomas", "lienhard", "Staff",  l1);
		Staff m2= new Staff("thomas", "lienhard", "Staff",  l1);
		assertEquals(m1.getSurname(),m2.getSurname());
		}
		
		@Test
		public void testStaff1(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Staff m1= new Staff("Thomas", "lienhard", "Staff",  l1);
		Staff m2= new Staff("thomas", "lienhard", "Staff",  l1);
		assertEquals(m1.getName(),m2.getName());
		}
		
		
		@Test
		public void testStaff1a(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Staff m1= new Staff("jefke", "lienhard", "Staff",  l1);
		Staff m2= new Staff("thomas", "lienhard", "Staff",  l1);
		assertEquals(m1.getName(),m2.getName());
		}
		
		
		@Test
		public void testStaff2(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Staff m1= new Staff("thomas", "Lienhard", "Staff",  l1);
		Staff m2= new Staff("thomas", "lienhard", "Staff",  l1);
		assertEquals(m1.getSurname(),m2.getSurname());
		}
		
		@Test
		public void testStaff2a(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Staff m1= new Staff("thomas", "filiberke", "Staff",  l1);
		Staff m2= new Staff("thomas", "lienhard", "Staff",  l1);
		assertEquals(m1.getSurname(),m2.getSurname());
		}
		
		
		@Test
		public void testStaff3(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Staff m1= new Staff("thomas", "lienhard", "staff",  l1);
		Staff m2= new Staff("thomas", "lienhard", "Staff",  l1);
		assertEquals(m1.getFunction(),m2.getFunction());
		}
		
		@Test
		public void testStaff3a(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Staff m1= new Staff("thomas", "lienhard", "nietstaff",  l1);
		Staff m2= new Staff("thomas", "lienhard", "Staff",  l1);
		assertEquals(m1.getFunction(),m2.getFunction());
		}
		
		
		@Test
		public void testStaff4(){
		Login l1 = new Login("t1mm2", "ik8eneenpass!"); 
		Login l2 = new Login("t1mm", "ik8eneenpass!"); 
		Staff m1= new Staff("thomas", "lienhard", "Staff",  l1);
		Staff m2= new Staff("thomas", "lienhard", "Staff",  l2);
		assertEquals(m1.getFunction(),m2.getFunction());
		}
		
		
		
		
		
		
		
		
	}


