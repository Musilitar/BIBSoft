package gui;


import gui.RentalsGUI;

import javax.swing.*;
import javax.swing.plaf.synth.SynthLookAndFeel;

import dao.StaffDAO;

import java.awt.*;
import java.text.ParseException;

import logic.Staff;

public class MainGUI {
	private JFrame mainFrame = new JFrame();
	private SynthLookAndFeel laf = new SynthLookAndFeel();
	private static JPanel contentPane = new JPanel();
	private static CardLayout mainLayout = new CardLayout();
	
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog loginDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;
	
	private static LoginGUI loginGUI;
	private static MenuGUI menuGUI;
	private static BookGUI bookGUI;
	private static BookGUI.BookListGUI bookListGUI;
	private static MediaGUI mediaGUI;
	private static MediaGUI.MediaListGUI mediaListGUI;
	private static MemberGUI memberGUI;
	private static MeetingRoomGUI meetingRoomGUI;
	private static MeetingRoomGUI.MeetingRoomListGUI meetingRoomListGUI;
	private static MemberGUI.MemberListGUI memberListGUI;
	private static StaffGUI staffGUI;
	private static StaffGUI.StaffListGUI staffListGUI;
	private static RentalsGUI rentalsGUI;
	private static RateGUI rateGUI;
	private static RateGUI.RateListGUI rateListGUI;
	private static ReservationsGUI reservationsGUI;
	private static ReservationsGUI.ReservationListGUI reservationListGUI;
	private static FineGUI fineGUI;
	private static StatisticsGUI statisticsGUI;
	
