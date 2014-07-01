package logic;

import java.util.Date;

public class MediaCopy extends Media {
	private int mediaCopyID;
	private Boolean lendable;
	


	/**
	 * volledig gekend media copy
	 */
	public MediaCopy(Date yearEdition, String publicationPlace, String title,
			String genre, int mediaID, String creator, String producer,
			String type, int mediaCopyID, Boolean lendable) {
		super(yearEdition, publicationPlace, title, genre, mediaID, creator,
				producer, type);
		this.mediaCopyID = mediaCopyID;
		this.lendable = lendable;
	}

	/**
	 * Nieuwe copy van nieuwe media
	 */
	public MediaCopy(Date yearEdition, String publicationPlace, String title,
			String genre, String creator, String producer, String type) {
		super(yearEdition, publicationPlace, title, genre, creator, producer,
				type);
	}

	/**
	 * nieuwe copy van bestaand media onderdeel
	 */
	public MediaCopy(Date yearEdition, String publicationPlace, String title,
			String genre, int mediaID, String creator, String producer,
			String type, Boolean lendable) {
		super(yearEdition, publicationPlace, title, genre, mediaID, creator,
				producer, type);
		this.lendable = lendable;
	}

	public int getMediaCopyID() {
		return mediaCopyID;
	}

	public void setMediaCopyID(int mediaCopyID) {
		this.mediaCopyID = mediaCopyID;
	}

	public Boolean getLendable() {
		return lendable;
	}

	public void setLendable(Boolean lendable) {
		this.lendable = lendable;
	}
	
	
	
		
	
	

}
