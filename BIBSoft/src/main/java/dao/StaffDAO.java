 package dao;

import java.sql.*;
import java.util.ArrayList;

import logic.Staff;
import logic.Login;

public class StaffDAO {
	private static Connection conn = DatabaseConnection.getConnection();
	private static Staff staff;
	private static Login login;
	
	public static ArrayList<Staff> getAll() {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Staff";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				login = new Login(res.getString("staff_id"), res.getString("password"));
				staff = new Staff(res.getString("name"), res.getString("first_name"), res.getString("function"), login);
				staffList.add(staff);
			}

		}
		catch(SQLException e) {

		}
		
		return staffList;
	}
	
	public static void insertStaff(Staff staff){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		Login login = staff.getLogin();
		
		try{
			conn.setAutoCommit(false);
			PreparedStatement stmnt = conn.prepareStatement("INSERT INTO Staff VALUES (?,?,?,?,?)"); 
			stmnt.setString(1, login.getStaffID());
			stmnt.setString(2, staff.getName());
			stmnt.setString(3, staff.getSurname()); 
			stmnt.setString(4, login.getPassword());
			stmnt.setString(5, staff.getFunction());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("insert fail!! - " + e);
		}
		
	}
	
	public static void removeStaff(String staffID){
		
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
			PreparedStatement stmnt = conn.prepareStatement("DELETE FROM Staff WHERE staff_id = ?");
			stmnt.setString(1, staffID);
			
			stmnt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("Remove fail: " + e);
		}
	}

	public static Staff getStaffByID(String staffID){
		
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
			String sql = "SELECT * FROM Staff where staff_id= "+staffID;
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				login = new Login(res.getString("staff_id"), res.getString("password"));
				staff = new Staff(res.getString("name"), res.getString("first_name"), res.getString("function"), login);
				
			}

		}
		catch(SQLException e) {

		}
		
		return staff;
	}
	
	public static void editStaff(Staff f){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Staff set name = ?, first_name = ?, function = ? WHERE staff_id = ?");
			
			stmnt.setString(1, f.getName());
			stmnt.setString(2, f.getSurname());
			stmnt.setString(3, f.getFunction());
			stmnt.setString(4, f.getLogin().getStaffID());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		}
		catch(SQLException e){
			System.out.println("update fail!! - " + e);
		}
		
	}
	
	public static void UperFirstName(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Staff set first_name = CONCAT( UPPER( LEFT( first_name, 1 ) ) , SUBSTRING( first_name, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}
	
	public static void UpperName(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Staff set name = CONCAT( UPPER( LEFT( name, 1 ) ) , SUBSTRING( name, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}
	
	public static void UpperFunction(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Staff set function = CONCAT( UPPER( LEFT( function, 1 ) ) , SUBSTRING( function, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}

	public static ArrayList<Staff> searchStaffByID(String staffID){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Staff WHERE staff_id LIKE ? ");
			stmnt.setString(1, staffID + "%");
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				//Date yearEdition, String publicationPlace, String title String genre, String author, String iSBN, String publisher,int bookID
				login = new Login(res.getString("staff_id"),res.getString("password"));
				staff = new Staff(res.getString("name"), res.getString("first_name"),res.getString("function"), login);
				staffs.add(staff);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return staffs;
	}
}
