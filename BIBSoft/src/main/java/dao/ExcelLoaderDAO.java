package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;





import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ExcelLoaderDAO {
	private static Connection conn = DatabaseConnection.getConnection();
	public static void ImportData(String Books){
		String place_of_publication = "";
		String title = "";
		String author = "";
		String publisher = "";
		int year = 0;
		String isbn = "";
		String genre="";
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
	        try{
	        	conn.setAutoCommit(false);
	            PreparedStatement pstm = null ;
	            FileInputStream input = new FileInputStream(Books);
	            POIFSFileSystem fs = new POIFSFileSystem( input );
	            HSSFWorkbook wb = new HSSFWorkbook(fs);
	            HSSFSheet sheet = wb.getSheetAt(0);
	            Row row;
	            Cell titleCell;
	            Cell genreCell;
	            Cell authorCell;
	            Cell place_of_publicationCell;
	            Cell publisherCell;
	            Cell yearCell;
	            Cell isbnCell;
	            for(int i=0; i<=sheet.getLastRowNum(); i++){
	                row = sheet.getRow(i);
	                titleCell = row.getCell(0);
	                genreCell = row.getCell(1);
	                authorCell = row.getCell(2);
	                place_of_publicationCell = row.getCell(3);
	                publisherCell = row.getCell(4);
	                yearCell = row.getCell(5);
	                isbnCell = row.getCell(6);
						
	                if(titleCell!=null)
	                {
	                	if(titleCell.getCellType()==1)
	                	{
	                		title = row.getCell(0).getStringCellValue();
	                	}
	                }
	                else
	                {
	                	title="";
	                }
	                if(genreCell!=null)
	                {
	                	if(genreCell.getCellType()==1)
	                	{
	                		genre = row.getCell(1).getStringCellValue();
	                	}
	            	}
	                else
	                {
	                	genre = "";
	                }
	                if(authorCell!=null)
	                {
	                	if(authorCell.getCellType()==1)
	                	{
	                		author = row.getCell(2).getStringCellValue();
	                	}
	                }
	                else
	                {
	                	author = "";
	                }
	                if(place_of_publicationCell!=null)
	                {
	                	if(place_of_publicationCell.getCellType()==1)
	                	{
	                		place_of_publication = row.getCell(3).getStringCellValue();
	                	}
	                }
	                else
	                {
	                	place_of_publication = "";
	                }
	                if(publisherCell!=null)
	                {
	                	if(publisherCell.getCellType()==1)
	                	{
	                		publisher = row.getCell(4).getStringCellValue();
	                	}
	                }
	                else
	                {
	                	publisher = "";
	                }
	                if(yearCell!=null)
	                {
	                	if(yearCell.getCellType()==0)
	                	{
	                		year =(int) row.getCell(5).getNumericCellValue();
	                	}
	            	}
	                else
	                {
	                	year = 0;
	                }
	                if(isbnCell!=null)
	                {
	                	if(isbnCell.getCellType()==1)
	                	{
	                		isbn = row.getCell(6).getStringCellValue();
	                	} 
	                }
	                else
	                {
	                	isbn = "";
	                }
					
	                String sql = "INSERT INTO Books(title,author,year,place_of_publication,publisher,genre,isbn) VALUES(?,?,?,?,?,?,?)";
	                pstm = conn.prepareStatement(sql);
	                pstm.setString(1, title);
	                pstm.setString(2, author);
	                pstm.setInt(3, year);
	                pstm.setString(4, place_of_publication);
	                pstm.setString(5, publisher);
	                pstm.setString(6, genre);
	                pstm.setString(7, isbn);
	                pstm.execute();
	                
	                	
	               
	               
	                System.out.println("Import rows Books "+i); 
	                		
	                
	            }
	            conn.commit();
	            pstm.close();
 
	            conn.close();
	            input.close();
	            System.out.println("Success import excel to mysql table");
	        }catch(SQLException ex){
	            System.out.println(ex);
	        }catch(IOException ioe){
	            System.out.println(ioe);
	        }

	    }
	public static void ImportDataBookCopies(){
		try {
			   if(conn == null || conn.isClosed()){
			    conn = DatabaseConnection.getConnection();
			   }
			  } catch (SQLException e1) {
			   // TODO Auto-generated catch block
			   e1.printStackTrace();
			  }
        try{
        	conn.setAutoCommit(false);
            PreparedStatement pstm = null ;
          
	                String sql = "INSERT INTO BookCopies(book_id) SELECT book_id FROM Books WHERE book_id NOT IN (SELECT bc.book_id FROM BookCopies bc, Books b WHERE bc.book_id = b.book_id)";
	                
	                pstm = (PreparedStatement) conn.prepareStatement(sql);
	                pstm.executeUpdate();
            conn.commit();
            pstm.close();
            conn.close();
            System.out.println("Success import excel to mysql table");
            }catch(SQLException ex){
	            System.out.println(ex);
            }

		}
	
	}




