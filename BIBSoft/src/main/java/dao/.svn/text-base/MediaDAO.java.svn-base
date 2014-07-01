package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import logic.Media;
import logic.MediaCopy;

public class MediaDAO {
	private static Connection conn = DatabaseConnection.getConnection();
	private static ArrayList<MediaCopy> mc = new ArrayList<MediaCopy>();
	
 	public static ArrayList<MediaCopy> getAllCopies() {
 		
 		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<MediaCopy> mediaList = new ArrayList<MediaCopy>();
		
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM MediaCopies mc, Media m WHERE mc.media_id = m.media_id and mc.exist = 1";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				MediaCopy mc = new MediaCopy(StringDateSwitcher.toDateYear(res.getString("year")), res.getString("place_of_publication"),
						res.getString("title"), res.getString("genre"), res.getInt("media_id"), 
						res.getString("creator"), res.getString("producer"),
						res.getString("type"), res.getInt("copy_id"), res.getBoolean("lendable"));
				mediaList.add(mc);
			}

		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		return mediaList;
	}
	
	public static ArrayList<Media> getAllMedia() {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Media> mediaList = new ArrayList<Media>();
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Media";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				Media m = new Media(StringDateSwitcher.toDateYear(res.getString("year")), res.getString("place_of_publication"),
						res.getString("title"), res.getString("genre"), res.getInt("media_id"), 
						res.getString("creator"), res.getString("producer"), res.getString("type"));
				mediaList.add(m);
			}

		}
		catch(SQLException e) {
			System.out.println(e);
		
		}
		return mediaList;
	}
	
	public static ArrayList<Media> getAllRentedMedia() {
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		ArrayList<Media> mediaList = new ArrayList<Media>();
		Media m = null;
		try {
			Statement stmnt = conn.createStatement();
			String sql = "SELECT * FROM Media m WHERE m.media_id = (SELECT media_id FROM MediaCopies mc, Rentals r WHERE mc.media_id = m.media_id AND mc.copy_id = r.product_id AND (r.type = 'DVD' OR r.type = 'CD') AND r.rental_id = (SELECT rental_id FROM RentTransactions rt WHERE rt.rent_trans_id = r.rental_id AND rt.closed = 0))";
			ResultSet res = stmnt.executeQuery(sql);

			while(res.next()) {
				m = new Media(StringDateSwitcher.toDateYear(res.getString("year")), res.getString("place_of_publication"),
						res.getString("title"), res.getString("genre"), res.getInt("media_id"), 
						res.getString("creator"), res.getString("producer"), res.getString("type"));
				mediaList.add(m);
			}

		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		return mediaList;
	}

	public static void insertMedia(MediaCopy mc){
		
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
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Media(title, creator, producer, place_of_publication, year, genre, type)"
														+  "VALUES (?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(5, StringDateSwitcher.dateToStringYear(mc.getYearEdition()));
			stmt.setString(4, mc.getPublicationPlace());
			stmt.setString(1, mc.getTitle());
			stmt.setString(2, mc.getCreator());
			stmt.setString(7, mc.getType());
			stmt.setString(3, mc.getProducer());
			stmt.setString(6, mc.getGenre());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		}catch(SQLException e){
			System.out.println("insert fail!! - " + e);
		}
	}
	

	
	public static ArrayList<MediaCopy> getMediaByMediaID(int bookID){
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		//todo nog te schrijven
		return mc;
	}
	
	public static MediaCopy getMediaCopyByMediaCopyID(int copyID){
		MediaCopy mc = null;
		
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
		
		try {
			
			PreparedStatement stmnt = conn.prepareStatement("SELECT * FROM MediaCopies mc, Media m WHERE mc.media_id = m.media_id AND mc.copy_id = ?");
			stmnt.setInt(1, copyID);
			ResultSet res = stmnt.executeQuery();
			if(res.next())
			{
			mc = new MediaCopy(StringDateSwitcher.toDateYear(res.getString("year")), res.getString("place_of_publication"),
					res.getString("title"), res.getString("genre"), res.getInt("media_id"), 
					res.getString("creator"), res.getString("producer"),
					res.getString("type"), res.getInt("copy_id"), res.getBoolean("lendable"));
			}
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		
		return mc;
	}
	
	public static void editMedia(Media m){

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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Media set title = ?, creator = ?, producer = ?, place_of_publication = ?, year = ?, genre = ?, type = ? WHERE media_id = ?");
			stmnt.setString(1, m.getTitle());
			stmnt.setString(2, m.getCreator());
			stmnt.setString(3, m.getProducer());
			stmnt.setString(4, m.getPublicationPlace());
			stmnt.setString(5, StringDateSwitcher.dateToStringYear(m.getYearEdition()));
			stmnt.setString(6, m.getGenre());
			stmnt.setString(7, m.getType());
			stmnt.setInt(8, m.getMediaID());
			
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Media update fail: " + e);
		}
	}

	public static void UpperCreator(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Media set creator = CONCAT( UPPER( LEFT( creator, 1 ) ) , SUBSTRING( creator, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}
	
	public static void UpperPlaceOfPublication(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Media set place_of_publication = CONCAT( UPPER( LEFT( place_of_publication, 1 ) ) , SUBSTRING( place_of_publication, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}

	public static void UpperTitle(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Media set title = CONCAT( UPPER( LEFT( title, 1 ) ) , SUBSTRING( title, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}	
	
	public static void UpperProducer(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Media set producer = CONCAT( UPPER( LEFT( producer, 1 ) ) , SUBSTRING( producer, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}
	
	public static void UpperType(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Media set type = UPPER(type)");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}
	
	public static void UpperGenre(){
		
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
			PreparedStatement stmnt = conn.prepareStatement("UPDATE Media set genre = CONCAT( UPPER( LEFT( genre, 1 ) ) , SUBSTRING( genre, 2 ))");
			stmnt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			e.printStackTrace();
		}
}	
}
