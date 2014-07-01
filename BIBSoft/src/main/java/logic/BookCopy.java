package logic;

import java.util.Date;

public class BookCopy extends Book {

	private int copyId;
	private int edition;
	private Boolean lendable;
	
	/**
	 * Nieuwe copy van bestaande boek
	 */
	public BookCopy(Date yearEdition, String publicationPlace, String title,
			String genre, String author, String iSBN, String publisher,
			int bookID, int edition, Boolean lendable) {
		super(yearEdition, publicationPlace, title, genre, author, iSBN,
				publisher, bookID);
		this.edition = edition;
		this.lendable = lendable;
	}

	/**
	 * Nieuwe copy van nieuw boek
	 */
	public BookCopy(Date yearEdition, String publicationPlace, String title,
			String genre, String author, String iSBN, String publisher,
			int edition) {
		super(yearEdition, publicationPlace, title, genre, author, iSBN,
				publisher);
		this.edition = edition;
	}

	/**
	 * nieuw object van bestaand boek per copy
	 */
	public BookCopy(Date yearEdition, String publicationPlace, String title,
			String genre, String author, String iSBN, String publisher,
			int bookID, int copyId, int edition, Boolean lendable) {
		super(yearEdition, publicationPlace, title, genre, author, iSBN,
				publisher, bookID);
		this.copyId = copyId;
		this.edition = edition;
		this.lendable = lendable;
	}

	public int getCopyId() {
		return copyId;
	}

	public void setCopyId(int copyId) {
		this.copyId = copyId;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public Boolean getLendable() {
		return lendable;
	}

	public void setLendable(Boolean lendable) {
		this.lendable = lendable;
	}
	
	

}
