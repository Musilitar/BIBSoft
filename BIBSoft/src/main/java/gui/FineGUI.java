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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import logic.Fine;
import logic.RentTransaction;



public class FineGUI {
	private JPanel contentPane = new JPanel();
	private SpringLayout fineLayout = new SpringLayout();
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog fineDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;
	private JTextArea listField = new JTextArea(10, 50);
	private JScrollPane listScrollPane = new JScrollPane(listField);
	private JButton updateButton = new JButton("Update List");
	private JButton backButton = new JButton("Back");
	private JButton payButton = new JButton("Pay fine");
	private JButton detailButton = new JButton("Detail");
	
	private Fine fine = null;
	
	private String selectedLine;
	
	private ArrayList<Fine> fineList;
	private String fineResults;
	private RentTransaction rentTrans;
	
	public FineGUI(){
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(fineDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;
		
		//Fill container
		contentPane.setLayout(fineLayout);
		contentPane.add(backButton);
		contentPane.add(detailButton);
		contentPane.add(payButton);
		contentPane.add(listScrollPane);
		contentPane.add(updateButton);
		
		//Prepare frame components
		listField.setEditable(false);
		listField.setSelectionColor(Color.LIGHT_GRAY);
		
		//Placement of components on screen
		fineLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		fineLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
		
		fineLayout.putConstraint(SpringLayout.WEST, listScrollPane, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		fineLayout.putConstraint(SpringLayout.NORTH, listScrollPane, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
		
		fineLayout.putConstraint(SpringLayout.WEST, payButton, (int)(screenWidth * 0.9), SpringLayout.WEST, contentPane);
		fineLayout.putConstraint(SpringLayout.NORTH, payButton, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPane);
		
		fineLayout.putConstraint(SpringLayout.WEST, detailButton, (int)(screenWidth * 0.9), SpringLayout.WEST, contentPane);
		fineLayout.putConstraint(SpringLayout.NORTH, detailButton, (int)(screenHeight * 0.43), SpringLayout.NORTH, contentPane);
		
		fineLayout.putConstraint(SpringLayout.WEST, updateButton, (int)(screenWidth * 0.50), SpringLayout.WEST, contentPane);
		fineLayout.putConstraint(SpringLayout.NORTH, updateButton, (int)(screenHeight * 0.85), SpringLayout.NORTH, contentPane);
		
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
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				MainGUI.switchToMenu();
			}
		});
		
		detailButton.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				int books = 0;
				int media = 0;
				
				for(Fine f : fineList){
					if(f.getFineId() == Integer.valueOf(selectedLine)){
						fine = f;
					}
				}
				if(activeUser == activeLibrarian){
					rentTrans = activeLibrarian.getRentTransaction(fine.getTransactionId());
				}else{
					rentTrans = activeAdmin.getRentTransaction(fine.getTransactionId());
				}
				
				if(rentTrans.getBookList() != null){
					books = rentTrans.getBookList().size();
					System.out.println(books);
				}
				
				if(rentTrans.getMediaList() != null){
					media = rentTrans.getMediaList().size();
					System.out.println(media);
				}
				
				JOptionPane.showMessageDialog(contentPane, "Transaction ID: " + rentTrans.getRentTransId() + 
						"\nBooks: " + books + "\nMedia: " + media);
				
			}
		});
		
		payButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(activeUser == activeLibrarian){
					activeLibrarian.payFine(Integer.valueOf(selectedLine));
				}else{
					activeAdmin.payFine(Integer.valueOf(selectedLine));
				}
				reset();
				update();
			}
		});
		
		updateButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				reset();
				update();
			}
		});
		

	}
	public void reset() {
		fineList = null;
		fineResults = "";
		listField.setText("");
	}
	
	public void update() {
		if(listField.getText().equals("")) {
			if(activeUser == activeLibrarian){
				fineList = activeLibrarian.getAllUnpaidFines();
			}else{
				fineList = activeAdmin.getAllUnpaidFines();
			}
			
			for(Fine f : fineList) {
				fineResults += " ID: " + f.getFineId() + " || Transaction: " + f.getTransactionId()
						+ " || MemberID: " + f.getMemberId() + " || Amount: " + f.getFineAmount() + System.lineSeparator();
			}
			listField.setText(fineResults);
		}
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
}
