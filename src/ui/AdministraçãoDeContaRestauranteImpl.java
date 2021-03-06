package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import restaurant.Database;
import restaurant.Ingrediente;
import restaurant.Item;
import restaurant.Mesa;
import restaurant.Pedido;
import restaurant.funcionarios.AuxiliarCozinha;
import restaurant.funcionarios.Cozinheiro;
import restaurant.funcionarios.Funcionario;
import restaurant.funcionarios.Gerente;

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
			System.out.println(String.format("\nOlá, %s.", funcionario.getNome()));
			
			if (funcionario instanceof AuxiliarCozinha)
				esperaOpçãoAuxiliar();
			else if (funcionario instanceof Cozinheiro)
				esperaOpçãoCozinheiro();
			else if (funcionario instanceof Gerente)
				esperaOpçãoGerente();
			
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
			List<Mesa> mesas = operações.getMesasParaLimpeza();

			if (mesas.size() == 0)
				System.out.println("\nNão existem mesas para limpeza.");
			else {
				System.out.print("\nMesas para limpar: ");
				for (int i = 0; i < mesas.size() - 1; i++)
					System.out.print(mesas.get(i).getCódigo() + ", ");
				System.out.println(mesas.get(mesas.size() - 1).getCódigo() + "\n");
			}
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
	
	private void esperaOpçãoGerente()
	{
		System.out.println("\nAções disponíveis:");
		System.out.println("1. Verificar Estoque");
		System.out.println("2. Cancelar");
		int opção = requestNumber("\nSua escolha: ", 1, 3);
		
		Gerente operações = (Gerente) funcionario;
		
		switch (opção) {
		case 1:
			operações.checarEstoque();
			List<Ingrediente> ingrediente = operações.getIngredientesQtd();

			
			
			if (ingrediente.size() == 0)
				System.out.println("\nNão existem ingredientes faltando.");
			else {
				System.out.print("\nIngredientes para repor: ");
				for (int i = 0; i < ingrediente.size() - 1; i++)
					System.out.print(ingrediente.get(i).getNome() + ", ");
				System.out.println(ingrediente.get(ingrediente.size() - 1).getNome() + "\n");
			}
			break;
		case 2:

			
			break;
		}
	
	}
	
	private void esperaOpçãoCozinheiro() {
		System.out.println("\nAções disponíveis:");
		System.out.println("1. Iniciar Preparação");
		System.out.println("2. Finalizar Preparação");
		System.out.println("3. Cancelar");
		int opção = requestNumber("\nSua escolha: ", 1, 3);
		
		Cozinheiro operações = (Cozinheiro) funcionario;
		
		switch (opção) {
		case 1:
			if (operações.getPedidoEmPreparação() != null)
				System.out.println("Já existe um pedido em preparação");
			else {
				operações.iniciarPreparação();
				
				Pedido pedido = operações.getPedidoEmPreparação();
				
				if (pedido == null) 
					System.out.println("Não há pedidos para serem feitos");
				else {
					System.out.println("\nPedido para mesa " + pedido.getMesa().getCódigo() + ":");
					
					List<Item> itens = pedido.getItens();
					for (int i = 0; i < itens.size(); i++)
						System.out.println(i+1 + ". " + itens.get(i).getNome());
				}
			}
			
			break;
		case 2:
			
			Pedido pedido = operações.getPedidoEmPreparação();
			
			if (pedido == null)
				System.out.println("É preciso iniciar a preparação de um pedido antes.");
			else {
				System.out.println("\nO item " + pedido.getItens().get(0).getNome() + " foi finalizado");	
				
				if (operações.finalizarPreparação())
					System.out.println("\nO pedido para a mesa " + pedido.getMesa().getCódigo() + " foi finalizado.");
				else {
					System.out.println("\nItens restantes para mesa " + pedido.getMesa().getCódigo() + ":");
					
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
