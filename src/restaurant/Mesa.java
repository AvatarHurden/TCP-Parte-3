package restaurant;

import java.util.Date;
import java.util.Map;

public class Mesa {

	private String setor;
	private int código, capacidade;
	private Status status;
	private Pedido pedido;
	private Map<Turno, Date> reservas;
	
	public Mesa(int código, String nomeSetor, int capacidade) {
		this.código = código;
		this.setor = nomeSetor;
		this.capacidade = capacidade;
		
		this.status = Math.random() > 0.7 ? Status.LIMPAR : Status.LIVRE;
	}
	
	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Map<Turno, Date> getReservas() {
		return reservas;
	}

	public void setReservas(Map<Turno, Date> reservas) {
		this.reservas = reservas;
	}

	public int getCódigo() {
		return código;
	}

}
