public class Livro extends ItemBiblioteca {

    public Livro(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoDevolucao() {
        return 14;
    }

    @Override
    public double getMultaDiaria() {
        return 0.50;
    }
}
