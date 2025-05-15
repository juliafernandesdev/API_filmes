CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE filme_omdb (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    tittle VARCHAR(100) NOT NULL,
    year VARCHAR(50) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    plot VARCHAR(250) NOT NULL
);