package logic;

import java.util.ArrayList;
import java.util.Date;

import dao.MemberDAO;
import dao.RateDAO;
import dao.StaffDAO;
import dao.Statistics;
import dao.StringDateSwitcher;


public class Admin extends Librarian {
	
	/**
	 * tijdelijke dao - Is mss nog te gebruiken om zaken vanuit de db op te vangen?
	 */
	public static ArrayList<Admin> staffDAOadmin = new ArrayList<Admin>();
	public static ArrayList<Librarian> staffDAOlibrarian = new ArrayList<Librarian>();
	public static ArrayList<Manager> staffDAOmanager = new ArrayList<Manager>();
	public static ArrayList<Staff> staffDAO = new ArrayList<Staff>();


	public Admin(String name, String surname, String function, Login login) 
	{
		super(name, surname, function, login);
		
	}
	
	//Toevoegen van accounts
	
	public static boolean addStaff(String name, String surname, String staffID, 
			String password,String function)
	{
		Login login = new Login(staffID, password);
		login.setPassword(password);
		Staff staff = new Staff(name, surname, function, login);
		StaffDAO.insertStaff(staff);
		return true;
		
		
	}
	
	
	public void deleteStaff(String id)
	{
		StaffDAO.removeStaff(id);
	}
	
	public void editStaffFunction(Staff staff,String function)
	{
		staff.setFunction(function);
	}
	
	public void editStaffName(Staff staff, String name)
	
	{
		staff.setName(name);
	}
	
	public void editStaffPassword(Staff staff, String pw)
	{
		Login login = staff.getLogin();
		
		login.setPassword(login.encrypt(pw));
	}
	
	public void editStaffSurname(Staff staff, String surname)
	{
		staff.setSurname(surname);
		
	}
	
	public Staff getStaffById(String id)

	{
		return StaffDAO.getStaffByID(id);
	}
	
	public ArrayList<Staff> getAllStaff()
	{
		return StaffDAO.getAll();
	}
	
	public static void main(String[] args) {
		
	}
	
	//Rate functies	
	public void addRate(Rate r){
		RateDAO.saveRate(r);
	}
	
	public void updateRate(Rate r){
		RateDAO.editRate(r);
	}
	
	public ArrayList<Rate> getAllRates(){
		rateList = RateDAO.getAllRates();
		return rateList;
	}
	
	public void removeRate(int rateID){
		RateDAO.removeRate(rateID);
	}

	//Statistics functies
	public ArrayList<String> top10BooksRented(){
		return Statistics.top10BooksRented();
	}
	
	public ArrayList<String> top10BooksReserved(){
		return Statistics.top10BooksReserved();
	}
	
	public ArrayList<String> top10DVDRented(){
		return Statistics.top10DvdRented();
	}
	
	public ArrayList<String> top10DVDReserved(){
		return Statistics.top10DvdReserved();
	}
	
	public ArrayList<String> top10CDRented(){
		return Statistics.top10CdRented();
	}
	
	public ArrayList<String> top10CDReserved(){
		return Statistics.top10CdReserved();
	}
	
	public ArrayList<String> topTenMembersAllTime(){
		ArrayList<Integer> members = Statistics.top10loyalMemberAllTimes();
		return getMembers(members);
	}
	
	public ArrayList<String> topTenMembersMonth(){
		Date d = new Date();
		String date = StringDateSwitcher.dateToStringMonthYear(d);
		ArrayList<Integer> members = Statistics.top10loyalMemberPerMonth(date);
		return getMembers(members);
	}
	
	public ArrayList<String> topTenLocalMembersAllTime(int pc){
		ArrayList<Integer> members = Statistics.top10loyalLocalMemberAllTimes(pc);
		return getMembers(members);
	}
	
	public ArrayList<String> topTenLocalMembersMonth(int pc){
		Date d = new Date();
		String date = StringDateSwitcher.dateToStringMonthYear(d);
		ArrayList<Integer> members = Statistics.top10loyalLocalMemberPerMonth(pc, date);
		return getMembers(members);
	}
	
	public ArrayList<String> getMembers(ArrayList<Integer> members){
		ArrayList<String> memberList = new ArrayList<String>();
		Member m;
		String s;
			for(Integer memberID : members){
				m = MemberDAO.getMemberByID(memberID);
				s = "ID: " + m.getLidID() + " || " + m.getSurname() + " " + m.getName();
				memberList.add(s);
			}
		return memberList;
	}
	
	public int rentStatisticsForThisMonth(){
		Date d = new Date();
		String date = StringDateSwitcher.dateToStringMonthYear(d);
		return Statistics.RentsPerMonth(date);
	}
	
}
