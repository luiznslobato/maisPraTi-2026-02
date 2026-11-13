# CINEBR

**O melhor do cinema e das séries brasileiras em um só lugar.**

## Sobre o projeto

O CINEBR é uma aplicação web desenvolvida para apresentar um catálogo de filmes e séries brasileiras, permitindo que os visitantes conheçam produções nacionais por meio de informações obtidas através da API do The Movie Database (TMDB).

O projeto tem como objetivo valorizar o audiovisual brasileiro por meio de uma interface simples, moderna e responsiva.

## Tecnologias utilizadas

- HTML5
- CSS3
- JavaScript
- API do The Movie Database (TMDB)
- Netlify Functions
- Netlify

## Funcionalidades

- Exibição de filmes brasileiros.
- Exibição de séries brasileiras.
- Apresentação de pôsteres, títulos, anos, avaliações e sinopses.
- Expansão e recolhimento das sinopses.
- Pesquisa de filmes por título.
- Navegação entre as seções da página.
- Formulário de contato com confirmação visual.
- Layout adaptável a diferentes tamanhos de tela.

## Integração com a API

O catálogo utiliza a API do TMDB para consultar informações sobre filmes e séries brasileiras.

As requisições são realizadas por meio de uma função serverless do Netlify, evitando a exposição da chave de acesso no código JavaScript disponibilizado ao navegador.

A variável de ambiente necessária é:

`TMDB_API_KEY`

## Configuração e publicação

O projeto utiliza o Netlify para hospedagem e execução das funções serverless.

Para publicar:

1. Importe o repositório do GitHub no Netlify.
2. Configure a branch `main` como branch de produção.
3. Configure o diretório de publicação como `modulo-2/atividade-4-5/public`.
4. Configure a variável de ambiente `TMDB_API_KEY` com uma chave válida da API do TMDB.
5. Realize a publicação do projeto.

A configuração dos diretórios de publicação e das funções está definida no arquivo `netlify.toml`, localizado na raiz do repositório.

## Estrutura do projeto

```text
atividade-4-5/
├── netlify/
│   └── functions/
│       └── catalogo.mjs
├── public/
│   ├── css/
│   │   └── style.css
│   ├── images/
│   │   └── tmdb-logo.svg
│   ├── js/
│   │   └── script.js
│   └── index.html
└── README.md
```

## Formulário de contato

O formulário apresenta uma confirmação visual após o preenchimento e envio. Nesta versão, os dados não são transmitidos para um servidor nem enviados por e-mail.


## Créditos

Os dados de filmes e séries são fornecidos pela API do The Movie Database (TMDB).

Este produto utiliza a API do TMDB, mas não é endossado nem certificado pelo TMDB.

Site oficial: https://www.themoviedb.org/

Documentação: https://developer.themoviedb.org/
