export default async (request) => {
    const url = new URL(request.url);
    const tipo = url.searchParams.get("tipo");

    if (!["movie", "tv"].includes(tipo)) {
        return new Response(
            JSON.stringify({ erro: "Tipo de catálogo inválido." }),
            {
                status: 400,
                headers: { "Content-Type": "application/json" }
            }
        );
    }

    const apiKey = process.env.TMDB_API_KEY;

    if (!apiKey) {
        return new Response(
            JSON.stringify({ erro: "Chave da API não configurada." }),
            {
                status: 500,
                headers: { "Content-Type": "application/json" }
            }
        );
    }

    const parametros = new URLSearchParams({
        api_key: apiKey,
        language: "pt-BR",
        with_origin_country: "BR",
        sort_by: "popularity.desc",
        include_adult: "false",
        page: "1"
    });

    const endpoint =
        `https://api.themoviedb.org/3/discover/${tipo}?${parametros}`;

    try {
        const resposta = await fetch(endpoint);
        const dados = await resposta.json();

        return new Response(JSON.stringify(dados), {
            status: resposta.status,
            headers: {
                "Content-Type": "application/json",
                "Cache-Control": "public, max-age=300"
            }
        });

    } catch (erro) {
        return new Response(
            JSON.stringify({ erro: "Falha ao consultar o TMDB." }),
            {
                status: 502,
                headers: { "Content-Type": "application/json" }
            }
        );
    }
};