	public MainGUI() {
		//Get size of screen without taskbar
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(loginDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;
		
		//Basic frame set-up
		try {
			laf.load(MainGUI.class.getResourceAsStream("synth.xml"), MainGUI.class);
			UIManager.setLookAndFeel(laf);
		} catch (ParseException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		mainFrame.setSize(screenWidth, screenHeight);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		
		//Fill container
		loginGUI = new LoginGUI();
		menuGUI = new MenuGUI();
		bookGUI = new BookGUI();
		bookListGUI = bookGUI.new BookListGUI();
		mediaGUI = new MediaGUI();
		mediaListGUI = mediaGUI.new MediaListGUI();
		meetingRoomGUI = new MeetingRoomGUI();
		meetingRoomListGUI = meetingRoomGUI.new MeetingRoomListGUI();
		memberGUI = new MemberGUI();
		memberListGUI = memberGUI.new MemberListGUI();
		staffGUI = new StaffGUI();
		staffListGUI = staffGUI.new StaffListGUI();
		rentalsGUI = new RentalsGUI();
		rateGUI = new RateGUI();
		rateListGUI = rateGUI.new RateListGUI();
		reservationsGUI = new ReservationsGUI();
		reservationListGUI = reservationsGUI.new ReservationListGUI();
		fineGUI = new FineGUI();
		statisticsGUI = new StatisticsGUI();
		contentPane.setLayout(mainLayout);
		contentPane.add(loginGUI.getContentPane(), "login");
		contentPane.add(menuGUI.getContentPane(), "menu");
		contentPane.add(bookGUI.getContentPane(), "book");
		contentPane.add(bookGUI.getContentPaneCheck(), "bookcheck");
		contentPane.add(bookListGUI.getContentPane(), "booklist");
		contentPane.add(mediaGUI.getContentPane(), "media");
		contentPane.add(mediaGUI.getContentPaneCheck(), "mediacheck");
		contentPane.add(mediaListGUI.getContentPane(), "medialist");
		contentPane.add(meetingRoomGUI.getContentPane(), "meetingroom");
		contentPane.add(meetingRoomListGUI.getContentPane(), "meetingroomlist");
		contentPane.add(memberGUI.getContentPane(), "member");
		contentPane.add(memberListGUI.getContentPane(), "memberlist");
		contentPane.add(staffGUI.getContentPane(), "staff");
		contentPane.add(staffListGUI.getContentPane(), "stafflist");
		contentPane.add(rateGUI.getContentPane(), "rate");
		contentPane.add(rateListGUI.getContentPane(), "ratelist");
		contentPane.add(rentalsGUI.getContentPane(), "rentals");
		contentPane.add(rentalsGUI.getContentPaneMember(), "rentalsmember");
		contentPane.add(rentalsGUI.getContentPaneProduct(), "rentalsproduct");
		contentPane.add(rentalsGUI.getContentPaneMeeting(), "rentalsmeeting");
		contentPane.add(reservationsGUI.getContentPane(), "reservations");
		contentPane.add(reservationsGUI.getContentPaneProduct(), "reservationsproduct");
		contentPane.add(reservationListGUI.getContentPane(), "reservationlist");
		contentPane.add(fineGUI.getContentPane(), "fines");
		contentPane.add(statisticsGUI.getContentPane(), "statistics");
		contentPane.add(statisticsGUI.getContentPaneTopTen(), "topten");
		contentPane.add(statisticsGUI.getContentPaneMembers(), "members");
		contentPane.add(statisticsGUI.getContentPaneRentStatistics(), "rent");
		
		//Frame visible
		if(StaffDAO.getAll().size()==0)
		{
			mainLayout.show(contentPane, "staff");
			StaffGUI.setBackButton();
			StaffGUI.setFunctionBox();
		}
		else
		{
			mainLayout.show(contentPane, "login");
		}
		mainFrame.setContentPane(contentPane);
		mainFrame.setVisible(true);
	}
	
	public static void switchToLogin() {
		loginGUI.reset();
		mainLayout.show(contentPane, "login");
	}
	
	public static void switchToMenu() {
		mainLayout.show(contentPane, "menu");
	}
	
	public static void switchToMenu(Staff staff) {
		menuGUI.setWelcome(staff);
		mainLayout.show(contentPane, "menu");
	}
	
	public static void switchToBook() {
		bookGUI.reset();
		mainLayout.show(contentPane, "book");
	}
	
	public static void switchToBookCheck() {
		bookGUI.reset();
		mainLayout.show(contentPane, "bookcheck");
	}
	public static void switchToBook(Boolean forEdit) {
		bookGUI.reset();
		bookGUI.setForEdit(forEdit);
		mainLayout.show(contentPane, "book");
	}
	
	public static void switchToBookList() {
		bookListGUI.reset();
		bookListGUI.update();
		mainLayout.show(contentPane, "booklist");
	}
	
	public static void switchToMedia() {
		mediaGUI.reset();
		mainLayout.show(contentPane, "media");
	}
	
	public static void switchToMedia(Boolean forEdit) {
		mediaGUI.reset();
		mediaGUI.setForEdit(forEdit);
		mainLayout.show(contentPane, "media");
	}
	
	public static void switchToMediaCheck() {
		mediaGUI.reset();
		mainLayout.show(contentPane, "mediacheck");
	}
	
	public static void switchToMediaList() {
		mainLayout.show(contentPane, "medialist");
		mediaListGUI.reset();
		mediaListGUI.update();
	}
	
	public static void switchToMeetingRoom() {
		meetingRoomGUI.reset();
		mainLayout.show(contentPane, "meetingroom");
	}
	
	public static void switchToMeetingRoom(Boolean forEdit) {
		meetingRoomGUI.reset();
		meetingRoomGUI.setForEdit(forEdit);
		mainLayout.show(contentPane, "meetingroom");
	}
	
	public static void switchToMeetingRoomList() {
		meetingRoomListGUI.reset();
		meetingRoomListGUI.update();
		mainLayout.show(contentPane, "meetingroomlist");
	}
	
	public static void switchToMember() {
		memberGUI.reset();
		mainLayout.show(contentPane, "member");
	}
	public static void switchToMemberList(){
		memberListGUI.reset();
		memberListGUI.update();
		mainLayout.show(contentPane,"memberlist");
	}
	public static void switchToMember(Boolean forEdit) {
		memberGUI.reset();
		memberGUI.setForEdit(forEdit);
		mainLayout.show(contentPane, "member");
	}
	
	public static void switchToStaff() {
		staffGUI.reset();
		mainLayout.show(contentPane, "staff");
	}
	
	public static void switchToStaff(Boolean forEdit) {
		staffGUI.reset();
		staffGUI.setForEdit(forEdit);
		mainLayout.show(contentPane, "staff");
	}
	
	public static void switchToStaffList() {
		staffListGUI.reset();
		staffListGUI.update();
		mainLayout.show(contentPane, "stafflist");
	}
	
	public static void switchToRate() {
		rateGUI.reset();
		mainLayout.show(contentPane, "rate");
	}
	
	public static void switchToRate(boolean forEdit){
		rateGUI.reset();
		rateGUI.setForEdit(forEdit);
		mainLayout.show(contentPane, "rate");
	}
	
	public static void switchToRateList(){
		mainLayout.show(contentPane, "ratelist");
		rateListGUI.reset();
		rateListGUI.update();
	}
	
	public static void switchToRentals() {
		rentalsGUI.reset();
		mainLayout.show(contentPane, "rentals");
	}
	
	public static void switchToRentalsMember() {
		rentalsGUI.reset();
		rentalsGUI.setForReturn(false);
		mainLayout.show(contentPane, "rentalsmember");
	}
	
	public static void switchToRentalsMember(Boolean forReturn) {
		rentalsGUI.reset();
		rentalsGUI.setForReturn(forReturn);
		mainLayout.show(contentPane, "rentalsmember");
	}
	
	public static void switchToRentalsProduct() {
		rentalsGUI.reset();
		rentalsGUI.resetBooks();
		rentalsGUI.updateBooks();
		mainLayout.show(contentPane, "rentalsproduct");
		
	}
	
	public static void switchToRentalsMeeting() {
		rentalsGUI.reset();
		mainLayout.show(contentPane, "rentalsmeeting");
	}
	
	public static void switchToReservations() {
		reservationsGUI.reset();
		mainLayout.show(contentPane, "reservations");
	}
	
	public static void switchToReservations(boolean forEdit) {
		reservationsGUI.reset();
		reservationsGUI.setForEdit(forEdit);
		mainLayout.show(contentPane, "reservations");
	}
	
	public static void switchToReservationsProduct() {
		reservationsGUI.reset();
		mainLayout.show(contentPane, "reservationsproduct");
		
	}
	
	public static void switchToReservationList() {
		reservationListGUI.reset();
		reservationListGUI.update();
		mainLayout.show(contentPane, "reservationlist");
	}
	
	public static void switchToFines(){
		fineGUI.reset();
		fineGUI.update();
		mainLayout.show(contentPane, "fines");
	}
	
	public static void switchToStatistics(){
		mainLayout.show(contentPane, "statistics");
	}
	
	public static void switchToStatisticsTopTen(){
		mainLayout.show(contentPane, "topten");
	}
	
	public static void switchToStatisticsTopMembers(){
		mainLayout.show(contentPane, "members");
	}
	
	public static void switchToRentStatistics(){
		mainLayout.show(contentPane, "rent");
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainGUI test = new MainGUI();
	}

	

}
