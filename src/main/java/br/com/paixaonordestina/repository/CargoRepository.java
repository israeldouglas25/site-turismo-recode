package br.com.paixaonordestina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paixaonordestina.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
	
}
