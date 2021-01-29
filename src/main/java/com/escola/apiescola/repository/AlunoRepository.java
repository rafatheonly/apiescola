package com.escola.apiescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.apiescola.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	/**
	 * @param id É O ID DO ALUNO QUE SERA BUSCADO CASO EXISTA NO BD
	 * @return É O OBJETO ALUNO ENCONTRADO OU NAO
	 */
	Aluno findById(long id);
}
