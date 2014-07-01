package logic;

import java.util.ArrayList;

import dao.StaffDAO;

public class Login {
	
	private String staffID, password;
	

	
	public Login(String staffID, String password) {
		super();
		this.staffID = staffID;
		this.password = password;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = encrypt(password);
	}
	
	//info gevonden op http://howtodoinjava.com/2013/07/22/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
	//Copyright vermelding in BCrypt.java
	//Password hashing with BCrypt
	public String encrypt (String pw)
	{
		String generatedSecuredPasswordHash = BCrypt.hashpw(pw, BCrypt.gensalt(12));
        
        password = generatedSecuredPasswordHash;
        
        return generatedSecuredPasswordHash;
	}
	
	public boolean passwordCheck (String pw)
	{
		
		return BCrypt.checkpw(pw, password);
	}
	
	//login check: haalt staff uit DAO
	public static boolean checkLogin(Login l){
		
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		
		staffList = StaffDAO.getAll();
		
		if(staffList.isEmpty()){
			return false;
		}
		for(Staff staff: staffList){
				Login contrLogin;
				contrLogin = staff.getLogin();
				if(contrLogin.getStaffID().equals(l.getStaffID())){
					if(BCrypt.checkpw(l.getPassword(), contrLogin.getPassword())){
						return true;
					}
				}
		}
		return false;
	}
	
	public static void main(String[] args) 
	{
		
		String s = "here are a bunch of words";

		final StringBuilder result = new StringBuilder(s.length());
		String[] words = s.split("\\s");
		for(int i=0,l=words.length;i<l;++i) {
		  if(i>0) result.append(" ");      
		  result.append(Character.toUpperCase(words[i].charAt(0)))
		        .append(words[i].substring(1));
		 
		}
		 
		
	}
	

}
