package com.escola.apiescola.resources;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.escola.apiescola.models.Aluno;
import com.escola.apiescola.models.Boletim;
import com.escola.apiescola.models.Gabarito;
import com.escola.apiescola.models.Nota;
import com.escola.apiescola.models.Prova;
import com.escola.apiescola.models.Resposta;
import com.escola.apiescola.repository.AlunoRepository;
import com.escola.apiescola.repository.BoletimRepository;
import com.escola.apiescola.repository.GabaritoRepository;
import com.escola.apiescola.repository.NotaRepository;
import com.escola.apiescola.repository.ProvaRepository;
import com.escola.apiescola.repository.RespostaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Rafael Calearo
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value="API RESTful Escola Alf")
public class AlfResource {

	@Autowired
	ProvaRepository provaRepository;

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	GabaritoRepository gabaritoRepository;

	@Autowired
	NotaRepository notaRepository;

	@Autowired
	RespostaRepository respostaRepository;

	@Autowired
	BoletimRepository boletimRepository;

	/**
	 * LISTA AS PROVAS!
	 * @return É UM JSON CONTENDO AS PROVAS CADASTRADAS
	 */
	@ApiOperation(value="LISTA AS PROVAS!")
	@GetMapping("/provas")	
	public List<Prova> provas() {
		return provaRepository.findAll();
	}

	/**
	 * CADASTRA UM GABARITO!
	 * @param prova_id É DA PROVA QUE SE RELACIONA COM O GABARITO CRIADO
	 * @param gabarito É O OBJETO A SER CADASTRADO
	 * @return É UM JSON CONTENDO O GABARITO CADASTRADO
	 */
	@ApiOperation(value="CADASTRA UM GABARITO!")
	@PostMapping("/gabarito/{prova_id}")	
	public Gabarito gabarito(@PathVariable(value = "prova_id") long prova_id, @RequestBody @Valid Gabarito gabarito) {
		Prova prova = provaRepository.findById(prova_id);
		gabarito.setProva(prova);
		return gabaritoRepository.save(gabarito);
	}

	
	/**
	 * CADASTRA E CALCULA AS RESPOSTAS DA PROVA FEITA PELO ALUNO!
	 * @param prova_id É DA PROVA QUE SERVE P/ COMPARAR A RESPOSTA DO ALUNO E GABARITO
	 * @param aluno_id É DO ALUNO QUE REALIZA AS RESPOSTAS DA PROVA 
	 * @param resposta É O OBJETO A SER CADASTRADO
	 * @return É UM JSON CONTENDO A RESPOSTA CADASTRADA
	 */
	@ApiOperation(value="CADASTRA E CALCULA AS RESPOSTAS DA PROVA FEITA PELO ALUNO!")
	@PostMapping("/resposta/{prova_id}/{aluno_id}")	
	public Resposta resposta(@PathVariable(value = "prova_id") long prova_id, @PathVariable(value = "aluno_id") long aluno_id,
			@RequestBody @Valid Resposta resposta) {

		resposta.setProva(provaRepository.findById(prova_id));
		resposta.setAluno(alunoRepository.findById(aluno_id));

		calculaNotaProva(resposta); //METODO QUE FAZ A MEDIA PONDERADA DAS QUESTOES

		return respostaRepository.save(resposta);
	}

	/**
	 * CADASTRA UMA PROVA!
	 * @param prova É O OBJETO A SER CADASTRADO
	 * @return É UM JSON CONTENDO A PROVA CADASTRADA
	 */
	@ApiOperation(value="CADASTRA UMA PROVA!")
	@PostMapping("/prova")	
	public Prova prova(@RequestBody @Valid Prova prova) {
		return provaRepository.save(prova);
	}

