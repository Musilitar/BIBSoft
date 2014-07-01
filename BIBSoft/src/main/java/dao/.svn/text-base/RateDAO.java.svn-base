package dao;

import java.sql.*;
import java.util.ArrayList;

import logic.Rate;

public class RateDAO {


	private static Connection conn = DatabaseConnection.getConnection();
	private static Rate rate;
	public ResultSet res = null;
	public Statement stmt = null;

	public static ArrayList<Rate> getAllRates(){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Rate> rateList = new ArrayList<Rate>();
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Rates";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				rate = new Rate(res.getInt("rate_id"), res.getString("description"), res.getFloat("rate"));
				rateList.add(rate);
			}

		}
		catch(SQLException e) {
			System.out.println(e);

		}
		
		return rateList;
			
		}

	public static Rate getRateByID(int rateID){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		Rate r = null;
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Rates where rate_id = " + rateID;
			ResultSet res = stmnt.executeQuery(sql);

			if(res.next()) {
				r = new Rate(res.getInt("rate_id"), res.getString("description"), res.getFloat("rate"));
				
			}

		}
		catch(SQLException e) {
			System.out.println("PROBLEM");
			e.printStackTrace();
			

		}
		
		
		return r;
	}

	public static float getRate(int rateId){
		
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
			String sql = "SELECT * FROM Rates where rate_id = " + rateId;
			ResultSet res = stmnt.executeQuery(sql);

			if(res.next()) {
				return res.getFloat("rate");
			}

		}
		catch(SQLException e) {
			System.out.println("PROBLEM");
			e.printStackTrace();
			return 0;

		}
		return 0;
		
	}
	
	public static void saveRate(Rate r){
		
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
			PreparedStatement stmnt = conn.prepareStatement("INSERT INTO Rates(description, rate) VALUES(?,?)");

			stmnt.setString(1, r.getDescription());
			stmnt.setFloat(2, r.getRate());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
			
		}
		catch(SQLException e){
			System.out.println("insert fail!! - " + e);
		}
		
	}
	
	public static void removeRate(int rateId){
		
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
			PreparedStatement stmnt = conn.prepareStatement("DELETE FROM Rates WHERE rate_id = ?");
			stmnt.setInt(1, rateId);

			stmnt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		}
		catch(SQLException e){
			System.out.println("Remove fail: " + e);
		}
		
	}
	
	public static void editRate(Rate r){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Rates set description = ?, rate = ? WHERE rate_id = ?");
			
			stmnt.setString(1, r.getDescription());
			stmnt.setFloat(2, r.getRate());
			stmnt.setInt(3, r.getRateId());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		}
		catch(SQLException e){
			System.out.println("update fail!! - " + e);
		}
		
	}
}
