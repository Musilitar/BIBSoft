package logic;

import java.util.ArrayList;

import dao.AdressDAO;

public class Adress {
	
	private String bus, street, city, houseNr;
	private int zipcode;
	private int adressID;
	
	

	//validate Street
	public static boolean validateStreet( String street )
	   {
	      return street.matches( "[a-zA-Z]{5,35}+([ -][a-zA-Z]+)*" );
	   }
	
//validate city
public static boolean validateCity( String city )
	   {
	      return city.matches( "[a-zA-Z]{3,35}+([ -][a-zA-Z]+)*" );
	   } 	
	

//validate houseNr

	public static boolean validateHouseNr( String houseNr )
	   {
		  
	      return houseNr.matches( "[1-9][a-z]{0,1}[0-9]{0,3}[a-z]{0,1}" );
	   }
//validate zipcode
	String zipString= Integer.toString(zipcode);
	public static boolean validateZipcode( String zipString )
	   {
		  
	      return zipString.matches( "[1-9][0-9]{3}" );
	   }
	   
//validate bus
	public static boolean validateBus(String bus){
		return bus.matches("[1-9][0-9]{0,1}|^$");
	}

	
	public Adress(String bus, String street, String city, String houseNr,int zipcode, int adressID){
		super();
		setAdressID(adressID);
		setBus(bus);
		//if(validateBus(bus)==false)
		//	System.out.println("Bus is niet correct ingevuld");
		//else System.out.println("Bus is correct ingevuld");
		setStreet(street);
		//if(validateStreet(street)==false)
		//	System.out.println("Street is niet correct ingevuld");
		//else System.out.println("Street is correct ingevuld");
		setCity(city);
		//if(validateCity(city)==false)
		//	System.out.println("City is niet correct ingevuld");
		//else System.out.println("City is correct ingevuld");
		setHouseNr(houseNr);
		//if(validateHouseNr(houseNr)==false)
		//	System.out.println("HouseNr is niet correct ingevuld");
		//else System.out.println("HouseNr is correct ingevuld");
		setZipcode(zipcode);
		//if(validateZipcode(zipString)==false)
		//	System.out.println("Zipcode is niet correct ingevuld");
		//else System.out.println("Zipcode is correct ingevuld");
	}
	

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHouseNr() {
		return houseNr;
	}

	public void setHouseNr(String houseNr) {
		this.houseNr = houseNr;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public int getAdressID() {
		return adressID;
	}

	public void setAdressID(int adressID) {
		this.adressID = adressID;
	}
	
	public boolean checkAdress(){
		ArrayList<Adress> aList = new ArrayList<Adress>();
		aList = AdressDAO.getAll();
		
		for(Adress a: aList){
			if(this.equals(a)){
				this.setAdressID(a.getAdressID());
				return true;
			}
		}
		return false;
	}
	
		


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adressID;
		result = prime * result + ((bus == null) ? 0 : bus.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((houseNr == null) ? 0 : houseNr.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result
				+ ((zipString == null) ? 0 : zipString.hashCode());
		result = prime * result + zipcode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adress other = (Adress) obj;
		if (adressID != other.adressID)
			return false;
		if (bus == null) {
			if (other.bus != null)
				return false;
		} else if (!bus.equals(other.bus))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (houseNr == null) {
			if (other.houseNr != null)
				return false;
		} else if (!houseNr.equals(other.houseNr))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipString == null) {
			if (other.zipString != null)
				return false;
		} else if (!zipString.equals(other.zipString))
			return false;
		if (zipcode != other.zipcode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adress [bus=" + bus + ", street=" + street + ", city=" + city
				+ ", houseNr=" + houseNr + ", zipcode=" + zipcode
				+ ", getAdressID()=" + getAdressID() + "]";
	}


}
