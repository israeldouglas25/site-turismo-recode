package br.com.paixaonordestina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paixaonordestina.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
