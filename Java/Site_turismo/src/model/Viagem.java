package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Viagem {
	
	private int id;
	private String origem;
	private String destino;
	private LocalDate dataIda;
	private LocalDate dataVolta;
	private int qtdViajantes;
	private int qtdQuartos;
	private double preco;
	
	private Viajante viajante;
	
	// classe responsavel por formatar um padrao diferente do formato ISO
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Viagem() {
		
	}

	public Viagem(int id, String origem, String destino, String dataIda, String dataVolta, int qtdViajantes, int qtdQuartos,
			Viajante viajante, double preco) {
		this.id = id;
		this.origem = origem;
		this.destino = destino;
		this.dataIda = LocalDate.parse(dataIda, formatter);
		this.dataVolta = LocalDate.parse(dataVolta, formatter);
		this.qtdViajantes = qtdViajantes;
		this.qtdQuartos = qtdQuartos;
		this.viajante = viajante;
		this.setPreco(preco);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDataIda() {
		return formatter.format(dataIda);
	}

	public void setDataIda(String dataIda) {
		this.dataIda = LocalDate.parse(dataIda, formatter);
	}

	public String getDataVolta() {
		return formatter.format(dataVolta);
	}

	public void setDataVolta(String dataVolta) {
		this.dataVolta = LocalDate.parse(dataVolta, formatter);
	}

	public int getQtdViajantes() {
		return qtdViajantes;
	}

	public void setQtdViajantes(int qtdViajantes) {
		this.qtdViajantes = qtdViajantes;
	}

	public int getQtdQuartos() {
		return qtdQuartos;
	}

	public void setQtdQuartos(int qtdQuartos) {
		this.qtdQuartos = qtdQuartos;
	}

	public Viajante getViajante() {
		return viajante;
	}

	public void setViajante(Viajante viajante) {
		this.viajante = viajante;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Viagem [id=" + id + ", origem=" + origem + ", destino=" + destino + ", dataIda=" + dataIda
				+ ", dataVolta=" + dataVolta + ", qtdViajantes=" + qtdViajantes + ", qtdQuartos=" + qtdQuartos
				+ ", preco=" + preco + ", viajante=" + viajante + "]";
	}
	
	

}
