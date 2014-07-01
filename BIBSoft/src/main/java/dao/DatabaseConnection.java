package dao;

import java.sql.*;

public class DatabaseConnection {
	private static Connection conn;
	private static DatabaseConnection instance = null;
	
	private static void createInstance(){
		if(instance == null){
			instance = new DatabaseConnection();
		}
	}
	
	public static DatabaseConnection getInstance(){
		if(instance == null){
			createInstance();
		}
		return instance;
	}
	
	private DatabaseConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			if(conn == null || conn.isClosed()){
			conn = DriverManager.getConnection("jdbc:mysql://iwt5.ehb.be/SP2A", "SP2A", "sCPQ");
			System.out.println("Connected to database");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Oops!");
		}
		return conn;
	}
	
	public void close(){
		try{
			conn.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
}
