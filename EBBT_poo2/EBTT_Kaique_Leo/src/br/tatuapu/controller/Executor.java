//Kaíque
package br.tatuapu.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.tatuapu.model.Carreira;
import br.tatuapu.model.Janela;
import br.tatuapu.reader.LeitorODS;
import br.tatuapu.reader.LeitorXLS;

public class Executor {
	public static void main(String[] args) throws Exception {
		LeitorODS leitor = new LeitorODS();
		
        File file = new File("dados/Tabela.ods");
        List<Carreira> lista = new ArrayList<>();
        lista = leitor.readODS(file);
        
        Janela j = new Janela();
        j.setVisible(true);
        j.setData(lista);
	}
}