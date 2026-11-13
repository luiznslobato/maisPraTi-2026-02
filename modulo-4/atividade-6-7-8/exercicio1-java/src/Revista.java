public class Revista extends ItemBiblioteca {

    public Revista(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoDevolucao() {
        return 7;
    }

    @Override
    public double getMultaDiaria() {
        return 1.00;
    }
}
