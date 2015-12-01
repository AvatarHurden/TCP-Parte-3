package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import restaurant.Database;
import restaurant.Item;
import restaurant.Mesa;
import restaurant.Pedido;
import restaurant.funcionarios.AuxiliarCozinha;
import restaurant.funcionarios.Cozinheiro;
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
			System.out.println(String.format("\nOl�, %s.", funcionario.getNome()));
			
			if (funcionario instanceof AuxiliarCozinha)
				esperaOp��oAuxiliar();
			else if (funcionario instanceof Cozinheiro)
				esperaOp��oCozinheiro();
			
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
	
	private void esperaOp��oCozinheiro() {
		System.out.println("\nA��es dispon�veis:");
		System.out.println("1. Iniciar Prepara��o");
		System.out.println("2. Finalizar Prepara��o");
		System.out.println("3. Cancelar");
		int op��o = requestNumber("\nSua escolha: ", 1, 3);
		
		Cozinheiro opera��es = (Cozinheiro) funcionario;
		
		switch (op��o) {
		case 1:
			if (opera��es.getPedidoEmPrepara��o() != null)
				System.out.println("J� existe um pedido em prepara��o");
			else {
				opera��es.iniciarPrepara��o();
				
				Pedido pedido = opera��es.getPedidoEmPrepara��o();
				
				if (pedido == null) 
					System.out.println("N�o h� pedidos para serem feitos");
				else {
					System.out.println("\nPedido para mesa " + pedido.getMesa().getC�digo() + ":");
					
					List<Item> itens = pedido.getItens();
					for (int i = 0; i < itens.size(); i++)
						System.out.println(i+1 + ". " + itens.get(i).getNome());
				}
			}
			
			break;
		case 2:
			
			Pedido pedido = opera��es.getPedidoEmPrepara��o();
			
			if (pedido == null)
				System.out.println("� preciso iniciar a prepara��o de um pedido antes.");
			else {
				System.out.println("\nO item " + pedido.getItens().get(0).getNome() + " foi finalizado");	
				
				if (opera��es.finalizarPrepara��o())
					System.out.println("\nO pedido para a mesa " + pedido.getMesa().getC�digo() + " foi finalizado.");
				else {
					System.out.println("\nItens restantes para mesa " + pedido.getMesa().getC�digo() + ":");
					
					List<Item> itens = pedido.getItens();
					for (int i = 0; i < itens.size(); i++)
						System.out.println(i + ". " + itens.get(i).getNome());
				}
			}
			break;
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
