-- 1. Listar todos os itens do acervo
SELECT codigo, titulo, tipo, disponivel
FROM item
ORDER BY codigo;


-- 2. Listar emprestimos em aberto com usuario e titulo do item
SELECT
    u.nome AS usuario,
    i.titulo AS item,
    e.data_retirada,
    e.data_devolucao_prevista
FROM emprestimo e
INNER JOIN usuario u ON e.usuario_id = u.id
INNER JOIN item i ON e.item_id = i.id
WHERE e.data_devolucao IS NULL;


-- 3. Calcular o total de multas por usuario
SELECT
    u.nome AS usuario,
    COALESCE(SUM(e.valor_multa), 0.00) AS total_multas
FROM usuario u
LEFT JOIN emprestimo e ON u.id = e.usuario_id
GROUP BY u.id, u.nome
ORDER BY u.nome;


-- 4. Listar itens que nunca foram emprestados
SELECT
    i.codigo,
    i.titulo,
    i.tipo
FROM item i
LEFT JOIN emprestimo e ON i.id = e.item_id
WHERE e.item_id IS NULL;
