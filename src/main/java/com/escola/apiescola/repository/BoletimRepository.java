package com.escola.apiescola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.escola.apiescola.models.Boletim;

public interface BoletimRepository extends JpaRepository<Boletim, Long> {

	/**
	 * @param id É O ID DO BOLETIM QUE SERA BUSCADO CASO EXISTA NO BD
	 * @return É O OBJETO BOLETIM ENCONTRADO
	 */
	Boletim findById(long id);
	
	/**
	 * @param aluno_id É O ID DO ALUNO QUE SERA BUSCADO CASO EXISTA NA TABELA DE BOLETINS
	 * @return É O OBJETO BOLETIM ENCONTRADO
	 */
	Boletim findByAluno_id(long aluno_id);
	
	/**
	 * @return A LISTA DE OBJETOS DO TIPO BOLETIM QUE ESTAO C/ A SITUACAO DO ALUNO APROVADO
	 */
	@Query("SELECT b FROM Boletim b WHERE b.situacao = true")
	List<Boletim> findByAprovados();
}
