package gui;


import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import static dao.ExcelLoaderDAO.*;

@SuppressWarnings("serial")
public class ChooseExcelGUI extends JPanel {

	private JFileChooser chooser = new JFileChooser();
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file 97 - 2003 (*.xls)","xls");
	
	
	public ChooseExcelGUI(){
				//Placement of components on screen
				chooser.addChoosableFileFilter(filter);
				chooser.setFileFilter(filter);
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
				      System.out.println("getCurrentDirectory(): " 
				         +  chooser.getCurrentDirectory());
				      System.out.println("getSelectedFile() : " 
				         +  chooser.getSelectedFile());
				      action();
				      }
				    else {
				      System.out.println("No Selection ");
				      }
				     
				
			}
			public void action(){
				File file = new File(".");
			      String directory = "";
			      file = chooser.getSelectedFile();
			      directory =  file.getName();
				  ImportData(directory);   
				  ImportDataBookCopies();
			}

				 
}
