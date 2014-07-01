package gui;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import logic.*;
import dao.MeetingRoomDAO;

public class MeetingRoomGUI {
	private JPanel contentPane = new JPanel();
	private SpringLayout meetingRoomLayout = new SpringLayout();
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog meetingRoomDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;
	private JLabel floorLabel = new JLabel("Floor:"), seatsAmountLabel = new JLabel("Amount of seats: "), nameLabel = new JLabel("Name: ");
	private JTextField floorField = new JTextField(), seatsAmountField = new JTextField(), nameField = new JTextField();
	private JButton meetingRoomButton = new JButton("Add");
	private static JButton backButton = new JButton("Back");
	private MeetingRoom meetingRoom;
	private int roomID;
	private boolean forEdit = false;
	
	public MeetingRoomGUI() {
		//Get size of screen without taskbar
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(meetingRoomDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;
		
		//Fill container
		contentPane.setLayout(meetingRoomLayout);
		contentPane.add(backButton);
		contentPane.add(floorLabel);
		contentPane.add(floorField);
		contentPane.add(seatsAmountLabel);
		contentPane.add(seatsAmountField);
		contentPane.add(nameLabel);
		contentPane.add(nameField);
		contentPane.add(meetingRoomButton);
		
		//Prepare frame components
		floorField.setColumns(20);
		seatsAmountField.setColumns(20);
		nameField.setColumns(20);
		
		//Placement of components on screen
		meetingRoomLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		meetingRoomLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
		
		meetingRoomLayout.putConstraint(SpringLayout.WEST, floorLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		meetingRoomLayout.putConstraint(SpringLayout.NORTH, floorLabel, (int)(screenHeight * 0.43), SpringLayout.NORTH, contentPane);
		
		meetingRoomLayout.putConstraint(SpringLayout.WEST, floorField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		meetingRoomLayout.putConstraint(SpringLayout.NORTH, floorField, (int)(screenHeight * 0.43), SpringLayout.NORTH, contentPane);
		
		meetingRoomLayout.putConstraint(SpringLayout.WEST, seatsAmountLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		meetingRoomLayout.putConstraint(SpringLayout.NORTH, seatsAmountLabel, (int)(screenHeight * 0.49), SpringLayout.NORTH, contentPane);
		
		meetingRoomLayout.putConstraint(SpringLayout.WEST, seatsAmountField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		meetingRoomLayout.putConstraint(SpringLayout.NORTH, seatsAmountField, (int)(screenHeight * 0.49), SpringLayout.NORTH, contentPane);
		
		meetingRoomLayout.putConstraint(SpringLayout.WEST, nameLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		meetingRoomLayout.putConstraint(SpringLayout.NORTH, nameLabel, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
		
		meetingRoomLayout.putConstraint(SpringLayout.WEST, nameField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		meetingRoomLayout.putConstraint(SpringLayout.NORTH, nameField, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
			
		meetingRoomLayout.putConstraint(SpringLayout.WEST, meetingRoomButton, (int)(screenWidth * 0.50), SpringLayout.WEST, contentPane);
		meetingRoomLayout.putConstraint(SpringLayout.NORTH, meetingRoomButton, (int)(screenHeight * 0.70) , SpringLayout.NORTH, contentPane);
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if(forEdit == true)
					MainGUI.switchToMeetingRoomList();
				else
					MainGUI.switchToMenu();
			}
			
		});
		
		meetingRoomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(forEdit == false) {
					if(floorField.getText().equals("") || seatsAmountField.getText().equals("") || nameField.getText().equals(""))
						meetingRoomButton.setEnabled(false);
					else {
						meetingRoom = new MeetingRoom(Integer.valueOf(floorField.getText()), Integer.valueOf(seatsAmountField.getText()), nameField.getText());
						MeetingRoomDAO.saveMeetingRoom(meetingRoom);
						System.out.println(seatsAmountField.getText());
					}
				}
				
				else if(forEdit == true) {
					if(floorField.getText().equals("") || seatsAmountField.getText().equals("") || nameField.getText().equals(""))
						meetingRoomButton.setEnabled(false);
					else {
						meetingRoomButton.setEnabled(true);
						roomID = meetingRoom.getRoomID();
						meetingRoom = new MeetingRoom(roomID, Integer.valueOf(floorField.getText()), Integer.valueOf(seatsAmountField.getText()), nameField.getText());
						MeetingRoomDAO.editMeetingRoom(meetingRoom);
						JOptionPane.showMessageDialog(contentPane, "MeetingRoom saved", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
			
		});		
	}
	
	
	public void reset() {
		floorField.setText("");
		seatsAmountField.setText("");
		nameField.setText("");
		forEdit = false;
		meetingRoomButton.setText("Add");
	}
	
	public void setForEdit(Boolean forEdit) {
		this.forEdit = forEdit;
	}
	
	public static void setBackButton(){
		backButton.setEnabled(false);
	}
	
	public static void setBackButtonTrue(){
		backButton.setEnabled(true);
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
	
	
	
	
	
	//Inner class MeetingRoomListGUI
	public class MeetingRoomListGUI {
		private JPanel contentPane = new JPanel();
		private SpringLayout bookLayout = new SpringLayout();
		private Dimension screenSize;
		private Insets screenMax;
		private JDialog bookDialog = new JDialog();
		private int taskbarSize;
		private int screenWidth, screenHeight;
		private JTextArea listField = new JTextArea(10, 50);
		private JScrollPane listScrollPane = new JScrollPane(listField);
		private JButton addButton = new JButton("Add");
		private JButton deleteButton = new JButton("Delete");
		private JButton editButton = new JButton("Edit");
		private JButton backButton = new JButton("Back");
		private JLabel searchLabel = new JLabel("Search:");
		private JTextField searchField = new JTextField();
		private String[] pattern = {" ID", " Name"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		private JComboBox meetingRoomBox = new JComboBox(pattern);
		private String a = " ID";
		private Color selectionColor = new Color(96, 158, 240);
		
		
		private String selectedLine;
		private Boolean selectionMade = false;
		
		private ArrayList<MeetingRoom> meetingRoomList;
		private String meetingRoomResults;
		
		public MeetingRoomListGUI() {
		//Get size of screen without taskbar
				screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				screenMax = Toolkit.getDefaultToolkit().getScreenInsets(bookDialog.getGraphicsConfiguration());
				taskbarSize = screenMax.bottom;
				screenWidth = (int)screenSize.getWidth();
				screenHeight = (int)screenSize.getHeight() - taskbarSize;
				
				//Fill container
				contentPane.setLayout(bookLayout);
				contentPane.add(backButton);
				contentPane.add(addButton);
				contentPane.add(deleteButton);
				contentPane.add(editButton);
				contentPane.add(listScrollPane);
				contentPane.add(searchLabel);
				contentPane.add(searchField);
				contentPane.add(meetingRoomBox);
				
				
				//Prepare frame components
				listField.setEditable(false);
				listField.setSelectionColor(selectionColor);
				searchField.setColumns(20);
				
				//Placement of components on screen
				bookLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, listScrollPane, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, listScrollPane, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, addButton, (int)(screenWidth * 0.7), SpringLayout.WEST, contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, addButton, (int)(screenHeight * 0.41), SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, deleteButton, (int)(screenWidth * 0.7), SpringLayout.WEST, contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, deleteButton, (int)(screenHeight * 0.46), SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, editButton, (int)(screenWidth * 0.7), SpringLayout.WEST, contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, editButton, (int)(screenHeight * 0.51), SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, searchLabel, (int)(screenWidth * 0.42), SpringLayout.WEST,contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, searchLabel, (int)(screenHeight * 0.33) , SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, searchField, (int)(screenWidth * 0.45), SpringLayout.WEST,contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, searchField, (int)(screenHeight * 0.33) , SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, meetingRoomBox, (int)(screenWidth * 0.6), SpringLayout.WEST,contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, meetingRoomBox, (int)(screenHeight * 0.33) , SpringLayout.NORTH, contentPane);
				
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
				
				addButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						MainGUI.switchToMeetingRoom();
						forEdit = true;
					}
					
				});
				
				editButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						MainGUI.switchToMeetingRoom(true);
						meetingRoom = MeetingRoomDAO.getMeetingRoom(Integer.valueOf(selectedLine));
						floorField.setText(String.valueOf(meetingRoom.getFloor()));
						seatsAmountField.setText(String.valueOf(meetingRoom.getSeatsAmount()));
						nameField.setText(meetingRoom.getName());
						MeetingRoomGUI.this.meetingRoomButton.setText("Save");
					}
					
				});
				
				deleteButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(selectionMade == true) {
							MeetingRoomDAO.removeMeetingRoom(Integer.valueOf(selectedLine));
							selectionMade = false;
							
							//UpseatsAmount list
							reset();
							update();
						}
					}
				});
				
				meetingRoomBox.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						@SuppressWarnings("rawtypes")
						JComboBox cb = (JComboBox)e.getSource();
						a = (String)cb.getSelectedItem();				
					}
					
				});
				
				searchField.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						reset();
						String text = searchField.getText();
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
				});
		}
	
		
		public void reset() {
			meetingRoomList = null;
			meetingRoomResults = "";
			listField.setText("");
		}
		
		public void update() {
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
		
	}
}
