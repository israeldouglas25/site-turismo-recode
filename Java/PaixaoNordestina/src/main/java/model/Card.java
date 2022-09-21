package model;

public class Card {
	
	private int id;
	private String nome;
	private double precoPromocao;
	
	public Card() {
		super();
		
	}

	public Card(int id, String nome, double precoPromocao) {
		super();
		this.id = id;
		this.nome = nome;
		this.precoPromocao = precoPromocao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoPromocao() {
		return precoPromocao;
	}

	public void setPrecoPromocao(double precoPromocao) {
		this.precoPromocao = precoPromocao;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", nome=" + nome + ", precoPromocao=" + precoPromocao + "]";
	}

}
