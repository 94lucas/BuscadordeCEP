package br.com.buscador;

import br.com.buscador.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class ConsultaCep{

	
	public Endereco buscaEndereco(String cep) {
		URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");
		//HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
		      .uri(endereco)
		      .build();
		
		 
		
		try {
			HttpResponse<String> response = HttpClient
					.newHttpClient()
					  .send(request, HttpResponse.BodyHandlers.ofString());
			
			return new Gson().fromJson(response.body(), Endereco.class);
		} catch (Exception e) {
			throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
			
		} 
		
		
		
	}
	
	
	
	
}
