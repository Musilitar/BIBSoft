package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.MediaCopy;

public class MediaCopyDAO {
	private static Connection conn = DatabaseConnection.getConnection();
	private static MediaCopy mediaCopy;
	public ResultSet res = null;
	public Statement stmt = null;

	
	public static void saveCopy(MediaCopy mc){
		
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
			PreparedStatement stmnt = conn.prepareStatement("INSERT INTO MediaCopies(media_id) VALUES(?)");
		
			stmnt.setInt(1, mc.getMediaID());
						
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE MediaCopies SET lendable = ? "
															+ ", exist = ?  "
															+ "WHERE copy_id = ?");
			stmnt.setBoolean(1, false);
			stmnt.setBoolean(2, false);
			stmnt.setInt(3, copyId);
			
			System.out.println(stmnt.toString());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			System.out.println("Remove fail: " + e);
		}
	
	}
	
	public static MediaCopy getMediaCopy(int mediaCopyId){
		
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
			String sql = "SELECT * FROM MediaCopies mc, Media m WHERE mc.media_id = m.media_id AND copy_id = " + mediaCopyId;
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				mediaCopy = new MediaCopy(StringDateSwitcher.toDateYear(res.getString("year")), res.getString("place_of_publication"), res.getString("title"), res.getString("genre"), res.getInt("media_id"), res.getString("creator"), res.getString("producer"), res.getString("type"), res.getInt("copy_id"), res.getBoolean("lendable"));
			}

		}
		catch(SQLException e) {
			System.out.println("PROBLEM");
			e.printStackTrace();
			return mediaCopy;

		}
		return mediaCopy;
	}
	
	public static ArrayList<MediaCopy> searchMediaByTitle(String title){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<MediaCopy> media = new ArrayList<MediaCopy>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Media m, MediaCopies mc WHERE m.media_id = mc.media_id AND title LIKE ? OR title LIKE ? AND mc.media_id = m.media_id");
			stmnt.setString(1, title + "%");
			stmnt.setString(2,"% "+ title + "%");
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				mediaCopy = new MediaCopy(StringDateSwitcher.toDateYear(res.getString("year")), res.getString("place_of_publication"), res.getString("title"), res.getString("genre"), res.getInt("media_id"), res.getString("creator"), res.getString("producer"), res.getString("type"), res.getInt("copy_id"), res.getBoolean("lendable"));
				media.add(mediaCopy);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
					
			}
		return media;
	}
	
	
	
	
	
	
	public static ArrayList<MediaCopy> searchMediaByGenre(String genre){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<MediaCopy> media = new ArrayList<MediaCopy>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Media m, MediaCopies mc WHERE mc.media_id = m.media_id AND genre LIKE ? AND m.media_id = mc.media_id");
			stmnt.setString(1, genre + "%");
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				mediaCopy = new MediaCopy(StringDateSwitcher.toDateYear(res.getString("year")), res.getString("place_of_publication"), res.getString("title"), res.getString("genre"), res.getInt("media_id"), res.getString("creator"), res.getString("producer"), res.getString("type"), res.getInt("copy_id"), res.getBoolean("lendable"));
				media.add(mediaCopy);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return media;
	}
	
	
	public static ArrayList<MediaCopy> searchMediaByCreator(String creator){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<MediaCopy> media = new ArrayList<MediaCopy>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Media m, MediaCopies mc WHERE m.media_id = mc.media_id AND creator LIKE ? OR creator LIKE ? AND mc.media_id = m.media_id");
			stmnt.setString(1, creator + "%");
			stmnt.setString(2, "% " + creator + "%");
			
			
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				mediaCopy = new MediaCopy(StringDateSwitcher.toDateYear(res.getString("year")), res.getString("place_of_publication"), res.getString("title"), res.getString("genre"), res.getInt("media_id"), res.getString("creator"), res.getString("producer"), res.getString("type"), res.getInt("copy_id"), res.getBoolean("lendable"));
				media.add(mediaCopy);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return media;
	}
	
	public static ArrayList<MediaCopy> searchMediaByID(String ID){

		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<MediaCopy> media = new ArrayList<MediaCopy>();
		try {
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM Media m, MediaCopies mc WHERE mc.media_id = m.media_id AND copy_id LIKE ? AND m.media_id = mc.media_id");
			stmnt.setString(1, ID + "%");
			ResultSet res;
			res = stmnt.executeQuery();
			while(res.next()){
				//Date yearEdition, String publicationPlace, String title String genre, String author, String iSBN, String publisher,int MediaID
				mediaCopy = new MediaCopy(StringDateSwitcher.toDateYear(res.getString("year")), res.getString("place_of_publication"), res.getString("title"), res.getString("genre"), res.getInt("media_id"), res.getString("creator"), res.getString("producer"), res.getString("type"), res.getInt("copy_id"), res.getBoolean("lendable"));
				media.add(mediaCopy);
			}
		}
			catch(SQLException e){
				e.printStackTrace();
				
				
			}
		
		return media;
	}
	
	public static void changeLendability(MediaCopy mc, boolean lendable) {
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE MediaCopies SET lendable = ? WHERE copy_id = ?");

			stmnt.setBoolean(1, lendable);
			stmnt.setInt(2, mc.getMediaCopyID());

			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);

		}catch(SQLException e){
			System.out.println("update fail!! - " + e);
		}
	}
}
