package gui;

import static gui.LoginGUI.activeLibrarian;
import static gui.LoginGUI.activeUser;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import dao.BookDAO;
import dao.MediaDAO;
import dao.MeetingRoomDAO;
import dao.MemberDAO;
import dao.ReservationDAO;
import dao.StringDateSwitcher;
import logic.*;

public class ReservationsGUI {
	private JPanel contentPane = new JPanel(), contentPaneProduct = new JPanel();
	private SpringLayout reservationsLayout = new SpringLayout(), productLayout = new SpringLayout();
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog staffDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;
	private JLabel memberIDLabel2 = new JLabel("Member ID:");
	private JTextField memberIDField = new JTextField(), memberIDField2 = new JTextField();
	private JRadioButton bookButton = new JRadioButton("Book"), mediaButton = new JRadioButton("Media"), roomButton = new JRadioButton("Room");
	private ButtonGroup typeGroup = new ButtonGroup();
	private JButton rentalsButton = new JButton("Rent"), chooseButton = new JButton("Choose"), 
			useButton = new JButton("Reserve"), finishedButton = new JButton("Finished");
	private JButton backButton2 = new JButton("Back"), backButton3 = new JButton("Back");
	private JTextArea listField = new JTextArea(25, 80), chosenField = new JTextArea(25, 11);
	private JScrollPane listScrollPane = new JScrollPane(listField);

	private Member chosenMember;
	private String typeOfRental = "book";
	private String selectedLine, bookResults, mediaResults, meetingRoomResults, chosenProducts = "";
	private ArrayList<Book> bookList = new ArrayList<Book>(), chosenBooksList = new ArrayList<Book>();
	private ArrayList<Media> mediaList = new ArrayList<Media>(), chosenMediaList = new ArrayList<Media>();
	private ArrayList<MeetingRoom> meetingRoomList = new ArrayList<MeetingRoom>(), chosenMeetingRoomList = new ArrayList<MeetingRoom>();
	private Color selectionColor = new Color(96, 158, 240);
	private Boolean forEdit;

