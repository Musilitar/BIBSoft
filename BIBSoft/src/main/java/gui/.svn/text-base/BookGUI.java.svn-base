package gui;

import static dao.BookCopyDAO.*;

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
import dao.BookDAO;
import dao.StringDateSwitcher;
import logic.*;

public class BookGUI {
	private JPanel contentPane = new JPanel();
	private JPanel contentPaneCheck = new JPanel();
	private SpringLayout bookLayout = new SpringLayout(), checkLayout = new SpringLayout();
	private Dimension screenSize;
	private Insets screenMax;
	private JDialog bookDialog = new JDialog();
	private int taskbarSize;
	private int screenWidth, screenHeight;
	private JLabel titleLabel = new JLabel("Title:"), authorLabel = new JLabel("Author:"),
			yearLabel = new JLabel("Year:"), placeLabel = new JLabel("Place:"),
			publisherLabel = new JLabel("Publisher:"), genreLabel = new JLabel("Genre:"), ISBNLabel = new JLabel("ISBN:"),
			editionLabel = new JLabel("Edition:"), checkISBNLabel = new JLabel("ISBN to check:");
	private JTextField titleField = new JTextField(), authorField = new JTextField(),
			yearField = new JTextField(), placeField = new JTextField(), publisherField = new JTextField(),
			genreField = new JTextField(), ISBNField = new JTextField(), editionField = new JTextField(), checkISBNField = new JTextField();
	private JButton bookButton = new JButton("Add");
	private JButton checkButton = new JButton("Check");
	private JButton backButton = new JButton("Back"), backButton2 = new JButton("Back");
	private Date date;
	private BookCopy bc;
	private Book b;
	private boolean forEdit = false;
	
