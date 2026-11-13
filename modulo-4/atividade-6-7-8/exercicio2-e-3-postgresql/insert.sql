-- Cadastro de itens
INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
('L001', 'Dom Casmurro', 'LIVRO', 'Machado de Assis', '1a edicao', FALSE),
('L002', 'O Pequeno Principe', 'LIVRO', 'Antoine de Saint-Exupery', '2a edicao', TRUE),
('R001', 'National Geographic', 'REVISTA', NULL, 'Edicao 120', TRUE),
('R002', 'Ciencia Hoje', 'REVISTA', NULL, 'Edicao 85', TRUE);


-- Cadastro de usuarios
INSERT INTO usuario (nome, tipo, limite_itens) VALUES
('Carlos', 'ALUNO', 3),
('Mariana', 'PROFESSOR', 5);


-- Cadastro de emprestimos
INSERT INTO emprestimo
(item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa)
VALUES
(1, 1, '2026-11-01', '2026-11-15', NULL, 0.00),
(2, 2, '2026-10-01', '2026-10-15', '2026-10-18', 1.50);
