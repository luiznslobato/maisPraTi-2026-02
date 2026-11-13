# Sistema de Biblioteca

Projeto acadêmico desenvolvido em Java e PostgreSQL para representar o funcionamento básico de um sistema de biblioteca.

## Organização do projeto

```text
SistemaBiblioteca/
├── README.md
├── exercicio1-java/
│   └── src/
│       ├── Aluno.java
│       ├── Biblioteca.java
│       ├── DVD.java
│       ├── ItemBiblioteca.java
│       ├── Livro.java
│       ├── Main.java
│       ├── Professor.java
│       ├── Revista.java
│       └── Usuario.java
└── exercicio2-e-3-postgresql/
    ├── create.sql
    ├── insert.sql
    └── consultas.sql
```

## Exercício 1 — Programação Orientada a Objetos em Java

Implementação de um sistema de biblioteca utilizando os conceitos de:

- Classes e objetos.
- Herança.
- Abstração.
- Encapsulamento.
- Polimorfismo.

### Classes principais

- `ItemBiblioteca`: classe abstrata que representa os itens do acervo.
- `Livro` e `Revista`: especializações de `ItemBiblioteca`.
- `DVD`: nova categoria adicionada para demonstrar a extensibilidade do sistema.
- `Usuario`: classe abstrata que representa os usuários.
- `Aluno` e `Professor`: especializações de `Usuario`.
- `Biblioteca`: controla os cadastros, empréstimos, devoluções e listagem do acervo.
- `Main`: executa os cenários de teste.

### Regras de negócio

| Item | Prazo | Multa diária |
|---|---:|---:|
| Livro | 14 dias | R$ 0,50 |
| Revista | 7 dias | R$ 1,00 |
| DVD | 5 dias | R$ 0,25 |

| Usuário | Limite de empréstimos |
|---|---:|
| Aluno | 3 itens |
| Professor | 5 itens |

### Como executar

Entre na pasta do código Java:

```bash
cd exercicio1-java/src
```

Compile:

```bash
javac *.java
```

Execute:

```bash
java Main
```

## Exercício 2 — Modelagem de banco de dados PostgreSQL

Criação de um banco de dados relacional chamado `biblioteca_bairro`.

Foram desenvolvidas três tabelas:

- `item`: armazena os livros e as revistas.
- `usuario`: armazena alunos e professores.
- `emprestimo`: registra retiradas, devoluções e multas.

O modelo utiliza:

- Chaves primárias.
- Chaves estrangeiras.
- Campos de identidade automática.
- Restrições `CHECK`.
- Relacionamentos entre tabelas.

### Arquivos SQL

- `create.sql`: criação das tabelas.
- `insert.sql`: inserção dos dados de teste.

### Como executar

A partir da pasta principal do projeto:

```bash
cd exercicio2-e-3-postgresql
```

Criar as tabelas:

```bash
sudo -u postgres psql -d biblioteca_bairro -f create.sql
```

Inserir os dados:

```bash
sudo -u postgres psql -d biblioteca_bairro -f insert.sql
```

**Observação:** os comandos de criação e inserção devem ser executados uma única vez em um banco vazio.

## Exercício 3 — Consultas SQL

Desenvolvimento de quatro consultas para recuperação e análise dos dados:

1. Listagem completa do acervo.
2. Listagem dos empréstimos em aberto, relacionando usuários e itens.
3. Cálculo do total de multas por usuário.
4. Identificação dos itens que nunca foram emprestados.

### Como executar

```bash
sudo -u postgres psql -P pager=off -d biblioteca_bairro -f consultas.sql
```

## Tecnologias utilizadas

- Java 21.
- PostgreSQL 16.
- SQL.
- Ubuntu Linux.

## Status do projeto

- [x] Exercício 1 — Programação Orientada a Objetos em Java.
- [x] Exercício 2 — Modelagem e implementação do banco PostgreSQL.
- [x] Exercício 3 — Consultas SQL.
