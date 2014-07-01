package dao;

import java.sql.*;
import java.util.ArrayList;

import logic.Copy;

public class CopyDAO {

	private static Connection conn = DatabaseConnection.getConnection();
	private static Copy copy;
	public ResultSet res = null;
	public Statement stmt = null;

	public ArrayList<Copy> getAllCopies(){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Copy> copyList = new ArrayList<Copy>();
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Copies";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				copy = new Copy(res.getInt("copy_id"), res.getInt("book_id"), res.getInt("edition"), res.getBoolean("lendable"));
				copyList.add(copy);
			}

		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
			return copyList;
			
		}



	public Copy getCopy(int copyId){
		
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
			String sql = "SELECT * Copies where id = " + copyId;
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				copy = new Copy(res.getInt("copy_id"), res.getInt("book_id"), res.getInt("edition"), res.getBoolean("lendable"));
			}

		}
		catch(SQLException e) {
			System.out.println("PROBLEM");
			e.printStackTrace();
			return copy;

		}
		
		
		return copy;
		
	}
	
	public void saveCopy(int copyId){
		
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
			PreparedStatement stmnt = conn.prepareStatement("INSERT INTO Copies VALUES(?,?,?,?)");

			stmnt.setInt(1, copy.getCopyId());
			stmnt.setInt(2, copy.getBookId());
			stmnt.setInt(3, copy.getEdition());
			stmnt.setBoolean(4, copy.getLendable());
			
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
			PreparedStatement stmnt = conn.prepareStatement("DELETE FROM Copies WHERE copy_id = ?");
			stmnt.setInt(1, copyId);
			
		
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("Remove fail: " + e);
		}
		
		}
	}
