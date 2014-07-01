package gui;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import static gui.LoginGUI.*;
import dao.MediaCopyDAO;
import dao.MediaDAO;
import dao.StringDateSwitcher;
import logic.Media;
import logic.MediaCopy;
import logic.Product;

public class MediaGUI {
	private JPanel contentPane = new JPanel();
	private JPanel contentPaneCheck = new JPanel();
	private SpringLayout mediaLayout = new SpringLayout(), checkLayout = new SpringLayout();
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog mediaDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;
	private JLabel IDLabel = new JLabel("ID:"), titleLabel = new JLabel("Title:"), creatorLabel = new JLabel("Artist/Director:"),
			yearLabel = new JLabel("Year:"), placeLabel = new JLabel("Place:"),
			producerLabel = new JLabel("Producer:"), genreLabel = new JLabel("Genre:"), typeLabel = new JLabel("Type:"),
			checkTitleLabel = new JLabel("Title to check:"), checkTypeLabel = new JLabel("Type:");
	private JTextField IDField = new JTextField(), titleField = new JTextField(), creatorField = new JTextField(),
			yearField = new JTextField(), placeField = new JTextField(), producerField = new JTextField(),
			genreField = new JTextField(), typeField = new JTextField(), checkTitleField = new JTextField(), checkTypeField = new JTextField();
	private JButton mediaButton = new JButton("Add");
	private JButton checkButton = new JButton("Check");
	private JButton backButton = new JButton("Back"), backButton2 = new JButton("Back");
	private Date date;
	private MediaCopy mc;
	private boolean forEdit = false;
	
