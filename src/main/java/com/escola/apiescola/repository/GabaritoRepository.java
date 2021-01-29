package com.escola.apiescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.apiescola.models.Gabarito;

public interface GabaritoRepository extends JpaRepository<Gabarito, Long> {

	/**
	 * @param id É O ID DO GABARITO QUE SERA BUSCADO CASO EXISTA NO BD
	 * @return É O OBJETO GABARITO ENCONTRADO
	 */
	Gabarito findById(long id);

	/**
	 * @param id É O ID DA PROVA QUE SERA BUSCADO NA TABELA DE GABARITOS CASO EXISTA
	 * @return É O OBJETO GABARITO ENCONTRADO
	 */
	Gabarito findByProva_id(long id);
}
