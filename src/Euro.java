public class Euro extends Moeda {
    public Euro(double valor){
        super(valor);
    }
    @Override
    public  void info() {
        System.out.printf("Euro: E$ %.2f%n", valor);
    }

    @Override
    public double converter(){
        return valor * 6.45; // Cotação do Euro
    }
}