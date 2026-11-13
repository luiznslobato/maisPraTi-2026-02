public abstract class ItemBiblioteca {

    private String codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public abstract int getPrazoDevolucao();

    public abstract double getMultaDiaria();

    public double calcularMulta(int diasAtraso) {
        if (diasAtraso <= 0) {
            return 0.0;
        }

        return diasAtraso * getMultaDiaria();
    }

    void marcarComoEmprestado() {
        disponivel = false;
    }

    void marcarComoDevolvido() {
        disponivel = true;
    }
}

