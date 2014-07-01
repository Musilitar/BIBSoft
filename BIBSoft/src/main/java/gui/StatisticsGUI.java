package gui;

import static gui.LoginGUI.*;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class StatisticsGUI {
	private JPanel contentPane = new JPanel(), contentPaneTopTen = new JPanel(), contentPaneTopMembers = new JPanel(), contentPaneRentStatistics = new JPanel();
	private SpringLayout statisticsLayout = new SpringLayout(), topTenLayout = new SpringLayout(), topMembersLayout = new SpringLayout(), rentStatisticsLayout = new SpringLayout();
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog statisticsDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;

	private JButton topTenButton = new JButton("Top Ten"), topMembersButton = new JButton("Top Members"), rentStatisticsButton = new JButton("Rent Statistics");
	
	private JButton localMembers = new JButton("Update"), localMembersMonth = new JButton("Update");
	
	private JLabel topMembersAllTime = new JLabel("Top 10 Members"), topMembersMonth = new JLabel("Top 10 Members of the month"),
			topLocalMembers = new JLabel("Top 10 Local Members"), topLocalMembersMonth = new JLabel("Top 10 Local Members of the month"),
			pcAllTime = new JLabel("Postcode"), pcMonth = new JLabel("Postcode");
	private JTextField pcAllTimeField = new JTextField(10), pcMonthField = new JTextField(10);
	private JTextArea topMembersAllTimeList = new JTextArea(10, 20), topMembersMonthList = new JTextArea(10, 20),
			topLocalMembersList = new JTextArea(10, 20), topLocalMembersMonthList = new JTextArea(10, 20);
	
	private JButton backButton = new JButton("Back"), backButtonTopTen = new JButton("Back"), backButtonTopMembers = new JButton("Back"),
			backButtonRentStatistics = new JButton("Back");
	
	private JLabel rentsPerMonth = new JLabel("Total Rents This Month");
	private JTextField rentsPerMonthField = new JTextField(10);
	
	private String topTenResults = "";
	
	private JLabel topTenBooksRented = new JLabel("Top Ten Books Rented"), topTenBooksReserved = new JLabel("Top Ten Books Reserved"),
			topTenDVDRented = new JLabel("Top Ten DVD Rented"), topTenDVDReserved = new JLabel("Top Ten DVD Reserved"),
			topTenCDRented = new JLabel("Top Ten CD Rented"), topTenCDReserved = new JLabel("Top Ten CD Reserved");
	private JTextArea topTenBooksRentedList = new JTextArea(10, 20), topTenBooksReservedList = new JTextArea(10, 20),
			topTenDVDRentedList = new JTextArea(10, 20), topTenDVDReservedList = new JTextArea(10, 20),
			topTenCDRentedList = new JTextArea(10, 20), topTenCDReservedList = new JTextArea(10, 20);
	
	public StatisticsGUI(){
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(statisticsDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;
		
		//Fill container
		contentPane.setLayout(statisticsLayout);
		contentPane.add(backButton);
		contentPane.add(topTenButton);
		contentPane.add(topMembersButton);
		contentPane.add(rentStatisticsButton);
		
		contentPaneTopMembers.setLayout(topMembersLayout);
		contentPaneTopMembers.add(backButtonTopMembers);
		contentPaneTopMembers.add(topMembersAllTime);
		contentPaneTopMembers.add(topMembersAllTimeList);
		contentPaneTopMembers.add(topMembersMonth);
		contentPaneTopMembers.add(pcAllTime);
		contentPaneTopMembers.add(pcAllTimeField);
		contentPaneTopMembers.add(topMembersMonthList);
		contentPaneTopMembers.add(localMembersMonth);
		contentPaneTopMembers.add(topLocalMembers);
		contentPaneTopMembers.add(localMembers);
		contentPaneTopMembers.add(topLocalMembersList);
		contentPaneTopMembers.add(topLocalMembersMonth);
		contentPaneTopMembers.add(pcMonth);
		contentPaneTopMembers.add(pcMonthField);
		contentPaneTopMembers.add(topLocalMembersMonthList);
		
		topMembersAllTimeList.setEditable(false);
		topMembersMonthList.setEditable(false);
		topLocalMembersList.setEditable(false);
		topLocalMembersMonthList.setEditable(false);
		
		contentPaneTopTen.setLayout(topTenLayout);
		contentPaneTopTen.add(topTenBooksRented);
		contentPaneTopTen.add(topTenBooksRentedList);
		contentPaneTopTen.add(topTenBooksReserved);
		contentPaneTopTen.add(topTenBooksReservedList);
		contentPaneTopTen.add(topTenDVDRented);
		contentPaneTopTen.add(topTenDVDRentedList);
		contentPaneTopTen.add(topTenDVDReserved);
		contentPaneTopTen.add(topTenDVDReservedList);
		contentPaneTopTen.add(topTenCDRented);
		contentPaneTopTen.add(topTenCDRentedList);
		contentPaneTopTen.add(topTenCDReserved);
		contentPaneTopTen.add(topTenCDReservedList);
		contentPaneTopTen.add(backButtonTopTen);
		
		topTenBooksRentedList.setEditable(false);
		topTenBooksReservedList.setEditable(false);
		topTenDVDRentedList.setEditable(false);
		topTenDVDReservedList.setEditable(false);
		topTenCDRentedList.setEditable(false);
		topTenCDReservedList.setEditable(false);
		
		contentPaneRentStatistics.setLayout(rentStatisticsLayout);
		contentPaneRentStatistics.add(rentsPerMonth);
		contentPaneRentStatistics.add(rentsPerMonthField);
		contentPaneRentStatistics.add(backButtonRentStatistics);
		
		rentsPerMonthField.setEditable(false);
		
		//Placement of components on screen
		statisticsLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		statisticsLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
		
		statisticsLayout.putConstraint(SpringLayout.WEST, topTenButton, (int)(screenWidth * 0.45), SpringLayout.WEST, contentPane);
		statisticsLayout.putConstraint(SpringLayout.NORTH, topTenButton, (int)(screenHeight * 0.40), SpringLayout.NORTH, contentPane);
		
		statisticsLayout.putConstraint(SpringLayout.WEST, topMembersButton, (int)(screenWidth * 0.45), SpringLayout.WEST, contentPane);
		statisticsLayout.putConstraint(SpringLayout.NORTH, topMembersButton, (int)(screenHeight * 0.45), SpringLayout.NORTH, contentPane);
		
		statisticsLayout.putConstraint(SpringLayout.WEST, rentStatisticsButton, (int)(screenWidth * 0.45), SpringLayout.WEST, contentPane);
		statisticsLayout.putConstraint(SpringLayout.NORTH, rentStatisticsButton, (int)(screenHeight * 0.50), SpringLayout.NORTH, contentPane);
		
		topTenLayout.putConstraint(SpringLayout.WEST, backButtonTopTen, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		topTenLayout.putConstraint(SpringLayout.NORTH, backButtonTopTen, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
		
		topTenLayout.putConstraint(SpringLayout.WEST, topTenBooksRented, (int)(screenWidth * 0.13), SpringLayout.WEST, contentPaneTopTen);
		topTenLayout.putConstraint(SpringLayout.NORTH, topTenBooksRented, (int)(screenHeight * 0.2), SpringLayout.NORTH, contentPaneTopTen);
		
		topTenLayout.putConstraint(SpringLayout.WEST, topTenBooksRentedList, (int)(screenWidth * 0.13), SpringLayout.WEST, contentPaneTopTen);
		topTenLayout.putConstraint(SpringLayout.NORTH, topTenBooksRentedList, (int)(screenHeight * 0.22), SpringLayout.NORTH, contentPaneTopTen);
		
		topTenLayout.putConstraint(SpringLayout.WEST, topTenBooksReserved, (int)(screenWidth * 0.13), SpringLayout.WEST, contentPaneTopTen);
		topTenLayout.putConstraint(SpringLayout.NORTH, topTenBooksReserved, (int)(screenHeight * 0.50), SpringLayout.NORTH, contentPaneTopTen);
		
		topTenLayout.putConstraint(SpringLayout.WEST, topTenBooksReservedList, (int)(screenWidth * 0.13), SpringLayout.WEST, contentPaneTopTen);
		topTenLayout.putConstraint(SpringLayout.NORTH, topTenBooksReservedList, (int)(screenHeight * 0.52), SpringLayout.NORTH, contentPaneTopTen);
		
		topTenLayout.putConstraint(SpringLayout.WEST, topTenDVDRented, (int)(screenWidth * 0.43), SpringLayout.WEST, contentPaneTopTen);
		topTenLayout.putConstraint(SpringLayout.NORTH, topTenDVDRented, (int)(screenHeight * 0.2), SpringLayout.NORTH, contentPaneTopTen);
		
		topTenLayout.putConstraint(SpringLayout.WEST, topTenDVDRentedList, (int)(screenWidth * 0.43), SpringLayout.WEST, contentPaneTopTen);
		topTenLayout.putConstraint(SpringLayout.NORTH, topTenDVDRentedList, (int)(screenHeight * 0.22), SpringLayout.NORTH, contentPaneTopTen);
		
		topTenLayout.putConstraint(SpringLayout.WEST, topTenDVDReserved, (int)(screenWidth * 0.43), SpringLayout.WEST, contentPaneTopTen);
		topTenLayout.putConstraint(SpringLayout.NORTH, topTenDVDReserved, (int)(screenHeight * 0.50), SpringLayout.NORTH, contentPaneTopTen);
		
		topTenLayout.putConstraint(SpringLayout.WEST, topTenDVDReservedList, (int)(screenWidth * 0.43), SpringLayout.WEST, contentPaneTopTen);
		topTenLayout.putConstraint(SpringLayout.NORTH, topTenDVDReservedList, (int)(screenHeight * 0.52), SpringLayout.NORTH, contentPaneTopTen);
		
		topTenLayout.putConstraint(SpringLayout.WEST, topTenCDRented, (int)(screenWidth * 0.73), SpringLayout.WEST, contentPaneTopTen);
		topTenLayout.putConstraint(SpringLayout.NORTH, topTenCDRented, (int)(screenHeight * 0.2), SpringLayout.NORTH, contentPaneTopTen);
		
		topTenLayout.putConstraint(SpringLayout.WEST, topTenCDRentedList, (int)(screenWidth * 0.73), SpringLayout.WEST, contentPaneTopTen);
		topTenLayout.putConstraint(SpringLayout.NORTH, topTenCDRentedList, (int)(screenHeight * 0.22), SpringLayout.NORTH, contentPaneTopTen);
		
		topTenLayout.putConstraint(SpringLayout.WEST, topTenCDReserved, (int)(screenWidth * 0.73), SpringLayout.WEST, contentPaneTopTen);
		topTenLayout.putConstraint(SpringLayout.NORTH, topTenCDReserved, (int)(screenHeight * 0.50), SpringLayout.NORTH, contentPaneTopTen);
		
		topTenLayout.putConstraint(SpringLayout.WEST, topTenCDReservedList, (int)(screenWidth * 0.73), SpringLayout.WEST, contentPaneTopTen);
		topTenLayout.putConstraint(SpringLayout.NORTH, topTenCDReservedList, (int)(screenHeight * 0.52), SpringLayout.NORTH, contentPaneTopTen);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, backButtonTopMembers, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, backButtonTopMembers, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, topMembersAllTime, (int)(screenWidth * 0.30), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, topMembersAllTime, (int)(screenHeight * 0.2), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, topMembersAllTimeList, (int)(screenWidth * 0.30), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, topMembersAllTimeList, (int)(screenHeight * 0.22), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, topMembersMonth, (int)(screenWidth * 0.60), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, topMembersMonth, (int)(screenHeight * 0.2), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, topMembersMonthList, (int)(screenWidth * 0.60), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, topMembersMonthList, (int)(screenHeight * 0.22), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, topLocalMembers, (int)(screenWidth * 0.30), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, topLocalMembers, (int)(screenHeight * 0.50), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, pcAllTime, (int)(screenWidth * 0.30), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, pcAllTime, (int)(screenHeight * 0.53), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, pcAllTimeField, (int)(screenWidth * 0.35), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, pcAllTimeField, (int)(screenHeight * 0.53), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, topLocalMembersList, (int)(screenWidth * 0.30), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, topLocalMembersList, (int)(screenHeight * 0.56), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, localMembers, (int)(screenWidth * 0.30), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, localMembers, (int)(screenHeight * 0.775), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, topLocalMembersMonth, (int)(screenWidth * 0.60), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, topLocalMembersMonth, (int)(screenHeight * 0.50), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, pcMonth, (int)(screenWidth * 0.60), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, pcMonth, (int)(screenHeight * 0.53), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, pcMonthField, (int)(screenWidth * 0.65), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, pcMonthField, (int)(screenHeight * 0.53), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, topLocalMembersMonthList, (int)(screenWidth * 0.60), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, topLocalMembersMonthList, (int)(screenHeight * 0.56), SpringLayout.NORTH, contentPaneTopMembers);
		
		topMembersLayout.putConstraint(SpringLayout.WEST, localMembersMonth, (int)(screenWidth * 0.60), SpringLayout.WEST, contentPaneTopMembers);
		topMembersLayout.putConstraint(SpringLayout.NORTH, localMembersMonth, (int)(screenHeight * 0.775), SpringLayout.NORTH, contentPaneTopMembers);
		
		rentStatisticsLayout.putConstraint(SpringLayout.WEST, backButtonRentStatistics, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPaneRentStatistics);
		rentStatisticsLayout.putConstraint(SpringLayout.NORTH, backButtonRentStatistics, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPaneRentStatistics);
		
		rentStatisticsLayout.putConstraint(SpringLayout.WEST, rentsPerMonth, (int)(screenWidth * 0.40), SpringLayout.WEST, contentPaneRentStatistics);
		rentStatisticsLayout.putConstraint(SpringLayout.NORTH, rentsPerMonth, (int)(screenHeight * 0.40), SpringLayout.NORTH, contentPaneRentStatistics);
		
		rentStatisticsLayout.putConstraint(SpringLayout.WEST, rentsPerMonthField, (int)(screenWidth * 0.55), SpringLayout.WEST, contentPaneRentStatistics);
		rentStatisticsLayout.putConstraint(SpringLayout.NORTH, rentsPerMonthField, (int)(screenHeight * 0.40), SpringLayout.NORTH, contentPaneRentStatistics);
		
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				MainGUI.switchToMenu();
			}
		});
		
		backButtonTopTen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				MainGUI.switchToStatistics();
			}
		});
		
		backButtonTopMembers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				MainGUI.switchToStatistics();
				reset();
			}
		});
		
		backButtonRentStatistics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				MainGUI.switchToStatistics();
				reset();
			}
		});
		
		topTenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				ArrayList<String> stringList = new ArrayList<String>();
				MainGUI.switchToStatisticsTopTen();
				if(activeUser == activeAdmin){
					stringList = activeAdmin.top10BooksRented();
					fillList(topTenBooksRentedList, stringList);
					stringList = activeAdmin.top10BooksReserved();
					fillList(topTenBooksReservedList, stringList);
					stringList = activeAdmin.top10DVDRented();
					fillList(topTenDVDRentedList, stringList);
					stringList = activeAdmin.top10DVDReserved();
					fillList(topTenDVDReservedList, stringList);
					stringList = activeAdmin.top10CDRented();
					fillList(topTenCDRentedList, stringList);
					stringList = activeAdmin.top10CDReserved();
					fillList(topTenCDReservedList, stringList);
				}else if(activeUser == activeManager){
					stringList = activeManager.top10BooksRented();
					fillList(topTenBooksRentedList, stringList);
					stringList = activeManager.top10BooksReserved();
					fillList(topTenBooksReservedList, stringList);
					stringList = activeManager.top10DVDRented();
					fillList(topTenDVDRentedList, stringList);
					stringList = activeManager.top10DVDReserved();
					fillList(topTenDVDReservedList, stringList);
					stringList = activeManager.top10CDRented();
					fillList(topTenCDRentedList, stringList);
					stringList = activeManager.top10CDReserved();
					fillList(topTenCDReservedList, stringList);
				}
				
			}
		});
		
		topMembersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				MainGUI.switchToStatisticsTopMembers();
				ArrayList<String> stringList = new ArrayList<String>();
				if(activeUser == activeAdmin){
					stringList = activeAdmin.topTenMembersAllTime();
					fillList(topMembersAllTimeList, stringList);
					stringList = activeAdmin.topTenMembersMonth();
					fillList(topMembersMonthList, stringList);
				}
				
			}
		});
		
		localMembers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				ArrayList<String> stringList = new ArrayList<String>();
				if(activeUser == activeAdmin){
					stringList = activeAdmin.topTenLocalMembersAllTime(Integer.valueOf(pcAllTimeField.getText()));
					fillList(topLocalMembersList, stringList);
				}
				
			}
		});
		
		localMembersMonth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				ArrayList<String> stringList = new ArrayList<String>();
				if(activeUser == activeAdmin){
					stringList = activeAdmin.topTenLocalMembersMonth(Integer.valueOf(pcMonthField.getText()));
					fillList(topLocalMembersMonthList, stringList);
				}
				
			}
		});
		
		rentStatisticsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				MainGUI.switchToRentStatistics();
				if(activeUser == activeAdmin){
					rentsPerMonthField.setText(String.valueOf(activeAdmin.rentStatisticsForThisMonth()));
				}
			}
		});
		
		
	}
	
	public void fillList(JTextArea field, ArrayList<String> stringList){
		for(String s : stringList){
			topTenResults += s + System.lineSeparator();
		}
		field.setText(topTenResults);
		topTenResults = "";
	}
	
	public void reset(){
		topLocalMembersMonthList.setText("");
		topLocalMembersList.setText("");
		topMembersAllTimeList.setText("");
		topMembersMonthList.setText("");
		pcAllTimeField.setText("");
		pcMonthField.setText("");
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
	
	public JPanel getContentPaneTopTen(){
		return contentPaneTopTen;
	}
	
	public JPanel getContentPaneMembers(){
		return contentPaneTopMembers;
	}
	
	public JPanel getContentPaneRentStatistics(){
		return contentPaneRentStatistics;
	}
}
