package model;

public class Itens_pacote {
	
	private int id;
	private int qtd_itens;
	private double valor;
	
	private Pacote pacote;

	public Itens_pacote() {
	
	}

	public Itens_pacote(int id, int qtd_itens, double valor, Pacote pacote) {
		super();
		this.id = id;
		this.qtd_itens = qtd_itens;
		this.valor = valor;
		this.pacote = pacote;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtd_itens() {
		return qtd_itens;
	}

	public void setQtd_itens(int qtd_itens) {
		this.qtd_itens = qtd_itens;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	@Override
	public String toString() {
		return "Itens_pacote [id=" + id + ", qtd_itens=" + qtd_itens + ", valor=" + valor + ", pacote=" + pacote + "]";
	}
	
	private void valorItens(double preco) {
		this.valor = this.qtd_itens * preco;
	}
	

}
