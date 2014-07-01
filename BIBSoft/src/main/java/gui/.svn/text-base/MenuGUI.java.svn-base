package gui;

import static gui.LoginGUI.*;

import javax.swing.*;

import dao.StaffDAO;

import java.awt.*;
import java.awt.event.*;

import logic.Staff;

public class MenuGUI{
	private JPanel contentPane = new JPanel();
	private SpringLayout menuLayout = new SpringLayout();
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog menuDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;
	private JLabel membersLabel = new JLabel("Members"), booksLabel = new JLabel("Products"),rentalsLabel = new JLabel("Rentals"), reservationsLabel = new JLabel("Reservations"),
			finesLabel = new JLabel("Fines"), staffLabel = new JLabel("Staff"), statisticsLabel = new JLabel("Statistics"), welcomeLabel = new JLabel();
	private JButton backButton = new JButton("Log out"), memberAddButton = new JButton("Add member"), memberListButton = new JButton("Member list"), 
			bookAddButton = new JButton("Add book"), bookListButton = new JButton("Book list"), mediaAddButton = new JButton("Add media"), mediaListButton = new JButton("Media list"),
			meetingRoomAddButton = new JButton("Add meeting room"), meetingRoomListButton = new JButton("Meeting room list"),
			rentalAddButton = new JButton("Add rental"), rentalRemoveButton = new JButton("End rental"), rateAddButton = new JButton("Add rate"), 
			rateListButton = new JButton("Rate list"), reservationAddButton = new JButton("Add reservation"), reservationListButton = new JButton("Reservation list"),
			fineListButton = new JButton("Fine list"), staffAddButton = new JButton("Add staff"), staffListButton = new JButton("Staff list"),
			statisticListButton = new JButton("Statistic list"), chooseExcelButton = new JButton("Choose Excel");

	
	public MenuGUI() {
		//Get size of screen without taskbar
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(menuDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;
		
		//Fill container
		contentPane.setLayout(menuLayout);
		contentPane.add(backButton);
		contentPane.add(welcomeLabel);
		contentPane.add(membersLabel);
		contentPane.add(memberAddButton);
		contentPane.add(memberListButton);
		contentPane.add(booksLabel);
		contentPane.add(bookAddButton);
		contentPane.add(bookListButton);
		contentPane.add(mediaAddButton);
		contentPane.add(mediaListButton);
		contentPane.add(meetingRoomAddButton);
		contentPane.add(meetingRoomListButton);
		contentPane.add(rentalsLabel);
		contentPane.add(rentalAddButton);
		contentPane.add(rentalRemoveButton);
		contentPane.add(rateAddButton);
		contentPane.add(rateListButton);
		contentPane.add(reservationsLabel);
		contentPane.add(reservationAddButton);
		contentPane.add(reservationListButton);
		contentPane.add(finesLabel);
		contentPane.add(fineListButton);
		contentPane.add(staffLabel);
		contentPane.add(staffAddButton);
		contentPane.add(staffListButton);
		contentPane.add(statisticsLabel);
		contentPane.add(statisticListButton);
		contentPane.add(chooseExcelButton);
		
		//Placement of components on screen
		menuLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, welcomeLabel, (int)(screenWidth * 0.45), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, welcomeLabel, (int)(screenHeight * 0.05), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, staffLabel, (int)(screenWidth * 0.3), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, staffLabel, (int)(screenHeight * 0.15), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, staffAddButton, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, staffAddButton, (int)(screenHeight * 0.15), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, staffListButton, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, staffListButton, (int)(screenHeight * 0.2), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, membersLabel, (int)(screenWidth * 0.3), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, membersLabel, (int)(screenHeight * 0.3), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, memberAddButton, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, memberAddButton, (int)(screenHeight * 0.3), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, memberListButton, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, memberListButton, (int)(screenHeight * 0.35), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, booksLabel, (int)(screenWidth * 0.3), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, booksLabel, (int)(screenHeight * 0.45), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, bookAddButton, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, bookAddButton, (int)(screenHeight * 0.45), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, bookListButton, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, bookListButton, (int)(screenHeight * 0.5), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, mediaAddButton, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, mediaAddButton, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, mediaListButton, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, mediaListButton, (int)(screenHeight * 0.6), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, meetingRoomAddButton, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, meetingRoomAddButton, (int)(screenHeight * 0.65), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, meetingRoomListButton, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, meetingRoomListButton, (int)(screenHeight * 0.7), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, chooseExcelButton, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, chooseExcelButton, (int)(screenHeight * 0.75), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, rentalsLabel, (int)(screenWidth * 0.5), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, rentalsLabel, (int)(screenHeight * 0.15), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, rentalAddButton, (int)(screenWidth * 0.55), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, rentalAddButton, (int)(screenHeight * 0.15), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, rentalRemoveButton, (int)(screenWidth * 0.55), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, rentalRemoveButton, (int)(screenHeight * 0.2), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, rateAddButton, (int)(screenWidth * 0.55), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, rateAddButton, (int)(screenHeight * 0.25), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, rateListButton, (int)(screenWidth * 0.55), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, rateListButton, (int)(screenHeight * 0.3), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, reservationsLabel, (int)(screenWidth * 0.5), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, reservationsLabel, (int)(screenHeight * 0.4), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, reservationAddButton, (int)(screenWidth * 0.55), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, reservationAddButton, (int)(screenHeight * 0.4), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, reservationListButton, (int)(screenWidth * 0.55), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, reservationListButton, (int)(screenHeight * 0.45), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, finesLabel, (int)(screenWidth * 0.5), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, finesLabel, (int)(screenHeight * 0.55) , SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, fineListButton, (int)(screenWidth * 0.55), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, fineListButton, (int)(screenHeight * 0.6), SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, statisticsLabel, (int)(screenWidth * 0.5), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, statisticsLabel, (int)(screenHeight * 0.7) , SpringLayout.NORTH, contentPane);
		
		menuLayout.putConstraint(SpringLayout.WEST, statisticListButton, (int)(screenWidth * 0.55), SpringLayout.WEST, contentPane);
		menuLayout.putConstraint(SpringLayout.NORTH, statisticListButton, (int)(screenHeight * 0.7), SpringLayout.NORTH, contentPane);
		
		
		//Add ActionListeners
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if(StaffDAO.getAll().size()==0)
				{
					MainGUI.switchToStaff();
					StaffGUI.setBackButton();
					StaffGUI.setFunctionBox();
				}
				else
				{
				MainGUI.switchToLogin();
				}
			}
			
		});
		
		memberAddButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToMember();
			}
		});
		
		memberListButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToMemberList();
			}
		});
		
		bookAddButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToBookCheck();
			}
		});
		
		bookListButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToBookList();
			}
		});
		
		mediaAddButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToMediaCheck();
			}
		});
		
		mediaListButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToMediaList();
			}
		});
		
		meetingRoomAddButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToMeetingRoom();
			}
		});
		
		meetingRoomListButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToMeetingRoomList();
			}
		});
		
		staffAddButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToStaff();
			}
		});
		
		staffListButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToStaffList();
			}
		});
		
		rentalAddButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToRentalsMember();
			}
		});
		
		rentalRemoveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToRentalsMember(true);
			}
		});
		
		rateAddButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToRate();
			}
		});
		
		rateListButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToRateList();
			}
		});
		
		reservationAddButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToReservations();
			}
		});
		
		reservationListButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToReservationList();
			}
		});	
		
		fineListButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToFines();
			}
		});
		
		statisticListButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI.switchToStatistics();
			}
		});
		
		chooseExcelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
			     @SuppressWarnings("unused")
				ChooseExcelGUI excel = new ChooseExcelGUI();
					 
		
			}
		});
	
		
	}
		
	
	public void checkUser() {
		
		if(activeUser == activeLibrarian) {
			staffLabel.setVisible(false);
			staffAddButton.setVisible(false);
			staffListButton.setVisible(false);
			statisticsLabel.setVisible(false);
		}
		else if(activeUser == activeManager) {
			membersLabel.setVisible(false);
			memberAddButton.setVisible(false);
			memberListButton.setVisible(false);
			booksLabel.setVisible(false);
			bookAddButton.setVisible(false);
			bookListButton.setVisible(false);
			mediaAddButton.setVisible(false);
			mediaListButton.setVisible(false);
			rentalsLabel.setVisible(false);
			reservationsLabel.setVisible(false);
			rateAddButton.setVisible(false);
			finesLabel.setVisible(false);
			staffLabel.setVisible(false);
			staffAddButton.setVisible(false);
			staffListButton.setVisible(false);
		}
	}

	
	public void setWelcome(Staff staff) {
		welcomeLabel.setText("Welcome, " + staff.getSurname() + "!");
	}
	
	public void reset() {
		membersLabel.setVisible(true);
		memberAddButton.setVisible(true);
		memberListButton.setVisible(true);
		booksLabel.setVisible(true);
		bookAddButton.setVisible(true);
		bookListButton.setVisible(true);
		rentalsLabel.setVisible(true);
		reservationsLabel.setVisible(true);
		rateAddButton.setVisible(true);
		finesLabel.setVisible(true);
		statisticsLabel.setVisible(true);
		staffLabel.setVisible(true);
		staffAddButton.setVisible(true);
		staffListButton.setVisible(true);
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
}
