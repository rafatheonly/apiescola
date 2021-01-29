# ESCOLA ALF

A Escola Alf é um projeto referente a um teste/desafio para uma vaga de emprego para *developer*!

#### O DESAFIO/TESTE

Constitui das seguintes situações:

**RESUMO:** A escola Alf aplica provas de múltipla escolha para os alunos. A nota do
aluno na prova é determinada pela **média ponderada** das questões com os
**pesos** de cada questão. Cada questão correta **soma 1 ponto** multiplicada pelo
**peso** e cada questão errada **0**. A nota final é a **média aritmética** das notas de
todas as provas. 

**REQUISITOS OBRIGATÓRIOS, DESEJÁVEIS, ENFIM TODOS:**

- Criar uma **API HTTP** "que permitirá à escola realizar algumas tarefas, como as listadas na sequência" (✓);
- Cadastrar o gabarito de cada prova (✓);
- Cadastrar as respostas de cada aluno para cada prova (✓);
- Verificar a nota final de cada aluno (✓);
- Listar os alunos aprovados (✓);
- A nota total da prova é sempre maior que 0 e menor que 10 (✓);
- A quantidade máxima de alunos é 100 (X);
- O peso de cada questão é sempre um inteiro maior que 0 (✓);
- Os alunos aprovados tem média de notas maior do que 7 (✓);
- A entrada e saída de dados deverá ser em JSON (✓);
- API RESTful (✓);
- Preferência de linguagem p/ o desenvolvimento: JAVA ou PYTHON (✓);
- Qualquer biblioteca utilizada precisa ter uma licença de cód. aberto permissiva (✓);
- Versionar com Git e enviado para um repositório da preferência (✓);
- Projeto deve ter um README.md na raiz do mesmo (✓);
- No README deve conter como compilar, executar e toda as informações necessárias (✓);
- Para concluir deve-se enviar o link do repositório por e-mail p/ o desafiante "que mandou o teste" (✓).

#### SOBRE A AVALIAÇÃO

- Entrega dos requisitos obrigatórios: 6 pontos
- Documentação: 1 ponto
- Testes unitários: 1 ponto 
- Separação de camadas: 1 ponto
- API RESTFul: 1 ponto

#### A APLICAÇÃO

- A aplicação é uma API RESTful desenvolvida com o Spring Boot (Java);
- Banco de dados PostgreSQL;
- Swagger UI (para dar uma aparência melhor nos métodos, requisições e JSON pelo navegador de sua preferência);
- Permite requisições em HTTP.

#### COMO COMPILAR, EXECUTAR A APLICAÇÃO

1. Deve-se baixar esse projeto do Github ou clonar o mesmo para a sua máquina usando o Git;
2. Importa o mesmo, para a sua IDE de preferência, a usada foi o Eclipse;
3. Atualizar e aplicar configurações do projeto;
4. Configurar o arquivo https://github.com/rafatheonly/apiescola/blob/main/src/main/resources/application.properties conforme o seu banco de dados local;
5. Executar a aplicação depois que todas as configurações forem feitas e baixadas.

PARA SABER MAIS ACESSE O SITE: https://medium.com/@alex.girao/importar-um-projeto-maven-spring-boot-ea10078b2bde

#### UTILIZANDO A APLICAÇÃO

- Depois de configurar os arquivos, o bd e baixar todas as dependências e executar o projeto, basta:
    - Abrir as requisições desejas no navegador, conforme a lista: https://apiescola.herokuapp.com/swagger-ui.html#/alf45resource (Heroku);
    - Se preferir, podem ser executadas como HTTP: https://apiescola.herokuapp.com/api/provas (Heroku);
    - Ou localmente: http://localhost:8080/api/provas ou http://localhost:8080/swagger-ui.html.

##### REQUISIÇÕES

- POST: /api/aluno — CADASTRA UM ALUNO;
- GET: /api/aprovados — BUSCA (O)S ALUNO(S) APROVADO(S);
- GET: /api/boletim/{aluno_id} — BUSCA A MEDIA FINAL DO ALUNO A PARTIR DO SEU ID;
- POST: /api/boletim/{aluno_id} — CADASTRA A MEDIA FINAL NO BOLETIM;
- POST: /api/gabarito/{prova_id} — CADASTRA UM GABARITO;
- POST: /api/prova — CADASTRA UMA PROVA;
- GET: /api/provas — LISTA AS PROVAS;
- POST: /api/resposta/{prova_id}/{aluno_id} — CADASTRA E CALCULA AS RESPOSTAS DA PROVA FEITA PELO ALUNO.

**ATENÇÃO:** TODOS OS MÉTODOS ESTÃO DOCUMENTADOS NO ARQUIVO (https://github.com/rafatheonly/apiescola/blob/main/src/main/java/com/escola/apiescola/resources/AlfResource.java) ONDE AS REQUISIÇÕES SÃO CHAMADAS! 

**OBSERVAÇÕES:** uma prova de múltipla escolha é formada por uma questão e suas múltiplas escolhas: a, b, c, d. Logo, eu não criei uma entidade para as opções das questões para ganhar tempo, fiz hipoteticamente as respostas da prova do aluno da seguinte maneira: 
- Prova X — com 10 questões, logo um gabarito com as respostas correta para cada questão levando em consideração que a resposta correta é hipotética, ex.: questão 1 a resposta correta é a letra b! Da questão 2 a resposta é a letra c e por aí adiante...
- A resposta do aluno também segue a mesma ideia, sendo assim não tem as opções para as questões e sim só o gabarito com as hipotéticas opções corretas para cada questão!

###### A aplicação conta com a seguinte licença de uso: MIT!
