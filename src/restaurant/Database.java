package restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import restaurant.funcionarios.Atendente;
import restaurant.funcionarios.AuxiliarCozinha;
import restaurant.funcionarios.Cozinheiro;
import restaurant.funcionarios.Funcionario;
import restaurant.funcionarios.Garcom;
import restaurant.funcionarios.Gerente;

public class Database {

	private Map<Integer, Mesa> mapaDeMesas;
	
	private Map<Class<? extends Funcionario>, Double> salariosFixo;
	private Map<Class<? extends Funcionario>, Double> salariosVariavel;
	
	private Map<Integer, Funcionario> funcionarios;
	
	private Map<Integer, Item> cardapio;
	
	private Map<String, Ingrediente>  estoque;
	
	
	public Database() {
		mapaDeMesas = new HashMap<>();
		salariosFixo = new HashMap<>();
		salariosVariavel = new HashMap<>();
		funcionarios = new HashMap<>();
			
		cardapio = new HashMap<>();
		
		estoque = new HashMap<>();
		
		inicializarMesas();
		inicializarSalarios();
		inicializarCardapio();
		inicializarFuncionarios();
		inicializaEstoque();
		
	}
	
	
	private void inicializaEstoque()
	{
		estoque.put("tomate", new Ingrediente("tomate", 0, "unidade"));
		estoque.put("cebola", new Ingrediente("cebola", 4, "unidade"));
		estoque.put("pernil", new Ingrediente("pernil", 5, "kilos"));
		estoque.put("arroz", new Ingrediente("arroz", 20, "kilos"));
		estoque.put("lim�o", new Ingrediente("lim�o", 20, "unidade"));
		estoque.put("p�o", new Ingrediente("p�o", 0, "unidade"));
		
	}
	

