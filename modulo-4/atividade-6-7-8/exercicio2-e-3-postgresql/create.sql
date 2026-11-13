-- Tabela de itens da biblioteca
CREATE TABLE item (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    autor VARCHAR(100),
    edicao VARCHAR(50),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT chk_tipo_item
        CHECK (tipo IN ('LIVRO', 'REVISTA'))
);


-- Tabela de usuarios
CREATE TABLE usuario (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    limite_itens INTEGER NOT NULL,

    CONSTRAINT chk_tipo_usuario
        CHECK (tipo IN ('ALUNO', 'PROFESSOR')),

    CONSTRAINT chk_limite_usuario
        CHECK (
            (tipo = 'ALUNO' AND limite_itens = 3)
            OR
            (tipo = 'PROFESSOR' AND limite_itens = 5)
        )
);


-- Tabela de emprestimos
CREATE TABLE emprestimo (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INTEGER NOT NULL,
    usuario_id INTEGER NOT NULL,
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10,2) NOT NULL DEFAULT 0.00,

    CONSTRAINT fk_emprestimo_item
        FOREIGN KEY (item_id) REFERENCES item(id),

    CONSTRAINT fk_emprestimo_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuario(id),

    CONSTRAINT chk_valor_multa
        CHECK (valor_multa >= 0),

    CONSTRAINT chk_datas_emprestimo
        CHECK (
            data_devolucao_prevista >= data_retirada
            AND
            (data_devolucao IS NULL OR data_devolucao >= data_retirada)
        )
);
