# Imersão Java - Alura 🚀

> Projetos desenvolvidos durante a Imersão Java da Alura - Março 2023

## Principais tecnologias 👩‍💻

- Java 17
- Spring Framework
- Mongo DB (Atlas cloud)
- fly.io (deploy)

### 📚 Bibliotecas utilizadas 🗃️

- java sdk 17
- spring-boot-starter-web
- spring-boot-starter-data-mongodb
- spring-boot-starter-validation

## Aula 1 👨‍💻

> Consumindo uma API de filmes com Java (java.net)

### Desafios da aula 1 ✨

1. Consumir o endpoint de filmes mais populares da API do IMDB. Procure também, na documentação da API do IMDB, o endpoint que retorna as melhores séries e o que retorna as séries mais populares.

2. Usar sua criatividade para deixar a saída dos dados mais bonitinha: usar emojis com código UTF-8, mostrar a nota do filme como estrelinhas, decorar o terminal com cores, negrito e itálico usando códigos ANSI, e mais!

3. Colocar a chave da API do IMDB em algum lugar fora do código como um arquivo de configuração (p. ex, um arquivo .properties) ou uma variável de ambiente.

#### Set Environment Variable in Linux

> export IMDB*KEY=k*????????

#### Get Environment Variable in Java

> String imdbAPIKey = System.getenv("IMDB_KEY");

## Aula 2 👨‍💻

> Gerando figurinhas para WhatsApp

### Desafios da aula 2 ✨

1. Criar diretório de saída das imagens, se ainda não existir.

2. Centralizar o texto na figurinha.

3. Colocar outra fonte como a Comic Sans ou a Impact, a fonte usada em memes.

4. Colocar contorno (outline) no texto da imagem.

5. Colocar uma imagem de você que está fazendo esse curso sorrindo, fazendo joinha e fazer com que o texto da figurinha seja personalizado de acordo com as classificações do IMDB.

## Aula 3 👨‍💻

> Ligando as pontas, refatoração e orientação a objetos

### Desafios da aula 3 ✨

1. Transformar a classe que representa os conteúdos em um Record, disponível a partir do Java 16.

2. Criar as suas próprias exceções e usá-las na classe que implementa o cliente HTTP.

3. Usar recursos do Java 8 e posterior, como Streams e Lambdas, para mapear uma lista em uma outra.

4. Criar uma Enum que une, como configurações, a URL da API e o extrator utilizado.

## Aula 4 👨‍💻

> Criando nossa própria API com Spring

### Desafios da aula 4 ✨

1. Finalizar o CRUD (Create, Read, Update e Delete) para que se possa atualizar e excluir uma linguagem cadastrada.

2. Devolver a listagem ordenada pelo ranking;

3. Retornar o status 201 quando um recurso (linguagem, no nosso caso) for cadastrado através do POST.

## Aula 5 👨‍💻

> Publicando nossa API no Cloud

### Passo a passo deploy

- Acessar: https://fly.io
- Criar uma conta
- Adicionar cartão de crédito
- obs: Ficar de olho no free tier
- Instalar o flyctl no Linux (terminal): curl -L https://fly.io/install.sh | sh
- Lazer login com flyctl (terminal): fly auth login
- Confirmar a autenticação no browser
- Entrar na pasta do projeto pelo terminal
- Lançar a aplicação (terminal): fly launch --image rodolfohok/languages-api:latest
- Escolher o nome da aplicação: alura-languages-api
- Escolher a região para o deploy: Sao Paulo, Brazil (gru)
- Set up PostgreSQL: no
- Set up Redis: no
- Confirm deploy: yes
- Acessar: https://fly.io/dashboard
- Clicar: alura-languages-api
- Copiar o hostname
- Testar acessando o hostname/languages
- Testar no Postman / Insomnia com o hostname
- Usar o hostname para gerar os stickers com a outra aplicação

#### Adendo

- Setar outro banco de dados (terminal): fly secrets set "SPRING_DATA_MONGODB_URI=mongodb+srv://rodolfohokino:<password>@cluster0.s8iey.mongodb.net/aluraDb?retryWrites=true&w=majority"
- obs: substituir <password> pela senha correta
