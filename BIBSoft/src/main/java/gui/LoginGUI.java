package gui;

import javax.swing.*;

import dao.StaffDAO;

import java.awt.*;
import java.awt.event.*;

import logic.Admin;
import logic.Librarian;
import logic.Login;
import logic.Manager;
import logic.Staff;

public class LoginGUI {
	private JPanel contentPane = new JPanel();
	private SpringLayout loginLayout = new SpringLayout();
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog loginDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;
	private JLabel nameLabel = new JLabel("ID:"), passwordLabel = new JLabel("Password:");
	private JTextField nameField = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JButton loginButton = new JButton("Log in");
	private Login login;
	
	public static Staff activeUser;
	public static String activeType = "Admin";
	public static Admin activeAdmin;
	public static Librarian activeLibrarian;
	public static Manager activeManager;
		
	public LoginGUI() {
		//Get size of screen without taskbar
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(loginDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;

		//Fill container
		contentPane.setLayout(loginLayout);
		contentPane.add(nameLabel);
		contentPane.add(passwordLabel);
		contentPane.add(nameField);
		contentPane.add(passwordField);
		contentPane.add(loginButton);
		
		//Prepare frame components
		nameField.setColumns(20);
		nameField.requestFocus();
		passwordField.setColumns(20);
		contentPane.setFocusable(true);
		
		//Placement of components on screen
		loginLayout.putConstraint(SpringLayout.WEST, nameLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		loginLayout.putConstraint(SpringLayout.NORTH, nameLabel, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
		
		loginLayout.putConstraint(SpringLayout.WEST, nameField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		loginLayout.putConstraint(SpringLayout.NORTH, nameField, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
		
		loginLayout.putConstraint(SpringLayout.WEST, passwordLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		loginLayout.putConstraint(SpringLayout.NORTH, passwordLabel, (int)(screenHeight * 0.4166), SpringLayout.NORTH, contentPane);
		
		loginLayout.putConstraint(SpringLayout.WEST, passwordField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		loginLayout.putConstraint(SpringLayout.NORTH, passwordField, (int)(screenHeight * 0.4166), SpringLayout.NORTH, contentPane);
		
		loginLayout.putConstraint(SpringLayout.WEST, loginButton, (int)(screenWidth * 0.50), SpringLayout.WEST, contentPane);
		loginLayout.putConstraint(SpringLayout.NORTH, loginButton, (int)(screenHeight * 0.52) , SpringLayout.NORTH, contentPane);

		//Define action of log in button when clicked
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					login = new Login(nameField.getText(), new String(passwordField.getPassword()));
						if(Login.checkLogin(login)) {
							Staff staff = StaffDAO.getStaffByID(login.getStaffID());
							if(staff.getFunction().equals("Admin")) {
								activeAdmin = new Admin(staff.getName(), staff.getSurname(), staff.getFunction(), login);
								activeUser = activeAdmin;
								activeType = "Admin";
								MainGUI.switchToMenu(activeAdmin);
							}
							else if(staff.getFunction().equals("Librarian")) {
								activeLibrarian = new Librarian(staff.getName(), staff.getSurname(), staff.getFunction(), login);
								activeUser = activeLibrarian;
								activeType = "Librarian";
								MainGUI.switchToMenu(activeLibrarian);
							}
							else if(staff.getFunction().equals("Manager")) {
								activeManager = new Manager(staff.getName(), staff.getSurname(), staff.getFunction(), login);
								activeUser = activeManager;
								activeType = "Manager";
								MainGUI.switchToMenu(activeManager);
							}
							else {
								JOptionPane.showMessageDialog(contentPane, "Not enough rights", "Log in result", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "Log in failed", "Log in result", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				catch(NullPointerException e) {
					System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(contentPane, "User doesn't exist", "Log in result", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enterPressed");
		contentPane.getActionMap().put("enterPressed", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					login = new Login(nameField.getText(), new String(passwordField.getPassword()));
						if(Login.checkLogin(login)) {
							Staff staff = StaffDAO.getStaffByID(login.getStaffID());
							if(staff.getFunction().equals("Admin")) {
								activeAdmin = new Admin(staff.getName(), staff.getSurname(), staff.getFunction(), login);
								activeUser = activeAdmin;
								activeType = "Admin";
								MainGUI.switchToMenu(activeAdmin);
							}
							else if(staff.getFunction().equals("Librarian")) {
								activeLibrarian = new Librarian(staff.getName(), staff.getSurname(), staff.getFunction(), login);
								activeUser = activeLibrarian;
								activeType = "Librarian";
								MainGUI.switchToMenu(activeLibrarian);
							}
							else if(staff.getFunction().equals("Manager")) {
								activeManager = new Manager(staff.getName(), staff.getSurname(), staff.getFunction(), login);
								activeUser = activeManager;
								activeType = "Manager";
								MainGUI.switchToMenu(activeManager);
							}
							else {
								JOptionPane.showMessageDialog(contentPane, "Not enough rights", "Log in result", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "Log in failed", "Log in result", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				catch(NullPointerException e) {
					System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(contentPane, "User doesn't exist", "Log in result", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	
	public void reset() {
		login = null;
		nameField.setText("");
		passwordField.setText("");
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
}
