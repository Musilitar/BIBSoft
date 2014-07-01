package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import static dao.BookCopyDAO.searchBookByAuthor;
import static dao.BookCopyDAO.searchBookByGenre;
import static dao.BookCopyDAO.searchBookByISBN;
import static dao.BookCopyDAO.searchBookByTitle;
import static gui.LoginGUI.*;
import dao.BookCopyDAO;
import dao.BookDAO;
import dao.MediaCopyDAO;
import dao.MediaDAO;
import dao.MeetingRoomDAO;
import dao.MemberDAO;
import dao.RentTransactionDAO;
import dao.ReservationDAO;
import dao.StringDateSwitcher;
import logic.*;

public class RentalsGUI {
	private JPanel contentPane = new JPanel(), contentPaneMember = new JPanel(), contentPaneProduct = new JPanel(), contentPaneMeeting = new JPanel();
	private SpringLayout rentalsLayout = new SpringLayout(), memberLayout = new SpringLayout(), productLayout = new SpringLayout(), meetingLayout = new SpringLayout();
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog staffDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;
	private JLabel memberIDLabel = new JLabel("Member ID:"), memberIDLabel2 = new JLabel("Member ID:"), dateOutLabel = new JLabel("Date out:"), 
			dateInLabel = new JLabel("Date in: "), closedLabel = new JLabel("Closed: "), staffIDLabel = new JLabel("Staff ID:"),
			meetingDateOutLabel = new JLabel("Date out: "), meetingDateInLabel = new JLabel("Date in: ");
	private JTextField memberIDField = new JTextField(), memberIDField2 = new JTextField(), dateOutField = new JTextField(), dateInField = new JTextField(), 
			closedField = new JTextField(), staffIDField = new JTextField(), meetingDateOutField = new JTextField(), meetingDateInField = new JTextField();
	private JRadioButton bookButton = new JRadioButton("Book"), mediaButton = new JRadioButton("Media"), roomButton = new JRadioButton("Room");
	private ButtonGroup typeGroup = new ButtonGroup();
	private JButton rentalsButton = new JButton("Rent"), chooseButton = new JButton("Choose"), 
			useButton = new JButton("Use"), finishedButton = new JButton("Finished"), meetingRentButton = new JButton("Rent");
	private JButton backButton = new JButton("Back"), backButton2 = new JButton("Back"), backButton3 = new JButton("Back");
	private JTextArea listField = new JTextArea(25, 80), chosenField = new JTextArea(25, 11);
	private JScrollPane listScrollPane = new JScrollPane(listField);
	private JTextField searchField = new JTextField(20);
	private JLabel searchLabel = new JLabel("Search:");
	private String[] patternMedia = {" Title"," Genre"," Creator"," ID"};
	private String[] patternBooks = {" Title"," Genre"," Author"," ISBN"};
	private String[] patternRooms = {" ID", " Name"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox rentBox = new JComboBox(patternBooks);
	private String a = " Title";
	
	private Member chosenMember;
	private String typeOfRental = "book";
	private Calendar calendar = Calendar.getInstance();
	private String selectedLine, bookResults, mediaResults, meetingRoomResults, chosenProducts = "";
	private ArrayList<BookCopy> bookCopyList = new ArrayList<BookCopy>(), chosenBooksList = new ArrayList<BookCopy>();
	private ArrayList<MediaCopy> mediaCopyList = new ArrayList<MediaCopy>(), chosenMediaList = new ArrayList<MediaCopy>();
	private ArrayList<MeetingRoom> meetingRoomList = new ArrayList<MeetingRoom>(), chosenMeetingRoomList = new ArrayList<MeetingRoom>();
	private RentTransaction rentrans;
	private Boolean forReturn = false, canRentRoom = true;
	private ArrayList<RentTransaction> rentTransactions = new ArrayList<RentTransaction>();
	private Color selectionColor = new Color(96, 158, 240);
	private int currentRentTransID = 0;
	private int currentRoomID = 0;
	
	//Moet nog vervangen worden door algemene librarian
	private Login login = new Login("1", "1");
	private Librarian librarian = new Librarian("1", "1", "1", login);

	public RentalsGUI() {
		//Get size of screen without taskbar
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(staffDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;
		
		//Fill container
		contentPaneMember.setLayout(memberLayout);
		contentPaneMember.add(memberIDLabel2);
		contentPaneMember.add(memberIDField2);
		contentPaneMember.add(chooseButton);
		contentPaneMember.add(backButton2);
		contentPaneProduct.setLayout(productLayout);
		contentPaneProduct.add(backButton3);
		contentPaneProduct.add(bookButton);
		contentPaneProduct.add(mediaButton);
		contentPaneProduct.add(roomButton);
		contentPaneProduct.add(listScrollPane);
		contentPaneProduct.add(searchLabel);
		contentPaneProduct.add(searchField);
		contentPaneProduct.add(rentBox);
		contentPaneProduct.add(useButton);
		contentPaneProduct.add(chosenField);
		contentPaneProduct.add(finishedButton);
		contentPane.setLayout(rentalsLayout);
		contentPane.add(backButton);
		contentPane.add(memberIDLabel);
		contentPane.add(memberIDField);
		contentPane.add(dateOutLabel);
		contentPane.add(dateOutField);
		contentPane.add(dateInLabel);
		contentPane.add(dateInField);
		contentPane.add(closedLabel);
		contentPane.add(closedField);
		contentPane.add(staffIDLabel);
		contentPane.add(staffIDField);
		contentPane.add(rentalsButton);
		contentPaneMeeting.setLayout(meetingLayout);
		contentPaneMeeting.add(meetingDateOutLabel);
		contentPaneMeeting.add(meetingDateOutField);
		contentPaneMeeting.add(meetingDateInLabel);
		contentPaneMeeting.add(meetingDateInField);
		contentPaneMeeting.add(meetingRentButton);
		
		//Prepare frame components
		bookButton.setSelected(true);
		typeGroup.add(bookButton);
		typeGroup.add(mediaButton);
		typeGroup.add(roomButton);
		
		listField.setEditable(false);
		listField.setSelectionColor(selectionColor);
		listField.setBorder(BorderFactory.createEmptyBorder());
		chosenField.setEditable(false);
		
		memberIDField.setColumns(20);
		memberIDField2.setColumns(20);
		dateInField.setColumns(20);
		dateOutField.setColumns(20);
		closedField.setColumns(20);
		staffIDField.setColumns(20);
		meetingDateOutField.setColumns(20);
		meetingDateInField.setColumns(20);
		
		//Placement of components on screen
		//Choosing member portion
		memberLayout.putConstraint(SpringLayout.WEST, memberIDLabel2, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPaneMember);
		memberLayout.putConstraint(SpringLayout.NORTH, memberIDLabel2, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPaneMember);
		
		memberLayout.putConstraint(SpringLayout.WEST, memberIDField2, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPaneMember);
		memberLayout.putConstraint(SpringLayout.NORTH, memberIDField2, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPaneMember);
		
		memberLayout.putConstraint(SpringLayout.WEST, chooseButton, (int)(screenWidth * 0.63), SpringLayout.WEST, contentPaneMember);
		memberLayout.putConstraint(SpringLayout.NORTH, chooseButton, (int)(screenHeight * 0.365), SpringLayout.NORTH, contentPaneMember);
		
		memberLayout.putConstraint(SpringLayout.WEST, backButton2, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPaneMember);
		memberLayout.putConstraint(SpringLayout.NORTH, backButton2, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPaneMember);
		
		//Choosing products portion
		productLayout.putConstraint(SpringLayout.WEST, backButton3, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPaneMember);
		productLayout.putConstraint(SpringLayout.NORTH, backButton3, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPaneMember);
		
		productLayout.putConstraint(SpringLayout.WEST, bookButton, (int)(screenWidth * 0.40), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, bookButton, (int)(screenHeight * 0.10), SpringLayout.NORTH, contentPaneProduct);
		
		productLayout.putConstraint(SpringLayout.WEST, mediaButton, (int)(screenWidth * 0.45), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, mediaButton, (int)(screenHeight * 0.10), SpringLayout.NORTH, contentPaneProduct);
		
		productLayout.putConstraint(SpringLayout.WEST, roomButton, (int)(screenWidth * 0.5), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, roomButton, (int)(screenHeight * 0.10), SpringLayout.NORTH, contentPaneProduct);
		
		productLayout.putConstraint(SpringLayout.WEST, listScrollPane, (int)(screenWidth * 0.15), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, listScrollPane, (int)(screenHeight * 0.25), SpringLayout.NORTH, contentPaneProduct);
		
		productLayout.putConstraint(SpringLayout.WEST, searchLabel, (int)(screenWidth * 0.4), SpringLayout.WEST, contentPane);
		productLayout.putConstraint(SpringLayout.NORTH, searchLabel, (int)(screenHeight * 0.21), SpringLayout.NORTH, contentPane);
		
		productLayout.putConstraint(SpringLayout.WEST, searchField, (int)(screenWidth * 0.43), SpringLayout.WEST, contentPane);
		productLayout.putConstraint(SpringLayout.NORTH, searchField, (int)(screenHeight * 0.21), SpringLayout.NORTH, contentPane);
		
		productLayout.putConstraint(SpringLayout.WEST, rentBox, (int)(screenWidth * 0.58), SpringLayout.WEST, contentPane);
		productLayout.putConstraint(SpringLayout.NORTH, rentBox, (int)(screenHeight * 0.21), SpringLayout.NORTH, contentPane);
		
		productLayout.putConstraint(SpringLayout.WEST, useButton, (int)(screenWidth * 0.81), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, useButton, (int)(screenHeight * 0.25), SpringLayout.NORTH, contentPaneProduct);
		
		productLayout.putConstraint(SpringLayout.WEST, chosenField, (int)(screenWidth * 0.72), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, chosenField, (int)(screenHeight * 0.25), SpringLayout.NORTH, contentPaneProduct);
		
		productLayout.putConstraint(SpringLayout.WEST, finishedButton, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, finishedButton, (int)(screenHeight * 0.8), SpringLayout.NORTH, contentPaneProduct);
		
		//Complete transaction portion
		rentalsLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
		
		rentalsLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
		
		rentalsLayout.putConstraint(SpringLayout.WEST, memberIDLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, memberIDLabel, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
		
		rentalsLayout.putConstraint(SpringLayout.WEST, memberIDField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, memberIDField, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
		
		rentalsLayout.putConstraint(SpringLayout.WEST, dateOutLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, dateOutLabel, (int)(screenHeight * 0.43), SpringLayout.NORTH, contentPane);
		
		rentalsLayout.putConstraint(SpringLayout.WEST, dateOutField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, dateOutField, (int)(screenHeight * 0.43), SpringLayout.NORTH, contentPane);
		
		rentalsLayout.putConstraint(SpringLayout.WEST, dateInLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, dateInLabel, (int)(screenHeight * 0.49), SpringLayout.NORTH, contentPane);
		
		rentalsLayout.putConstraint(SpringLayout.WEST, dateInField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, dateInField, (int)(screenHeight * 0.49), SpringLayout.NORTH, contentPane);
		
		rentalsLayout.putConstraint(SpringLayout.WEST, closedLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, closedLabel, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
		
		rentalsLayout.putConstraint(SpringLayout.WEST, closedField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, closedField, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
		
		rentalsLayout.putConstraint(SpringLayout.WEST, staffIDLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, staffIDLabel, (int)(screenHeight * 0.61), SpringLayout.NORTH, contentPane);
		
		rentalsLayout.putConstraint(SpringLayout.WEST, staffIDField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, staffIDField, (int)(screenHeight * 0.61), SpringLayout.NORTH, contentPane);
			
		rentalsLayout.putConstraint(SpringLayout.WEST, rentalsButton, (int)(screenWidth * 0.50), SpringLayout.WEST, contentPane);
		rentalsLayout.putConstraint(SpringLayout.NORTH, rentalsButton, (int)(screenHeight * 0.70) , SpringLayout.NORTH, contentPane);
		
		//Meeting room portion
		meetingLayout.putConstraint(SpringLayout.WEST, meetingDateOutLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		meetingLayout.putConstraint(SpringLayout.NORTH, meetingDateOutLabel, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
		
		meetingLayout.putConstraint(SpringLayout.WEST, meetingDateOutField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		meetingLayout.putConstraint(SpringLayout.NORTH, meetingDateOutField, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
		
		meetingLayout.putConstraint(SpringLayout.WEST, meetingDateInLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		meetingLayout.putConstraint(SpringLayout.NORTH, meetingDateInLabel, (int)(screenHeight * 0.43), SpringLayout.NORTH, contentPane);
		
		meetingLayout.putConstraint(SpringLayout.WEST, meetingDateInField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		meetingLayout.putConstraint(SpringLayout.NORTH, meetingDateInField, (int)(screenHeight * 0.43), SpringLayout.NORTH, contentPane);
		
		meetingLayout.putConstraint(SpringLayout.WEST, meetingRentButton, (int)(screenWidth * 0.53), SpringLayout.WEST, contentPane);
		meetingLayout.putConstraint(SpringLayout.NORTH, meetingRentButton, (int)(screenHeight * 0.48), SpringLayout.NORTH, contentPane);
		
		//Backbuttons
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if(forReturn == true) {
					MainGUI.switchToRentalsProduct();
					forReturn = true;
				}
				MainGUI.switchToRentalsProduct();
			}
		});
		
		backButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				MainGUI.switchToMenu();
			}
		});
		
		backButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if(forReturn == true) {
					MainGUI.switchToRentalsMember();
					forReturn = true;
				}
				MainGUI.switchToRentalsMember();
			}
		});
		
		//Chooses member
		chooseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chosenMember = MemberDAO.getMemberByID(Integer.valueOf(memberIDField2.getText()));
				if(chosenMember == null) {
					JOptionPane.showMessageDialog(contentPane, "No member found with that ID", "Not found", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					if(forReturn == true) {
						rentTransactions = librarian.getTransactionByMemberId(chosenMember.getLidID());
						searchLabel.setVisible(false);
						searchField.setVisible(false);
						rentBox.setVisible(false);
						
						if(rentTransactions.isEmpty()) {
							JOptionPane.showMessageDialog(contentPane, "This member has no open rentals", "Not found", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							MainGUI.switchToRentalsProduct();
							bookButton.setVisible(false);
							mediaButton.setVisible(false);
							roomButton.setVisible(false);
							useButton.setText("Return");
							String results = "";
							for(RentTransaction rt : rentTransactions) {
								if(rt.getBookList().isEmpty() == false) {
									for(BookCopy bc : rt.getBookList()) {
										results += " ID: " + bc.getCopyId() + " || Title: " + bc.getTitle() + " || Author: " + bc.getAuthor() + " || Genre: " + bc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(bc.getYearEdition()) + " || Publisher: " + bc.getPublisher()
												+ " || Place of Publication: " + bc.getPublicationPlace() + " || ISBN: " + bc.getISBN() + " || Type: Book" + System.lineSeparator();
									}
								}
								if(rt.getMediaList().isEmpty() == false) {
									for(MediaCopy mc : rt.getMediaList()) {
										results += " ID: " + mc.getMediaCopyID() + " || Title: " + mc.getTitle() + " || Artist/Director: " + mc.getCreator() + " || Genre: " + mc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(mc.getYearEdition()) + " || Producer: " + mc.getProducer()
												+ " || Place of Publication: " + mc.getPublicationPlace() + " || Type: " + mc.getType() + System.lineSeparator();
									}
								}
								if(rt.getMeetingRoomList().isEmpty() == false) {
									for(MeetingRoom m : rt.getMeetingRoomList()) {
										System.out.println(m.getRoomID());
										results += " ID: " + m.getRoomID() + " || Floor: " + m.getFloor() + " || Amount of seats: " + m.getSeatsAmount()
												+ " || Name: " + m.getName() + System.lineSeparator();
									}
								}
							}
							listField.setText(results);
						}
					}
					else {
						MainGUI.switchToRentalsProduct();
					}
				}
			}
		});
		
		rentalsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(forReturn == true) {
					ArrayList<Book> foundBooks = new ArrayList<Book>();
					ArrayList<Media> foundMedia = new ArrayList<Media>();
					ArrayList<MeetingRoom> foundMeetingRooms = new ArrayList<MeetingRoom>();
					
					for(BookCopy bc : chosenBooksList) {
						BookCopyDAO.changeLendability(bc, true);
						foundBooks = ReservationDAO.checkBookReservation(chosenBooksList);
					}
					for(Book b : foundBooks) {
						JOptionPane.showMessageDialog(contentPane, "Reservation fullfiled for product " + b.getBookID() + " " + b.getClass().getSimpleName(), "Notice", JOptionPane.INFORMATION_MESSAGE);
					}
					
					for(MediaCopy mc : chosenMediaList) {
						MediaCopyDAO.changeLendability(mc, true);
						foundMedia = ReservationDAO.checkMediaReservation(chosenMediaList);
					}
					for(Media m : foundMedia) {
						JOptionPane.showMessageDialog(contentPane, "Reservation fullfiled for product " + m.getMediaID() + " " + m.getClass().getSimpleName(), "Notice", JOptionPane.INFORMATION_MESSAGE);
					}
					
					foundMeetingRooms = ReservationDAO.checkMeetingRoomReservation(chosenMeetingRoomList);

					for(MeetingRoom mr : foundMeetingRooms) {
						JOptionPane.showMessageDialog(contentPane, "Reservation fullfiled for product " + mr.getRoomID() + " " + mr.getClass().getSimpleName(), "Notice", JOptionPane.INFORMATION_MESSAGE);
					}
					
					if(closedField.getText().equals("Yes")) {
						RentTransactionDAO.changeClosed(currentRentTransID, 1, StringDateSwitcher.datetoString(calendar.getTime()));
					}
					forReturn = false;
					JOptionPane.showMessageDialog(contentPane, "Products returned!", "Success", JOptionPane.INFORMATION_MESSAGE);
					MainGUI.switchToMenu();
					chosenBooksList.clear();
					chosenMediaList.clear();
					chosenMeetingRoomList.clear();
				}
				else {
					RentTransactionDAO.saveRentTransaction(rentrans);
					for(BookCopy bc : rentrans.getBookList()) {
						BookCopyDAO.changeLendability(bc, false);
					}
					for(MediaCopy mc : rentrans.getMediaList()) {
						MediaCopyDAO.changeLendability(mc, false);
					}
				
					if(rentrans.getMeetingRoomList().isEmpty() == false) {
						MainGUI.switchToRentalsMeeting();
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Products rented!", "Success", JOptionPane.INFORMATION_MESSAGE);
						chosenMeetingRoomList.clear();
						MainGUI.switchToMenu();
					}
				}
				chosenBooksList.clear();
				chosenMediaList.clear();
			}
			
		});
		
		meetingRentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(RentTransactionDAO.checkDate(currentRoomID, meetingDateOutField.getText(), meetingDateInField.getText()) == false) {
					RentTransactionDAO.changeDate(rentrans.getRentTransId(), meetingDateOutField.getText(), meetingDateInField.getText());
					JOptionPane.showMessageDialog(contentPane, "Products rented!", "Success", JOptionPane.INFORMATION_MESSAGE);
					chosenMeetingRoomList.clear();
					MainGUI.switchToMenu();
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Room already booked at this date", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}

		});
		
		//Actionlisteners voor radiobuttons
		bookButton.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void actionPerformed(ActionEvent e) {
				typeOfRental = "book";
				if(typeOfRental.equals("book")) {
					resetBooks();
					updateBooks();
					rentBox.setModel(new JComboBox(patternBooks).getModel());
					a = " Title";
					searchField.setText("");
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No type selected", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		mediaButton.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void actionPerformed(ActionEvent e) {
				typeOfRental = "media";
				if(typeOfRental.equals("media")) {
					resetMedia();
					updateMedia();
					rentBox.setModel(new JComboBox(patternMedia).getModel());
					a = " Title";
					searchField.setText("");
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No type selected", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		roomButton.addActionListener(new ActionListener() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void actionPerformed(ActionEvent e) {
				typeOfRental = "room";
				if(typeOfRental.equals("room")) {
					resetMeetingRooms();
					updateMeetingRooms();
					rentBox.setModel(new JComboBox(patternRooms).getModel());
					a = " ID";
					searchField.setText("");
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No type selected", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		listField.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int offset = listField.viewToModel(e.getPoint());
					int rowStart = Utilities.getRowStart(listField, offset);
					int rowEnd = Utilities.getRowEnd(listField, offset);
					listField.setSelectionStart(rowStart);
					listField.setSelectionEnd(rowEnd);
					selectedLine = listField.getText().substring(rowStart, rowEnd);
					int end = selectedLine.indexOf("|", 5);
					selectedLine = selectedLine.substring(5, end - 1);
					System.out.println(selectedLine);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		
		useButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(forReturn == true) {
					BookCopy bookCopy = null;
					MediaCopy mediaCopy = null;
					MeetingRoom meetingRoom = null;
					for(RentTransaction rt : rentTransactions) {
						for(BookCopy bc : rt.getBookList()) {
							if(Integer.valueOf(selectedLine) == bc.getCopyId()) {
								bookCopy = bc;
							}
						}
						if(bookCopy != null) {
							chosenBooksList.add(bookCopy);
							chosenProducts += "ID: " + bookCopy.getCopyId() + " || " + bookCopy.getClass().getSimpleName() + System.lineSeparator();
							chosenField.setText(chosenProducts);
						}
						for(MediaCopy mc : rt.getMediaList()) {
							if(Integer.valueOf(selectedLine) == mc.getMediaCopyID()) {
								mediaCopy = mc;
							}
						}
						if(mediaCopy != null) {
							chosenMediaList.add(mediaCopy);
							chosenProducts += "ID: " + mediaCopy.getMediaCopyID() + " || " + mediaCopy.getClass().getSimpleName() + System.lineSeparator();
							chosenField.setText(chosenProducts);
						}
						for(MeetingRoom mr : rt.getMeetingRoomList()) {
							if(Integer.valueOf(selectedLine) == mr.getRoomID()) {
								meetingRoom = mr;
							}
						}
						if(meetingRoom != null) {
							chosenMeetingRoomList.add(meetingRoom);
							chosenProducts += "ID: " + meetingRoom.getRoomID() + " || " + meetingRoom.getClass().getSimpleName() + System.lineSeparator();
							chosenField.setText(chosenProducts);
						}
					}
				}
				else {
					if(typeOfRental.equals("book")) {
						BookCopy bookCopy = null;
						for(BookCopy bc : bookCopyList) {
							if(Integer.valueOf(selectedLine) == bc.getCopyId()) {
								bookCopy = bc;
							}
						}
						canRentRoom = false;
						if(bookCopy != null && canRentRoom == false) {
							chosenBooksList.add(bookCopy);
							chosenProducts += "ID: " + bookCopy.getCopyId() + " || " + bookCopy.getClass().getSimpleName() + System.lineSeparator();
							chosenField.setText(chosenProducts);
						}
					}
					else if(typeOfRental.equals("media")) {
						MediaCopy mediaCopy = null;
						for(MediaCopy mc : mediaCopyList) {
							if(Integer.valueOf(selectedLine) == mc.getMediaCopyID()) {
								mediaCopy = mc;
							}
						}
						canRentRoom = false;
						if(mediaCopy != null & canRentRoom == false) {
							chosenMediaList.add(mediaCopy);
							chosenProducts += "ID: " + mediaCopy.getMediaCopyID() + " || " + mediaCopy.getClass().getSimpleName() + System.lineSeparator();
							chosenField.setText(chosenProducts);
						}
					}
					else if(typeOfRental.equals("room")) {
						MeetingRoom meetingRoom = null;
						for(MeetingRoom mr : meetingRoomList) {
							if(Integer.valueOf(selectedLine) == mr.getRoomID()) {
								meetingRoom = mr;
							}
						}
						if(meetingRoom != null && chosenMeetingRoomList.size() <= 0 && canRentRoom == true) {
							currentRoomID = meetingRoom.getRoomID();
							chosenMeetingRoomList.add(meetingRoom);
							chosenProducts += "ID: " + meetingRoom.getRoomID() + " || " + meetingRoom.getClass().getSimpleName() + System.lineSeparator();
							chosenField.setText(chosenProducts);
						}
						else if(canRentRoom == false) {
							JOptionPane.showMessageDialog(contentPane, "Can not rent room along with other products", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "Can only rent 1 meeting room at a time", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "Product does not exist", "Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		finishedButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(forReturn == true) {
					for(RentTransaction rt : rentTransactions) {
						MainGUI.switchToRentals();
						memberIDField.setText(String.valueOf(chosenMember.getLidID()));
						dateOutLabel.setText("Date loaned: ");
						dateOutField.setText(rt.getDateOut());
						dateInLabel.setText("Date returning: ");
						dateInField.setText(StringDateSwitcher.datetoString(calendar.getTime()));
						staffIDField.setText(rt.getStaffId());
						rentalsButton.setText("End");

						memberIDField.setEditable(false);
						dateOutField.setEditable(false);
						dateInField.setEditable(false);
						closedField.setEditable(true);
						staffIDField.setEditable(false);
						
						Fine fine = librarian.checkFine(rt);
						if(fine != null) {
							if(activeUser == activeLibrarian){
								activeLibrarian.saveFine(fine);
							}else{
								activeAdmin.saveFine(fine);
							}
							JOptionPane.showMessageDialog(contentPane, "Products are overdue, fine amount: " + fine.getFineAmount(), "Error", JOptionPane.INFORMATION_MESSAGE);
						}
					
						currentRentTransID = rt.getRentTransId();
					}
				}
				else {
					MainGUI.switchToRentals();
					memberIDField.setText(String.valueOf(chosenMember.getLidID()));
					dateOutField.setText(StringDateSwitcher.datetoString(calendar.getTime()));
					calendar.add(Calendar.DAY_OF_YEAR, 21);
					dateInField.setText(StringDateSwitcher.datetoString(calendar.getTime()));
					calendar = Calendar.getInstance();
					closedField.setText("No");
					staffIDField.setText(LoginGUI.activeUser.getLogin().getStaffID());

					memberIDField.setEditable(false);
					dateOutField.setEditable(false);
					dateInField.setEditable(false);
					closedField.setEditable(false);
					staffIDField.setEditable(false);

					rentrans = new RentTransaction(false, chosenBooksList, chosenMediaList, chosenMeetingRoomList, chosenMember.getLidID(), 
							dateOutField.getText(), dateInField.getText(), LoginGUI.activeUser.getLogin().getStaffID());
				}
			}
		});
		
		searchField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				resetBooks();
				resetMedia();
				resetMeetingRooms();
				String text = searchField.getText();
				
				if(typeOfRental.equals("media")) {
					if(a==" Title")
					{
						if(listField.getText().equals("")) {
							mediaCopyList = MediaCopyDAO.searchMediaByTitle(text);
							for(MediaCopy mc : mediaCopyList) {
								mediaResults += " ID: " + mc.getMediaCopyID() + " || Media ID: " + mc.getMediaID() + " || Title: " + mc.getTitle() + " || Artist/Director: " + mc.getCreator() + " || Genre: " + mc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(mc.getYearEdition()) + " || Producer: " + mc.getProducer()
										+ " || Place of Publication: " + mc.getPublicationPlace() + " || Type: " + mc.getType() + " || Lendable: " + mc.getLendable() + System.lineSeparator();
							}
							listField.setText(mediaResults);
						}
					}
					if(a==" Genre")
					{
						if(listField.getText().equals("")){
							mediaCopyList = MediaCopyDAO.searchMediaByGenre(text);
							for(MediaCopy mc : mediaCopyList) {
								mediaResults += " ID: " + mc.getMediaCopyID() + " || Media ID: " + mc.getMediaID() + " || Title: " + mc.getTitle() + " || Artist/Director: " + mc.getCreator() + " || Genre: " + mc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(mc.getYearEdition()) + " || Producer: " + mc.getProducer()
										+ " || Place of Publication: " + mc.getPublicationPlace() + " || Type: " + mc.getType() + " || Lendable: " + mc.getLendable() + System.lineSeparator();
							}
							listField.setText(mediaResults);
						}
					}
					if(a==" Creator")
					{
						if(listField.getText().equals("")){
							mediaCopyList = MediaCopyDAO.searchMediaByCreator(text);
							for(MediaCopy mc : mediaCopyList) {
								mediaResults += " ID: " + mc.getMediaCopyID() + " || Media ID: " + mc.getMediaID() + " || Title: " + mc.getTitle() + " || Artist/Director: " + mc.getCreator() + " || Genre: " + mc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(mc.getYearEdition()) + " || Producer: " + mc.getProducer()
										+ " || Place of Publication: " + mc.getPublicationPlace() + " || Type: " + mc.getType() + " || Lendable: " + mc.getLendable() + System.lineSeparator();
							}
							listField.setText(mediaResults);
						}
					}
					if(a==" ID")
					{
						if(listField.getText().equals("")){
							mediaCopyList = MediaCopyDAO.searchMediaByID(text);
							for(MediaCopy mc : mediaCopyList) {
								mediaResults += " ID: " + mc.getMediaCopyID() + " || Media ID: " + mc.getMediaID() + " || Title: " + mc.getTitle() + " || Artist/Director: " + mc.getCreator() + " || Genre: " + mc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(mc.getYearEdition()) + " || Producer: " + mc.getProducer()
										+ " || Place of Publication: " + mc.getPublicationPlace() + " || Type: " + mc.getType() + " || Lendable: " + mc.getLendable() + System.lineSeparator();
							}
							listField.setText(mediaResults);
						}
					}
				}
				
				if(typeOfRental.equals("book")) {
					if(a==" Title")
					{
						if(listField.getText().equals("")){
							bookCopyList = searchBookByTitle(text);
							for(BookCopy bc : bookCopyList) {
								bookResults += " ID: " + bc.getCopyId() + " || Book ID: " + bc.getBookID() + " || Title: " + bc.getTitle() + " || Author: " + bc.getAuthor() + " || Genre: " + bc.getGenre() + " || Year: " + bc.getYearEdition() + " || Publisher: " + bc.getPublisher()
										+ " || Place of Publication: " + bc.getPublicationPlace() + " || ISBN: " + bc.getISBN() + " || Edition: " + bc.getEdition() + " || Lendable: " + bc.getLendable() + System.lineSeparator();
							}
							listField.setText(bookResults);
						}
					}
					if(a==" Genre")
					{
						if(listField.getText().equals("")){
							bookCopyList = searchBookByGenre(text);
							for(BookCopy bc : bookCopyList) {
								bookResults += " ID: " + bc.getCopyId() + " || Book ID: " + bc.getBookID() + " || Title: " + bc.getTitle() + " || Author: " + bc.getAuthor() + " || Genre: " + bc.getGenre() + " || Year: " + bc.getYearEdition() + " || Publisher: " + bc.getPublisher()
										+ " || Place of Publication: " + bc.getPublicationPlace() + " || ISBN: " + bc.getISBN() + " || Edition: " + bc.getEdition() + " || Lendable: " + bc.getLendable() + System.lineSeparator();
							}
							listField.setText(bookResults);
						}
					}
					if(a==" Author")
					{
						if(listField.getText().equals("")){
							bookCopyList = searchBookByAuthor(text);
							for(BookCopy bc : bookCopyList) {
								bookResults += " ID: " + bc.getCopyId() + " || Book ID: " + bc.getBookID() + " || Title: " + bc.getTitle() + " || Author: " + bc.getAuthor() + " || Genre: " + bc.getGenre() + " || Year: " + bc.getYearEdition() + " || Publisher: " + bc.getPublisher()
										+ " || Place of Publication: " + bc.getPublicationPlace() + " || ISBN: " + bc.getISBN() + " || Edition: " + bc.getEdition() + " || Lendable: " + bc.getLendable() + System.lineSeparator();
							}
							listField.setText(bookResults);
						}


					}
					if(a==" ISBN")
					{
						if(listField.getText().equals("")){
							bookCopyList = searchBookByISBN(text);
							for(BookCopy bc : bookCopyList) {
								bookResults += " ID: " + bc.getCopyId() + " || Book ID: " + bc.getBookID() + " || Title: " + bc.getTitle() + " || Author: " + bc.getAuthor() + " || Genre: " + bc.getGenre() + " || Year: " + bc.getYearEdition() + " || Publisher: " + bc.getPublisher()
										+ " || Place of Publication: " + bc.getPublicationPlace() + " || ISBN: " + bc.getISBN() + " || Edition: " + bc.getEdition() + " || Lendable: " + bc.getLendable() + System.lineSeparator();
							}
							listField.setText(bookResults);

						}

					}
				}
				
				if(typeOfRental.equals("room")) {
					if(a==" ID")
					{
						if(listField.getText().equals("")){
							meetingRoomList = MeetingRoomDAO.searchRoomByID(text);
							for(MeetingRoom m : meetingRoomList) {
								meetingRoomResults += " ID: " + m.getRoomID() + " || Floor: " + m.getFloor() + " || Amount of seats: " + m.getSeatsAmount()
										+ " || Name: " + m.getName() + System.lineSeparator();
							}
							listField.setText(meetingRoomResults);
						}
					}
					if(a==" Name")
					{
						if(listField.getText().equals("")){
							meetingRoomList = MeetingRoomDAO.searchRoomByName(text);
							for(MeetingRoom m : meetingRoomList) {
								meetingRoomResults += " ID: " + m.getRoomID() + " || Floor: " + m.getFloor() + " || Amount of seats: " + m.getSeatsAmount()
										+ " || Name: " + m.getName() + System.lineSeparator();
							}
							listField.setText(meetingRoomResults);
						}
					}
				}
			}
		});
		
		rentBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				JComboBox cb = (JComboBox)e.getSource();
				a = (String)cb.getSelectedItem();
			}
		});

	}
	
	public void reset() {
		memberIDField.setText("");
		memberIDField2.setText("");
		dateInField.setText("");
		dateOutField.setText("");
		closedField.setText("");
		staffIDField.setText("");
		chosenField.setText("");
		selectedLine = "";
		resetBooks();
		resetMedia();
		resetMeetingRooms();
		chosenProducts = "";
		bookButton.setVisible(true);
		mediaButton.setVisible(true);
		roomButton.setVisible(true);
		useButton.setText("Use");
		canRentRoom = true;
	}
	
	public void resetBooks() {
		bookCopyList.clear();
		bookResults = "";
		listField.setText("");
	}
	
	public void updateBooks() {
		if(listField.getText().equals("")) {
			bookCopyList = BookDAO.getAllCopies();
			for(BookCopy bc : bookCopyList) {
				if(bc.getLendable() == true) {
				bookResults += " ID: " + bc.getCopyId() + " || Title: " + bc.getTitle() + " || Author: " + bc.getAuthor() + " || Genre: " + bc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(bc.getYearEdition()) + " || Publisher: " + bc.getPublisher()
						+ " || Place of Publication: " + bc.getPublicationPlace() + " || ISBN: " + bc.getISBN() + System.lineSeparator();
				}
			}
			listField.setText(bookResults);
		}
	}
	
	public void resetMedia() {
		mediaCopyList.clear();
		mediaResults = "";
		listField.setText("");
	}
	
	public void updateMedia() {
		if(listField.getText().equals("")) {
			mediaCopyList = MediaDAO.getAllCopies();
			for(MediaCopy mc : mediaCopyList) {
				if(mc.getLendable() == true) {
				mediaResults += " ID: " + mc.getMediaCopyID() + " || Title: " + mc.getTitle() + " || Artist/Director: " + mc.getCreator() + " || Genre: " + mc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(mc.getYearEdition()) + " || Producer: " + mc.getProducer()
						+ " || Place of Publication: " + mc.getPublicationPlace() + " || Type: " + mc.getType() + System.lineSeparator();
				}
			}
			listField.setText(mediaResults);
		}
	}
	
	public void resetMeetingRooms() {
		meetingRoomList.clear();
		meetingRoomResults = "";
		listField.setText("");
	}
	
	public void updateMeetingRooms() {
		if(listField.getText().equals("")) {
			meetingRoomList = MeetingRoomDAO.getAllMeetingRooms();
			for(MeetingRoom m : meetingRoomList) {
				meetingRoomResults += " ID: " + m.getRoomID() + " || Floor: " + m.getFloor() + " || Amount of seats: " + m.getSeatsAmount()
						+ " || Name: " + m.getName() + System.lineSeparator();
			}
			listField.setText(meetingRoomResults);
		}
	}
	
	public Boolean getForReturn() {
		return forReturn;
	}

	public void setForReturn(Boolean forReturn) {
		this.forReturn = forReturn;
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
	
	public JPanel getContentPaneMember() {
		return contentPaneMember;
	}
	
	public JPanel getContentPaneProduct() {
		return contentPaneProduct;
	}
	
	public JPanel getContentPaneMeeting() {
		return contentPaneMeeting;
	}
}
