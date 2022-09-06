package model;

public class ItensPacote {

	private int id;
	private int qtdViajantes;
	private double valor;

	private Pacote pacote;
	private Viagem viagem;

	public ItensPacote() {

	}

	public ItensPacote(int id, int qtdViajantes, Pacote pacote, Viagem viagem) {
		super();
		this.id = id;
		this.qtdViajantes = qtdViajantes;
		valorItens(viagem.getPreco());
		this.pacote = pacote;
		this.viagem = viagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtdViajantes() {
		return qtdViajantes;
	}

	public void setQtdViajantes(int qtdViajantes) {
		this.qtdViajantes = qtdViajantes;
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

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	@Override
	public String toString() {
		return "Itens_pacote [id=" + id + ", qtd_itens=" + qtdViajantes + ", valor=" + valor + ", pacote=" + pacote
				+ "]";
	}

	private void valorItens(double preco) {
		this.valor = this.qtdViajantes * preco;
	}

}
