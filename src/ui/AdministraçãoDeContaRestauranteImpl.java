package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import restaurant.Database;
import restaurant.Funcionario;

public class AdministraçãoDeContaRestauranteImpl implements
		AdministraçãoDeContaRestaurante {

	private Funcionario funcionario;
	private Database database;
	
	public AdministraçãoDeContaRestauranteImpl(Database database) {
		this.database = database;
	}
	
	@Override
	public boolean login(int código) {
		funcionario = database.getFuncionario(código);
		if (funcionario != null)
			return true;
		return false;
	}
	
	public void menu() {
		boolean loginCorreto = login(requestLogin());
		if (!loginCorreto)
			System.out.println("Login inexistente.");
	}

	private int requestLogin() {
		Integer login = null;
		
		while (login == null) {
			try {
				System.out.print("Informe o login: ");
				String resposta = new BufferedReader(new InputStreamReader(System.in)).readLine();
				login = Integer.parseInt(resposta);
			} catch (NumberFormatException e) {
				System.out.println("Por favor insira um número");
			} catch (IOException e) {
				System.out.println("Erro de IO. Encerrando programa");
				System.exit(-1);
			}
		}
		return login.intValue();
	}

	public void logout() {
		funcionario = null;
	}

}