	public ReservationsGUI() {
		//Get size of screen without taskbar
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(staffDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;

		//Fill container
		contentPane.setLayout(reservationsLayout);
		contentPane.add(memberIDLabel2);
		contentPane.add(memberIDField2);
		contentPane.add(chooseButton);
		contentPane.add(backButton2);
		contentPaneProduct.setLayout(productLayout);
		contentPaneProduct.add(backButton3);
		contentPaneProduct.add(bookButton);
		contentPaneProduct.add(mediaButton);
		contentPaneProduct.add(roomButton);
		contentPaneProduct.add(listScrollPane);
		contentPaneProduct.add(useButton);
		contentPaneProduct.add(chosenField);
		contentPaneProduct.add(finishedButton);

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
		
		chooseButton.setMnemonic(KeyEvent.VK_ENTER);
		chooseButton.setActionCommand("Choose");

		//Placement of components on screen
		//Choosing member portion
		reservationsLayout.putConstraint(SpringLayout.WEST, memberIDLabel2, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		reservationsLayout.putConstraint(SpringLayout.NORTH, memberIDLabel2, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);

		reservationsLayout.putConstraint(SpringLayout.WEST, memberIDField2, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		reservationsLayout.putConstraint(SpringLayout.NORTH, memberIDField2, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);

		reservationsLayout.putConstraint(SpringLayout.WEST, chooseButton, (int)(screenWidth * 0.63), SpringLayout.WEST, contentPane);
		reservationsLayout.putConstraint(SpringLayout.NORTH, chooseButton, (int)(screenHeight * 0.365), SpringLayout.NORTH, contentPane);

		reservationsLayout.putConstraint(SpringLayout.WEST, backButton2, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		reservationsLayout.putConstraint(SpringLayout.NORTH, backButton2, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);

		//Choosing products portion
		productLayout.putConstraint(SpringLayout.WEST, backButton3, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		productLayout.putConstraint(SpringLayout.NORTH, backButton3, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);

		productLayout.putConstraint(SpringLayout.WEST, bookButton, (int)(screenWidth * 0.40), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, bookButton, (int)(screenHeight * 0.10), SpringLayout.NORTH, contentPaneProduct);

		productLayout.putConstraint(SpringLayout.WEST, mediaButton, (int)(screenWidth * 0.45), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, mediaButton, (int)(screenHeight * 0.10), SpringLayout.NORTH, contentPaneProduct);

		productLayout.putConstraint(SpringLayout.WEST, roomButton, (int)(screenWidth * 0.5), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, roomButton, (int)(screenHeight * 0.10), SpringLayout.NORTH, contentPaneProduct);

		productLayout.putConstraint(SpringLayout.WEST, listScrollPane, (int)(screenWidth * 0.15), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, listScrollPane, (int)(screenHeight * 0.25), SpringLayout.NORTH, contentPaneProduct);

		productLayout.putConstraint(SpringLayout.WEST, useButton, (int)(screenWidth * 0.81), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, useButton, (int)(screenHeight * 0.25), SpringLayout.NORTH, contentPaneProduct);

		productLayout.putConstraint(SpringLayout.WEST, chosenField, (int)(screenWidth * 0.72), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, chosenField, (int)(screenHeight * 0.25), SpringLayout.NORTH, contentPaneProduct);

		productLayout.putConstraint(SpringLayout.WEST, finishedButton, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPaneProduct);
		productLayout.putConstraint(SpringLayout.NORTH, finishedButton, (int)(screenHeight * 0.8), SpringLayout.NORTH, contentPaneProduct);

		//Backbuttons
		backButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				MainGUI.switchToMenu();
			}
		});

		backButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				MainGUI.switchToReservations();
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
					MainGUI.switchToReservationsProduct();
					resetBooks();
					updateBooks();
				}
			}
		});

		rentalsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chosenBooksList.clear();
				chosenMediaList.clear();
				chosenMeetingRoomList.clear();
			}

		});

		//Actionlisteners voor radiobuttons
		bookButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bookButton.setSelected(true);
				typeOfRental = "book";
				if(typeOfRental.equals("book")) {
					resetBooks();
					updateBooks();
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No type selected", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		mediaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mediaButton.setSelected(true);
				typeOfRental = "media";
				if(typeOfRental.equals("media")) {
					resetMedia();
					updateMedia();
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "No type selected", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		roomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				roomButton.setSelected(true);
				typeOfRental = "room";
				if(typeOfRental.equals("room")) {
					resetMeetingRooms();
					updateMeetingRooms();
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
				if(typeOfRental.equals("book")) {
					Book book = null;
					for(Book b : bookList) {
						if(Integer.valueOf(selectedLine) == b.getBookID()) {
							book = b;
						}
					}
					if(book != null) {
						chosenBooksList.add(book);
						chosenProducts += "ID: " + book.getBookID() + " || " + book.getClass().getSimpleName() + System.lineSeparator();
						chosenField.setText(chosenProducts);
					}
				}
				else if(typeOfRental.equals("media")) {
					Media media = null;
					for(Media m : mediaList) {
						if(Integer.valueOf(selectedLine) == m.getMediaID()) {
							media = m;
						}
					}
					if(media != null) {
						chosenMediaList.add(media);
						chosenProducts += "ID: " + media.getMediaID() + " || " + media.getClass().getSimpleName() + System.lineSeparator();
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
					if(meetingRoom != null) {
						chosenMeetingRoomList.add(meetingRoom);
						chosenProducts += "ID: " + meetingRoom.getRoomID() + " || " + meetingRoom.getClass().getSimpleName() + System.lineSeparator();
						chosenField.setText(chosenProducts);
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Product does not exist", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		finishedButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Reservation reservation = null;
				for(Book b : chosenBooksList) {
					reservation = new Reservation(b.getBookID(), chosenMember.getLidID(), "boek");
					ReservationDAO.saveReservation(reservation);
				}
				for(Media m : chosenMediaList) {
					reservation = new Reservation(m.getMediaID(), chosenMember.getLidID(), m.getType());
					ReservationDAO.saveReservation(reservation);
				}
				for(MeetingRoom mr : chosenMeetingRoomList) {
					reservation = new Reservation(mr.getRoomID(), chosenMember.getLidID(), "room");
					ReservationDAO.saveReservation(reservation);
				}
				JOptionPane.showMessageDialog(contentPane, "Reservations made", "Success", JOptionPane.INFORMATION_MESSAGE);
				chosenProducts = "";
			}
		});

	}

	public void reset() {
		memberIDField.setText("");
		memberIDField2.setText("");
		chosenField.setText("");
		selectedLine = "0";
		resetBooks();
		resetMedia();
		resetMeetingRooms();
		bookButton.setVisible(true);
		mediaButton.setVisible(true);
		roomButton.setVisible(true);
		useButton.setText("Use");
	}

	public void resetBooks() {
		bookList = null;
		bookResults = "";
		listField.setText("");
	}

	public void updateBooks() {
		if(listField.getText().equals("")) {
			bookList = BookDAO.getAllRentedBooks();
			for(Book b : bookList) {
				bookResults += " ID: " + b.getBookID() + " || Title: " + b.getTitle() + " || Author: " + b.getAuthor() + " || Genre: " + b.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(b.getYearEdition()) + " || Publisher: " + b.getPublisher()
						+ " || Place of Publication: " + b.getPublicationPlace() + " || ISBN: " + b.getISBN() + System.lineSeparator();
			}
			listField.setText(bookResults);
		}
	}

	public void resetMedia() {
		mediaList = null;
		mediaResults = "";
		listField.setText("");
	}

	public void updateMedia() {
		if(listField.getText().equals("")) {
			mediaList = MediaDAO.getAllRentedMedia();
			for(Media m : mediaList) {
				mediaResults += " ID: " + m.getMediaID() + " || Title: " + m.getTitle() + " || Artist/Director: " + m.getCreator() + " || Genre: " + m.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(m.getYearEdition()) + " || Producer: " + m.getProducer()
						+ " || Place of Publication: " + m.getPublicationPlace() + " || Type: " + m.getType() + System.lineSeparator();
			}
			listField.setText(mediaResults);
		}
	}
	
	public void resetMeetingRooms() {
		meetingRoomList = null;
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

	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getContentPaneProduct() {
		return contentPaneProduct;
	}
	
	public boolean getForEdit() {
		return this.forEdit;
	}
	
	public void setForEdit(boolean forEdit) {
		this.forEdit = forEdit;
	}

	//Inner class ReservationListGUI
	public class ReservationListGUI {
		private JPanel contentPane = new JPanel();
		private SpringLayout reservationListLayout = new SpringLayout();
		private Dimension screenSize;
		private Insets screenMax;
		private JDialog reservationListDialog = new JDialog();
		private int taskbarSize;
		private int screenWidth, screenHeight;
		private JTextArea listField = new JTextArea(10, 50);
		private JScrollPane listScrollPane = new JScrollPane(listField);
		private JButton deleteButton = new JButton("Delete");
		private JButton editButton = new JButton("Edit");
		private JButton addButton =  new JButton("Add");
		private JButton backButton = new JButton("Back");
		private Color selectionColor = new Color(96, 158, 240);

		private String selectedLine;
		private JLabel searchLabel = new JLabel("Search");
		private JTextField searchField = new JTextField();
		private String[] pattern = {" Product"," Type"," Member"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		private JComboBox reservationListBox = new JComboBox(pattern);
		private String a = " Product";
		private Boolean selectionMade = false;

		private ArrayList<Reservation> reservationList;
		private String reservationResults;

		public ReservationListGUI() {
			//Get size of screen without taskbar
			screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			screenMax = Toolkit.getDefaultToolkit().getScreenInsets(reservationListDialog.getGraphicsConfiguration());
			taskbarSize = screenMax.bottom;
			screenWidth = (int)screenSize.getWidth();
			screenHeight = (int)screenSize.getHeight() - taskbarSize;

			//Fill container
			contentPane.setLayout(reservationListLayout);
			contentPane.add(backButton);
			contentPane.add(addButton);
			contentPane.add(deleteButton);
			contentPane.add(editButton);
			contentPane.add(listScrollPane);
			contentPane.add(searchLabel);
			contentPane.add(searchField);
			contentPane.add(reservationListBox);

			//Prepare frame components
			listField.setEditable(false);
			listField.setSelectionColor(selectionColor);
			searchField.setColumns(20);

			//Placement of components on screen
			reservationListLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
			reservationListLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);

			reservationListLayout.putConstraint(SpringLayout.WEST, listScrollPane, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
			reservationListLayout.putConstraint(SpringLayout.NORTH, listScrollPane, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);

			reservationListLayout.putConstraint(SpringLayout.WEST, addButton, (int)(screenWidth * 0.71), SpringLayout.WEST, contentPane);
			reservationListLayout.putConstraint(SpringLayout.NORTH, addButton, (int)(screenHeight * 0.41), SpringLayout.NORTH, contentPane);

			reservationListLayout.putConstraint(SpringLayout.WEST, deleteButton, (int)(screenWidth * 0.71), SpringLayout.WEST, contentPane);
			reservationListLayout.putConstraint(SpringLayout.NORTH, deleteButton, (int)(screenHeight * 0.46), SpringLayout.NORTH, contentPane);

			reservationListLayout.putConstraint(SpringLayout.WEST, editButton, (int)(screenWidth * 0.71), SpringLayout.WEST, contentPane);
			reservationListLayout.putConstraint(SpringLayout.NORTH, editButton, (int)(screenHeight * 0.51), SpringLayout.NORTH, contentPane);

			reservationListLayout.putConstraint(SpringLayout.WEST, searchLabel, (int)(screenWidth * 0.42), SpringLayout.WEST,contentPane);
			reservationListLayout.putConstraint(SpringLayout.NORTH, searchLabel, (int)(screenHeight * 0.33) , SpringLayout.NORTH, contentPane);

			reservationListLayout.putConstraint(SpringLayout.WEST, searchField, (int)(screenWidth * 0.45), SpringLayout.WEST,contentPane);
			reservationListLayout.putConstraint(SpringLayout.NORTH, searchField, (int)(screenHeight * 0.33) , SpringLayout.NORTH, contentPane);

			reservationListLayout.putConstraint(SpringLayout.WEST, reservationListBox, (int)(screenWidth * 0.6), SpringLayout.WEST,contentPane);
			reservationListLayout.putConstraint(SpringLayout.NORTH, reservationListBox, (int)(screenHeight * 0.33) , SpringLayout.NORTH, contentPane);

			addButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					MainGUI.switchToReservations();
				}

			});

			editButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					MainGUI.switchToReservations(true);
				}


			});

			backButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent event) {
					MainGUI.switchToMenu();
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
						selectionMade = true;
						System.out.println(selectedLine);
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			});

			deleteButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(selectionMade == true) {
						Reservation reservation = null;
						for(Reservation r : reservationList) {
							if(r.getMemberID() == Integer.valueOf(selectedLine)) {
								reservation = r;
							}
						}
						if(activeUser == activeLibrarian){
							ReservationDAO.removeReservation(reservation.getProductID(), reservation.getMemberID());
						}
						selectionMade = false;

						reset();
						update();
					}

				}

			});
			searchField.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					reset();
					String text = searchField.getText();
					if(a==" Product")
					{
						reset();
						reservationList = ReservationDAO.searchByProductID(Integer.valueOf(text));
						update(reservationList);
					}
					if(a==" Member")
					{
						reset();
						reservationList = ReservationDAO.searchByMemberID(Integer.valueOf(text));
						update(reservationList);
					}
					if(a==" Type")
					{
						reset();
						reservationList = ReservationDAO.searchByType(text);
						update(reservationList);
					}
				}
			});
			
			reservationListBox.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					@SuppressWarnings("rawtypes")
					JComboBox cb = (JComboBox)e.getSource();
					a = (String)cb.getSelectedItem();

				}

			});
		}


		public void reset() {
			reservationList = null;
			reservationResults = "";
			listField.setText("");
		}

		public void update() {
			if(listField.getText().equals("")) {
				reservationList = ReservationDAO.getAllReservations();
				for(Reservation r : reservationList) {
					reservationResults += " ID Product: " + r.getProductID() + " ||  Type: " + r.getType() + " || ID Member: " + r.getMemberID() + System.lineSeparator();
				}
				listField.setText(reservationResults);
			}
		}
		
		public void update(ArrayList<Reservation> reservationList) {
			if(listField.getText().equals("")) {
				for(Reservation r : reservationList) {
					reservationResults += " ID Product: " + r.getProductID() + " ||  Type: " + r.getType() + " || ID Member: " + r.getMemberID() + System.lineSeparator();
				}
				listField.setText(reservationResults);
			}
		}

		public JPanel getContentPane() {
			return contentPane;
		}

	}
}

