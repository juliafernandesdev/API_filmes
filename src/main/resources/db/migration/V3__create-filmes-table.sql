-- Criação da tabela filmes com ID SERIAL
CREATE TABLE filmes (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    ano VARCHAR(50) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    descricao VARCHAR(250) NOT NULL
);
