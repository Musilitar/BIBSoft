package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import dao.AdressDAO;
import dao.MemberDAO;
import static dao.AdressDAO.*;
import static dao.MemberDAO.*;
import logic.Adress;
import logic.Member;
import static gui.LoginGUI.*;



public class MemberGUI {
	private JPanel contentPane = new JPanel();
	private SpringLayout memberLayout = new SpringLayout();
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog memberDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;
	private JLabel nameLabel = new JLabel("Name:");
	private JTextField nameField = new JTextField();
	private JLabel firstNameLabel = new JLabel("First Name:");
	private JTextField firstNameField = new JTextField();
	private JLabel phoneNrLabel = new JLabel("Phone Nr:");
	private JTextField phoneNrField = new JTextField();
	private JLabel streetLabel = new JLabel("Street:");
	private JTextField streetField = new JTextField();
	private JLabel cityLabel = new JLabel("City:");
	private JTextField cityField = new JTextField();
	private JLabel streetNrLabel = new JLabel("Street Nr:");
	private JTextField streetNrField = new JTextField();
	private JLabel zipCodeLabel = new JLabel("Zip Code:");
	private JTextField zipCodeField = new JTextField();
	private JLabel busLabel = new JLabel("Bus:");
	private JTextField busField = new JTextField();
	private JButton memberButton = new JButton("Add");
	private JButton backButton = new JButton("Back");
	private boolean forEdit = false;
	private Adress adress;
	private Member member;
	
