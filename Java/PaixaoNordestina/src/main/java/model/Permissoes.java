package model;

public class Permissoes {
	// Atributos
	private int id;
	private String tipo;
	
	//Construtor
	public Permissoes() {
		
	}
	
	public Permissoes(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	
	//Geters e Seters
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	@Override
	public String toString() {
		return "Permissoes [id=" + id + ", tipo=" + tipo + "]";
	}

	//Metodo mostrar
	public String mostrar() {
		return "Id: " + this.id + " tipo: " + this.tipo ;
	}
}
