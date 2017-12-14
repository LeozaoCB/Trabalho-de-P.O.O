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

public class LeitorODS {
	//private String[] cabecalho = { "CLASSE", "NÃ�VEL", "VENC.", "RT", "TOTAL" };

	public List<Carreira> carrega(String srcFile) {
		
		List<Carreira> lista = new ArrayList();
		try {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile), "UTF-8"));
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
	public List<Carreira> readODS(File file){
	    Sheet sheet;
	    List<Carreira> lista = new ArrayList<>();
	    
	    try {
	         //Getting the 0th sheet for manipulation| pass sheet name as string
	         sheet = SpreadSheet.createFromFile(file).getSheet(0);

	         //Get row count and column count
	         int nColCount = sheet.getColumnCount();
	         int nRowCount = sheet.getRowCount();

	         String ano = null;
    		 String tipo = null;
    		 
	         //Iterating through each row of the selected sheet
	         MutableCell cell = null;
	         for(int nRowIndex = 0; nRowIndex < nRowCount; nRowIndex++) {
	        	 if(!sheet.getCellAt(0, nRowIndex).getValue().toString().equals("")) {
	        		 
	        		 
	        		 
	        		 if(sheet.getCellAt(0, nRowIndex).getValue().toString().equals("2017 20H")) {
	        			 ano = "2017";
	        			 tipo = "20H";
	        			 
	        		 }else if(sheet.getCellAt(0, nRowIndex).getValue().toString().equals("2017 40H")) {
	        			 ano = "2017";
	        			 tipo = "40H";
	        		 }else if(sheet.getCellAt(0, nRowIndex).getValue().toString().equals("2017 DE")) {
	        			 ano = "2017";
	        			 tipo = "DE";
	        		 }else if(sheet.getCellAt(0, nRowIndex).getValue().toString().equals("2019 20H")) {
	        			 ano = "2019";
	        			 tipo = "20H";
	        		 }else if(sheet.getCellAt(0, nRowIndex).getValue().toString().equals("2019 40H")) {
	        			 ano = "2019";
	        			 tipo = "40H";
	        		 }else if(sheet.getCellAt(0, nRowIndex).getValue().toString().equals("2019 DE")) {
	        			 ano = "2019";
	        			 tipo = "DE";
	        		 }else if(sheet.getCellAt(0, nRowIndex).getValue().toString().equals("2020 20H")) {
	        			 ano = "2020";
	        			 tipo = "20H";
	        		 }else if(sheet.getCellAt(0, nRowIndex).getValue().toString().equals("2020 40H")) {
	        			 ano = "2020";
	        			 tipo = "40H";
	        		 }else if(sheet.getCellAt(0, nRowIndex).getValue().toString().equals("2020 DE")) {
	        			 ano = "2020";
	        			 tipo = "DE";
	        		 }
	        	 else {
	        			 
	        			 String classe;
	        			 int nivel;
	        			 double salario;
	        			 String titulacao;
	        			 
	        			 classe = sheet.getCellAt(0, nRowIndex).getValue().toString();
	        			 nivel =Integer.parseInt( sheet.getCellAt(1, nRowIndex).getValue().toString());
	        			 salario = Double.parseDouble(sheet.getCellAt(2, nRowIndex).getValue().toString());
	        			 titulacao = "Graduação";
	        			 
	        			 
	        			 lista.add(new Carreira( classe,  nivel, salario,  tipo,  titulacao,  Integer.parseInt(ano)));
	        			 
	        			 
	        			 salario = Double.parseDouble(sheet.getCellAt(3, nRowIndex).getValue().toString());
	        			 titulacao = "Aperfeiçoamento";
	        			 
	        			 lista.add(new Carreira( classe,  nivel, salario,  tipo,  titulacao,  Integer.parseInt(ano)));
	        			 
	        			 salario = Double.parseDouble(sheet.getCellAt(4, nRowIndex).getValue().toString());
	        			 titulacao = "Especialização ou Graduação + RSC I";
	        			 
	        			 lista.add(new Carreira( classe,  nivel, salario,  tipo,  titulacao,  Integer.parseInt(ano)));
	        			 
	        			 salario = Double.parseDouble(sheet.getCellAt(5, nRowIndex).getValue().toString());
	        			 titulacao = "Mestrado ou Especialização + RSC II";
	        			 
	        			 lista.add(new Carreira( classe,  nivel, salario,  tipo,  titulacao,  Integer.parseInt(ano)));
	        			 
	        			 salario = Double.parseDouble(sheet.getCellAt(6, nRowIndex).getValue().toString());
	        			 titulacao = "Doutorado ou Mestrado + RSC III";
	        			 
	        			 lista.add(new Carreira( classe,  nivel, salario,  tipo,  titulacao,  Integer.parseInt(ano)));
	        			 
	        		 }
	        		
	        	 }
	        	 
	        	 else {
	        		 
	        		 break;
	        	 }
	          
	          }

	        } catch (IOException e) {
	          e.printStackTrace();
	       }
	    
	    return lista;
	 }
}
