package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Viagem {
	private int id;
	private LocalDate dataIda;
	private LocalDate dataVolta;
	private double total;
	private long dias;

	private Destino destino;
	private Usuario usuario;

	// classe responsavel por formatar um padrao diferente do formato ISO
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Viagem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Viagem(String dataIda, String dataVolta, Destino destino, Usuario usuario) {
		super();
		this.dataIda = LocalDate.parse(dataIda, formatter);
		this.dataVolta = LocalDate.parse(dataVolta, formatter);
		// retorna a quantidade de dias entre as datas
		this.dias = setPeriodo(this.dataIda, this.dataVolta);
		// metodo faz a operação de mutiplicação do valor de aluguel do carro vezes os dias.
		this.total = setTotal_dias(destino.getPreco());
		this.destino = destino;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public double setTotal_dias(double total) {
		this.total = total * dias;
		return this.total;
	}

	public long getDias() {
		return dias;
	}

	public void setDias(long dias) {
		this.dias = dias;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public long setPeriodo(LocalDate dataIda, LocalDate dataVolta) {
		this.dias = ChronoUnit.DAYS.between(this.dataIda, this.dataVolta);
		return this.dias;
	}

}
