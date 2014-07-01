package logic;

import java.util.ArrayList;
import java.util.Date;

import dao.MemberDAO;

public class Member extends Person {
	
	private int aantalBoeken = 0;
	private boolean actief = true;
	private Date date = new Date();
	private java.sql.Date inschrijvingsDatum = new java.sql.Date(date.getTime());
	private boolean lidgeld = true;
	private int lidID;
	private String telnr;
	private Adress adress;
	
	
	
	// validate telnr
				public static boolean validateTelnr( String telnr )
				   { 
				      return telnr.matches( "^(02|03|04|09|047|048|049)\\d{7}|^[+](32(2|3|4|9|47|48|49))\\d{7}|[+]\\d{10,16}|\\d{9,15}" );
				      // de ^ wil zeggen moet beginnen met vb 02
				      //(02|04) wil zeggen meot dus beginnen met 02 of 04
				      //\\d{7} wil zeggen meto vergolgd worden door characters naamelijk 7
				   } 

	
	public Member(String name, String surname, String telnr, Adress adress, int lidID){
		super(name,surname);
		setLidID(lidID);
		setTelnr(telnr);
		//if(validateTelnr(telnr)==false)
		//	System.out.println("telnr is niet correct ingevuld");
		//else System.out.println("telnr is correct ingevuld");
		setAdress(adress);
		
	}
	public Member(String name, String surname, String telnr, Adress adress){
		super(name,surname);
		setTelnr(telnr);
		//if(validateTelnr(telnr)==false)
		//	System.out.println("telnr is niet correct ingevuld");
		//else System.out.println("telnr is correct ingevuld");
		setAdress(adress);
		
	}
	public Member(String name, String surname, String telnr, Adress adress,int lidID, int aantalboeken, java.sql.Date inschrijvingsdatum, boolean actief, boolean lidgeld)
	{
		super(name,surname);
		setTelnr(telnr);
		setAdress(adress);
		setAantalBoeken(aantalboeken);
		setInschrijvingsDatum(inschrijvingsdatum);
		setActief(actief);
		setLidgeld(lidgeld);
		setLidID(lidID);
	}
	
	  
	

	public int getAantalBoeken() {
		return aantalBoeken;
	}


	public void setAantalBoeken(int aantalBoeken) {
		this.aantalBoeken = aantalBoeken;
	}


	public boolean isActief() {
		return actief;
	}


	public void setActief(boolean actief) {
		this.actief = actief;
	}


	public java.sql.Date getInschrijvingsDatum() {
		return inschrijvingsDatum;
	}


	public void setInschrijvingsDatum(java.sql.Date inschrijvingsdatum) {
		this.inschrijvingsDatum = inschrijvingsdatum;
	}


	public boolean isLidgeld() {
		return lidgeld;
	}


	public void setLidgeld(boolean lidgeld) {
		this.lidgeld = lidgeld;
	}


	public int getLidID() {
		return lidID;
	}


	public void setLidID(int lidID) {
		this.lidID = lidID;
	}

	public String getTelnr() {
		return telnr;
	}


	public void setTelnr(String telnr) {
		this.telnr = telnr;
	}


	public Adress getAdress() {
		return adress;
	}


	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public boolean checkMember(){
		ArrayList<Member> mList = new ArrayList<Member>();
		mList = MemberDAO.getAll();
		
		for(Member m : mList){
			if(this.equals(m)){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Member [aantalBoeken=" + aantalBoeken + ", actief=" + actief
				+ ", inschrijvingsDatum=" + inschrijvingsDatum + ", lidgeld="
				+ lidgeld + ", lidID=" + lidID + ", telnr=" + telnr + ", adress=" + adress + ", getName()="
				+ getName() + ", getSurname()=" + getSurname() + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((telnr == null) ? 0 : telnr.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (telnr == null) {
			if (other.telnr != null)
				return false;
		} else if (!telnr.equals(other.telnr))
			return false;
		return true;
	}

	

	
}
