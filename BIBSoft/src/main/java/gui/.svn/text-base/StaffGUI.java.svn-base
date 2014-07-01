package gui;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import logic.*;
import dao.MemberDAO;
import dao.StaffDAO;

public class StaffGUI {
	private JPanel contentPane = new JPanel();
	private SpringLayout staffLayout = new SpringLayout();
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog staffDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;
	private JLabel IDLabel = new JLabel("Staff ID:"), passwordLabel = new JLabel("Password:"), 
			firstNameLabel = new JLabel("First name: "), nameLabel = new JLabel("Name: "), functionLabel = new JLabel("Function:");
	private JTextField IDField = new JTextField(), firstNameField = new JTextField(), nameField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JButton staffButton = new JButton("Add");
	private static JButton backButton = new JButton("Back");
	private static String[] pattern = {" Admin"," Librarian"," Manager"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static JComboBox functionBox = new JComboBox(pattern);
	private String a = " Admin";
	private Login login;
	private Staff staff;
	private boolean forEdit = false;
	private boolean passwordChanged = false;
	
	public StaffGUI() {
		//Get size of screen without taskbar
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(staffDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;
		
		//Fill container
		contentPane.setLayout(staffLayout);
		contentPane.add(backButton);
		contentPane.add(IDLabel);
		contentPane.add(IDField);
		contentPane.add(passwordLabel);
		contentPane.add(passwordField);
		contentPane.add(firstNameLabel);
		contentPane.add(firstNameField);
		contentPane.add(nameLabel);
		contentPane.add(nameField);
		contentPane.add(functionLabel);
		contentPane.add(staffButton);
		contentPane.add(functionBox);
		
		//Prepare frame components
		IDField.setColumns(20);
		nameField.setColumns(20);
		passwordField.setColumns(20);
		firstNameField.setColumns(20);
		nameField.setColumns(20);
		
		//Placement of components on screen
		staffLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		staffLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
		
		staffLayout.putConstraint(SpringLayout.WEST, IDLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		staffLayout.putConstraint(SpringLayout.NORTH, IDLabel, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
		
		staffLayout.putConstraint(SpringLayout.WEST, IDField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		staffLayout.putConstraint(SpringLayout.NORTH, IDField, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
		
		staffLayout.putConstraint(SpringLayout.WEST, passwordLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		staffLayout.putConstraint(SpringLayout.NORTH, passwordLabel, (int)(screenHeight * 0.43), SpringLayout.NORTH, contentPane);
		
		staffLayout.putConstraint(SpringLayout.WEST, passwordField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		staffLayout.putConstraint(SpringLayout.NORTH, passwordField, (int)(screenHeight * 0.43), SpringLayout.NORTH, contentPane);
		
		staffLayout.putConstraint(SpringLayout.WEST, firstNameLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		staffLayout.putConstraint(SpringLayout.NORTH, firstNameLabel, (int)(screenHeight * 0.49), SpringLayout.NORTH, contentPane);
		
		staffLayout.putConstraint(SpringLayout.WEST, firstNameField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		staffLayout.putConstraint(SpringLayout.NORTH, firstNameField, (int)(screenHeight * 0.49), SpringLayout.NORTH, contentPane);
		
		staffLayout.putConstraint(SpringLayout.WEST, nameLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		staffLayout.putConstraint(SpringLayout.NORTH, nameLabel, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
		
		staffLayout.putConstraint(SpringLayout.WEST, nameField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		staffLayout.putConstraint(SpringLayout.NORTH, nameField, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
		
		staffLayout.putConstraint(SpringLayout.WEST, functionLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		staffLayout.putConstraint(SpringLayout.NORTH, functionLabel, (int)(screenHeight * 0.61), SpringLayout.NORTH, contentPane);
		
		staffLayout.putConstraint(SpringLayout.WEST, functionBox, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		staffLayout.putConstraint(SpringLayout.NORTH, functionBox, (int)(screenHeight * 0.61), SpringLayout.NORTH, contentPane);
			
		staffLayout.putConstraint(SpringLayout.WEST, staffButton, (int)(screenWidth * 0.50), SpringLayout.WEST, contentPane);
		staffLayout.putConstraint(SpringLayout.NORTH, staffButton, (int)(screenHeight * 0.70) , SpringLayout.NORTH, contentPane);
		
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if(forEdit == true)
					MainGUI.switchToStaffList();
				else
					MainGUI.switchToMenu();
			}
			
		});
		
		passwordField.getDocument().addDocumentListener(new DocumentListener()  {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				passwordChanged = true;
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				passwordChanged = true;
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				passwordChanged = true;
			}
			
		});
		
		staffButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(forEdit == false) {
					if(IDField.getText().equals("") || new String(passwordField.getPassword()).equals(""))
						staffButton.setEnabled(false);
					else {
						login = new Login(IDField.getText(), new String(passwordField.getPassword()));
						login.setPassword(new String(passwordField.getPassword()));
					}
					if(nameField.getText().equals("") || firstNameField.getText().equals(""))
						staffButton.setEnabled(false);
					else {
						staff = new Staff(nameField.getText(), firstNameField.getText(), a, login);
						
						
					}
					if(StaffDAO.getAll().size()==0){
						MainGUI.switchToLogin();
						StaffDAO.insertStaff(staff);
						setBackButtonTrue();
						setFunctionBoxTrue();
					}
					else
					{
						if(Staff.validateFirstName(nameField.getText())==true){
							if(Staff.validateSurname(firstNameField.getText())==true){
								StaffDAO.insertStaff(staff);
								MemberDAO.UperFirstName();
								MemberDAO.UpperSurname();
								JOptionPane.showMessageDialog(contentPane, "Staff added", "Succes", JOptionPane.INFORMATION_MESSAGE);
							
							}
							else
								JOptionPane.showMessageDialog(contentPane, "Phonenumber not correct. Must consist of 9 or 10 characters.");
							
						}
						else
							JOptionPane.showMessageDialog(contentPane, "Name not correct. Must be at least 3 characters long and can only include spaces, tremas or apostrophes as special characters.");
					
						
						}
				}
				
				else if(forEdit == true) {
					IDField.setEditable(false);
					if(IDField.getText().equals("") || new String(passwordField.getPassword()).equals(""))
						staffButton.setEnabled(false);
					else {
						login = new Login(IDField.getText(), new String(passwordField.getPassword()));
						if(passwordChanged == true)
							login.setPassword(new String(passwordField.getPassword()));
						System.out.println(new String(passwordField.getPassword()));
						System.out.println(passwordChanged);
					}
					if(nameField.getText().equals("") || firstNameField.getText().equals(""))
						staffButton.setEnabled(false);
					else {
						staffButton.setEnabled(true);
						staff = new Staff(nameField.getText(), firstNameField.getText(), a, login);
						StaffDAO.editStaff(staff);
						IDField.setEditable(true);
						passwordChanged = false;
						JOptionPane.showMessageDialog(contentPane, "Staff saved", "Success", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
			
		});
		
		functionBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("rawtypes")
				JComboBox cb = (JComboBox)e.getSource();
				a = (String)cb.getSelectedItem();				
			}
			
		});

		
	}
	
	
	public void reset() {
		IDField.setText("");
		passwordField.setText("");
		nameField.setText("");
		firstNameField.setText("");
		a="Admin";
		forEdit = false;
		staffButton.setText("Add");
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
	public static void setFunctionBox() {
	functionBox.setEnabled(false);	
	}
	public static void setFunctionBoxTrue() {
	functionBox.setEnabled(true);	
	}

	
	public JPanel getContentPane() {
		return contentPane;
	}
	
	
	
	
	
	//Inner class StaffListGUI
	public class StaffListGUI {
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
		private String[] pattern = {" ID"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		private JComboBox bookBox = new JComboBox(pattern);
		private String a = " ID";
		private Color selectionColor = new Color(96, 158, 240);
		
		
		private String selectedLine;
		private Boolean selectionMade = false;
		
		private ArrayList<Staff> staffList;
		private String staffResults;
		
		public StaffListGUI() {
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
				contentPane.add(bookBox);
				
				
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
				
				bookLayout.putConstraint(SpringLayout.WEST, bookBox, (int)(screenWidth * 0.6), SpringLayout.WEST,contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, bookBox, (int)(screenHeight * 0.33) , SpringLayout.NORTH, contentPane);
				
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
						MainGUI.switchToStaff();
						forEdit = true;
					}
					
				});
				
				editButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						MainGUI.switchToStaff(true);
						Staff staff = StaffDAO.getStaffByID(selectedLine);
						IDField.setText(staff.getLogin().getStaffID());
						passwordField.setText(staff.getLogin().getPassword());
						nameField.setText(staff.getName());
						a = staff.getFunction();
						firstNameField.setText(staff.getSurname());
						StaffGUI.this.staffButton.setText("Save");
						passwordChanged = false;
						
					}
					
				});
				
				deleteButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(selectionMade == true) {
							StaffDAO.removeStaff(selectedLine);
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
						if(a==" ID")
						{
							if(listField.getText().equals("")){
								staffList = StaffDAO.searchStaffByID(text);
								for(Staff s : staffList) {
									Login login = s.getLogin();
									staffResults += " ID: " + login.getStaffID() + " || Surname: " + s.getSurname() + " || Name: " + s.getName()
											+ " || Function: " + s.getFunction() + System.lineSeparator();
								}
								listField.setText(staffResults);
							}
						}
													
					}
					});
				
		}
	
		
		public void reset() {
			staffList = null;
			staffResults = "";
			listField.setText("");
		}
		
		public void update() {
			if(listField.getText().equals("")) {
				staffList = StaffDAO.getAll();
				for(Staff s : staffList) {
					Login login = s.getLogin();
					staffResults += " ID: " + login.getStaffID() + " || Surname: " + s.getSurname() + " || Name: " + s.getName()
							+ " || Function: " + s.getFunction() + System.lineSeparator();
				}
				listField.setText(staffResults);
			}
		}
		
		public JPanel getContentPane() {
			return contentPane;
		}
		
	}
	



}


