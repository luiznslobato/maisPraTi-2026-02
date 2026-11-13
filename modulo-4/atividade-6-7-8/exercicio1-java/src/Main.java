public class Main {

    public static void main(String[] args) {

        // Criando a biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Criando os itens
        Livro livro1 = new Livro("L001", "Dom Casmurro");
        Livro livro2 = new Livro("L002", "O Pequeno Principe");

        Revista revista1 = new Revista("R001", "National Geographic");

        DVD dvd1 = new DVD("D001", "Interestelar");

        // Cadastrando os itens
        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(dvd1);

        // Criando os usuarios
        Aluno aluno = new Aluno("Carlos");
        Professor professor = new Professor("Mariana");

        // Cadastrando os usuarios
        biblioteca.cadastrarUsuario(aluno);
        biblioteca.cadastrarUsuario(professor);

        System.out.println("\n===== TESTE DE EMPRESTIMOS =====");

        // Tres emprestimos para o aluno
        biblioteca.emprestar(livro1, aluno);
        biblioteca.emprestar(livro2, aluno);
        biblioteca.emprestar(revista1, aluno);

        // Tentativa de quarto emprestimo
        System.out.println("\nTentativa de quarto emprestimo:");
        biblioteca.emprestar(dvd1, aluno);

        // Professor realiza um emprestimo
        System.out.println("\nEmprestimo para professor:");
        biblioteca.emprestar(dvd1, professor);

        // Listando o acervo
        biblioteca.listarAcervo();

        // Devolvendo um livro
        System.out.println("\n===== TESTE DE DEVOLUCAO =====");
        biblioteca.devolver(livro1, aluno);

        // Aluno tenta realizar novo emprestimo
        System.out.println("\nNovo emprestimo para o aluno:");
        biblioteca.emprestar(livro1, aluno);

        // Listagem final
        biblioteca.listarAcervo();

        // Testando calculo de multa
        System.out.println("\n===== TESTE DE MULTAS =====");

        System.out.printf("Livro - 3 dias de atraso: R$ %.2f%n",
                livro1.calcularMulta(3));

        System.out.printf("Revista - 3 dias de atraso: R$ %.2f%n",
                revista1.calcularMulta(3));

        System.out.printf("DVD - 3 dias de atraso: R$ %.2f%n",
                dvd1.calcularMulta(3));
    }
}
