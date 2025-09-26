--v1_criar_tabela_event.sql
CREATE TABLE tb_events(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR (255) NOT NULL,
    descricao TEXT,
    identificador VARCHAR(255) NOT NULL UNIQUE,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP NOT NULL,
    local_evento VARCHAR(255) NOT NULL,
    capacidade INTEGER NOT NULL,
    tipo_evento VARCHAR(50) NOT NULL,
    organizador VARCHAR(255) NOT NULL
);