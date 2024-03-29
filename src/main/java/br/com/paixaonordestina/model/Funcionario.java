package br.com.paixaonordestina.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Funcionario extends Pessoa {

	@Column(name = "data_admissao", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataAdmissao;

	@Column(name = "data_demissao")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataDemissao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cargo_id_fk", nullable = false)
	private Cargo cargo;

	@Column(nullable = false)
	private String senha;
	
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
