public class Dolar extends Moeda {
    public Dolar(double valor){
        super(valor);
    }
    @Override
    public  void info() {
        System.out.printf("Dolar: US$ %.2f%n", valor);
    }

    @Override
    public double converter(){
        return valor * 5.56; // Cotação do Dollar
    }
}
