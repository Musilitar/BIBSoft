package logic;

import java.util.Date;

public class Media extends Product {

	public int mediaID;
	public String creator, producer, type;
	
	//validate creator
			public static boolean validateCreator( String creator )
			   {
			      return creator.matches( "[a-zA-Z]{2,20}+([ -,][a-zA-Z]+)*" );
			   } 

			   
	// validate producer
			public static boolean validateProducer( String producer )
			   {
			      return producer.matches( "[a-zA-z]{1,25}+([ '-.][a-zA-Z]+)*" );
			   } 
			
			
	
	
	
	/**
	 * nieuw media exemplaar
	 */
	public Media(Date yearEdition, String publicationPlace, String title,
			String genre, String creator, String producer, String type) {
		super(yearEdition, publicationPlace, title, genre);
		this.creator = creator;
		this.producer = producer;
		this.type = type;
	}
	
	/**
	 * volledig gekend media exemplaar
	 */
	public Media(Date yearEdition, String publicationPlace, String title,
			String genre, int mediaID, String creator, String producer,
			String type) {
		super(yearEdition, publicationPlace, title, genre);
		this.mediaID = mediaID;
		this.creator = creator;
		this.producer = producer;
		this.type = type;
	}



	public int getMediaID() {
		return mediaID;
	}

	public void setMediaID(int mediaID) {
		this.mediaID = mediaID;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
