package br.com.buscador;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GeradorDeArquivoCep {
	
	
	public void salvaJson(Endereco endereco) throws IOException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileWriter escrita = new FileWriter(endereco.cep() + ".json");
		
		escrita.write(gson.toJson(endereco));
		escrita.close();
		
		
	}
}
