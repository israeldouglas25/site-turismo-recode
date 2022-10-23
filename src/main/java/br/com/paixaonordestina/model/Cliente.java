package br.com.paixaonordestina.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {

//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "destino_id_fk", nullable = false)
//	private Destino destino;

	@Column(nullable = false)
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