	public MemberGUI() {
		//Get size of screen without taskbar
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(memberDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;
		
		//Fill container
		contentPane.add(backButton);
		contentPane.setLayout(memberLayout);
		contentPane.add(nameLabel);
		contentPane.add(nameField);
		contentPane.add(firstNameLabel);
		contentPane.add(firstNameField);
		contentPane.add(phoneNrLabel);
		contentPane.add(phoneNrField);
		contentPane.add(streetLabel);
		contentPane.add(streetField);
		contentPane.add(streetNrLabel);
		contentPane.add(streetNrField);
		contentPane.add(cityLabel);
		contentPane.add(cityField);
		contentPane.add(zipCodeLabel);
		contentPane.add(zipCodeField);
		contentPane.add(busLabel);
		contentPane.add(busField);
		contentPane.add(memberButton);
		
		
		//Prepare frame components
		nameField.setColumns(20);
		firstNameField.setColumns(20);
		phoneNrField.setColumns(20);
		streetField.setColumns(20);
		streetNrField.setColumns(20);
		cityField.setColumns(20);
		zipCodeField.setColumns(20);
		busField.setColumns(20);
		
		
		//Placement of components on screen
		memberLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, nameLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, nameLabel, (int)(screenHeight * 0.3), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, nameField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, nameField, (int)(screenHeight * 0.3), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, firstNameLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, firstNameLabel, (int)(screenHeight * 0.35), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, firstNameField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, firstNameField, (int)(screenHeight * 0.35), SpringLayout.NORTH, contentPane);
			
		memberLayout.putConstraint(SpringLayout.WEST, phoneNrLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, phoneNrLabel, (int)(screenHeight * 0.4), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, phoneNrField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, phoneNrField, (int)(screenHeight * 0.4), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, streetLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, streetLabel, (int)(screenHeight * 0.45), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, streetField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, streetField, (int)(screenHeight * 0.45), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, streetNrLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, streetNrLabel, (int)(screenHeight * 0.5), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, streetNrField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, streetNrField, (int)(screenHeight * 0.5), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, cityLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, cityLabel, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, cityField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, cityField, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, zipCodeLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, zipCodeLabel, (int)(screenHeight * 0.6), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, zipCodeField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, zipCodeField, (int)(screenHeight * 0.6), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, busLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, busLabel, (int)(screenHeight * 0.65), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, busField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, busField, (int)(screenHeight * 0.65), SpringLayout.NORTH, contentPane);
		
		memberLayout.putConstraint(SpringLayout.WEST, memberButton, (int)(screenWidth * 0.52), SpringLayout.WEST, contentPane);
		memberLayout.putConstraint(SpringLayout.NORTH, memberButton, (int)(screenHeight * 0.725) , SpringLayout.NORTH, contentPane);
		
		
		
		
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				MainGUI.switchToMenu();
			}
			
		});
		memberButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				String b = zipCodeField.getText();
				int m = Integer.parseInt(b);
				if(forEdit == false)
					{
						if(streetField.getText().equals("") || cityField.getText().equals("") || streetNrField.getText().equals("") || zipCodeField.getText().equals(""))
							{
								memberButton.setEnabled(false);
							}
						else
							{
								adress = new Adress(busField.getText(),streetField.getText(),cityField.getText(),streetNrField.getText(),m,-1);
								
							}
						if(nameField.getText().equals("") || firstNameField.getText().equals("") || phoneNrField.getText().equals(""))
							{
								memberButton.setEnabled(false);
							}
						else
							{
								member = new Member(nameField.getText(),firstNameField.getText(),phoneNrField.getText(), adress,-1);
								if(Member.validateSurname(nameField.getText())==true){
									if(Member.validateTelnr(phoneNrField.getText())==true){
										if(Member.validateFirstName(firstNameField.getText())){
											if(Adress.validateStreet(streetField.getText())==true){
												if(Adress.validateHouseNr(streetNrField.getText())==true){
													if(Adress.validateZipcode(zipCodeField.getText())==true){
														if(Adress.validateBus(busField.getText())==true){
															if(Adress.validateCity(cityField.getText())==true){
																if(activeUser == activeLibrarian){
																	activeLibrarian.addAdress(adress);
																	activeLibrarian.addMember(member);	
																	MemberDAO.UperFirstName();
																	MemberDAO.UpperSurname();
																	AdressDAO.UpperCity();
																	AdressDAO.UpperStreet();
																}
																else{
																	activeAdmin.addAdress(adress);
																	activeAdmin.addMember(member);	
																	MemberDAO.UperFirstName();
																	MemberDAO.UpperSurname();
																	AdressDAO.UpperCity();
																	AdressDAO.UpperStreet();
																}
																JOptionPane.showMessageDialog(contentPane, "Member added");
																}
														
														else
															JOptionPane.showMessageDialog(contentPane, "City not correct. Has to be at least 3 characters long.");
													}
													else
														JOptionPane.showMessageDialog(contentPane, "Bus not correct. Has to be between 1 and 99");
													}
												else
													JOptionPane.showMessageDialog(contentPane, "Zipcode not correct. Has to be between 1000 and 9999");
												}

											else
												JOptionPane.showMessageDialog(contentPane, "Street Nr not correct. Has to be between 1 and 999");
											}
										else
											JOptionPane.showMessageDialog(contentPane, "Street name not correct. Has to be at least 5 characters long.");
											}
										else
											JOptionPane.showMessageDialog(contentPane, "First name not correct. Has to at least 2 characters long");
										}
									else
										JOptionPane.showMessageDialog(contentPane, "Phonenumber not correct. Has to consist of numbers and be either 9 characters long (without '+' at front) or 10 characters long(with '+' at front).");
									}
								else
									JOptionPane.showMessageDialog(contentPane, "Last name not correct. Has to be at least 3 characters long and can have spaces, '¨' and ''' as special characters.");
							}
			
					}
				else if(forEdit == true) 
				{
					backButton.setEnabled(false);
					if(streetField.getText().equals("") || cityField.getText().equals("") || streetNrField.getText().equals("") || zipCodeField.getText().equals(""))
						{
							memberButton.setEnabled(false);
						}
					else
						{
							adress = new Adress(busField.getText(),streetField.getText(),cityField.getText(),streetNrField.getText(), Integer.parseInt(zipCodeField.getText()), adress.getAdressID());
						}
					if(nameField.getText().equals("") || firstNameField.getText().equals("") || phoneNrField.getText().equals(""))
						{
							memberButton.setEnabled(false);
						}
					else
					{
						member = new Member(nameField.getText(),firstNameField.getText(),phoneNrField.getText(), adress, member.getLidID());
						if(Member.validateSurname(nameField.getText())==true){
							if(Member.validateTelnr(phoneNrField.getText())==true){
								if(Member.validateFirstName(firstNameField.getText())){
									if(Adress.validateStreet(streetField.getText())==true){
										if(Adress.validateHouseNr(streetNrField.getText())==true){
											if(Adress.validateZipcode(zipCodeField.getText())==true){
												if(Adress.validateBus(busField.getText())==true){
													if(Adress.validateCity(cityField.getText())==true){

														editMember(member);
														editAdress(adress);
														MemberDAO.UperFirstName();
														MemberDAO.UpperSurname();
														AdressDAO.UpperCity();
														AdressDAO.UpperStreet();
														JOptionPane.showMessageDialog(contentPane, "Member upgedate");
														backButton.setEnabled(true);
													}

													else
														JOptionPane.showMessageDialog(contentPane, "City not correct. Has to be at least 3 characters long.");
												}
												else
													JOptionPane.showMessageDialog(contentPane, "Bus not correct. Has to be between 1 and 99");
											}
											else
												JOptionPane.showMessageDialog(contentPane, "Zipcode not correct. Has to be between 1000 and 9999");
										}

										else
											JOptionPane.showMessageDialog(contentPane, "Street Nr not correct. Has to be between 1 and 999");
									}
									else
										JOptionPane.showMessageDialog(contentPane, "Street name not correct. Has to be at least 5 characters long.");
								}
								else
									JOptionPane.showMessageDialog(contentPane, "First name not correct. Has to at least 2 characters long");
							}
							else
								JOptionPane.showMessageDialog(contentPane, "Phonenumber not correct. Has to consist of numbers and be either 9 characters long (without '+' at front) or 10 characters long(with '+' at front).");
						}
						else
							JOptionPane.showMessageDialog(contentPane, "Last name not correct. Has to be at least 3 characters long and can have spaces, '¨' and ''' as special characters.");
					}
				}

			}

		});
	}
	
	public void reset() {
		nameField.setText("");
		firstNameField.setText("");
		phoneNrField.setText("");
		streetField.setText("");
		streetNrField.setText("");
		cityField.setText("");
		zipCodeField.setText("");
		forEdit = false;
		memberButton.setText("Add");
	}
	
	public void setForEdit(boolean forEdit) {
		this.forEdit = forEdit;
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}


