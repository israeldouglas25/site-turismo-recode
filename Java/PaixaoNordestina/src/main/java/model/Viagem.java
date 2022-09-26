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
	private double total;
	private int dias;

	// classe responsavel por formatar um padrao diferente do formato ISO
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
	

	public Viagem() {

	}

	public Viagem(int id, String dataIda, String dataVolta, int qtdViajantes, int qtdQuartos, double preco,
			double total) {
		this.id = id;
		this.dataIda = LocalDate.parse(dataIda, formatter);
		this.dataVolta = LocalDate.parse(dataVolta, formatter);
		this.qtdViajantes = qtdViajantes;
		this.qtdQuartos = qtdQuartos;
		this.preco = preco;
		this.total = total;
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
		this.dataIda = LocalDate.parse(dataIda);
	}

	public String getDataVolta() {
		return formatter.format(dataVolta);
	}

	public void setDataVolta(String dataVolta) {
		this.dataVolta = LocalDate.parse(dataVolta);
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

}
