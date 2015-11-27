package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import operações.OperaçõesAuxiliar;
import restaurant.Database;
import restaurant.Mesa;
import restaurant.funcionarios.AuxiliarCozinha;
import restaurant.funcionarios.Funcionario;

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
		boolean loginCorreto = login(requestNumber("\nInforme o login: ", 0, null));
		if (!loginCorreto)
			System.out.println("Login inexistente.");
		else {
			
			if (funcionario instanceof AuxiliarCozinha)
				esperaOpçãoAuxiliar();
			
		}
	}

	private void esperaOpçãoAuxiliar() {
		System.out.println("\nAções disponíveis:");
		System.out.println("1. Checar mesas para limpeza");
		System.out.println("2. Liberar mesa");
		System.out.println("3. Cancelar");
		int opção = requestNumber("\nSua escolha: ", 1, 3);
		
		AuxiliarCozinha operações = (AuxiliarCozinha) funcionario;
		
		switch (opção) {
		case 1:
			operações.checarMesasParaLimpeza();

			System.out.print("\nMesas para limpar: ");
			List<Mesa> mesas = operações.getMesasParaLimpeza();
			for (int i = 0; i < mesas.size() - 1; i++)
				System.out.print(mesas.get(i).getCódigo() + ", ");
			System.out.println(mesas.get(mesas.size() - 1).getCódigo() + "\n");
			
			break;
		case 2:

			mesas = operações.getMesasParaLimpeza();
			if (mesas == null || mesas.isEmpty())
				System.out.println("É necessário checar mesas antes.");
			else
				System.out.println(String.format("\nMesa %d foi liberada", mesas.get(0).getCódigo()));
			
			operações.liberarMesa();
		default:
			break;
		}
	}

	private int requestNumber(String message, Integer min, Integer max) {
		Integer login = null;
		
		while (login == null) {
			try {
				System.out.print(message);
				String resposta = new BufferedReader(new InputStreamReader(System.in)).readLine();
				login = Integer.parseInt(resposta);
				
				if (min != null && login < min)
					login = null;
				if (max != null && login > max)
					login = null;
				
			} catch (NumberFormatException e) {
				System.out.println("Por favor insira um número válido");
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
