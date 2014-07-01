package dao;

import java.sql.*;
import java.util.ArrayList;

import logic.Rental;

public class RentalDAO {

	private static Connection conn = DatabaseConnection.getConnection();
	private static Rental rental;
	public ResultSet res = null;
	public Statement stmt = null;


	
	public ArrayList<Rental> getAllrentals(){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Rental> rentalList = new ArrayList<Rental>();
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM rentals";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				rental = new Rental(res.getInt("rental_id"),res.getInt("product_id"),res.getString("type"));
				rentalList.add(rental);
			}

		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		
		return rentalList;
			
		}


	public static ArrayList<Rental> getRentalById(int rentalId){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Rental> rentalList = new ArrayList<Rental>();

		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Rentals WHERE rental_id = " + rentalId;
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				rental = new Rental(res.getInt("rental_id"),res.getInt("product_id"),res.getString("type"));
				rentalList.add(rental);
			}

		}
		catch(SQLException e) {
			System.out.println("PROBLEM");
			e.printStackTrace();
			

		}
		
		
		return rentalList;
		
	}
	
	public static void saveRentalMedia(int rentId, int prodId, String type){
		
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
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Rentals VALUES(?,?,?)");

			stmt.setInt(1, rentId);
			stmt.setInt(2, prodId);
			stmt.setString(3, type);
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("insert fail!! - " + e);
		}
	
	}
	
	public static void saveRentalMeetingRoom(int rentId, int prodId, String type){
		
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
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Rentals VALUES(?,?,?)");

			stmt.setInt(1, rentId);
			stmt.setInt(2, prodId);
			stmt.setString(3, type);
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("insert fail!! - " + e);
		}
	
	}
	
	
	
	public static void saveRentalBook(int rentId, int prodId){
	
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
			PreparedStatement stmnt = conn.prepareStatement("INSERT INTO Rentals(rental_id, product_id)"
					+  "VALUES (?, ?)");
			
			
			stmnt.setInt(1, rentId);
			stmnt.setInt(2, prodId);
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("insert fail book!! - " + e);
		}
		
	}
	
	public static void removeRental(int rentalId, int prodId){
		
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
			PreparedStatement stmnt = conn.prepareStatement("DELETE FROM Rentals WHERE rental_id = ? AND product_id  = ?");
			stmnt.setInt(1, rentalId);
			stmnt.setInt(2, prodId);
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("Remove fail: " + e);
		}
		
	}
}
