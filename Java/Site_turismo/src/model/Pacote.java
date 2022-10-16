package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pacote {
	
	private int id;
	private LocalDate data;
	private double valor;
	
	private Usuario usuario;
	
	private List<ItensPacote> itens = new ArrayList<ItensPacote>();
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Pacote() {

	}

	public Pacote(int id, String data, Usuario usuario) {
		super();
		this.id = id;
		this.data = LocalDate.parse(data, formatter);
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return formatter.format(data);
	}

	public void setData(String data) {
		this.data = LocalDate.parse(data);
	}

	public double getValor() {
		return valorCompra();
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ItensPacote> getItens() {
		return itens;
	}

	public void setItens(List<ItensPacote> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "Pacote [id=" + id + ", data=" + data + ", valor=" + valor + "]";
	}
	
	public double valorCompra() {
		for (int i = 0; i < itens.size(); i++) {
			this.valor += itens.get(i).getValor();
		}
		return this.valor;
	}

}
