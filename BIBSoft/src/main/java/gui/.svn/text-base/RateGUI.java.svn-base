package gui;

import static gui.LoginGUI.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import dao.RateDAO;
import logic.Rate;

public class RateGUI {
	private JPanel contentPane = new JPanel();
	private SpringLayout rateLayout = new SpringLayout();
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog rateDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;
	private JLabel rateDescriptionLabel = new JLabel("Description:"), ratePriceLabel = new JLabel("Price:");
	private JTextField rateDescriptionField = new JTextField(), ratePriceField = new JTextField();
	private JButton rateButton = new JButton("Add");
	private JButton backButton = new JButton("Back");
	
	private boolean forEdit = false;
	private Rate r = null;
	
	public RateGUI() {
		//Get size of screen without taskbar
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(rateDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;
		
		//Fill container
		contentPane.setLayout(rateLayout);
		contentPane.add(backButton);
		contentPane.add(rateDescriptionLabel);
		contentPane.add(rateDescriptionField);
		contentPane.add(ratePriceLabel);
		contentPane.add(ratePriceField);
		contentPane.add(rateButton);
		
		//Prepare frame components
		rateDescriptionField.setColumns(20);
		ratePriceField.setColumns(20);
		
		//Placement of components on screen
		rateLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		rateLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
		
		rateLayout.putConstraint(SpringLayout.WEST, rateDescriptionLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		rateLayout.putConstraint(SpringLayout.NORTH, rateDescriptionLabel, (int)(screenHeight * 0.45), SpringLayout.NORTH, contentPane);
		
		rateLayout.putConstraint(SpringLayout.WEST, rateDescriptionField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		rateLayout.putConstraint(SpringLayout.NORTH, rateDescriptionField, (int)(screenHeight * 0.45), SpringLayout.NORTH, contentPane);
		
		rateLayout.putConstraint(SpringLayout.WEST, ratePriceLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		rateLayout.putConstraint(SpringLayout.NORTH, ratePriceLabel, (int)(screenHeight * 0.50), SpringLayout.NORTH, contentPane);
		
		rateLayout.putConstraint(SpringLayout.WEST, ratePriceField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		rateLayout.putConstraint(SpringLayout.NORTH, ratePriceField, (int)(screenHeight * 0.50), SpringLayout.NORTH, contentPane);
		
		rateLayout.putConstraint(SpringLayout.WEST, rateButton, (int)(screenWidth * 0.5), SpringLayout.WEST, contentPane);
		rateLayout.putConstraint(SpringLayout.NORTH, rateButton, (int)(screenHeight * 0.55) , SpringLayout.NORTH, contentPane);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if(!forEdit){
					MainGUI.switchToMenu();
				}else{
					MainGUI.switchToRateList();
				}
				
			}
		});
		
		rateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!forEdit){
					try {
						Rate rate = new Rate(rateDescriptionField.getText(), Float.valueOf(ratePriceField.getText()));
						if(activeUser == activeManager){
							activeManager.addRate(rate);
						}else{
							activeAdmin.addRate(rate);
						}
						reset();
						JOptionPane.showMessageDialog(contentPane, "Nieuwe prijs bewaard.");
					} catch (NumberFormatException | NullPointerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					try {
						r.setDescription(rateDescriptionField.getText());
						r.setRate(Float.valueOf(ratePriceField.getText()));
						if(activeUser == activeManager){
							activeManager.updateRate(r);
						}else{
							activeAdmin.updateRate(r);
						}
						reset();
						JOptionPane.showMessageDialog(contentPane, "Prijs bijgewerkt.");
						MainGUI.switchToRateList();
					} catch (NumberFormatException | NullPointerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
	
	}
	
	public void reset() {
		rateDescriptionField.setText("");
		rateDescriptionField.setEditable(true);
		ratePriceField.setText("");
		forEdit = false;
		
	}
	
	public void setForEdit(boolean forEdit){
		this.forEdit = forEdit;
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
	
	//Inner class RateListGUI
			public class RateListGUI {
				private JPanel contentPane = new JPanel();
				private SpringLayout rateLayout = new SpringLayout();
				private Dimension screenSize;
				private Insets screenMax;
				private JDialog rateDialog = new JDialog();
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
				private Boolean selectionMade = false;
				
				private ArrayList<Rate> rateList;
				private String rateResults;
				
				public RateListGUI() {
				//Get size of screen without taskbar
						screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						screenMax = Toolkit.getDefaultToolkit().getScreenInsets(rateDialog.getGraphicsConfiguration());
						taskbarSize = screenMax.bottom;
						screenWidth = (int)screenSize.getWidth();
						screenHeight = (int)screenSize.getHeight() - taskbarSize;
						
						//Fill container
						contentPane.setLayout(rateLayout);
						contentPane.add(backButton);
						contentPane.add(addButton);
						contentPane.add(deleteButton);
						contentPane.add(editButton);
						contentPane.add(listScrollPane);
						
						//Prepare frame components
						listField.setEditable(false);
						listField.setSelectionColor(selectionColor);
						
						//Placement of components on screen
						rateLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
						rateLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
						
						rateLayout.putConstraint(SpringLayout.WEST, listScrollPane, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPane);
						rateLayout.putConstraint(SpringLayout.NORTH, listScrollPane, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
						
						rateLayout.putConstraint(SpringLayout.WEST, addButton, (int)(screenWidth * 0.7), SpringLayout.WEST, contentPane);
						rateLayout.putConstraint(SpringLayout.NORTH, addButton, (int)(screenHeight * 0.41), SpringLayout.NORTH, contentPane);
						
						rateLayout.putConstraint(SpringLayout.WEST, deleteButton, (int)(screenWidth * 0.7), SpringLayout.WEST, contentPane);
						rateLayout.putConstraint(SpringLayout.NORTH, deleteButton, (int)(screenHeight * 0.46), SpringLayout.NORTH, contentPane);
						
						rateLayout.putConstraint(SpringLayout.WEST, editButton, (int)(screenWidth * 0.7), SpringLayout.WEST, contentPane);
						rateLayout.putConstraint(SpringLayout.NORTH, editButton, (int)(screenHeight * 0.51), SpringLayout.NORTH, contentPane);
						
												
						addButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								MainGUI.switchToRate();
							}

						});
						
						editButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								MainGUI.switchToRate(true);
								r = RateDAO.getRateByID(Integer.valueOf(selectedLine));
								
								rateDescriptionField.setText(r.getDescription());
								ratePriceField.setText(String.valueOf(r.getRate()));
								
								if(Integer.valueOf(selectedLine) < 6){
									rateDescriptionField.setEditable(false);
								}
								
								RateGUI.this.rateButton.setText("update");
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
									if(Integer.valueOf(selectedLine) < 6){
										deleteButton.setEnabled(false);
									}else{
										deleteButton.setEnabled(true);
									}
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
									Rate selectedRate = null;
									for(Rate r : rateList) {
										if(r.getRateId() == Integer.valueOf(selectedLine)) {
											selectedRate = r;
										}
									}
									if(activeUser == activeManager){
										activeManager.removeRate(selectedRate.getRateId());
									}else{
										activeAdmin.removeRate(selectedRate.getRateId());
									}
									selectionMade = false;
									
									reset();
									update();
								}
								
							}
							
						});
				}
				
				public void reset() {
					rateList = null;
					rateResults = "";
					listField.setText("");
				}
				
				public void update() {
					if(listField.getText().equals("")) {
						if(activeUser == activeManager){
							rateList = activeManager.getAllRates();
						}else{
							rateList = activeAdmin.getAllRates();
						}
						
						for(Rate r : rateList) {
							rateResults += " ID: " + r.getRateId() + " || Description: " + r.getDescription()
									+ " || Rate price: " + r.getRate() + System.lineSeparator();
						}
						listField.setText(rateResults);
					}
				}
				
				public JPanel getContentPane() {
					return contentPane;
				}
				
			}
}
