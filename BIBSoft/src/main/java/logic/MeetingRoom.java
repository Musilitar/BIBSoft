package logic;

public class MeetingRoom {
	
	
	private int roomID;
	private int floor;
	private int seatsAmount;
	private String name;

	public MeetingRoom(int roomID, int floor, int seatsAmount, String name) {
		super();
		this.roomID = roomID;
		this.name = name;
		this.floor = floor;
		this.seatsAmount = seatsAmount;
	}
	
	public MeetingRoom(int floor, int seatsAmount, String name) {
		super();
		this.name = name;
		this.floor = floor;
		this.name = name;
		this.seatsAmount = seatsAmount;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getSeatsAmount() {
		return seatsAmount;
	}

	public void setSeatsAmount(int seatsAmount) {
		this.seatsAmount = seatsAmount;
	}
}
