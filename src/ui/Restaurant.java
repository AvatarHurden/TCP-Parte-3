package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import restaurant.Database;


public class Restaurant {

	public static void main(String[] args) throws IOException {
		
		AdministraçãoDeContaRestauranteImpl ui = new AdministraçãoDeContaRestauranteImpl(new Database());
		
		while (continueProgram())
			ui.menu();
	}
	
	private static boolean continueProgram() throws IOException {
		System.out.println("\nEscolha uma das opções:");
		System.out.println("1. Fazer login");
		System.out.println("2. Sair do programa");
		System.out.print("\nSua escolha: ");
		String resposta = new BufferedReader(new InputStreamReader(System.in)).readLine();
		return resposta.equals("1");
	}
	
}
