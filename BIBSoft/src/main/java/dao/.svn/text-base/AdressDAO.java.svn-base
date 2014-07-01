package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.Adress;



public class AdressDAO {
	private static Connection conn = DatabaseConnection.getConnection();
	private static Adress adress;
	
	public static ArrayList<Adress> getAll()  {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Adress> adressList = new ArrayList<Adress>();
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Addresses";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				Adress a = new Adress(res.getString("bus"),
						res.getString("street"), res.getString("city"), res.getString("number"),
						res.getInt("postal_code"),res.getInt("address_id"));
				adressList.add(a);
			}

		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		return adressList;
	}
	
	public static void insertAdress(Adress a){
		
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
			
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Addresses(address_id, street, number, bus, postal_code, city) "
														 + "VALUES(null,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, a.getStreet());
			stmt.setString(2, a.getHouseNr());
			stmt.setString(3, a.getBus());
			stmt.setInt(4, a.getZipcode());
			stmt.setString(5, a.getCity());
			
			stmt.execute();
			ResultSet keyResultSet = stmt.getGeneratedKeys();
	        int newAdressId = 0;
	        if (keyResultSet.next()) {
	            newAdressId = (int) keyResultSet.getInt(1);
	            a.setAdressID(newAdressId);
	        }
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("insert fail!! - " + e);
		}
	}
	
	public static void removeAdress(int memberID){
		
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
			stmnt.setInt(1, memberID);
			
			stmnt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("Remove fail: " + e);
		}
	}
	
	public static Adress getAdressByID(int adressID){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
	
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Addresses WHERE address_id = ?");
			stmnt.setInt(1, adressID);
			ResultSet res = stmnt.executeQuery();
			res.next();
			
				adress = new Adress(res.getString("bus"),res.getString("street"),res.getString("city"),res.getString("number"),res.getInt("postal_code"),res.getInt("address_id"));
				
		}
		catch(SQLException e) {

		}
		
		return adress;
	}
	public static void editAdress(Adress a){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Addresses set street = ?, number = ?, bus = ?, postal_code = ?, city = ? WHERE address_id = ?");
			
			stmnt.setString(1, a.getStreet());
			stmnt.setString(2, a.getHouseNr());
			stmnt.setString(3, a.getBus());
			stmnt.setInt(4, a.getZipcode());
			stmnt.setString(5, a.getCity());
			stmnt.setInt(6, a.getAdressID());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		}catch(SQLException e){
			System.out.println("update fail!! - " + e);
		}

}
	public static void UpperStreet(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Addresses set street = CONCAT( UPPER( LEFT( street, 1 ) ) , SUBSTRING( street, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	
}
	public static void UpperCity(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Addresses set city = CONCAT( UPPER( LEFT( city, 1 ) ) , SUBSTRING( city, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}
	
	
	
}
// http://www.sql-server-helper.com/functions/initcap.aspx