	/**
	 * CADASTRA UM ALUNO!
	 * @param aluno É O OBJETO A SER CADASTRADO
	 * @return É UM JSON CONTENDO O ALUNO CADASTRADO
	 */
	@ApiOperation(value="CADASTRA UM ALUNO!")
	@PostMapping("/aluno")	
	public Aluno aluno(@RequestBody @Valid Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	/**
	 * CALCULA O RESULTADO DA PROVA COMPARANDO A RESPOSTA DO ALUNO C/ O GABARITO DA PROVA
	 * E USA A MEDIA PONDERADA!
	 * @param resposta É O OBJETO CONTENDO AS RESPOSTAS DA PROVA DO ALUNO A SER CALCULADA
	 */
	private void calculaNotaProva(Resposta resposta) {
		Prova prova = resposta.getProva();
		Gabarito gabarito = gabaritoRepository.findByProva_id(prova.getId());		
		double q1 = resposta.getR1() == gabarito.getR1() ? 1.00 : 0;
		double q2 = resposta.getR2() == gabarito.getR2() ? 1.00 : 0;
		double q3 = resposta.getR3() == gabarito.getR3() ? 1.00 : 0;
		double q4 = resposta.getR4() == gabarito.getR4() ? 1.00 : 0;
		double q5 = resposta.getR5() == gabarito.getR5() ? 1.00 : 0;
		double q6 = resposta.getR6() == gabarito.getR6() ? 1.00 : 0;
		double q7 = resposta.getR7() == gabarito.getR7() ? 1.00 : 0;
		double q8 = resposta.getR8() == gabarito.getR8() ? 1.00 : 0;
		double q9 = resposta.getR9() == gabarito.getR9() ? 1.00 : 0;
		double q10 = resposta.getR10() == gabarito.getR10() ? 1.00 : 0;
		Nota nota = new Nota();
		nota.setAluno(resposta.getAluno());
		nota.setProva(prova);
		nota.setNota(q1 + q2 + q3 + q4 + q5 + q6 + q7 + q8 + q9 + q10);
		notaRepository.save(nota);
	}

	/**
	 * CADASTRA A MEDIA FINAL NO BOLETIM!
	 * @param aluno_id É DO ALUNO QUE TEM A NOTA FINAL (MEDIA) DAS PROVAS CADASTRADA
	 * @param boletim É O OBJETO A SER CADASTRADO
	 * @return É O JSON CONTENDO O BOLETIM CADASTRADO
	 */
	@ApiOperation(value="CADASTRA A MEDIA FINAL NO BOLETIM!")
	@PostMapping("/boletim/{aluno_id}")	
	public Boletim boletim(@PathVariable(value = "aluno_id") long aluno_id, @RequestBody @Valid Boletim boletim) {
		List<Nota> notas = notaRepository.findByAluno_id(aluno_id);
		double media = 0.0;
		for (int i = 0; i < notas.size(); i++) {
			Nota nota = notas.get(i);
			media = media + nota.getNota();
		}
		media = media / notas.size(); //CALCULA A MEDIA ARITMETICA
		boletim.setMedia(media);
		boletim.setSituacao(media >= 7.0 ? true : false);
		boletim.setAluno(alunoRepository.findById(aluno_id));
		return boletimRepository.save(boletim);
	}

	/**
	 * BUSCA A MEDIA FINAL DO ALUNO A PARTIR DO SEU ID!
	 * @param aluno_id É DO ALUNO QUE SERA VERIFICADO A NOTA FINAL
	 * @return É UM JSON CONTENDO A MEDIA FINAL (NOTA FINAL) DO ALUNO
	 */
	@ApiOperation(value="BUSCA A MEDIA FINAL DO ALUNO A PARTIR DO SEU ID!")
	@GetMapping("/boletim/{aluno_id}")	
	public Boletim boletim(@PathVariable(value = "aluno_id") long aluno_id) {
		return boletimRepository.findByAluno_id(aluno_id);
	}

	/**
	 * BUSCA (O)S ALUNO(S) APROVADO(S)!
	 * @return É O JSON CONTENDO O(S) ALUNO(S) APROVADO(S)
	 */
	@ApiOperation(value="BUSCA (O)S ALUNO(S) APROVADO(S)!")
	@GetMapping("/aprovados")	
	public List<Boletim> aprovados() {
		return boletimRepository.findByAprovados();
	}
}
