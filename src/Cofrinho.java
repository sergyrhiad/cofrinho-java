
import java.util.ArrayList; //Aceita qualquer objeto que seja filha de Moeda

public class Cofrinho {
    public ArrayList<Moeda> getListaMoedas() {
    return listaMoedas;
    }
    //Lista que ira guardar qualquer moeda (Real, Dolar, Euro ...)
    private  ArrayList<Moeda> listaMoedas = new ArrayList<>();

    //Adiciona Moedas ao cofrinho
    public void adicionar(Moeda m){ 
        listaMoedas.add(m);
    }

    //Remove moedas do cofrinho
    public void remover(Moeda m){
        listaMoedas.remove(m);
    }

    //Lista todas as moedas
    public void listagemMoedas(){ //chama o método info()
        if (listaMoedas.isEmpty()){
            System.out.println("Cofrinho vazio.");
            return;
        }
        for (Moeda m : listaMoedas){
            m.info();
        }
    }

    //Soma tudo convertido paraReal
    public double totalConvertido(){ //Soma cada moeda convertida
        double total = 0;
        for (Moeda m: listaMoedas){
            total += m.converter();
        }
        return total;
    }
}
