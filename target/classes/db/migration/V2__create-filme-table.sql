CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE filme(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    ano VARCHAR(50) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    descricao VARCHAR(250) NOT NULL
);