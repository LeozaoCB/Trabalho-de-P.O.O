package br.tatuapu.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import br.tatuapu.model.*;

public class LeitorXLS {
	private String[] cabecalho = { "CLASSE", "NÃ�VEL", "VENC.", "RT", "TOTAL" };

	public List<Carreira> carrega(String srcFile) {
		List<Carreira> lista = new ArrayList();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
				    new FileInputStream(srcFile), "UTF-8"));
			String line;
			while((line = reader.readLine())!=null) {
				System.out.println(line);
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return lista;
	}
	public void readODS(File file)
	  {
	    Sheet sheet;
	    try {
	         //Getting the 0th sheet for manipulation| pass sheet name as string
	         sheet = SpreadSheet.createFromFile(file).getSheet(0);

	         //Get row count and column count
	         int nColCount = sheet.getColumnCount();
	         int nRowCount = sheet.getRowCount();

	         System.out.println("Rows :"+nRowCount);
	         System.out.println("Cols :"+nColCount);
	         //Iterating through each row of the selected sheet
	         MutableCell cell = null;
	         for(int nRowIndex = 0; nRowIndex < nRowCount; nRowIndex++)
	         {
	        	 if(!sheet.getCellAt(0, nRowIndex).getValue().toString().equals("")) {
	        		 
	        		 //Iterating through each column
	  	           int nColIndex = 0;
	  	           for( ;nColIndex < nColCount; nColIndex++)
	  	           {
	  	             cell = sheet.getCellAt(nColIndex, nRowIndex);
	  	             System.out.print(cell.getValue()+ " ");
	  	            }
	  	            System.out.println();
	        		 
	        	 }
	        	 
	        	 else {
	        		 
	        		 break;
	        	 }
	          
	          }

	        } catch (IOException e) {
	          e.printStackTrace();
	        }
	  }
}
