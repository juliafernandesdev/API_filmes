<h1 align="center">Filmes API 🎬</h1>

Esta é uma aplicação Spring Boot que permite buscar informações de filmes na API pública [OMDb](https://www.omdbapi.com/), armazená-las localmente em um banco de dados PostgreSQL e disponibilizá-las via uma API REST.
---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- OpenFeign
- Lombok
- OMDb API

---

## 📦 Funcionalidades

- Buscar filme por título na OMDb e salvar no banco de dados
- Listar todos os filmes (com paginação)
- Buscar filme por ID
- Deletar filme por ID
---

## 📦 Endpoints da API

### `POST /filmes`
Busca filme na OMDb por título, salva no banco e retorna os dados salvos.
**Request Body**:
```json
{
  "titulo": "The Matrix"
}
```

### `GET /filmes`
Lista todos os filmes salvos no banco.

### `GET /filmes/{id}`
Retorna os detalhes de um filme específico.

### `DELETE /filmes/{id}`
Remove um filme do banco de dados.

---

## 🔧 Como Rodar o Projeto

### 1. Clone o repositório
```bash
git clone https://github.com/seuusuario/API_filmes.git
cd API_filmes
```

### 2. Configure o banco PostgreSQL
Certifique-se de ter o PostgreSQL rodando localmente e crie um banco:
```sql
CREATE DATABASE filmesapi;
```

Atualize o arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/filmesapi
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### 3. Configure a chave da OMDb API
Registre-se em https://www.omdbapi.com/apikey.aspx e configure no `application.properties`:
```properties
omdb.apiKey=SUA_CHAVE_AQUI
```

### 4. Compile e rode a aplicação
```bash
./mvnw spring-boot:run
```

### 5. Acesse a API
- Localhost: http://localhost:8080/ApiFilmes/filmes

---

## ✅ Exemplo com `curl`
```bash
curl -X POST http://localhost:8080/ApiFilmes/filmes \
     -H 'Content-Type: application/json' \
     -d '{"titulo": "Inception"}'
```

---

## ✅ Testes
(Desejável) Pode ser adicionado com JUnit + Mockito

---

## ✅ Contato

Caso tenha alguma dúvida, pode entrar em contato comigo:

<a href = "mailto:anajuliafv88@gmail.com"><img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white"></a> 
<a href="https://www.linkedin.com/in/ajuliafernandesv/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>

<p align="center"> Desenvolvido por Ana Júlia Fernandes Venâncio </p>