	private void inicializarMesas() {
		String[] setores = new String[] {"Azul", "Amarelo", "Vermelho", "Verde", "Rosa" };
		int codigo = 0;
		
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[0], 4));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[0], 4));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[0], 2));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[0], 2));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[0], 5));

		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[1], 2));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[1], 2));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[1], 2));

		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[2], 4));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[2], 4));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[2], 4));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[2], 4));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[2], 6));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[2], 6));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[2], 2));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[2], 2));

		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[3], 3));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[3], 3));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[3], 3));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[3], 4));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[3], 4));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[3], 5));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[3], 5));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[3], 5));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[3], 6));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[3], 6));

		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[4], 3));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[4], 3));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[4], 3));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[4], 3));
		mapaDeMesas.put(codigo, new Mesa(codigo++, setores[4], 3));
	}
	
	private void inicializarFuncionarios() {
		int codigo = 0;
		
		funcionarios.put(codigo, new AuxiliarCozinha("Pedro", codigo++, this));
		funcionarios.put(codigo, new Gerente("Marta", codigo++, this));
		funcionarios.put(codigo, new Cozinheiro("Andr�", codigo++, this));

		Pedido pedido1 = new Pedido(getTodasMesas().get(0));
		pedido1.getItens().add(new Item("Prato Principal", 10, "Prato Principal 1", 3, 4, 10, "1 kg de sopa"));
		pedido1.getItens().add(new Item("Entrada", 2, "Entrada 2", 3, 4, 4, "2 kg de sopa"));
		pedido1.getItens().add(new Item("Salada", 1, "Salada 1", 3, 4, 1, "2 kg de sopa"));
		pedido1.getItens().add(new Item("Entrada", 1, "Entrada 1", 3, 4, 6, "2 kg de sopa"));
		pedido1.getItens().add(new Item("Prato Principal", 13, "Prato Principal 2", 3, 4, 8, "1 kg de sopa"));
		pedido1.getItens().add(new Item("Sopa", 3, "Sopa 2", 3, 4, 30, "1 kg de sopa"));
		
		Pedido pedido2 = new Pedido(getTodasMesas().get(1));
		pedido2.getItens().add(new Item("salada", 13, "Salada", 5, 10, 1, "1 kg de folha"));
		
		((Cozinheiro)funcionarios.get(codigo - 1)).receberPedido(pedido1);
		((Cozinheiro)funcionarios.get(codigo - 1)).receberPedido(pedido2);
	}
	
	private void inicializarSalarios() {
		salariosFixo.put(Atendente.class, 150d);
		salariosFixo.put(Garcom.class, 200d);
		salariosFixo.put(Cozinheiro.class, 350d);
		salariosFixo.put(AuxiliarCozinha.class, 100d);
		salariosFixo.put(Gerente.class, 300d);

		salariosVariavel.put(Atendente.class, 0.01);
		salariosVariavel.put(Garcom.class, 0.07);
		salariosVariavel.put(Cozinheiro.class, 0.05);
		salariosVariavel.put(AuxiliarCozinha.class, 0.03);
		salariosVariavel.put(Gerente.class, 0.03);
	}
	
	private void inicializarCardapio() {
		int codigo = 0;
		
		cardapio.put(codigo, new Item("Entrada", codigo++, "Lingui�a", 13, 17, 10, "1 cebola, 2 lingui�as, 1 p�o"));
		cardapio.put(codigo, new Item("Entrada", codigo++, "Camar�es", 20, 26, 13, "6 camar�es, 1 molho de folhas verdes"));

		cardapio.put(codigo, new Item("Salada", codigo++, "Salada Caprese", 15, 20, 9, "1 tomate, 2 molhos de folhas mix"));

		cardapio.put(codigo, new Item("Sopa", codigo++, "Chinesa", 10, 13, 15, "100g de miss�, 100g de pernil su�no, 100g de macarr�o"));

		cardapio.put(codigo, new Item("Prato Principal", codigo++, "Lombo Assado da Panela", 45, 58.5, 20, "200g de lombo de porco, 150g de arroz"));
		cardapio.put(codigo, new Item("Prato Principal", codigo++, "Frango com Quiabo", 50, 65, 14, "2 sobrecoxas de frango, 2 coxinhas de asa"));
		cardapio.put(codigo, new Item("Prato Principal", codigo++, "Robalo Oliva e Ervas", 60, 78, 15, "1 fil� de robalo, 3 batatas doces"));

		cardapio.put(codigo, new Item("Sobremesa", codigo++, "Torta Tiramissu", 12, 16, 8, "200g de biscoito champagne, 100ml de caf�"));
		cardapio.put(codigo, new Item("Sobremesa", codigo++, "Doce de ab�bora com coco", 8, 10.5, 6, "1 ab�bora, 100g de coco, 50g de a��car"));

		cardapio.put(codigo, new Item("Bebida", codigo++, "�gua com g�s", 3.5, 5, 0, ""));
		cardapio.put(codigo, new Item("Bebida", codigo++, "Vinho branco", 10, 13, 0, ""));
		cardapio.put(codigo, new Item("Bebida", codigo++, "Limonada refrescante", 9, 12, 0, "3 lim�es, 50ml de leite"));
	}
	
	public List<Mesa> getTodasMesas() {
		
		return new ArrayList<Mesa>(mapaDeMesas.values());
	}
	
	public List<Ingrediente> getTodosIngredientes(){
		
		return new ArrayList<Ingrediente>(estoque.values());
		
	}
	
	public List<Mesa> getMesasComStatus(Status status) {
		List<Mesa> ret = getTodasMesas();
		ret.removeIf(mesa -> mesa.getStatus() != status);
		return ret;
	}
	
	public List<Ingrediente> getIngredientesQtd(int quantidade)
	{
		List<Ingrediente> ingrediente = getTodosIngredientes();

		ingrediente.removeIf(Ingrediente -> Ingrediente.getQuantidade() != quantidade);
	
		return ingrediente;
	}

	public double getSalarioFixoPara(Class<? extends Funcionario> classe) {
		return salariosFixo.get(classe);
	}
	
	public double getSalarioVariavelPara(Class<? extends Funcionario> classe) {
		return salariosVariavel.get(classe);
	}

	public List<Item> getCardapio() {
		return new ArrayList<Item>(cardapio.values());
	}
	
	public Funcionario getFuncionario(int c�digo) {
		return funcionarios.get(c�digo);
	}
	
}
