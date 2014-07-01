package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.Product;

public class ProductDAO {
	
	private static Connection conn = DatabaseConnection.getConnection();
	
	public static ArrayList<Product> getAllPFromUser(int member_id){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Product> productList = new ArrayList<Product>();
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT copy_id FROM Reservations WHERE member_id = " + member_id;
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				productList.add(BookCopyDAO.getBookCopy(res.getInt("copy_id")));
				productList.add(MediaCopyDAO.getMediaCopy(res.getInt("copy_id")));
			}

		}
		catch(SQLException e) {
			System.out.println("PROBLEM");
			e.printStackTrace();
		}
		
		
		return productList;
			
		}
	}

	


