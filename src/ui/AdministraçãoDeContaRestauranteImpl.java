package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import opera��es.Opera��esAuxiliar;
import restaurant.Database;
import restaurant.Mesa;
import restaurant.funcionarios.AuxiliarCozinha;
import restaurant.funcionarios.Funcionario;

public class Administra��oDeContaRestauranteImpl implements
		Administra��oDeContaRestaurante {

	private Funcionario funcionario;
	private Database database;
	
	public Administra��oDeContaRestauranteImpl(Database database) {
		this.database = database;
	}
	
	@Override
	public boolean login(int c�digo) {
		funcionario = database.getFuncionario(c�digo);
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
				esperaOp��oAuxiliar();
			
		}
	}

	private void esperaOp��oAuxiliar() {
		System.out.println("\nA��es dispon�veis:");
		System.out.println("1. Checar mesas para limpeza");
		System.out.println("2. Liberar mesa");
		System.out.println("3. Cancelar");
		int op��o = requestNumber("\nSua escolha: ", 1, 3);
		
		AuxiliarCozinha opera��es = (AuxiliarCozinha) funcionario;
		
		switch (op��o) {
		case 1:
			opera��es.checarMesasParaLimpeza();

			System.out.print("\nMesas para limpar: ");
			List<Mesa> mesas = opera��es.getMesasParaLimpeza();
			for (int i = 0; i < mesas.size() - 1; i++)
				System.out.print(mesas.get(i).getC�digo() + ", ");
			System.out.println(mesas.get(mesas.size() - 1).getC�digo() + "\n");
			
			break;
		case 2:

			mesas = opera��es.getMesasParaLimpeza();
			if (mesas == null || mesas.isEmpty())
				System.out.println("� necess�rio checar mesas antes.");
			else
				System.out.println(String.format("\nMesa %d foi liberada", mesas.get(0).getC�digo()));
			
			opera��es.liberarMesa();
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
				System.out.println("Por favor insira um n�mero v�lido");
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
