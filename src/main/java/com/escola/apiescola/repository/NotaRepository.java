package com.escola.apiescola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.apiescola.models.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

	/**
	 * @param id É O ID DA NOTA QUE SERA BUSCADA CASO EXISTA NO BD
	 * @return É O OBJETO NOTA ENCONTRADO
	 */
	Nota findById(long id);

	/**
	 * @param id É O ID DO ALUNO QUE SERA BUSCADO NA TABELA DE NOTAS
	 * @return É A LISTA DE OBJETOS DO TIPO NOTA QUE O ALUNO REALIZOU (NOTAS DAS PROVAS)
	 */
	List<Nota> findByAluno_id(long id);
}
