package com.escola.apiescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.escola.apiescola.models.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {

	/**
	 * @param id É O ID DA RESPOSTA QUE SERA BUSCADA CASO EXISTA NO BD
	 * @return É O OBJETO RESPOSTA ENCONTRADO
	 */
	Resposta findById(long id);
}
