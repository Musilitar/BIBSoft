package logic;

import java.util.ArrayList;

public class Transaction {
	
	
	private ArrayList<BookCopy> bookList;
	private ArrayList<MediaCopy> mediaList;
	private ArrayList<MeetingRoom> meetingRoomList;
	
	//als er boeken en media uitgeleend wordt
	public Transaction() {
		super();
	}
	
	public Transaction(ArrayList<BookCopy> bookList, ArrayList<MediaCopy> mediaList) {
		super();
		this.bookList = bookList;
		this.mediaList = mediaList;
	}
	
	public Transaction(ArrayList<BookCopy> bookList, ArrayList<MediaCopy> mediaList, ArrayList<MeetingRoom> meetingRoomList) {
		super();
		this.bookList = bookList;
		this.mediaList = mediaList;
		this.meetingRoomList = meetingRoomList;
	}
	
	public ArrayList<MeetingRoom> getMeetingRoomList() {
		return meetingRoomList;
	}

	public void setMeetingRoomList(ArrayList<MeetingRoom> meetingRoomList) {
		this.meetingRoomList = meetingRoomList;
	}

	public ArrayList<BookCopy> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<BookCopy> bookList) {
		this.bookList = bookList;
	}

	public ArrayList<MediaCopy> getMediaList() {
		return mediaList;
	}

	public void setMediaList(ArrayList<MediaCopy> mediaList) {
		this.mediaList = mediaList;
	}
	
	

	
	
	

}
