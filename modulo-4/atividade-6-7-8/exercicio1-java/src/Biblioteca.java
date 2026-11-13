public class Biblioteca {

    private ItemBiblioteca[] itens;
    private Usuario[] usuarios;

    private ItemBiblioteca[] itensEmprestados;
    private Usuario[] usuariosEmprestimos;

    private int quantidadeItens;
    private int quantidadeUsuarios;

    public Biblioteca() {
        itens = new ItemBiblioteca[10];
        usuarios = new Usuario[10];

        itensEmprestados = new ItemBiblioteca[50];
        usuariosEmprestimos = new Usuario[50];

        quantidadeItens = 0;
        quantidadeUsuarios = 0;
    }

    public void cadastrarItem(ItemBiblioteca item) {
        if (quantidadeItens >= itens.length) {
            System.out.println("Limite de itens cadastrados atingido.");
            return;
        }

        itens[quantidadeItens] = item;
        quantidadeItens++;

        System.out.println("Item cadastrado: " + item.getTitulo());
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (quantidadeUsuarios >= usuarios.length) {
            System.out.println("Limite de usuários cadastrados atingido.");
            return;
        }

        usuarios[quantidadeUsuarios] = usuario;
        quantidadeUsuarios++;

        System.out.println("Usuário cadastrado: " + usuario.getNome());
    }

    public void emprestar(ItemBiblioteca item, Usuario usuario) {

        if (!itemCadastrado(item) || !usuarioCadastrado(usuario)) {
            System.out.println("Item ou usuário não cadastrado.");
            return;
        }

        if (!item.isDisponivel()) {
            System.out.println("Item indisponível para empréstimo.");
            return;
        }

        if (usuario.atingiuLimiteEmprestimos()) {
            System.out.println("Limite de empréstimos atingido para: "
                    + usuario.getNome());
            return;
        }

        int posicao = encontrarPosicaoLivre();

        if (posicao == -1) {
            System.out.println("Não há espaço para registrar novos empréstimos.");
            return;
        }

        item.marcarComoEmprestado();
        usuario.adicionarEmprestimo();

        itensEmprestados[posicao] = item;
        usuariosEmprestimos[posicao] = usuario;

        System.out.println("Empréstimo realizado: " + item.getTitulo()
                + " - Usuário: " + usuario.getNome());
    }

    public void devolver(ItemBiblioteca item, Usuario usuario) {

        for (int i = 0; i < itensEmprestados.length; i++) {

            if (itensEmprestados[i] == item
                    && usuariosEmprestimos[i] == usuario) {

                               item.marcarComoDevolvido();
                usuario.removerEmprestimo();

                itensEmprestados[i] = null;
                usuariosEmprestimos[i] = null;

                System.out.println("Devolução realizada: " + item.getTitulo());
                return;
            }
        }

        System.out.println("Empréstimo não encontrado para esse usuário.");
    }

    public void listarAcervo() {

        System.out.println("\n===== ACERVO DA BIBLIOTECA =====");

        for (int i = 0; i < quantidadeItens; i++) {

            ItemBiblioteca item = itens[i];

            System.out.println(
                    "Código: " + item.getCodigo()
                    + " | Título: " + item.getTitulo()
                    + " | Prazo: " + item.getPrazoDevolucao() + " dias"
                    + " | Multa diária: R$ " + item.getMultaDiaria()
                    + " | Disponível: "
                    + (item.isDisponivel() ? "Sim" : "Não")
            );
        }
    }

    private boolean itemCadastrado(ItemBiblioteca item) {
        for (int i = 0; i < quantidadeItens; i++) {
            if (itens[i] == item) {
                return true;
            }
        }

        return false;
    }

    private boolean usuarioCadastrado(Usuario usuario) {
        for (int i = 0; i < quantidadeUsuarios; i++) {
            if (usuarios[i] == usuario) {
                return true;
            }
        }

        return false;
    }

    private int encontrarPosicaoLivre() {
        for (int i = 0; i < itensEmprestados.length; i++) {
            if (itensEmprestados[i] == null) {
                return i;
            }
        }

        return -1;
    }
}
