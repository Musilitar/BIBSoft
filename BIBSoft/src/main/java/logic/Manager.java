package logic;

import java.util.ArrayList;

import dao.FineDAO;
import dao.RateDAO;
import dao.RentTransactionDAO;
import dao.Statistics;




public class Manager extends Staff {
	
	public static ArrayList<Rate> rateList = new ArrayList<Rate>();
	public static ArrayList<Fine> fineList = new ArrayList<Fine>();
	
	public Manager(String name, String surname, String function, Login login) 
	{
		super(name, surname, function, login);
		
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

	//Fine functies
		public ArrayList<Fine> getAllFines(){
			fineList = FineDAO.getAllFines();
			return fineList;
		}
		
		public RentTransaction getRentTransaction(int rentTransactionID)
		{
			
			return RentTransactionDAO.getRentTransaction(rentTransactionID);
			
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
		
}

