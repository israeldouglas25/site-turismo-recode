package model;

public class Viajante {
	
	private int id;
	private String nome;
	private String email;
	private int idade;
	private String estado;
	private String telefone;
	private String cpf;
	
	public Viajante() {
	
	}

	public Viajante(int id, String nome, String email, int idade, String estado, String telefone, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.estado = estado;
		this.telefone = telefone;
		this.cpf = cpf;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Viajante [id=" + id + ", nome=" + nome + ", email=" + email + ", idade=" + idade + ", estado=" + estado
				+ ", telefone=" + telefone + ", cpf=" + cpf + "]";
	}	
	
}
