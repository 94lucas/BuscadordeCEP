package br.com.buscador;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner leitura = new Scanner(System.in);
		
		ConsultaCep consultaCep = new ConsultaCep();
		
		System.out.println("Digite o numero do CEP para cunsulta: \n");
		
		String cep = leitura.nextLine();
		
		try {
			
			Endereco novoEndereco = consultaCep.buscaEndereco(cep);
			System.out.println(novoEndereco);
			GeradorDeArquivoCep gerador = new GeradorDeArquivoCep();
			gerador.salvaJson(novoEndereco);
			
		} catch (RuntimeException | IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Finalizando a aplicação");
		}
		
		
		
		
	}

}
