package model;

public class Viagem {
	
	private int id_viagem;
	private double preco;
	private String periodo;
	private String origem;
	private String destino;
	
	public Viagem() {
	}

	public Viagem(int id_viagem, double preco, String periodo, String origem, String destino) {
		super();
		this.id_viagem = id_viagem;
		this.preco = preco;
		this.periodo = periodo;
		this.origem = origem;
		this.destino = destino;
	}

	public int getId_viagem() {
		return id_viagem;
	}

	public void setId_viagem(int id_viagem) {
		this.id_viagem = id_viagem;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

}
