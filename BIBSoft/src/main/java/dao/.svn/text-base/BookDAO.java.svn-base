package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.Book;
import logic.BookCopy;

public class BookDAO {
	private static Connection conn = DatabaseConnection.getConnection();
	private static ArrayList<BookCopy> b = new ArrayList<BookCopy>();
	
 	public static ArrayList<BookCopy> getAllCopies() {
 		
 		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<BookCopy> bookList = new ArrayList<BookCopy>();
		try {
			
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM BookCopies bc, Books b WHERE bc.book_id = b.book_id";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				BookCopy bc = new BookCopy(res.getDate("year"), res.getString("place_of_publication"),
						res.getString("title"), res.getString("genre"), res.getString("author"),
						res.getString("isbn"), res.getString("publisher"), res.getInt("book_id"),
						res.getInt("copy_id"), res.getInt("edition"),res.getBoolean("lendable"));
				bookList.add(bc);
			}

		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		return bookList;
	}
	
	public static ArrayList<Book> getAllBooks() {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Book> bookList = new ArrayList<Book>();
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Books";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				Book b = new Book(res.getDate("year"), res.getString("place_of_publication"),
						res.getString("title"), res.getString("genre"), res.getString("author"),
						res.getString("isbn"), res.getString("publisher"), res.getInt("book_id"));
				bookList.add(b);
			}

		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		return bookList;
	}
	
	public static ArrayList<Book> getAllRentedBooks() {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Book> bookList = new ArrayList<Book>();
		Book b = null;
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Books b WHERE b.book_id = (SELECT book_id FROM BookCopies bc, Rentals r WHERE bc.book_id = b.book_id AND bc.copy_id = r.product_id AND r.type = 'boek' AND r.rental_id = (SELECT rental_id FROM RentTransactions rt WHERE rt.rent_trans_id = r.rental_id AND rt.closed = 0))";
			
			ResultSet res = stmnt.executeQuery(sql);
			while(res.next()) {
				b = new Book(res.getDate("year"), res.getString("place_of_publication"),
						res.getString("title"), res.getString("genre"), res.getString("author"),
						res.getString("isbn"), res.getString("publisher"), res.getInt("book_id"));
				bookList.add(b);
			}

		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		return bookList;
	}

	public static void insertBook(BookCopy b){
		
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
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Books(title, author, year, place_of_publication, publisher, genre, isbn)"
														+  "VALUES (?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(3, StringDateSwitcher.dateToStringYear(b.getYearEdition()));
			stmt.setString(4, b.getPublicationPlace());
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getAuthor());
			stmt.setString(7, b.getISBN());
			stmt.setString(5, b.getPublisher());
			stmt.setString(6, b.getGenre());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		}catch(SQLException e){
			System.out.println("insert fail!! - " + e);
		}
	}
	
	public static void removeBook(Book b){
		
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
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM Books WHERE book_id = ?");
			stmt.setInt(1, b.getBookID());
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
				System.out.println(e);
			
		}
	}
	
	public static ArrayList<BookCopy> getBookByBookID(int bookID){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		//TODO nog te schrijven
		return b;
	}
	
		
	public static BookCopy getBookCopyByBookCopyID(int copyID){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		BookCopy bc = null;
		
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Books b, BookCopies bc WHERE b.book_id = bc.book_id AND bc.copy_id = ?");
			stmnt.setInt(1, copyID);
			ResultSet res = stmnt.executeQuery();
			if(res.next())
			{
				bc = new BookCopy(StringDateSwitcher.toDateYear(res.getString("year")), res.getString("place_of_publication"),
						res.getString("title"), res.getString("genre"), res.getString("author"),
						res.getString("isbn"), res.getString("publisher"), res.getInt("book_id"),
						res.getInt("copy_id"), res.getInt("edition"),res.getBoolean("lendable"));
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		return bc;
	}
	
	
	public static int getBookID(String isbn){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		int bookID = 0;
		
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT book_id FROM Books WHERE isbn = ?");
			stmnt.setString(1, isbn);
			ResultSet res = stmnt.executeQuery();
			bookID = res.getInt(1);
			System.out.println("opgevraagde book id dao: " + bookID);
			}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		
		return bookID;
	}
	public static void editBook(Book b){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Books set title = ?, author = ?, year = ?, place_of_publication = ?, publisher = ?, genre = ?, isbn = ? WHERE book_id = ?");
			
			stmnt.setString(1, b.getTitle());
			stmnt.setString(2, b.getAuthor());
			stmnt.setString(3, StringDateSwitcher.dateToStringYear(b.getYearEdition()));
			stmnt.setString(4, b.getPublicationPlace());
			stmnt.setString(5, b.getPublisher());
			stmnt.setString(6, b.getGenre());
			stmnt.setString(7, b.getISBN());
			stmnt.setInt(8,b.getBookID());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		}catch(SQLException e){
			System.out.println("update fail!! - " + e);
		}

}
	public static void Upperauthor(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Books set author = CONCAT( UPPER( LEFT( author, 1 ) ) , SUBSTRING( author, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}
	
	public static void UpperPlaceOfPublication(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Books set place_of_publication = CONCAT( UPPER( LEFT( place_of_publication, 1 ) ) , SUBSTRING( place_of_publication, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}

	public static void UpperTitle(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Books set title = CONCAT( UPPER( LEFT( title, 1 ) ) , SUBSTRING( title, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}	
	public static void UpperGenre(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Books set genre = CONCAT( UPPER( LEFT( genre, 1 ) ) , SUBSTRING( genre, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}
	
	public static void UpperPublisher(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Books set publisher = CONCAT( UPPER( LEFT( publisher, 1 ) ) , SUBSTRING( publisher, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}	
	
	
	public static void Updatetrema(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Books set isbn = CONCAT( UPPER( LEFT( publisher, 1 ) ) , SUBSTRING( publisher, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}	
	
	
	
}
