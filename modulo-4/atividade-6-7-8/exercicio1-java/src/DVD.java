public class DVD extends ItemBiblioteca {

    public DVD(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoDevolucao() {
        return 5;
    }

    @Override
    public double getMultaDiaria() {
        return 0.25;
    }
}