	public MediaGUI(){
		//Get size of screen without taskbar
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(mediaDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;
		
		//Fill container
		contentPaneCheck.setLayout(checkLayout);
		contentPaneCheck.add(backButton2);
		contentPaneCheck.add(checkTitleLabel);
		contentPaneCheck.add(checkTypeLabel);
		contentPaneCheck.add(checkTitleField);
		contentPaneCheck.add(checkTypeField);
		contentPaneCheck.add(checkButton);
		contentPane.setLayout(mediaLayout);
		contentPane.add(backButton);
		contentPane.add(IDLabel);
		contentPane.add(IDField);
		contentPane.add(titleLabel);
		contentPane.add(titleField);
		contentPane.add(creatorLabel);
		contentPane.add(creatorField);
		contentPane.add(yearLabel);
		contentPane.add(yearField);
		contentPane.add(placeLabel);
		contentPane.add(placeField);
		contentPane.add(producerLabel);
		contentPane.add(producerField);
		contentPane.add(genreLabel);
		contentPane.add(genreField);
		contentPane.add(typeLabel);
		contentPane.add(typeField);
		contentPane.add(mediaButton);
		
		//Prepare frame components
		IDField.setColumns(20);
		titleField.setColumns(20);
		creatorField.setColumns(20);
		yearField.setColumns(20);
		placeField.setColumns(20);
		producerField.setColumns(20);
		genreField.setColumns(20);
		typeField.setColumns(20);
		checkTitleField.setColumns(20);
		checkTypeField.setColumns(20);
		
		//Placement of components on screen
		checkLayout.putConstraint(SpringLayout.WEST, backButton2, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPaneCheck);
		checkLayout.putConstraint(SpringLayout.NORTH, backButton2, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPaneCheck);
		
		checkLayout.putConstraint(SpringLayout.WEST, checkTitleLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPaneCheck);
		checkLayout.putConstraint(SpringLayout.NORTH, checkTitleLabel, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPaneCheck);
				
		checkLayout.putConstraint(SpringLayout.WEST, checkTitleField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPaneCheck);
		checkLayout.putConstraint(SpringLayout.NORTH, checkTitleField, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPaneCheck);
		
		checkLayout.putConstraint(SpringLayout.WEST, checkTypeLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPaneCheck);
		checkLayout.putConstraint(SpringLayout.NORTH, checkTypeLabel, (int)(screenHeight * 0.43), SpringLayout.NORTH, contentPaneCheck);
				
		checkLayout.putConstraint(SpringLayout.WEST, checkTypeField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPaneCheck);
		checkLayout.putConstraint(SpringLayout.NORTH, checkTypeField, (int)(screenHeight * 0.43), SpringLayout.NORTH, contentPaneCheck);
			
		checkLayout.putConstraint(SpringLayout.WEST, checkButton, (int)(screenWidth * 0.63), SpringLayout.WEST, contentPaneCheck);
		checkLayout.putConstraint(SpringLayout.NORTH, checkButton, (int)(screenHeight * 0.365), SpringLayout.NORTH, contentPaneCheck);
				
		mediaLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, IDLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, IDLabel, (int)(screenHeight * 0.25), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, IDField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, IDField, (int)(screenHeight * 0.25), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, titleLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, titleLabel, (int)(screenHeight * 0.30), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, titleField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, titleField, (int)(screenHeight * 0.30), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, creatorLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, creatorLabel, (int)(screenHeight * 0.35), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, creatorField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, creatorField, (int)(screenHeight * 0.35), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, yearLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, yearLabel, (int)(screenHeight * 0.40), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, yearField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, yearField, (int)(screenHeight * 0.40), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, placeLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, placeLabel, (int)(screenHeight * 0.45), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, placeField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, placeField, (int)(screenHeight * 0.45), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, producerLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, producerLabel, (int)(screenHeight * 0.50), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, producerField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, producerField, (int)(screenHeight * 0.50), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, genreLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, genreLabel, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, genreField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, genreField, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, typeLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, typeLabel, (int)(screenHeight * 0.60), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, typeField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, typeField, (int)(screenHeight * 0.60), SpringLayout.NORTH, contentPane);
				
		mediaLayout.putConstraint(SpringLayout.WEST, mediaButton, (int)(screenWidth * 0.52), SpringLayout.WEST, contentPane);
		mediaLayout.putConstraint(SpringLayout.NORTH, mediaButton, (int)(screenHeight * 0.725) , SpringLayout.NORTH, contentPane);
	
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if(!forEdit){
					MainGUI.switchToMenu();
				}else{
					MainGUI.switchToMediaList();
				}
			}
			
		});
		
		backButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				MainGUI.switchToMenu();
			}
		});
	
		checkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String title = checkTitleField.getText();
				String type = checkTypeField.getText();
				Media media;
				if(activeUser == activeLibrarian){
					media = activeLibrarian.checkMedia(title, type);
				}else{
					media = activeAdmin.checkMedia(title, type);
				}
				if(media == null) {
					MainGUI.switchToMedia();
					titleField.setText(title);
					typeField.setText(type);
					IDField.setVisible(false);
					IDLabel.setVisible(false);
				}
				else {
					MainGUI.switchToMedia();
					IDField.setText(String.valueOf(media.getMediaID()));
					IDField.setEditable(false);
					titleField.setText(media.getTitle());
					titleField.setEditable(false);
					creatorField.setText(media.getCreator());
					creatorField.setEditable(false);
					yearField.setText(StringDateSwitcher.dateToStringYear(media.getYearEdition()));
					yearField.setEditable(false);
					placeField.setText(media.getPublicationPlace());
					placeField.setEditable(false);
					producerField.setText(media.getProducer());
					producerField.setEditable(false);
					genreField.setText(media.getGenre());
					genreField.setEditable(false);
					typeField.setText(media.getType());
					typeField.setEditable(false);
				}
			}
		});
		
		mediaButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!forEdit){
					try {
						date = new SimpleDateFormat("yyyy").parse(yearField.getText());
						MediaCopy mediaCopy = new MediaCopy(date, placeField.getText(), titleField.getText(), genreField.getText(),
								creatorField.getText(), producerField.getText(),typeField.getText().toUpperCase());
						if(Product.validatePublicationPlace(placeField.getText())==true){
							if(Product.validateGenre(genreField.getText())==true){
								if(Media.validateCreator(creatorField.getText())==true){
									if(Media.validateProducer(producerField.getText())==true){
										if(activeUser == activeLibrarian){
											activeLibrarian.addMedia(mediaCopy);
											MediaDAO.UpperCreator();
											MediaDAO.UpperGenre();
											MediaDAO.UpperPlaceOfPublication();
											MediaDAO.UpperProducer();
											MediaDAO.UpperTitle();
											MediaDAO.UpperType();
										}else{
											activeAdmin.addMedia(mediaCopy);
											MediaDAO.UpperCreator();
											MediaDAO.UpperGenre();
											MediaDAO.UpperPlaceOfPublication();
											MediaDAO.UpperProducer();
											MediaDAO.UpperTitle();
											MediaDAO.UpperType();
										}
										JOptionPane.showMessageDialog(contentPane, "Media opgeslagen");
										reset();
										MainGUI.switchToMediaCheck();
									}
									else
										JOptionPane.showMessageDialog(contentPane, "Producer not correct. Has to be at least 1 character long and can have spaces and '-', '¨', '.' and ';' as special characters.");
									}
								else
									JOptionPane.showMessageDialog(contentPane, "Creator not correct. Has to be at least 2 characters long and can have spaces and '-' as special characters.");
							}
							else
								JOptionPane.showMessageDialog(contentPane, "Genre not correct. Has to be at least 3 characters long.");
						}
						else
							JOptionPane.showMessageDialog(contentPane, "Place of publication not correct. Has to be at least 1 character long and can have spaces and '-', '¨', '.' and ';' as special characters.");
										
									
								
									
							
							
						
					} catch (NumberFormatException | ParseException | NullPointerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					try {
						date = new SimpleDateFormat("yyyy").parse(yearField.getText());
						Media media = new Media(date, placeField.getText(), titleField.getText(), genreField.getText(), Integer.parseInt(IDField.getText()),
								creatorField.getText(), producerField.getText(),typeField.getText().toUpperCase());
						if(Product.validatePublicationPlace(placeField.getText())==true){
							if(Product.validateGenre(genreField.getText())==true){
								if(Media.validateCreator(creatorField.getText())==true){
									if(Media.validateProducer(producerField.getText())==true){
										if(activeUser == activeLibrarian){
											activeLibrarian.editMedia(media);
											MediaDAO.UpperCreator();
											MediaDAO.UpperGenre();
											MediaDAO.UpperPlaceOfPublication();
											MediaDAO.UpperProducer();
											MediaDAO.UpperTitle();
											MediaDAO.UpperType();
										}else{
											activeAdmin.editMedia(media);
											MediaDAO.UpperCreator();
											MediaDAO.UpperGenre();
											MediaDAO.UpperPlaceOfPublication();
											MediaDAO.UpperProducer();
											MediaDAO.UpperTitle();
											MediaDAO.UpperType();
										}
										JOptionPane.showMessageDialog(contentPane, "Media gewijzigd");
										reset();
										MainGUI.switchToMediaList();
										
											
										
									}
									else
										JOptionPane.showMessageDialog(contentPane, "Producer not correct. Has to be at least 1 character long and can have spaces and '-', '¨', '.' and ';' as special characters.");
									}
								else
									JOptionPane.showMessageDialog(contentPane, "Creator not correct. Has to be at least 2 characters long and can have spaces and '-' as special characters.");
							}
							else
								JOptionPane.showMessageDialog(contentPane, "Genre not correct. Has to be at least 3 characters long.");
						}
						else
							JOptionPane.showMessageDialog(contentPane, "Place of publication not correct. Has to be at least 1 character long and can have spaces and '-', '¨', '.' and ';' as special characters.");
										
						
					} catch (NumberFormatException | ParseException | NullPointerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
	
	}
	
	public void reset() {
		IDField.setText("");
		titleField.setText("");
		creatorField.setText("");
		yearField.setText("");
		placeField.setText("");
		producerField.setText("");
		genreField.setText("");
		typeField.setText("");
		checkTitleField.setText("");
		checkTypeField.setText("");
		forEdit = false;
	}
	
	public void setForEdit(boolean forEdit){
		this.forEdit = forEdit;
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
	
	public JPanel getContentPaneCheck() {
		return contentPaneCheck;
	}
	
	//Inner class MediaListGUI
		public class MediaListGUI {
			private JPanel contentPane = new JPanel();
			private SpringLayout mediaLayout = new SpringLayout();
			private Dimension screenSize;
			private Insets screenMax;
			private JDialog mediaDialog = new JDialog();
			private int taskbarSize;
			private int screenWidth, screenHeight;
			private JTextArea listField = new JTextArea(25, 80);
			private JScrollPane listScrollPane = new JScrollPane(listField);
			private JButton deleteButton = new JButton("Delete");
			private JButton editButton = new JButton("Edit");
			private JButton addButton =  new JButton("Add");
			private JButton backButton = new JButton("Back");
			private JTextField searchField = new JTextField(20);
			private JLabel searchLabel = new JLabel("Search: ");
			private String[] pattern = {" Title"," Genre"," Creator"," ID"};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			private JComboBox mediaBox = new JComboBox(pattern);
			private String a = " Title";
			private Color selectionColor = new Color(96, 158, 240);
			
			private String selectedLine;
			private Boolean selectionMade = false;
			
			private ArrayList<MediaCopy> mediaCopyList;
			private String mediaCopyResults;
			
			public MediaListGUI() {
			//Get size of screen without taskbar
					screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					screenMax = Toolkit.getDefaultToolkit().getScreenInsets(mediaDialog.getGraphicsConfiguration());
					taskbarSize = screenMax.bottom;
					screenWidth = (int)screenSize.getWidth();
					screenHeight = (int)screenSize.getHeight() - taskbarSize;
					
					//Fill container
					contentPane.setLayout(mediaLayout);
					contentPane.add(backButton);
					contentPane.add(addButton);
					contentPane.add(deleteButton);
					contentPane.add(editButton);
					contentPane.add(listScrollPane);
					contentPane.add(searchField);
					contentPane.add(mediaBox);
					
					//Prepare frame components
					listField.setEditable(false);
					listField.setSelectionColor(selectionColor);
					listField.setBorder(BorderFactory.createEmptyBorder());
					
					//Placement of components on screen
					mediaLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
					mediaLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
					
					mediaLayout.putConstraint(SpringLayout.WEST, listScrollPane, (int)(screenWidth * 0.25), SpringLayout.WEST, contentPane);
					mediaLayout.putConstraint(SpringLayout.NORTH, listScrollPane, (int)(screenHeight * 0.25), SpringLayout.NORTH, contentPane);
					
					mediaLayout.putConstraint(SpringLayout.WEST, addButton, (int)(screenWidth * 0.81), SpringLayout.WEST, contentPane);
					mediaLayout.putConstraint(SpringLayout.NORTH, addButton, (int)(screenHeight * 0.41), SpringLayout.NORTH, contentPane);
					
					mediaLayout.putConstraint(SpringLayout.WEST, deleteButton, (int)(screenWidth * 0.81), SpringLayout.WEST, contentPane);
					mediaLayout.putConstraint(SpringLayout.NORTH, deleteButton, (int)(screenHeight * 0.46), SpringLayout.NORTH, contentPane);
					
					mediaLayout.putConstraint(SpringLayout.WEST, editButton, (int)(screenWidth * 0.81), SpringLayout.WEST, contentPane);
					mediaLayout.putConstraint(SpringLayout.NORTH, editButton, (int)(screenHeight * 0.51), SpringLayout.NORTH, contentPane);
					
					mediaLayout.putConstraint(SpringLayout.WEST, searchLabel, (int)(screenWidth * 0.4), SpringLayout.WEST, contentPane);
					mediaLayout.putConstraint(SpringLayout.NORTH, searchLabel, (int)(screenHeight * 0.21), SpringLayout.NORTH, contentPane);
					
					mediaLayout.putConstraint(SpringLayout.WEST, searchField, (int)(screenWidth * 0.43), SpringLayout.WEST, contentPane);
					mediaLayout.putConstraint(SpringLayout.NORTH, searchField, (int)(screenHeight * 0.21), SpringLayout.NORTH, contentPane);
					
					mediaLayout.putConstraint(SpringLayout.WEST, mediaBox, (int)(screenWidth * 0.58), SpringLayout.WEST, contentPane);
					mediaLayout.putConstraint(SpringLayout.NORTH, mediaBox, (int)(screenHeight * 0.21), SpringLayout.NORTH, contentPane);
					
					
					
					addButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							MainGUI.switchToMediaCheck();
						}

					});
					
					editButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							MainGUI.switchToMedia(true);
							mc = MediaDAO.getMediaCopyByMediaCopyID(Integer.valueOf(selectedLine));
							
							IDField.setText(String.valueOf(mc.getMediaID()));
							titleField.setText(mc.getTitle());
							creatorField.setText(mc.getCreator());
							yearField.setText(StringDateSwitcher.dateToStringYear(mc.getYearEdition()));
							placeField.setText(mc.getPublicationPlace());
							producerField.setText(mc.getProducer());
							genreField.setText(mc.getGenre());
							typeField.setText(mc.getType());
						
							MediaGUI.this.mediaButton.setText("Save");
						}
						
					});
					
					backButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							MainGUI.switchToMenu();
						}
						
					});
					
					mediaButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							reset();
							update();
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
								MediaCopy selectedMediaCopy = null;
								for(MediaCopy mc : mediaCopyList) {
									if(mc.getMediaCopyID() == Integer.valueOf(selectedLine)) {
										selectedMediaCopy = mc;
									}
								}
								if(activeUser == activeLibrarian){
									activeLibrarian.removeMediaCopy(selectedMediaCopy);
								}else{
									activeAdmin.removeMediaCopy(selectedMediaCopy);
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
							if(a==" Title")
							{
								if(listField.getText().equals("")) {
									mediaCopyList = MediaCopyDAO.searchMediaByTitle(text);
									for(MediaCopy mc : mediaCopyList) {
										mediaCopyResults += " ID: " + mc.getMediaCopyID() + " || Media ID: " + mc.getMediaID() + " || Title: " + mc.getTitle() + " || Artist/Director: " + mc.getCreator() + " || Genre: " + mc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(mc.getYearEdition()) + " || Producer: " + mc.getProducer()
												+ " || Place of Publication: " + mc.getPublicationPlace() + " || Type: " + mc.getType() + " || Lendable: " + mc.getLendable() + System.lineSeparator();
									}
									listField.setText(mediaCopyResults);
								}
							}
							if(a==" Genre")
							{
								if(listField.getText().equals("")){
									mediaCopyList = MediaCopyDAO.searchMediaByGenre(text);
									for(MediaCopy mc : mediaCopyList) {
										mediaCopyResults += " ID: " + mc.getMediaCopyID() + " || Media ID: " + mc.getMediaID() + " || Title: " + mc.getTitle() + " || Artist/Director: " + mc.getCreator() + " || Genre: " + mc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(mc.getYearEdition()) + " || Producer: " + mc.getProducer()
												+ " || Place of Publication: " + mc.getPublicationPlace() + " || Type: " + mc.getType() + " || Lendable: " + mc.getLendable() + System.lineSeparator();
									}
									listField.setText(mediaCopyResults);
								}
							}
							if(a==" Creator")
							{
								if(listField.getText().equals("")){
									mediaCopyList = MediaCopyDAO.searchMediaByCreator(text);
									for(MediaCopy mc : mediaCopyList) {
										mediaCopyResults += " ID: " + mc.getMediaCopyID() + " || Media ID: " + mc.getMediaID() + " || Title: " + mc.getTitle() + " || Artist/Director: " + mc.getCreator() + " || Genre: " + mc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(mc.getYearEdition()) + " || Producer: " + mc.getProducer()
												+ " || Place of Publication: " + mc.getPublicationPlace() + " || Type: " + mc.getType() + " || Lendable: " + mc.getLendable() + System.lineSeparator();
									}
									listField.setText(mediaCopyResults);
								}
							}
							if(a==" ID")
							{
								if(listField.getText().equals("")){
									mediaCopyList = MediaCopyDAO.searchMediaByID(text);
									for(MediaCopy mc : mediaCopyList) {
										mediaCopyResults += " ID: " + mc.getMediaCopyID() + " || Media ID: " + mc.getMediaID() + " || Title: " + mc.getTitle() + " || Artist/Director: " + mc.getCreator() + " || Genre: " + mc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(mc.getYearEdition()) + " || Producer: " + mc.getProducer()
												+ " || Place of Publication: " + mc.getPublicationPlace() + " || Type: " + mc.getType() + " || Lendable: " + mc.getLendable() + System.lineSeparator();
									}
									listField.setText(mediaCopyResults);
								}
							}
						}
					});
					
					mediaBox.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							@SuppressWarnings("rawtypes")
							JComboBox cb = (JComboBox)e.getSource();
							a = (String)cb.getSelectedItem();
						}
					});
			}
			
			public void reset() {
				mediaCopyList = null;
				mediaCopyResults = "";
				listField.setText("");
			}
			
			public void update() {
				if(listField.getText().equals("")) {
					if(activeUser == activeLibrarian){
						mediaCopyList = activeLibrarian.getAllMediaCopies();
					}else{
						mediaCopyList = activeAdmin.getAllMediaCopies();
					}
					
					for(MediaCopy mc : mediaCopyList) {
						mediaCopyResults += " ID: " + mc.getMediaCopyID() + " || Media ID: " + mc.getMediaID() + " || Title: " + mc.getTitle() + " || Artist/Director: " + mc.getCreator() + " || Genre: " + mc.getGenre() + " || Year: " + StringDateSwitcher.dateToStringYear(mc.getYearEdition()) + " || Producer: " + mc.getProducer()
								+ " || Place of Publication: " + mc.getPublicationPlace() + " || Type: " + mc.getType() + " || Lendable: " + mc.getLendable() + System.lineSeparator();
					}
					listField.setText(mediaCopyResults);
				}
			}
			
			public JPanel getContentPane() {
				return contentPane;
			}
			
		}
	
}
