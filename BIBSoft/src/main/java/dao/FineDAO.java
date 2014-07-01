package dao;

import java.sql.*;
import java.util.ArrayList;

import logic.Fine;

public class FineDAO {


	private static Connection conn = DatabaseConnection.getConnection();
	private static Fine fine;
	public ResultSet res = null;
	public Statement stmt = null;


	public static ArrayList<Fine> getAllFines(){

		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }

		ArrayList<Fine> fineList = new ArrayList<Fine>();
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Fines";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				fine = new Fine(res.getInt("fine_id"), res.getInt("transaction_id"), res.getInt("member_id"), res.getFloat("fine_amount"), res.getBoolean("paid"));
				fineList.add(fine);
			}

		}
		catch(SQLException e) {
			System.out.println(e);

		}
		
		return fineList;
			
}
	
	public static ArrayList<Fine> getAllUnpaidFines(){

		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }

		ArrayList<Fine> fineList = new ArrayList<Fine>();
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Fines where paid = 0";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				fine = new Fine(res.getInt("fine_id"), res.getInt("transaction_id"), res.getInt("member_id"), res.getFloat("fine_amount"), res.getBoolean("paid"));
				fineList.add(fine);
			}

		}
		catch(SQLException e) {
			System.out.println(e);

		}
		
		return fineList;
			
}




	public static Fine getFine(int fineId){
		
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
			String sql = "SELECT * Fines where id = " + fineId;
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				fine = new Fine(res.getInt("fine_id"), res.getInt("transaction_id"), res.getInt("member_id"), res.getFloat("fine_amount"), res.getBoolean("paid"));
			}

		}
		catch(SQLException e) {
			System.out.println("PROBLEM");
			e.printStackTrace();
			return fine;

		}

		return fine;
		
	}
	
	public static void saveFine(Fine fine){
		
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
			PreparedStatement stmnt = conn.prepareStatement("INSERT INTO Fines(transaction_id, member_id, fine_amount, paid) VALUES(?,?,?,?)");

			stmnt.setInt(1, fine.getTransactionId());
			stmnt.setInt(2, fine.getMemberId());
			stmnt.setFloat(3, fine.getFineAmount());
			stmnt.setBoolean(4, fine.getPaid());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
			
		}
		catch(SQLException e){
			System.out.println("insert fail!! - " + e);
		}
		
	}
	
	public static void removeFine(int fineId){

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
			PreparedStatement stmnt = conn.prepareStatement("DELETE FROM Fines WHERE fine_id = ?");
			stmnt.setInt(1, fineId);

			stmnt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		}
		catch(SQLException e){
			System.out.println("Remove fail: " + e);
		}
		
	}
	
	public static void editFine(Fine f){

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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Fines set transaction_id = ?, member_id = ?, fine_amount = ?, paid = ? WHERE fine_id = ?");
			
			stmnt.setInt(1, f.getTransactionId());
			stmnt.setInt(2, f.getMemberId());
			stmnt.setFloat(3, f.getFineAmount());
			stmnt.setBoolean(4, f.getPaid());
			stmnt.setInt(5, f.getFineId());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		}
		
		catch(SQLException e){
			System.out.println("update fail!! - " + e);
		}
		

	
		}
	
	public static void payFine(int fineId){

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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Fines set paid = 1 WHERE fine_id = ?");
			stmnt.setInt(1, fineId);

			stmnt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		}
		catch(SQLException e){
			System.out.println("Remove fail: " + e);
		}
		
	}

}

