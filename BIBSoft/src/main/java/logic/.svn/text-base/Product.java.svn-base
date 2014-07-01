package logic;

import java.util.Date;

public abstract class Product {
	
	private Date yearEdition;
	private String publicationPlace, title, genre;

	 
	
	//validate publicationplace 
	public static boolean validatePublicationPlace( String publicationPlace )
	   {
	      return publicationPlace.matches( "[a-zA-Z]{1,20}+([ -'.][a-zA-Z]+)*" );
	   } 

	   
	// validate genre
	public static boolean validateGenre( String genre )
	   {
	      return genre.matches( "[a-zA-z]{3,25}" );
	   } 
	
	public Product(Date yearEdition, String publicationPlace, String title, String genre) {
		super();
		this.yearEdition = yearEdition;
		this.publicationPlace = publicationPlace;
		this.title = title;
		this.genre = genre;
	
	}

	public Date getYearEdition() {
		return yearEdition;
	}

	public void setYearEdition(Date yearEdition) {
		this.yearEdition = yearEdition;
	}

	public String getPublicationPlace() {
		return publicationPlace;
	}

	public void setPublicationPlace(String publicationPlace) {
		this.publicationPlace = publicationPlace;
	}

	public String getTitle() {
		return title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	

}
