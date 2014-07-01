package logic;

import java.util.ArrayList;

public class RentTransaction extends Transaction {
	
	private int rentTransId;
	private int memberId;
	private String dateOut;
	private String dateIn;
	private Boolean closed;
	private String staffId;
	


	public RentTransaction(boolean closed, ArrayList<BookCopy> bookList,ArrayList<MediaCopy> mediaList,
			int rentTransId, int memberId, String dateOut, String dateIn, String staffId) {
		super(bookList,mediaList);
		
		this.rentTransId = rentTransId;
		this.memberId = memberId;
		this.dateOut = dateOut;
		this.dateIn = dateIn;
		this.closed = false;
		this.staffId = staffId;
	}
	
	public RentTransaction(boolean closed, int rentTransId, int memberId, String dateOut, String dateIn, String staffId) {
		super();
		this.rentTransId = rentTransId;
		this.memberId = memberId;
		this.dateOut = dateOut;
		this.dateIn = dateIn;
		this.closed = false;
		this.staffId = staffId;
	}
	
	public RentTransaction(boolean closed, ArrayList<BookCopy> bookList,ArrayList<MediaCopy> mediaList, int memberId, String dateOut, String dateIn, String staffId) {
		super(bookList,mediaList);
		
		this.memberId = memberId;
		this.dateOut = dateOut;
		this.dateIn = dateIn;
		this.closed = false;
		this.staffId = staffId;
	}
	
	public RentTransaction(boolean closed, ArrayList<BookCopy> bookList,ArrayList<MediaCopy> mediaList, ArrayList<MeetingRoom> meetingRoomList, int memberId, String dateOut, String dateIn, String staffId) {
		super(bookList,mediaList, meetingRoomList);
		
		this.memberId = memberId;
		this.dateOut = dateOut;
		this.dateIn = dateIn;
		this.closed = false;
		this.staffId = staffId;
	}
	


	public int getRentTransId() {
		return rentTransId;
	}

	public void setRentTransId(int rentTransId) {
		this.rentTransId = rentTransId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getDateOut() {
		return dateOut;
	}

	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}

	public String getDateIn() {
		return dateIn;
	}

	public void setDateIn(String dateIn) {
		this.dateIn = dateIn;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	

}
