package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.BookCopy;
import logic.MediaCopy;
import logic.MeetingRoom;
import logic.RentTransaction;
import logic.Rental;

public class RentTransactionDAO {
	

	private static Connection conn = DatabaseConnection.getConnection();
	private static RentTransaction rentTransaction;
	public ResultSet res = null;
	public Statement stmt = null;
	static ArrayList<BookCopy> bookList = new ArrayList<BookCopy>();
	static ArrayList<MediaCopy> mediaList = new ArrayList<MediaCopy>();
	static ArrayList<MeetingRoom> meetingRoomList = new ArrayList<MeetingRoom>();
	static ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public ArrayList<RentTransaction> getAllRentTransaction(){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<RentTransaction> rentTransactionList = new ArrayList<RentTransaction>();
		
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM RentTransactions";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				
				rentalList = RentalDAO.getRentalById(res.getInt("rent_trans_id"));
				
				for (int i = 0; i < rentalList.size(); i++) {
					
					if (rentalList.get(i).getType() == "boek"){
						
						bookList.add(BookDAO.getBookCopyByBookCopyID(rentalList.get(i).getProductId()));
					}
					if (rentalList.get(i).getType() == "dvd" || rentalList.get(i).getType() == "cd"){ 
						
						mediaList.add(MediaDAO.getMediaCopyByMediaCopyID(rentalList.get(i).getProductId()));
					}
					
					
				}
				
				rentTransaction = new RentTransaction(res.getBoolean("closed"),bookList,mediaList,res.getInt("rent_trans_id"),res.getInt("member_id"),res.getString("date_out"),res.getString("date_in"),res.getString("staff_id"));
				rentTransactionList.add(rentTransaction);
				
				bookList = null;
				mediaList = null;
				rentalList = null;
			}

		}
		catch(SQLException e) {
			System.out.println("PROBLEM");
			e.printStackTrace();
		}
		
		return rentTransactionList;
			
		}



	public static RentTransaction getRentTransaction(int rentTransactionId){
		
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
			String sql = "SELECT * from RentTransactions where rent_trans_id = " + rentTransactionId;
			ResultSet res = stmnt.executeQuery(sql);

			if(res.next()) {
								
				rentalList = RentalDAO.getRentalById(res.getInt("rent_trans_id"));
				
				
				for (int i = 0; i < rentalList.size(); i++) {
					System.out.println("productid: " + rentalList.get(i).getProductId());
					if (rentalList.get(i).getType().equals("boek")){
						
						bookList.add(BookDAO.getBookCopyByBookCopyID(rentalList.get(i).getProductId()));
						
					}
					if (rentalList.get(i).getType().equals("DVD") || rentalList.get(i).getType().equals("CD")){ 
						
						mediaList.add(MediaDAO.getMediaCopyByMediaCopyID(rentalList.get(i).getProductId()));
						
					}
					if(rentalList.get(i).getType().equals("room")) {
						meetingRoomList.add(MeetingRoomDAO.getMeetingRoom(rentalList.get(i).getProductId()));
					}
					
				}
				
				rentTransaction = new RentTransaction(res.getBoolean("closed"),bookList,mediaList,res.getInt("rent_trans_id"),res.getInt("member_id"),res.getString("date_out"),res.getString("date_in"),res.getString("staff_id"));
				
				bookList = null;
				mediaList = null;
				meetingRoomList = null;
				rentalList = null;
			}

		}
		catch(SQLException e) {
			System.out.println("PROBLEM");
			e.printStackTrace();
			return rentTransaction;

		}
			
		return rentTransaction;
		
	}
	
	public static ArrayList<RentTransaction> getRentTransactionByMemberId(int memberId){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<RentTransaction> rentTransactionList = new ArrayList<RentTransaction>();
		try {
			Statement stmnt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY, 
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			String sql = "SELECT * FROM RentTransactions WHERE closed = 0 AND member_id = " + memberId;
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
								
				ArrayList<Rental>rentalList = RentalDAO.getRentalById(res.getInt("rent_trans_id"));
				//conn = DatabaseConnection.getConnection();
				
				ArrayList<BookCopy> bookList2 = new ArrayList<BookCopy>();
				ArrayList<MediaCopy> mediaList2 = new ArrayList<MediaCopy>();
				ArrayList<MeetingRoom> meetingRoomList2 = new ArrayList<MeetingRoom>();
				
				for (int i = 0; i < rentalList.size(); i++) {
					
					if (rentalList.get(i).getType().equals("boek")){
						
						bookList2.add(BookDAO.getBookCopyByBookCopyID(rentalList.get(i).getProductId()));
						//conn = DatabaseConnection.getConnection();
					}
					if (rentalList.get(i).getType().equals("DVD") || rentalList.get(i).getType().equals("CD")){ 
						
						mediaList2.add(MediaDAO.getMediaCopyByMediaCopyID(rentalList.get(i).getProductId()));
						//conn = DatabaseConnection.getConnection();
					}
					if (rentalList.get(i).getType().equals("room")){ 
						
						meetingRoomList2.add(MeetingRoomDAO.getMeetingRoom(rentalList.get(i).getProductId()));
						//conn = DatabaseConnection.getConnection();
					}
					
				}
				//conn = DatabaseConnection.getConnection();
				rentTransaction = new RentTransaction(res.getBoolean("closed"),res.getInt("rent_trans_id"),res.getInt("member_id"),res.getString("date_out"),res.getString("date_in"),res.getString("staff_id"));
				rentTransaction.setBookList(bookList2);
				rentTransaction.setMediaList(mediaList2);
				rentTransaction.setMeetingRoomList(meetingRoomList2);
				rentTransactionList.add(rentTransaction);
			}

		}
		catch(SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			

		}
	
		return rentTransactionList;
		
	}
	
	
	
	public static  void saveRentTransaction(RentTransaction rentTransaction){
		
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
			PreparedStatement stmnt = conn.prepareStatement("INSERT INTO RentTransactions(member_id, date_out, date_in, closed, staff_id)"
					+  " VALUES (?, ?, ?, ?, ?)");
			
			
			stmnt.setInt(1, rentTransaction.getMemberId());
			stmnt.setString(2, rentTransaction.getDateOut());
			stmnt.setString(3, rentTransaction.getDateIn());
			stmnt.setBoolean(4, rentTransaction.getClosed());
			stmnt.setString(5, rentTransaction.getStaffId());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		}
		catch(SQLException e){
			System.out.println("SaveRent to DB fail!! - " + e);
		}
		

		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT rent_trans_id FROM RentTransactions WHERE rent_trans_id = (SELECT MAX(rent_trans_id) FROM RentTransactions)";
			ResultSet res = stmnt.executeQuery(sql);
			if(res.next()){
				rentTransaction.setRentTransId(res.getInt("rent_trans_id"));
			}
		}
		catch(SQLException e){
			System.out.println("fail getting rent_trans_id: " + e);
		}
		 
		
			bookList = rentTransaction.getBookList();
			mediaList =  rentTransaction.getMediaList();
			meetingRoomList = rentTransaction.getMeetingRoomList();
			
			for (BookCopy b : bookList) {
				
				RentalDAO.saveRentalBook(rentTransaction.getRentTransId(), b.getCopyId());
				
			}
			
			for (MediaCopy m : mediaList) {
				
				RentalDAO.saveRentalMedia(rentTransaction.getRentTransId(), m.getMediaCopyID(), m.getType());
			}
			
			for(MeetingRoom mr : meetingRoomList) {
				
				RentalDAO.saveRentalMeetingRoom(rentTransaction.getRentTransId(), mr.getRoomID(), "room");
			}
			
			bookList = null;
			mediaList = null;
			meetingRoomList = null;
		
	
			
	}
	
	

	
	
	public static void removeRentTransaction(int rentTransactionId){// deze functie zou ik niet gebruiken

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
			PreparedStatement stmnt = conn.prepareStatement("DELETE FROM RentTransactions WHERE renttransaction_id = ?");
			stmnt.setInt(1, rentTransactionId);

			stmnt.execute();

			conn.commit();
			conn.setAutoCommit(true);

		}
		catch(SQLException e){
			System.out.println("Remove fail: " + e);
		}


	}
	
	public static void changeClosed(int rentTransID, int closed, String dateReturned) {
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE RentTransactions SET closed = ?, date_in = ? WHERE rent_trans_id = ?");
			stmnt.setInt(1, closed);
			stmnt.setString(2, dateReturned);
			stmnt.setInt(3, rentTransID);
			stmnt.execute();

			conn.commit();
			conn.setAutoCommit(true);

		}
		catch(SQLException e){
			System.out.println("Update fail: " + e);
		}
	
	}
	
	public static void changeDate(int rentTransID, String dateIn, String dateOut) {
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE RentTransactions SET date_out = ?, date_in = ? WHERE rent_trans_id = ?");
			stmnt.setString(1, dateIn);
			stmnt.setString(2, dateOut);
			stmnt.setInt(3, rentTransID);
			stmnt.execute();

			conn.commit();
			conn.setAutoCommit(true);

		}
		catch(SQLException e){
			System.out.println("Update fail: " + e);
		}
	}
	
	public static Boolean checkDate(int roomID, String dateOut, String dateIn) {
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		Statement stmnt = null;
		String sql = "";
		ResultSet res = null;
		Boolean booked = false;
		try{
			stmnt = conn.createStatement();
			sql = "SELECT * FROM RentTransactions rt, Rentals r WHERE r.rental_id = rt.rent_trans_id AND rt.date_out = '" + dateOut + "' AND rt.date_in = '" + dateIn + "' AND r.product_id = " + roomID;
			res = stmnt.executeQuery(sql);
			System.out.println(res.isBeforeFirst());
			if(!res.isBeforeFirst()) {
				booked = false;
			}
			else {
				booked = true;
			}
		}
		catch(SQLException e){
			System.out.println("Update fail: " + e);
		}
		
		return booked;
	}
}
