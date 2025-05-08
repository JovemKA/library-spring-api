# API de Currículos

[![Documentation](https://img.shields.io/badge/Documentation-Online-brightgreen)](https://aos-curriculo-api.onrender.com/api/curriculos)

## Descrição

Esta é uma API simples para gerenciar currículos. A API permite listar, criar, buscar e deletar currículos. É construída com o framework Spring Boot e utiliza um banco de dados PostgreSQL na nuvem fornecido pelo Render.

## Funcionalidades

- **Listar** todos os currículos
- **Buscar** um currículo específico pelo ID
- **Criar** um novo currículo
- **Atualizar** um currículo pelo ID
- **Remover** um currículo pelo ID

## URL Base

A API está disponível na seguinte URL:

```
https://aos-curriculo-api.onrender.com/api/curriculos
```

## Endpoints

Abaixo está a lista de endpoints disponíveis na API:

| Método | Endpoint               | Descrição                          |
|--------|------------------------|------------------------------------|
| GET    | `/api/curriculos`      | Lista todos os currículos          |
| GET    | `/api/curriculos/{id}` | Busca um currículo por ID          |
| POST   | `/api/curriculos`      | Cria um novo currículo             |
| PUT    | `/api/curriculos/{id}` | Atualiza um curriculo pelo ID      |
| DELETE | `/api/curriculos/{id}` | Remove um currículo pelo ID        |

## Uso

### Listar todos os currículos

**Requisição:**

```http
GET /api/curriculos
```

**Resposta:**

```json
[
    {
        "id": 1,
        "nome": "João Silva",
        "email": "joao.silva@example.com",
        "telefone": "123456789",
        "experiencia": "Desenvolvedor de Software",
        "educacao": "Bacharel em Ciência da Computação"
    },
    "..."
]
```

### Buscar um currículo por ID

**Requisição:**

```http
GET /api/curriculos/{id}
```

**Resposta:**

```json
{
    "id": 1,
    "nome": "João Silva",
    "email": "joao.silva@example.com",
    "telefone": "123456789",
    "experiencia": "Desenvolvedor de Software",
    "educacao": "Bacharel em Ciência da Computação"
}
```

### Criar um novo currículo

**Requisição:**

```http
POST /api/curriculos
```

**Corpo da requisição:**

```json
{
    "nome": "Maria Oliveira",
    "email": "maria.oliveira@example.com",
    "telefone": "987654321",
    "experiencia": "Analista de Sistemas",
    "educacao": "Bacharel em Engenharia de Software"
}
```

**Resposta:**

```json
{
    "id": 2,
    "nome": "Maria Oliveira",
    "email": "maria.oliveira@example.com",
    "telefone": "987654321",
    "experiencia": "Analista de Sistemas",
    "educacao": "Bacharel em Engenharia de Software"
}
```

### Atualizar um currículo pelo ID

**Requisição**

````http
UPDATE /api/curriculos/{id}
````

**Corpo da requisição:**

```json
{
    "nome": "Andrey Ferreira",
    "email": "andrey.f@example.com",
    "telefone": "999999999",
    "experiencia": "Desenvolvedor Back-end",
    "educacao": "Bacharel em Ciência da Computação"
}
```

**Resposta:**

````json
{
   "id": 1,
   "nome": "Andrey Ferreira",
   "email": "andrey.f@example.com",
   "telefone": "999999999",
   "experiencia": "Desenvolvedor Back-end",
   "educacao": "Bacharel em Ciência da Computação"
}
````

### Remover um currículo pelo ID

**Requisição:**

```http
DELETE /api/curriculos/{id}
```

**Resposta:**

```json
{
    "message": "Currículo removido com sucesso."
}
```

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **PostgreSQL**
- **Docker**
- **Render** (para hospedagem)

## Como Executar Localmente

1. Clone este repositório:
   ```bash
   git clone https://github.com/JovemKA/aos-2025-1.git
   cd aos-2025-1/curriculos-api
   ```

2. Execute o Maven para compilar a aplicação:
   ```bash
   mvn spring-boot:run
   ```

3. Acesse a API localmente em:
   ```
   http://localhost:8080/api/curriculos
   ```

### Contribuições

Sinta-se à vontade para enviar pull requests ou relatar issues.