	public BookGUI() {
		//Get size of screen without taskbar
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenMax = Toolkit.getDefaultToolkit().getScreenInsets(bookDialog.getGraphicsConfiguration());
		taskbarSize = screenMax.bottom;
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight() - taskbarSize;
		
		//Fill container
		contentPaneCheck.setLayout(checkLayout);
		contentPaneCheck.add(checkISBNLabel);
		contentPaneCheck.add(checkButton);
		contentPaneCheck.add(checkISBNField);
		contentPaneCheck.add(backButton2);
		contentPane.setLayout(bookLayout);
		contentPane.add(backButton);
		contentPane.add(titleLabel);
		contentPane.add(titleField);
		contentPane.add(authorLabel);
		contentPane.add(authorField);
		contentPane.add(yearLabel);
		contentPane.add(yearField);
		contentPane.add(placeLabel);
		contentPane.add(placeField);
		contentPane.add(publisherLabel);
		contentPane.add(publisherField);
		contentPane.add(genreLabel);
		contentPane.add(genreField);
		contentPane.add(ISBNLabel);
		contentPane.add(ISBNField);
		contentPane.add(editionLabel);
		contentPane.add(editionField);
		contentPane.add(bookButton);
		
		//Prepare frame components
		titleField.setColumns(20);
		authorField.setColumns(20);
		yearField.setColumns(20);
		placeField.setColumns(20);
		publisherField.setColumns(20);
		genreField.setColumns(20);
		ISBNField.setColumns(20);
		editionField.setColumns(20);
		checkISBNField.setColumns(20);
		
		//Placement of components on screen
		checkLayout.putConstraint(SpringLayout.WEST, checkISBNLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPaneCheck);
		checkLayout.putConstraint(SpringLayout.NORTH, checkISBNLabel, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPaneCheck);
		
		checkLayout.putConstraint(SpringLayout.WEST, checkISBNField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPaneCheck);
		checkLayout.putConstraint(SpringLayout.NORTH, checkISBNField, (int)(screenHeight * 0.3703), SpringLayout.NORTH, contentPaneCheck);
		
		checkLayout.putConstraint(SpringLayout.WEST, checkButton, (int)(screenWidth * 0.63), SpringLayout.WEST, contentPaneCheck);
		checkLayout.putConstraint(SpringLayout.NORTH, checkButton, (int)(screenHeight * 0.365), SpringLayout.NORTH, contentPaneCheck);
		
		checkLayout.putConstraint(SpringLayout.WEST, backButton2, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPaneCheck);
		checkLayout.putConstraint(SpringLayout.NORTH, backButton2, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPaneCheck);
		
		bookLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
			
		bookLayout.putConstraint(SpringLayout.WEST, titleLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, titleLabel, (int)(screenHeight * 0.30), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, titleField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, titleField, (int)(screenHeight * 0.30), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, authorLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, authorLabel, (int)(screenHeight * 0.35), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, authorField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, authorField, (int)(screenHeight * 0.35), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, yearLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, yearLabel, (int)(screenHeight * 0.40), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, yearField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, yearField, (int)(screenHeight * 0.40), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, placeLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, placeLabel, (int)(screenHeight * 0.45), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, placeField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, placeField, (int)(screenHeight * 0.45), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, publisherLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, publisherLabel, (int)(screenHeight * 0.50), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, publisherField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, publisherField, (int)(screenHeight * 0.50), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, genreLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, genreLabel, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, genreField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, genreField, (int)(screenHeight * 0.55), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, ISBNLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, ISBNLabel, (int)(screenHeight * 0.60), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, ISBNField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, ISBNField, (int)(screenHeight * 0.60), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, editionLabel, (int)(screenWidth * 0.4166), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, editionLabel, (int)(screenHeight * 0.65), SpringLayout.NORTH, contentPane);
		
		bookLayout.putConstraint(SpringLayout.WEST, editionField, (int)(screenWidth * 0.48), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, editionField, (int)(screenHeight * 0.65), SpringLayout.NORTH, contentPane);
			
		bookLayout.putConstraint(SpringLayout.WEST, bookButton, (int)(screenWidth * 0.52), SpringLayout.WEST, contentPane);
		bookLayout.putConstraint(SpringLayout.NORTH, bookButton, (int)(screenHeight * 0.725) , SpringLayout.NORTH, contentPane);

		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				MainGUI.switchToMenu();
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
				String isbn = checkISBNField.getText();
				if(Book.validateISBN(checkISBNField.getText())==true){

					if(activeUser == activeLibrarian){
						b = activeLibrarian.checkBook(isbn);
					}
					else{
						b = activeAdmin.checkBook(isbn);
					}

					if(b == null) {
						System.out.println("Leeg!");
						MainGUI.switchToBook();
						ISBNField.setText(isbn);
						titleField.setEditable(true);
						authorField.setEditable(true);
						yearField.setEditable(true);
						placeField.setEditable(true);
						publisherField.setEditable(true);
						genreField.setEditable(true);
						ISBNField.setEditable(false);
					}
					else {
						MainGUI.switchToBook();
						titleField.setText(b.getTitle());
						titleField.setEditable(false);
						authorField.setText(b.getAuthor());
						authorField.setEditable(false);
						yearField.setText(StringDateSwitcher.dateToStringYear(b.getYearEdition()));
						yearField.setEditable(false);
						placeField.setText(b.getPublicationPlace());
						placeField.setEditable(false);
						publisherField.setText(b.getPublisher());
						publisherField.setEditable(false);
						genreField.setText(b.getGenre());
						genreField.setEditable(false);
						ISBNField.setText(b.getISBN());
						ISBNField.setEditable(false);
					}
				}
				else
					JOptionPane.showMessageDialog(contentPane, "ISBN not correct. Has to consist of 10 or 13 characters, either in a 3-10 or a 1-4-4-1 format.");
				
			
			}
		});
		

		
		
		
		bookButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(forEdit == false)
				{
				try {
					date = new SimpleDateFormat("yyyy").parse(yearField.getText());
					bc = new BookCopy(date, placeField.getText(), titleField.getText(), genreField.getText(),
							authorField.getText(), ISBNField.getText(), publisherField.getText(), 
							Integer.valueOf(editionField.getText()));
					if(Product.validatePublicationPlace(placeField.getText())==true){
						if(Product.validateGenre(genreField.getText())==true){
							if(Book.validateAuthor(authorField.getText())==true){
								if(Book.validateISBN(ISBNField.getText())==true){
									if(Book.validatePublisher(publisherField.getText())==true){
										if(activeUser == activeLibrarian){
											
											activeLibrarian.addBook(bc);
											BookDAO.Upperauthor();
											BookDAO.UpperGenre();
											BookDAO.UpperPlaceOfPublication();
											BookDAO.UpperPublisher();
											BookDAO.UpperTitle();

										}else{
											
											activeAdmin.addBook(bc);
											BookDAO.Upperauthor();
											BookDAO.UpperGenre();
											BookDAO.UpperPlaceOfPublication();
											BookDAO.UpperPublisher();
											BookDAO.UpperTitle();
										}
									}
									else
										JOptionPane.showMessageDialog(contentPane, "Publisher not correct. Has to be at least 1 character long and can have spaces and '-', '¨', '.' and ';' as special characters.");
								}
								else
									JOptionPane.showMessageDialog(contentPane, "ISBN not correct. Has to consist of 10 or 13 characters, either in a 3-10 or a 1-4-4-1 format.");
								
							}
							else
								JOptionPane.showMessageDialog(contentPane, "Author not correct. Has to be at least 2 characters long and can have spaces and '-', '¨', '.' and ';' as special characters.");
						}
						else
							JOptionPane.showMessageDialog(contentPane, "Genre not correct. Has to be at least 3 characters long");
					}
					else
						JOptionPane.showMessageDialog(contentPane, "Place of publication not correct. Has to be at least 1 character long and can have spaces and '-', '¨', '.' and ';' as special characters.");
					
					
					
				} catch (NumberFormatException | ParseException | NullPointerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				if(forEdit == true){
					try {
						date = new SimpleDateFormat("yyyy").parse(yearField.getText());
						b = new Book(date, placeField.getText(), titleField.getText(), genreField.getText(),
								authorField.getText(), ISBNField.getText(), publisherField.getText(),bc.getBookID());
						if(Product.validatePublicationPlace(placeField.getText())==true){
							if(Product.validateGenre(genreField.getText())==true){
								if(Book.validateAuthor(authorField.getText())==true){
									if(Book.validateISBN(ISBNField.getText())==true){
										if(Book.validatePublisher(publisherField.getText())==true){
											if(activeUser == activeLibrarian){
											    activeLibrarian.editBook(b);
												BookDAO.Upperauthor();
												BookDAO.UpperGenre();
												BookDAO.UpperPlaceOfPublication();
												BookDAO.UpperPublisher();
												BookDAO.UpperTitle();

											}else{
												
												activeAdmin.editBook(b);
												BookDAO.Upperauthor();
												BookDAO.UpperGenre();
												BookDAO.UpperPlaceOfPublication();
												BookDAO.UpperPublisher();
												BookDAO.UpperTitle();
											}
										}
										else
											JOptionPane.showMessageDialog(contentPane, "Publisher not correct. Has to be at least 1 character long and can have spaces and '-', '¨', '.' and ';' as special characters.");
									}
									else
										JOptionPane.showMessageDialog(contentPane, "ISBN not correct. Has to consist of 10 or 13 characters, either in a 3-10 or a 1-4-4-1 format.");
									
								}
								else
									JOptionPane.showMessageDialog(contentPane, "Author not correct. Has to be at least 2 characters long and can have spaces and '-', '¨', '.' and ';' as special characters.");
							}
							else
								JOptionPane.showMessageDialog(contentPane, "Genre not correct. Has to be at least 3 characters long");
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
		titleField.setText("");
		authorField.setText("");
		yearField.setText("");
		placeField.setText("");
		publisherField.setText("");
		genreField.setText("");
		ISBNField.setText("");
		editionField.setText("");
		checkISBNField.setText("");
		forEdit = false;
		bookButton.setText("Add");
	}
	public void setForEdit(boolean forEdit) {
		this.forEdit = forEdit;
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}
	
	public JPanel getContentPaneCheck() {
		return contentPaneCheck;
	}
	
	
	
	
	
	//Inner class BookListGUI
	public class BookListGUI {
		private JPanel contentPane = new JPanel();
		private SpringLayout bookLayout = new SpringLayout();
		private Dimension screenSize;
		private Insets screenMax;
		private JDialog bookDialog = new JDialog();
		private int taskbarSize;
		private int screenWidth, screenHeight;
		private JTextArea listField = new JTextArea(25, 80);
		private JScrollPane listScrollPane = new JScrollPane(listField);
		private JButton deleteButton = new JButton("Delete");
		private JButton editButton = new JButton("Edit");
		private JButton addButton =  new JButton("Add");
		private JButton backButton = new JButton("Back");
		private Color selectionColor = new Color(96, 158, 240);
		
		private String selectedLine;
		private JLabel searchLabel = new JLabel("Search:");
		private JTextField searchField = new JTextField();
		private String[] pattern = {" Title"," Genre"," Author"," ISBN"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		private JComboBox bookBox = new JComboBox(pattern);
		private String a = " Title";
		private Boolean selectionMade = false;
		
		private ArrayList<BookCopy> bookCopyList;
		private String bookCopyResults;
		
		public BookListGUI() {
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
				listField.setBorder(BorderFactory.createEmptyBorder());
				searchField.setColumns(20);
				
				//Placement of components on screen
				bookLayout.putConstraint(SpringLayout.WEST, backButton, (int)(screenWidth * 0.01), SpringLayout.WEST, contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, backButton, (int)(screenHeight * 0.01), SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, listScrollPane, (int)(screenWidth * 0.25), SpringLayout.WEST, contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, listScrollPane, (int)(screenHeight * 0.25), SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, addButton, (int)(screenWidth * 0.81), SpringLayout.WEST, contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, addButton, (int)(screenHeight * 0.41), SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, deleteButton, (int)(screenWidth * 0.81), SpringLayout.WEST, contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, deleteButton, (int)(screenHeight * 0.46), SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, editButton, (int)(screenWidth * 0.81), SpringLayout.WEST, contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, editButton, (int)(screenHeight * 0.51), SpringLayout.NORTH, contentPane);
						
				bookLayout.putConstraint(SpringLayout.WEST, searchLabel, (int)(screenWidth * 0.4), SpringLayout.WEST,contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, searchLabel, (int)(screenHeight * 0.21) , SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, searchField, (int)(screenWidth * 0.43), SpringLayout.WEST,contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, searchField, (int)(screenHeight * 0.21) , SpringLayout.NORTH, contentPane);
				
				bookLayout.putConstraint(SpringLayout.WEST, bookBox, (int)(screenWidth * 0.58), SpringLayout.WEST,contentPane);
				bookLayout.putConstraint(SpringLayout.NORTH, bookBox, (int)(screenHeight * 0.21) , SpringLayout.NORTH, contentPane);
				
				addButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						MainGUI.switchToBookCheck();
					}

				});
				
				editButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						MainGUI.switchToBook(true);
						bc = BookDAO.getBookCopyByBookCopyID(Integer.valueOf(selectedLine));
						titleField.setText(bc.getTitle());
						authorField.setText(bc.getAuthor());
						yearField.setText(StringDateSwitcher.dateToStringYear(bc.getYearEdition()));
						placeField.setText(bc.getPublicationPlace());
						publisherField.setText(bc.getPublisher());
						genreField.setText(bc.getGenre());
						ISBNField.setText(bc.getISBN());
						editionField.setText(Integer.toString(bc.getEdition()));
						BookGUI.this.bookButton.setText("Save");
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
							BookCopy selectedBookCopy = null;
							for(BookCopy bc : bookCopyList) {
								if(bc.getCopyId() == Integer.valueOf(selectedLine)) {
									selectedBookCopy = bc;
								}
							}
							if(activeUser == activeLibrarian){
								activeLibrarian.removeBookCopy(selectedBookCopy);
							}
							else{
								activeAdmin.removeBookCopy(selectedBookCopy);
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
							if(listField.getText().equals("")){
								bookCopyList = searchBookByTitle(text);
								for(BookCopy bc : bookCopyList) {
									bookCopyResults += " ID: " + bc.getCopyId() + " || Book ID: " + bc.getBookID() + " || Title: " + bc.getTitle() + " || Author: " + bc.getAuthor() + " || Genre: " + bc.getGenre() + " || Year: " + bc.getYearEdition() + " || Publisher: " + bc.getPublisher()
											+ " || Place of Publication: " + bc.getPublicationPlace() + " || ISBN: " + bc.getISBN() + " || Edition: " + bc.getEdition() + " || Lendable: " + bc.getLendable() + System.lineSeparator();
								}
								listField.setText(bookCopyResults);
							}
						}
						if(a==" Genre")
						{
							if(listField.getText().equals("")){
								bookCopyList = searchBookByGenre(text);
								for(BookCopy bc : bookCopyList) {
									bookCopyResults += " ID: " + bc.getCopyId() + " || Book ID: " + bc.getBookID() + " || Title: " + bc.getTitle() + " || Author: " + bc.getAuthor() + " || Genre: " + bc.getGenre() + " || Year: " + bc.getYearEdition() + " || Publisher: " + bc.getPublisher()
											+ " || Place of Publication: " + bc.getPublicationPlace() + " || ISBN: " + bc.getISBN() + " || Edition: " + bc.getEdition() + " || Lendable: " + bc.getLendable() + System.lineSeparator();
								}
								listField.setText(bookCopyResults);
							}
						}
						if(a==" Author")
						{
							if(listField.getText().equals("")){
								bookCopyList = searchBookByAuthor(text);
								for(BookCopy bc : bookCopyList) {
									bookCopyResults += " ID: " + bc.getCopyId() + " || Book ID: " + bc.getBookID() + " || Title: " + bc.getTitle() + " || Author: " + bc.getAuthor() + " || Genre: " + bc.getGenre() + " || Year: " + bc.getYearEdition() + " || Publisher: " + bc.getPublisher()
											+ " || Place of Publication: " + bc.getPublicationPlace() + " || ISBN: " + bc.getISBN() + " || Edition: " + bc.getEdition() + " || Lendable: " + bc.getLendable() + System.lineSeparator();
								}
								listField.setText(bookCopyResults);
							}


						}
						if(a==" ISBN")
						{
							if(listField.getText().equals("")){
								bookCopyList = searchBookByISBN(text);
								for(BookCopy bc : bookCopyList) {
									bookCopyResults += " ID: " + bc.getCopyId() + " || Book ID: " + bc.getBookID() + " || Title: " + bc.getTitle() + " || Author: " + bc.getAuthor() + " || Genre: " + bc.getGenre() + " || Year: " + bc.getYearEdition() + " || Publisher: " + bc.getPublisher()
											+ " || Place of Publication: " + bc.getPublicationPlace() + " || ISBN: " + bc.getISBN() + " || Edition: " + bc.getEdition() + " || Lendable: " + bc.getLendable() + System.lineSeparator();
								}
								listField.setText(bookCopyResults);

							}

						}
					}
				});
				
				bookBox.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						@SuppressWarnings("rawtypes")
						JComboBox cb = (JComboBox)e.getSource();
						a = (String)cb.getSelectedItem();
					}
				});
		}
		
		
		public void reset() {
			bookCopyList = null;
			bookCopyResults = "";
			listField.setText("");
		}
		
		public void update() {
			if(listField.getText().equals("")) {
				bookCopyList = Librarian.getAllBookCopys();
				for(BookCopy bc : bookCopyList) {
					bookCopyResults += " ID: " + bc.getCopyId() + " || Book ID: " + bc.getBookID() + " || Title: " + bc.getTitle() + " || Author: " + bc.getAuthor() + " || Genre: " + bc.getGenre() + " || Year: " + bc.getYearEdition() + " || Publisher: " + bc.getPublisher()
							+ " || Place of Publication: " + bc.getPublicationPlace() + " || ISBN: " + bc.getISBN() + " || Edition: " + bc.getEdition() + " || Lendable: " + bc.getLendable() + System.lineSeparator();
				}
				listField.setText(bookCopyResults);
			}
		}
		
		public JPanel getContentPane() {
			return contentPane;
		}
		
	}
}
