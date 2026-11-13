const URL_IMAGENS = "https://image.tmdb.org/t/p/w500";

const listaFilmes = document.querySelector("#lista-filmes");
const listaSeries = document.querySelector("#lista-series");
const buscaFilmes = document.querySelector("#busca-filmes");
const limparBusca = document.querySelector("#limpar-busca");

let filmesCarregados = [];

function criarURL(tipo) {
    return `/.netlify/functions/catalogo?tipo=${tipo}`;
}

function mostrarMensagem(container, mensagem) {
    container.textContent = mensagem;
}

function criarCard(item, tipo) {
    const card = document.createElement("article");
    card.classList.add("card");

    const titulo = tipo === "movie" ? item.title : item.name;
    const data = tipo === "movie" ? item.release_date : item.first_air_date;
    const ano = data ? data.substring(0, 4) : "Ano não informado";
    const nota = Number(item.vote_average || 0).toFixed(1);
    const sinopse = item.overview || "Sinopse não disponível.";

    if (item.poster_path) {
        const imagem = document.createElement("img");
        imagem.src = `${URL_IMAGENS}${item.poster_path}`;
        imagem.alt = `Cartaz de ${titulo}`;
        imagem.loading = "lazy";
        card.appendChild(imagem);
    }

    const conteudo = document.createElement("div");
    conteudo.classList.add("card-content");

    const nome = document.createElement("h3");
    nome.textContent = titulo;

    const anoElemento = document.createElement("p");
    anoElemento.textContent = ano;

    const descricao = document.createElement("p");
descricao.classList.add("sinopse-texto");
descricao.textContent = sinopse;

const botaoSaibaMais = document.createElement("button");
botaoSaibaMais.type = "button";
botaoSaibaMais.classList.add("btn-saiba-mais");
botaoSaibaMais.textContent = "Saiba mais";

botaoSaibaMais.addEventListener("click", () => {
    const expandida = descricao.classList.toggle("expandida");

    botaoSaibaMais.textContent = expandida
        ? "Ver menos"
        : "Saiba mais";
});

    const avaliacao = document.createElement("p");
    avaliacao.classList.add("card-rating");
    avaliacao.textContent = `★ ${nota}/10`;

     conteudo.append(
    nome,
    anoElemento,
    descricao,
    botaoSaibaMais,
    avaliacao
);
    card.appendChild(conteudo);

    return card;
}

function exibirCatalogo(container, itens, tipo) {
    container.replaceChildren();

    if (!itens.length) {
        mostrarMensagem(container, "Nenhum título encontrado.");
        return;
    }

    itens.forEach((item) => {
        container.appendChild(criarCard(item, tipo));
    });
}

async function carregarFilmes() {
    mostrarMensagem(listaFilmes, "Carregando filmes...");

    try {
        const resposta = await fetch(criarURL("movie"));

        if (!resposta.ok) {
            throw new Error("Não foi possível consultar os filmes.");
        }

        const dados = await resposta.json();

        filmesCarregados = dados.results || [];

        exibirCatalogo(listaFilmes, filmesCarregados, "movie");

    } catch (erro) {
        console.error("Erro ao carregar filmes:", erro);
        mostrarMensagem(listaFilmes, "Não foi possível carregar os filmes.");
    }
}

async function carregarSeries() {
    mostrarMensagem(listaSeries, "Carregando séries...");

    try {
        const resposta = await fetch(criarURL("tv"));

        if (!resposta.ok) {
            throw new Error("Não foi possível consultar as séries.");
        }

        const dados = await resposta.json();

        exibirCatalogo(listaSeries, dados.results || [], "tv");

    } catch (erro) {
        console.error("Erro ao carregar séries:", erro);
        mostrarMensagem(listaSeries, "Não foi possível carregar as séries.");
    }
}

if (buscaFilmes) {
    buscaFilmes.addEventListener("input", (evento) => {
        const termo = evento.target.value.toLowerCase().trim();

        const resultado = filmesCarregados.filter((filme) =>
            filme.title.toLowerCase().includes(termo)
        );

        exibirCatalogo(listaFilmes, resultado, "movie");
    });
}

if (limparBusca) {
    limparBusca.addEventListener("click", () => {
        buscaFilmes.value = "";
        exibirCatalogo(listaFilmes, filmesCarregados, "movie");
        buscaFilmes.focus();
    });
}

const formulario = document.querySelector("#form-contato");
const retornoFormulario = document.querySelector("#retorno-formulario");

if (formulario) {
    formulario.addEventListener("submit", (evento) => {
        evento.preventDefault();

        const nome = document.querySelector("#nome").value.trim();

        retornoFormulario.textContent =
    `Obrigado pelo contato, ${nome}! Sua mensagem foi recebida com sucesso. Agradecemos seu interesse pelo CINEBR!`;
        formulario.reset();
    });
}

carregarFilmes();
carregarSeries();
