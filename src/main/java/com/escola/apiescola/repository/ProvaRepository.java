package com.escola.apiescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.apiescola.models.Prova;

public interface ProvaRepository extends JpaRepository<Prova, Long> {

	/**
	 * @param id É O ID DA PROVA QUE SERA BUSCADA CASO EXISTA NO BD
	 * @return É O OBJETO PROVA ENCONTRADO
	 */
	Prova findById(long id);
}