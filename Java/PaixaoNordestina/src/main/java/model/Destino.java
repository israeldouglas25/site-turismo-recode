package model;

public class Destino {

	private int id;
	private String destino;
	private double preco;

	public Destino() {

	}

	public Destino(int id, String destino, double preco) {
		super();
		this.id = id;
		this.destino = destino;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Destino [id=" + id + ", destino=" + destino + ", preco=" + preco + "]";
	}

}
