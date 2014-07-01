package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.MeetingRoom;

public class MeetingRoomDAO {


	private static Connection conn = DatabaseConnection.getConnection();
	private static MeetingRoom meetingroom;
	public ResultSet res = null;
	public PreparedStatement stmt = null;

		public static ArrayList<MeetingRoom> getAllMeetingRooms(){
			
			try {
				   if(conn == null || conn.isClosed()){
				    conn = DatabaseConnection.getConnection();
				   }
				  } catch (SQLException e1) {
				   // TODO Auto-generated catch block
				   e1.printStackTrace();
				  }
			
			ArrayList<MeetingRoom> meetingList = new ArrayList<MeetingRoom>();
			try {
				Statement stmnt = conn.createStatement();
				String sql = "SELECT * FROM MeetingRooms";
				ResultSet res = stmnt.executeQuery(sql);

				while(res.next()) {
					meetingroom = new MeetingRoom(res.getInt("room_id"), res.getInt("floor"), res.getInt("seats_amount"), res.getString("name"));
					meetingList.add(meetingroom);
				}

			}
			catch(SQLException e) {
				System.out.println(e);
			}
			
			
			return meetingList;
				
			}



		public static MeetingRoom getMeetingRoom(int meetingID){
			
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
				String sql = "SELECT * FROM MeetingRooms WHERE room_id = " + meetingID;
				ResultSet res = stmnt.executeQuery(sql);

				while(res.next()) {
					meetingroom = new MeetingRoom(res.getInt("room_id"), res.getInt("floor"), res.getInt("seats_amount"), res.getString("name"));
				}

			}
			catch(SQLException e) {
				System.out.println("PROBLEM");
				e.printStackTrace();
				return meetingroom;

			}
		
			return meetingroom;
			
		}
		
		public static void saveMeetingRoom(MeetingRoom mr){
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
				PreparedStatement stmnt = conn.prepareStatement("INSERT INTO MeetingRooms(floor, seats_amount, name) VALUES(?,?,?)");

				stmnt.setInt(1, mr.getFloor());
				stmnt.setInt(2, mr.getSeatsAmount());
				stmnt.setString(3, mr.getName());
				
				stmnt.execute();
				conn.commit();
				conn.setAutoCommit(true);
				
			}catch(SQLException e){
				System.out.println("Insert fail: " + e);
			}
			
		}
		
		public static void editMeetingRoom(MeetingRoom mr){
			
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
				PreparedStatement stmnt = conn.prepareStatement("UPDATE MeetingRooms set floor = ?, seats_amount = ?, name = ? WHERE room_id = ?");
				
				stmnt.setInt(1, mr.getFloor());
				stmnt.setInt(2, mr.getSeatsAmount());
				stmnt.setString(3, mr.getName());
				stmnt.setInt(4, mr.getRoomID());
				
				stmnt.execute();
				conn.commit();
				conn.setAutoCommit(true);
			
			}
			catch(SQLException e){
				System.out.println("update fail!! - " + e);
			}
			
		}
		
		public static void removeMeetingRoom(int meetingID){
			
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
				PreparedStatement stmnt = conn.prepareStatement("DELETE FROM MeetingRooms WHERE room_id = ?");
				stmnt.setInt(1, meetingID);
				
			
				
				stmnt.execute();
				conn.commit();
				conn.setAutoCommit(true);
				
			}catch(SQLException e){
				System.out.println("Remove fail: " + e);
			}
			
		}
		
		public static ArrayList<MeetingRoom> searchRoomByID(String ID) {
			try {
				   if(conn == null || conn.isClosed()){
				    conn = DatabaseConnection.getConnection();
				   }
				  } catch (SQLException e1) {
				   // TODO Auto-generated catch block
				   e1.printStackTrace();
				  }
			
			ArrayList<MeetingRoom> rooms = new ArrayList<MeetingRoom>();
			try {
				PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM MeetingRooms WHERE room_id LIKE ? ");
				stmnt.setString(1, ID + "%");
				ResultSet res;
				res = stmnt.executeQuery();
				while(res.next()){
					meetingroom = new MeetingRoom(res.getInt("room_id"), res.getInt("floor"),res.getInt("seats_amount"), res.getString("name"));
					rooms.add(meetingroom);
				}
			}
				catch(SQLException e){
					e.printStackTrace();
					
					
				}
			
			return rooms;
		}
		
		public static ArrayList<MeetingRoom> searchRoomByName(String name) {
			try {
				   if(conn == null || conn.isClosed()){
				    conn = DatabaseConnection.getConnection();
				   }
				  } catch (SQLException e1) {
				   // TODO Auto-generated catch block
				   e1.printStackTrace();
				  }
			
			ArrayList<MeetingRoom> rooms = new ArrayList<MeetingRoom>();
			try {
				PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM MeetingRooms WHERE name LIKE ? ");
				stmnt.setString(1, "%" + name + "%");
				ResultSet res;
				res = stmnt.executeQuery();
				while(res.next()) {
					meetingroom = new MeetingRoom(res.getInt("room_id"), res.getInt("floor"),res.getInt("seats_amount"), res.getString("name"));
					rooms.add(meetingroom);
				}
			}
				catch(SQLException e){
					e.printStackTrace();
					
					
				}
			
			return rooms;
		}
}