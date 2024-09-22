-- Criar o banco de dados
CREATE DATABASE musicadb;

-- Usar o banco de dados
USE musicadb;

-- Criar a tabela de músicas
CREATE TABLE musica (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    genero VARCHAR(100),
    artista VARCHAR(255),
    ano_lancamento INT
);
-- Inserindo músicas
INSERT INTO musica (nome, genero, artista, ano_lancamento) VALUES 
('Bohemian Rhapsody', 'Rock', 'Queen', 1975),
('Billie Jean', 'Pop', 'Michael Jackson', 1982),
('Smells Like Teen Spirit', 'Grunge', 'Nirvana', 1991),
('Hotel California', 'Rock', 'Eagles', 1977),
('Shape of You', 'Pop', 'Ed Sheeran', 2017),
('Imagine', 'Rock', 'John Lennon', 1971),
('Hey Jude', 'Rock', 'The Beatles', 1968),
('Rolling in the Deep', 'Pop', 'Adele', 2010),
('Wonderwall', 'Rock', 'Oasis', 1995),
('Stairway to Heaven', 'Rock', 'Led Zeppelin', 1971);

