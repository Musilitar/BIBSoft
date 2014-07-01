package dao;

import java.sql.*;
import java.util.ArrayList;

import logic.BookCopy;


public class BookCopyDAO {

	private static Connection conn = DatabaseConnection.getConnection();
	private static BookCopy bookCopy;
	public ResultSet res = null;
	public Statement stmt = null;

	public static BookCopy getBookCopy(int bookCopyId){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM BookCopies b, Books s WHERE b.bookid = s.bookid AND id = " + bookCopyId;
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				bookCopy = new BookCopy(null, sql, sql, sql, sql, sql, sql, bookCopyId, bookCopyId, bookCopyId, null);
			}

		}
		catch(SQLException e) {
			System.out.println("PROBLEM");
			e.printStackTrace();
			return bookCopy;

		}
		
		return bookCopy;
		
	}
	
	public static void saveCopy(BookCopy bc){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement stmnt = conn.prepareStatement("INSERT INTO BookCopies(book_id, edition) VALUES(?,?)");
		
			stmnt.setInt(1, bc.getBookID());
			stmnt.setInt(2, bc.getEdition());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("insert fail!! - " + e);
		}
		
	}
	
	public static void removeCopy(int copyId){
	
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		try{
			conn.setAutoCommit(false);
			PreparedStatement stmnt = conn.prepareStatement("DELETE FROM BookCopies WHERE copy_id = ?");
			stmnt.setInt(1, copyId);
			
		
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("Remove fail: " + e);
		}
		
	}
	
	public static void changeLendability(BookCopy bc, boolean lendable) {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		try{
			conn.setAutoCommit(false);
			PreparedStatement stmnt = conn.prepareStatement("UPDATE BookCopies set lendable = ? WHERE copy_id = ?");

			stmnt.setBoolean(1, lendable);
			stmnt.setInt(2, bc.getCopyId());

			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);

		}catch(SQLException e){
			System.out.println("update fail!! - " + e);
		}
			
	}
	public static ArrayList<BookCopy> searchBookByTitle(String title){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<BookCopy> books = new ArrayList<BookCopy>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Books a, BookCopies b WHERE a.book_id = b.book_id AND title LIKE ? OR title LIKE ? AND a.book_id = b.book_id");
			stmnt.setString(1, title + "%");
			stmnt.setString(2,"% "+ title + "%");
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				//Date yearEdition, String publicationPlace, String title String genre, String author, String iSBN, String publisher,int bookID
				bookCopy = new BookCopy(res.getDate("year"),res.getString("place_of_publication"),res.getString("title"),res.getString("genre"),res.getString("author"),res.getString("iSBN"),res.getString("publisher"),res.getInt("book_id"),res.getInt("copy_id"),res.getInt("edition"),res.getBoolean("lendable"));
				books.add(bookCopy);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
					
			}
		return books;
	}
	
	
	
	
	
	
	public static ArrayList<BookCopy> searchBookByGenre(String genre){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<BookCopy> books = new ArrayList<BookCopy>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Books a, BookCopies b WHERE genre LIKE ? AND a.book_id = b.book_id");
			stmnt.setString(1, genre + "%");
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				//Date yearEdition, String publicationPlace, String title String genre, String author, String iSBN, String publisher,int bookID
				bookCopy = new BookCopy(res.getDate("year"),res.getString("place_of_publication"),res.getString("title"),res.getString("genre"),res.getString("author"),res.getString("iSBN"),res.getString("publisher"),res.getInt("book_id"),res.getInt("copy_id"),res.getInt("edition"),res.getBoolean("lendable"));
				books.add(bookCopy);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return books;
	}
	
	
	public static ArrayList<BookCopy> searchBookByAuthor(String author){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<BookCopy> books = new ArrayList<BookCopy>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Books a, BookCopies b WHERE a.book_id = b.book_id AND author LIKE ? OR author LIKE ? AND a.book_id = b.book_id");
			stmnt.setString(1, author + "%");
			stmnt.setString(2, "% " + author + "%");
			
			
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				//Date yearEdition, String publicationPlace, String title String genre, String author, String iSBN, String publisher,int bookID
				bookCopy = new BookCopy(res.getDate("year"),res.getString("place_of_publication"),res.getString("title"),res.getString("genre"),res.getString("author"),res.getString("iSBN"),res.getString("publisher"),res.getInt("book_id"),res.getInt("copy_id"),res.getInt("edition"),res.getBoolean("lendable"));
				books.add(bookCopy);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return books;
	}
	
	public static ArrayList<BookCopy> searchBookByISBN(String iSBN){

		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<BookCopy> books = new ArrayList<BookCopy>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Books a, BookCopies b WHERE iSBN LIKE ? AND a.book_id = b.book_id");
			stmnt.setString(1, iSBN + "%");
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				//Date yearEdition, String publicationPlace, String title String genre, String author, String iSBN, String publisher,int bookID
				bookCopy = new BookCopy(res.getDate("year"),res.getString("place_of_publication"),res.getString("title"),res.getString("genre"),res.getString("author"),res.getString("iSBN"),res.getString("publisher"),res.getInt("book_id"),res.getInt("copy_id"),res.getInt("edition"),res.getBoolean("lendable"));
				books.add(bookCopy);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return books;
	}
	
	
	
}
