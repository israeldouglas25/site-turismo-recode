package model;

public class Viajante {
	
	private int id;
	private String nome;
	private String email;
	private int idade;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone;
	
	public Viajante() {
	
	}
	
	public Viajante(int id, String nome, String email, int idade, String logradouro, String bairro, String cidade,
			String estado, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Viajante [id=" + id + ", nome=" + nome + ", email=" + email + ", idade=" + idade + ", logradouro="
				+ logradouro + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", telefone="
				+ telefone + "]";
	}
	
}