//Inner class MemberListGUI
	public class MemberListGUI {
		private JPanel contentPane = new JPanel();
		private SpringLayout memberLayout = new SpringLayout();
		private Dimension screenSize;
		private Insets screenMax;
		private JDialog memberDialog = new JDialog();
		private int taskbarSize;
		private int screenWidth, screenHeight;
		private JTextArea listField = new JTextArea(10, 50);
		private JScrollPane listScrollPane = new JScrollPane(listField);
		private JButton addButton = new JButton("Add");
		private JButton deleteButton = new JButton("Delete");
		private JButton editButton = new JButton("Edit");
		private JButton backButton = new JButton("Back");
		private JLabel searchLabel = new JLabel("Search");
		private JButton detailButton = new JButton("Detail");
		private JTextField searchField = new JTextField();
		private String[] pattern = {" Name"," First name"," City"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		private JComboBox memberBox = new JComboBox(pattern);
		private String a = " Name";
		private String selectedLine;
		private Boolean selectionMade = false;
		private Color selectionColor = new Color(96, 158, 240);
		
		private ArrayList<Member> memberList;
		private String memberResults;
		
		public MemberListGUI() {
		//Get size of screen without taskbar
				screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				screenMax = Toolkit.getDefaultToolkit().getScreenInsets(memberDialog.getGraphicsConfiguration());
				taskbarSize = screenMax.bottom;
				screenWidth = (int)screenSize.getWidth();
				screenHeight = (int)screenSize.getHeight() - taskbarSize;
				
				//Fill container
				contentPane.setLayout(memberLayout);
				contentPane.add(backButton);
				contentPane.add(addButton);
				contentPane.add(deleteButton);
				contentPane.add(editButton);
				contentPane.add(detailButton);
				contentPane.add(listScrollPane);
				contentPane.add(searchLabel);
				contentPane.add(searchField);
				contentPane.add(memberBox);
				
				//Prepare frame components
				listField.setEditable(false);
				listField.setSelectionColor(selectionColor);
				searchField.setColumns(20);
				
				//Placement of components on screen
				memberLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
				memberLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
				
				memberLayout.putConstraint(SpringLayout.WEST, listScrollPane, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
				memberLayout.putConstraint(SpringLayout.NORTH, listScrollPane, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
				
				memberLayout.putConstraint(SpringLayout.WEST, addButton, (int)(screenWidth * 0.7), SpringLayout.WEST, contentPane);
				memberLayout.putConstraint(SpringLayout.NORTH, addButton, (int)(screenHeight * 0.38), SpringLayout.NORTH, contentPane);
				
				memberLayout.putConstraint(SpringLayout.WEST, deleteButton, (int)(screenWidth * 0.7), SpringLayout.WEST, contentPane);
				memberLayout.putConstraint(SpringLayout.NORTH, deleteButton, (int)(screenHeight * 0.43), SpringLayout.NORTH, contentPane);
				
				memberLayout.putConstraint(SpringLayout.WEST, editButton, (int)(screenWidth * 0.7), SpringLayout.WEST, contentPane);
				memberLayout.putConstraint(SpringLayout.NORTH, editButton, (int)(screenHeight * 0.48), SpringLayout.NORTH, contentPane);
				
				memberLayout.putConstraint(SpringLayout.WEST,detailButton ,(int)(screenWidth * 0.7), SpringLayout.WEST, contentPane);
				memberLayout.putConstraint(SpringLayout.NORTH, detailButton, (int)(screenHeight * 0.53), SpringLayout.NORTH, contentPane);
				
				memberLayout.putConstraint(SpringLayout.WEST, searchLabel, (int)(screenWidth * 0.42), SpringLayout.WEST,contentPane);
				memberLayout.putConstraint(SpringLayout.NORTH, searchLabel, (int)(screenHeight * 0.33) , SpringLayout.NORTH, contentPane);
				
				memberLayout.putConstraint(SpringLayout.WEST, searchField, (int)(screenWidth * 0.45), SpringLayout.WEST,contentPane);
				memberLayout.putConstraint(SpringLayout.NORTH, searchField, (int)(screenHeight * 0.33) , SpringLayout.NORTH, contentPane);
				
				memberLayout.putConstraint(SpringLayout.WEST, memberBox, (int)(screenWidth * 0.6), SpringLayout.WEST,contentPane);
				memberLayout.putConstraint(SpringLayout.NORTH, memberBox, (int)(screenHeight * 0.33) , SpringLayout.NORTH, contentPane);
				
				addButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						MainGUI.switchToMember();
					}

				});
				backButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						MainGUI.switchToMenu();
					}
					
				});
				
				editButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						MainGUI.switchToMember(true);
							member = getMemberByID(Integer.parseInt(selectedLine));
							adress = member.getAdress();
					    	nameField.setText(member.getName());
							firstNameField.setText(member.getSurname());
							phoneNrField.setText(member.getTelnr());
							streetField.setText(member.getAdress().getStreet());
							streetNrField.setText(member.getAdress().getHouseNr());
							cityField.setText(member.getAdress().getCity());
							zipCodeField.setText(Integer.toString(member.getAdress().getZipcode()));
							busField.setText(member.getAdress().getBus());
							MemberGUI.this.memberButton.setText("Save");			
					}
					
				});
				detailButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						member = getMemberByID(Integer.parseInt(selectedLine));
						adress = member.getAdress();
						JOptionPane.showMessageDialog(contentPane, "Name: " + member.getName() + "\nFirstname: " + member.getSurname() + "\nPhone number: " + member.getTelnr() + "\nStreet: " + adress.getStreet() + " " + adress.getHouseNr() + "\nZipcode: " + adress.getZipcode() + "\nCity: " + adress.getCity() + "\nBus: " + adress.getBus() + "\nSubscription date: " + member.getInschrijvingsDatum() + "\nQuantity of books: " + member.getAantalBoeken() + "\nSubscription fee: " + member.isLidgeld() + "\nActive: " + member.isActief());
						
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
							removeMember(Integer.parseInt(selectedLine));
							removeAdress(Integer.parseInt(selectedLine));
							selectionMade = false;

							//Update list
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
						if(a==" Name")
						{
							if(listField.getText().equals("")){
								memberList = searchMemberByName(text);
								for(Member s : memberList) {
									memberResults += " ID: " + s.getLidID() + " || Name: " + s.getName() + " || First Name: " + s.getSurname() + " || " + s.getTelnr() + System.lineSeparator();
								}
								listField.setText(memberResults);
							}
						}
						if(a==" First name")
						{
							if(listField.getText().equals("")){
								memberList = searchMemberByFirstName(text);
								for(Member s : memberList) {
									memberResults += " ID: " + s.getLidID() + " || Name: " + s.getName() + " || First Name: " + s.getSurname() + " || " + s.getTelnr() + System.lineSeparator();
								}
								listField.setText(memberResults);
							}
						}
						if(a==" City")
						{
							if(listField.getText().equals("")){
								memberList = searchMemberByCity(text);
								for(Member s : memberList) {
									memberResults += " ID: " + s.getLidID() + " || Name: " + s.getName() + " || First Name: " + s.getSurname() + " || " + s.getTelnr() + System.lineSeparator();
								}
								listField.setText(memberResults);
							}


						}

					}
				});
				memberBox.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						@SuppressWarnings("rawtypes")
						JComboBox cb = (JComboBox)e.getSource();
						a = (String)cb.getSelectedItem();
						
					}
					
				});
		}
		
		public void reset() {
			memberList = null;
			memberResults = "";
			listField.setText("");
		}
		
		public void update() {
			if(listField.getText().equals("")) {
				memberList = MemberDAO.getAll();
				for(Member s : memberList) {
					memberResults += " ID: " + s.getLidID() + " || Name: " + s.getName() + " || First Name: " + s.getSurname() + " || " + s.getTelnr() + System.lineSeparator();
				}
				listField.setText(memberResults);
			}
		}
		
		public JPanel getContentPane() {
			return contentPane;
		}
		
	}
}


	



	