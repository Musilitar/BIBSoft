package dao;

import java.sql.*;
import java.util.ArrayList;

import logic.Book;
import logic.BookCopy;
import logic.Media;
import logic.MediaCopy;
import logic.MeetingRoom;
import logic.Reservation;

public class ReservationDAO {
	

	private static Connection conn = DatabaseConnection.getConnection();
	private static Reservation reservation;
	public ResultSet res = null;
	public Statement stmt = null;

	public static ArrayList<Reservation> getAllReservations(){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Reservations";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				reservation = new Reservation(res.getInt("product_id"), res.getInt("member_id"), res.getString("type"));
				reservationList.add(reservation);
			}

		}
		catch(SQLException e) {
			System.out.println("PROBLEM");
			e.printStackTrace();
		}
		
		
		return reservationList;
			
		}



	public static Reservation getReservation(int productID){
		
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
			String sql = "SELECT * FROM Reservations WHERE product_id = " + productID;
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				reservation = new Reservation(res.getInt("product_id"), res.getInt("member_id"), res.getString("type"));
			}

		}
		catch(SQLException e) {
			System.out.println("PROBLEM");
			e.printStackTrace();
			return reservation;

		}
		
		return reservation;
		
	}
	
	public static ArrayList<Book> checkBookReservation(ArrayList<BookCopy> bookList) {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Book> foundReservations = new ArrayList<Book>();
		Statement stmnt = null;
		String sql = "";
		ResultSet res = null;
		
		for(Book b : bookList) {
			try {
				stmnt = conn.createStatement();
				sql = "SELECT * FROM Reservations WHERE product_id = " + b.getBookID() + " AND type = 'boek'";
				res = stmnt.executeQuery(sql);
				if(res.next())
					foundReservations.add(b);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		
		return foundReservations;
	}
	
	public static ArrayList<Media> checkMediaReservation(ArrayList<MediaCopy> mediaList) {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Media> foundReservations = new ArrayList<Media>();
		Statement stmnt = null;
		String sql = "";
		ResultSet res = null;
		for(Media m : mediaList) {
			try {
				stmnt = conn.createStatement();
				sql = "SELECT * FROM Reservations WHERE product_id = " + m.getMediaID() + " AND (type = 'DVD' OR type = 'CD')";
				res = stmnt.executeQuery(sql);
				if(res.next())
					foundReservations.add(m);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		return foundReservations;
	}
	
	public static ArrayList<MeetingRoom> checkMeetingRoomReservation(ArrayList<MeetingRoom> meetingRoomList) {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<MeetingRoom> foundReservations = new ArrayList<MeetingRoom>();
		Statement stmnt = null;
		String sql = "";
		ResultSet res = null;
		for(MeetingRoom mr : meetingRoomList) {
			try {
				stmnt = conn.createStatement();
				sql = "SELECT * FROM Reservations WHERE product_id = " + mr.getRoomID() + " AND type = 'room'";
				res = stmnt.executeQuery(sql);
				if(res.next())
					foundReservations.add(mr);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		return foundReservations;
	}
	
	public static void saveReservation(Reservation reservation){
		
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
			PreparedStatement stmnt = conn.prepareStatement("INSERT INTO Reservations VALUES(?,?,?)");
			
			
			stmnt.setInt(1, reservation.getProductID());
			stmnt.setInt(2, reservation.getMemberID());
			stmnt.setString(3, reservation.getType());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		}
		catch(SQLException e){
			System.out.println("insert fail!! - " + e);
		}
		
	}
	
	public static void removeReservation(int productID, int memberID){
		
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
			PreparedStatement stmnt = conn.prepareStatement("DELETE FROM Reservations WHERE product_id = ? AND member_id = ?");
			stmnt.setInt(1, productID);
			stmnt.setInt(2, memberID);

			
			stmnt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
			
		}
		catch(SQLException e){
			System.out.println("Remove fail: " + e);
		}
		
	}
	
	public static void editReservation(Reservation r){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Reservations set member_id = ? WHERE product_id = ? AND type = ?");
			
			stmnt.setInt(1, r.getMemberID());
			stmnt.setInt(2, r.getProductID());
			stmnt.setString(3, r.getType());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		}
		catch(SQLException e){
			System.out.println("update fail!! - " + e);
		}
	
	}
	
	public static ArrayList<Reservation> searchByProductID(int productID) {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Reservations WHERE product_id = ?");
			stmnt.setInt(1, productID);
			
			
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				//Date yearEdition, String publicationPlace, String title String genre, String author, String iSBN, String publisher,int bookID
				reservation = new Reservation(res.getInt("product_id"),res.getInt("member_id"), res.getString("type"));
				reservations.add(reservation);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return reservations;
	}
	
	public static ArrayList<Reservation> searchByMemberID(int memberID) {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Reservations WHERE member_id = ?");
			stmnt.setInt(1, memberID);
			
			
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				//Date yearEdition, String publicationPlace, String title String genre, String author, String iSBN, String publisher,int bookID
				reservation = new Reservation(res.getInt("product_id"),res.getInt("member_id"), res.getString("type"));
				reservations.add(reservation);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return reservations;
	}
	
	public static ArrayList<Reservation> searchByType(String type) {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Reservations WHERE type LIKE ?");
			stmnt.setString(1, type + "%");
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				//Date yearEdition, String publicationPlace, String title String genre, String author, String iSBN, String publisher,int bookID
				reservation = new Reservation(res.getInt("product_id"),res.getInt("member_id"), res.getString("type"));
				reservations.add(reservation);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return reservations;
	}
}
