package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.Adress;
import logic.Member;

public class MemberDAO {
	private static Connection conn = DatabaseConnection.getConnection();
	private static Adress adress;
	private static Member member;
	public static ArrayList<Member> getAll(){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Member> memberList = new ArrayList<Member>();
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Members m, Addresses a "
					+ "WHERE m.address_id = a.address_id";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				Adress a = new Adress(res.getString("bus"),
						res.getString("street"), res.getString("city"), res.getString("number"),
						res.getInt("postal_code"),res.getInt("address_id"));
				Member m = new Member(res.getString("name"), res.getString("first_name"),
						res.getString("phone_num"),a, res.getInt("member_id"));
				memberList.add(m);
			}

		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return memberList;
	}
	
	public static void insertMember(Member m){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		Adress a = m.getAdress();
		try{
			conn.setAutoCommit(false);
			PreparedStatement stmnt = conn.prepareStatement("INSERT INTO Members(name, first_name, book_amount, subscription_date,"
															+ "phone_num, active, subscription_fee, address_id) "
															+ "VALUES(?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS); 
					
			stmnt.setString(1, m.getName());
			stmnt.setString(2, m.getSurname());
			stmnt.setInt(3, m.getAantalBoeken());
			stmnt.setDate(4, m.getInschrijvingsDatum());
			stmnt.setString(5, m.getTelnr());
			stmnt.setBoolean(6, m.isActief());
			stmnt.setBoolean(7, m.isLidgeld());
			stmnt.setInt(8, a.getAdressID());
			
			stmnt.execute();
			ResultSet keyResultSet = stmnt.getGeneratedKeys();
	        int newMemberId = 0;
	        if (keyResultSet.next()) {
	            newMemberId = (int) keyResultSet.getInt(1);
	            a.setAdressID(newMemberId);
	        }
			conn.commit();
			conn.setAutoCommit(true);
		
		}catch(SQLException e){
			System.out.println("insert fail!! - " + e);
		}
	}

	
	public static void editMember(Member m){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		Adress a = m.getAdress();
		try{
			conn.setAutoCommit(false);
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Members set name = ?, first_name = ?, phone_num = ?, address_id = ? WHERE member_id = ?");
			
			stmnt.setString(1, m.getName());
			stmnt.setString(2, m.getSurname());
			stmnt.setString(3, m.getTelnr());
			stmnt.setInt(4, a.getAdressID());
			stmnt.setInt(5, m.getLidID());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		}catch(SQLException e){
			System.out.println("update fail!! - " + e);
		}
	}

	public static void changeMemberName(String name, int memberID){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Members set name = ? WHERE member_id = ?");
			
			stmnt.setString(1, name);
			stmnt.setInt(2, memberID);
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		}catch(SQLException e){
			System.out.println("update fail!! - " + e);
		}
	}
	
	public static void changeMemberSurname(String surname, int memberID){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		try{
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Members set first_name = ? WHERE member_id = ?");
			
			stmnt.setString(1, surname);
			stmnt.setInt(2, memberID);
			
			stmnt.execute();	
			conn.commit();
			conn.setAutoCommit(true);
		
		}catch(SQLException e){
			System.out.println("update fail!! - " + e);
		}
	}
	
	public static void changeMemberTelNR(String telNR, int memberID){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Members set phone_num = ? WHERE member_id = ?");
			
			stmnt.setString(1, telNR);
			stmnt.setInt(2, memberID);
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		}catch(SQLException e){
			System.out.println("update fail!! - " + e);
		}
	}
	public static void removeMember(int memberID){
		
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
			PreparedStatement stmnt = conn.prepareStatement("DELETE FROM Members WHERE member_id = ?");
			stmnt.setInt(1, memberID);
			
			stmnt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("Remove fail: " + e);
		}
	}
	
	public static Member getMemberByID(int memberID){
		
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
			String sql = "SELECT * FROM Members WHERE member_id = " + memberID;
			ResultSet res = stmnt.executeQuery(sql);
			if(res.next()) {
				adress = null;
				member = new Member(res.getString("name"),res.getString("first_name"),res.getString("phone_num"),adress,res.getInt("member_id"), res.getInt("book_amount"),res.getDate("subscription_date"),res.getBoolean("active"), res.getBoolean("subscription_fee"));
				adress = AdressDAO.getAdressByID(res.getInt("address_id"));
				member.setAdress(adress);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return member;
		
	}
	public static ArrayList<Member> searchMemberByName(String name){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Member> members = new ArrayList<Member>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Members WHERE name LIKE ?");
			stmnt.setString(1, name + "%");
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				adress = AdressDAO.getAdressByID(res.getInt("address_id"));
				member = new Member(res.getString("name"),res.getString("first_name"),res.getString("phone_num"),adress,res.getInt("member_id"));
				members.add(member);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return members;
	}
	
	public static ArrayList<Member> searchMemberByFirstName(String firstName){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Member> members = new ArrayList<Member>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Members WHERE first_name LIKE ?");
			stmnt.setString(1, firstName + "%");
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				adress = AdressDAO.getAdressByID(res.getInt("address_id"));
				member = new Member(res.getString("name"),res.getString("first_name"),res.getString("phone_num"),adress,res.getInt("member_id"));
				members.add(member);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return members;
	}
	
	public static ArrayList<Member> searchMemberByCity(String city){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Member> members = new ArrayList<Member>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Addresses a, Members m WHERE a.address_id = m.address_id AND a.city LIKE ?");
			stmnt.setString(1, city + "%");
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				adress = AdressDAO.getAdressByID(res.getInt("address_id"));
				member = new Member(res.getString("name"),res.getString("first_name"),res.getString("phone_num"),adress,res.getInt("member_id"));
				members.add(member);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return members;
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Members set first_name = CONCAT( UPPER( LEFT( first_name, 1 ) ) , SUBSTRING( first_name, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}
	
	public static void UpperSurname(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Members set name = CONCAT( UPPER( LEFT( name, 1 ) ) , SUBSTRING( name, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}	
}
