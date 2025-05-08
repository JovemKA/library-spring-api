# API de Gerenciamento de Biblioteca

[![Documentação](https://img.shields.io/badge/Documentation-Online-brightgreen)](https://library-spring-api.onrender.com)

## Descrição

Esta API permite o gerenciamento completo de uma biblioteca, abrangendo operações de cadastro, atualização, busca e remoção de livros, autores, usuários, categorias e empréstimos. Ela oferece endpoints RESTful para manipulação dos recursos, com validação e controle de relacionamentos entre as entidades.

## Recursos e Funcionalidades

- **Livros:** CRUD de livros, com vínculos a autores e categorias, controle de disponibilidade para empréstimo.
- **Autores:** Cadastro, listagem, alteração e exclusão de autores.
- **Usuários:** CRUD de usuários da biblioteca.
- **Categorias:** Gerenciamento de categorias de livros.
- **Empréstimos:** Registro, controle, listagem e devolução de empréstimos de livros a usuários.

## URL Base

A API está disponível na seguinte URL:

```
https://library-spring-api.onrender.com
```

## Endpoints Principais

## Endpoints - Livros

| Método | Endpoint          | Descrição                             |
|--------|-------------------|---------------------------------------|
| GET    | `/livros`         | Lista todos os livros                 |
| GET    | `/livros/{id}`    | Detalha um livro pelo ID              |
| POST   | `/livros`         | Cadastra um novo livro                |
| PUT    | `/livros/{id}`    | Atualiza informações de um livro      |
| DELETE | `/livros/{id}`    | Remove um livro                       |


## Endpoints - Autores

| Método | Endpoint           | Descrição                            |
|--------|--------------------|--------------------------------------|
| GET    | `/autores`         | Lista todos os autores               |
| GET    | `/autores/{id}`    | Detalha um autor pelo ID             |
| POST   | `/autores`         | Cadastra um novo autor               |
| PUT    | `/autores/{id}`    | Atualiza um autor                    |
| DELETE | `/autores/{id}`    | Remove um autor                      |


## Endpoints - Usuários

| Método | Endpoint            | Descrição                             |
|--------|---------------------|---------------------------------------|
| GET    | `/usuarios`         | Lista todos os usuários               |
| GET    | `/usuarios/{id}`    | Informa dados de um usuário           |
| POST   | `/usuarios`         | Cadastra novo usuário                 |
| PUT    | `/usuarios/{id}`    | Atualiza um usuário                   |
| DELETE | `/usuarios/{id}`    | Remove um usuário                     |

## Endpoints - Categorias

| Método | Endpoint              | Descrição                            |
|--------|-----------------------|--------------------------------------|
| GET    | `/categorias`         | Lista todas as categorias            |
| GET    | `/categorias/{id}`    | Detalha uma categoria                |
| POST   | `/categorias`         | Cadastra uma nova categoria          |
| PUT    | `/categorias/{id}`    | Atualiza uma categoria               |
| DELETE | `/categorias/{id}`    | Remove uma categoria                 |

## Endpoints - Empréstimos

| Método | Endpoint                         | Descrição                 |
|--------|----------------------------------|---------------------------|
| GET    | `/emprestimos`                   | Lista todos os empréstimos|
| GET    | `/emprestimos/{id}`              | Detalha um empréstimo     |
| POST   | `/emprestimos`                   | Realiza novo empréstimo   |
| PUT    | `/emprestimos/{id}`              | Registra devolução        |
| DELETE | `/emprestimos/{id}`              | Remove um empréstimo      |

## Exemplos de Uso


### Listar todos os livros

**Requisição:**

``` http
GET /livros
```

**Resposta:**

``` json
[
  {
    "id": 7,
    "titulo": "Fundação",
    "anoPublicacao": 1951,
    "disponivel": true,
    "categoria": {
      "id": 4,
      "nome": "Ficção Científica",
      "descricao": "Livros que exploram conceitos de tecnologia, espaço e futuro."
    },
    "autor": {
      "id": 1,
      "nome": "Isaac Asimov",
      "sobrenome": "Asimov",
      "biografia": "Físico, escritor de ficção científica, conhecido por 'Fundação'."
    }
  },
  {
    "id": 8,
    "titulo": "Eu, Robô",
    "anoPublicacao": 1950,
    "disponivel": true,
    "categoria": {
      "id": 5,
      "nome": "Fantasia",
      "descricao": "Livros com elementos mágicos e mundos imaginários."
    },
    "autor": {
      "id": 1,
      "nome": "Isaac Asimov",
      "sobrenome": "Asimov",
      "biografia": "Físico, escritor de ficção científica, conhecido por 'Fundação'."
    }
  },
  {
    "id": 9,
    "titulo": "2001: Uma Odisseia no Espaço",
    "anoPublicacao": 1968,
    "disponivel": true,
    "categoria": {
      "id": 4,
      "nome": "Ficção Científica",
      "descricao": "Livros que exploram conceitos de tecnologia, espaço e futuro."
    },
    "autor": {
      "id": 2,
      "nome": "Arthur C.",
      "sobrenome": "Clark",
      "biografia": "Autor de ficção científica, criador de histórias futurísticas."
    }
  }
]
```

### Buscar um livro por ID

**Requisição:**

``` http
GET /livros/7
```

**Resposta:**

``` json
{
  "id": 7,
  "titulo": "Fundação",
  "anoPublicacao": 1951,
  "disponivel": true,
  "categoria": {
    "id": 4,
    "nome": "Ficção Científica",
    "descricao": "Livros que exploram conceitos de tecnologia, espaço e futuro."
  },
  "autor": {
    "id": 1,
    "nome": "Isaac Asimov",
    "sobrenome": "Asimov",
    "biografia": "Físico, escritor de ficção científica, conhecido por 'Fundação'."
  }
}
```

### Criar um novo livro

**Requisição:**

``` http
POST /livros
```

**Corpo da requisição:**

``` json
{
  "titulo": "O Fim da Eternidade",
  "anoPublicacao": 1955,
  "disponivel": true,
  "categoria": { "id": 4 },
  "autor": { "id": 1 }
}
```

**Resposta:**

``` json
{
  "id": 10,
  "titulo": "O Fim da Eternidade",
  "anoPublicacao": 1955,
  "disponivel": true,
  "categoria": {
    "id": 4,
    "nome": "Ficção Científica",
    "descricao": "Livros que exploram conceitos de tecnologia, espaço e futuro."
  },
  "autor": {
    "id": 1,
    "nome": "Isaac Asimov",
    "sobrenome": "Asimov",
    "biografia": "Físico, escritor de ficção científica, conhecido por 'Fundação'."
  }
}
```

### Atualizar um livro

**Requisição:**

``` http
PUT /livros/7
```

**Corpo da requisição:**

``` json
{
  "titulo": "Fundação (2ª Edição)",
  "anoPublicacao": 1951,
  "disponivel": false,
  "categoria": { "id": 4 },
  "autor": { "id": 1 }
}
```

**Resposta:**

``` json
{
  "id": 7,
  "titulo": "Fundação (2ª Edição)",
  "anoPublicacao": 1951,
  "disponivel": false,
  "categoria": {
    "id": 4,
    "nome": "Ficção Científica",
    "descricao": "Livros que exploram conceitos de tecnologia, espaço e futuro."
  },
  "autor": {
    "id": 1,
    "nome": "Isaac Asimov",
    "sobrenome": "Asimov",
    "biografia": "Físico, escritor de ficção científica, conhecido por 'Fundação'."
  }
}
```

### Remover um livro

**Requisição:**

``` http
DELETE /livros/7
```

**Resposta:**

``` json
{
  "message": "Livro removido com sucesso."
}
```

## AUTORES

### Listar todos os autores

**Requisição:**

``` http
GET /autores
```

**Resposta:**

``` json
[
  {
    "id": 1,
    "nome": "Isaac",
    "sobrenome": "Asimov",
    "biografia": "Físico, escritor de ficção científica, conhecido por 'Fundação'."
  },
  {
    "id": 2,
    "nome": "Arthur C.",
    "sobrenome": "Clark",
    "biografia": "Autor de ficção científica, criador de histórias futurísticas."
  }
]
```

### Buscar um autor por ID

**Requisição:**

``` http
GET /autores/1
```

**Resposta:**

``` json
{
  "id": 1,
  "nome": "Isaac",
  "sobrenome": "Asimov",
  "biografia": "Físico, escritor de ficção científica, conhecido por 'Fundação'."
}
```

### Criar um novo autor

**Requisição:**

``` http
POST /autores
```

**Corpo da requisição:**

``` json
{
  "nome": "J.R.R.",
  "sobrenome": "Tolkien",
  "biografia": "Filólogo, escritor de fantasia, autor de O Senhor dos Anéis."
}
```

**Resposta:**

``` json
{
  "id": 3,
  "nome": "J.R.R.",
  "sobrenome": "Tolkien",
  "biografia": "Filólogo, escritor de fantasia, autor de O Senhor dos Anéis."
}
```

### Atualizar um autor

**Requisição:**

``` http
PUT /autores/3
```

**Corpo da requisição:**

``` json
{
  "nome": "John Ronald Reuel",
  "sobrenome": "Tolkien",
  "biografia": "Autor clássico da literatura fantástica, criador da Terra-média."
}
```

**Resposta:**

``` json
{
  "id": 3,
  "nome": "John Ronald Reuel",
  "sobrenome": "Tolkien",
  "biografia": "Autor clássico da literatura fantástica, criador da Terra-média."
}
```

### Remover um autor

**Requisição:**

``` http
DELETE /autores/3
```

**Resposta:**

``` json
{
  "message": "Autor removido com sucesso."
}
```

## USUÁRIOS

### Listar todos os usuários

**Requisição:**

``` http
GET /usuarios
```

**Resposta:**

``` json
[
  {
    "id": 1,
    "nome": "Maria Oliveira",
    "email": "maria.oliveira@email.com"
  },
  {
    "id": 2,
    "nome": "Carlos Souza",
    "email": "carlos.souza@email.com"
  }
]
```

### Buscar um usuário por ID

**Requisição:**

``` http
GET /usuarios/1
```

**Resposta:**

``` json
{
  "id": 1,
  "nome": "Maria Oliveira",
  "email": "maria.oliveira@email.com"
}
```

### Criar um novo usuário

**Requisição:**

``` http
POST /usuarios
```

**Corpo da requisição:**

``` json
{
  "nome": "Ana Lima",
  "email": "ana.lima@email.com",
  "senha": "senha123"
}
```

**Resposta:**

``` json
{
  "id": 3,
  "nome": "Ana Lima",
  "email": "ana.lima@email.com"
}
```

### Atualizar um usuário

**Requisição:**

``` http
PUT /usuarios/3
```

**Corpo da requisição:**

``` json
{
  "nome": "Ana Lívia Lima",
  "email": "ana.livia@email.com",
  "senha": "novasenha456"
}
```

**Resposta:**

``` json
{
  "id": 3,
  "nome": "Ana Lívia Lima",
  "email": "ana.livia@email.com"
}
```

### Remover um usuário

**Requisição:**

``` http
DELETE /usuarios/3
```

**Resposta:**

``` json
{
  "message": "Usuário removido com sucesso."
}
```

## CATEGORIAS

### Listar todas as categorias

**Requisição:**

``` http
GET /categorias
```

**Resposta:**

``` json
[
  {
    "id": 4,
    "nome": "Ficção Científica",
    "descricao": "Livros que exploram conceitos de tecnologia, espaço e futuro."
  },
  {
    "id": 5,
    "nome": "Fantasia",
    "descricao": "Livros com elementos mágicos e mundos imaginários."
  }
]
```

### Buscar uma categoria por ID

**Requisição:**

``` http
GET /categorias/4
```

**Resposta:**

``` json
{
  "id": 4,
  "nome": "Ficção Científica",
  "descricao": "Livros que exploram conceitos de tecnologia, espaço e futuro."
}
```

### Criar uma nova categoria

**Requisição:**

``` http
POST /categorias
```

**Corpo da requisição:**

``` json
{
  "nome": "Romance",
  "descricao": "Narrativas que focam no desenvolvimento de relações humanas."
}
```

**Resposta:**

``` json
{
  "id": 6,
  "nome": "Romance",
  "descricao": "Narrativas que focam no desenvolvimento de relações humanas."
}
```

### Atualizar uma categoria

**Requisição:**

``` http
PUT /categorias/4
```

**Corpo da requisição:**

``` json
{
  "nome": "Ficção Científica Moderna",
  "descricao": "Livros sobre novas tendências e avanços tecnológicos."
}
```

**Resposta:**

``` json
{
  "id": 4,
  "nome": "Ficção Científica Moderna",
  "descricao": "Livros sobre novas tendências e avanços tecnológicos."
}
```

### Remover uma categoria

**Requisição:**

``` http
DELETE /categorias/6
```

**Resposta:**

``` json
{
  "message": "Categoria removida com sucesso."
}
```

## EMPRÉSTIMOS

### Listar todos os empréstimos

**Requisição:**

``` http
GET /emprestimos
```

**Resposta:**

``` json
[
  {
    "id": 4,
    "dataDevolucao": "2025-05-16",
    "dataEmprestimo": "2025-05-02",
    "tituloLivro": "Fundação"
  },
  {
    "id": 5,
    "dataDevolucao": "2025-05-17",
    "dataEmprestimo": "2025-05-03",
    "tituloLivro": "Eu, Robô"
  },
  {
    "id": 6,
    "dataDevolucao": "2025-05-18",
    "dataEmprestimo": "2025-05-04",
    "tituloLivro": "2001: Uma Odisseia no Espaço"
  }
]
```

### Buscar um empréstimo por ID

**Requisição:**

``` http
GET /emprestimos/4
```

**Resposta:**

``` json
{
  "id": 4,
  "dataDevolucao": "2025-05-16",
  "dataEmprestimo": "2025-05-02",
  "tituloLivro": "Fundação"
}
```

### Criar um novo empréstimo

**Requisição:**

``` http
POST /emprestimos
```

**Corpo da requisição:**

``` json
{
  "dataEmprestimo": "2025-05-10",
  "dataDevolucao": "2025-05-24",
  "livro": { "id": 9 },
  "usuario": { "id": 3 }
}
```

**Resposta:**

``` json
{
  "id": 7,
  "dataDevolucao": "2025-05-24",
  "dataEmprestimo": "2025-05-10",
  "tituloLivro": "2001: Uma Odisseia no Espaço"
}
```

### Atualizar um empréstimo

**Requisição:**

``` http
PUT /emprestimos/7
```

**Corpo da requisição:**

``` json
{
  "dataEmprestimo": "2025-05-10",
  "dataDevolucao": "2025-05-28",
  "livro": { "id": 9 },
  "usuario": { "id": 3 }
}
```

**Resposta:**

``` json
{
  "id": 7,
  "dataDevolucao": "2025-05-28",
  "dataEmprestimo": "2025-05-10",
  "tituloLivro": "2001: Uma Odisseia no Espaço"
}
```

### Remover um empréstimo

**Requisição:**

``` http
DELETE /emprestimos/7
```

**Resposta:**

``` json
{
  "message": "Empréstimo removido com sucesso."
}
```

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot & Jakarta EE**
- **Spring Data JPA**
- **Banco de Dados Relacional**
- **Docker**
- **Render**

## Como Executar Localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/JovemKA/library-spring-api
   cd library-spring-api/
   ```
2. Compile e inicie a aplicação:
   ```bash
   mvn spring-boot:run
   ```
3. Acesse a API local em:
   ```
   http://localhost:8080/
   ```