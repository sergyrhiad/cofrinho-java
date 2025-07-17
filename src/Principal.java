import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Cofrinho cofre = new Cofrinho();
        int opcao = -1;

        //O usuário digita o número da opção desejada
        while  (opcao != 0){
            System.out.print("________________________________________________");
            System.out.println("\n| ----- SEVEN KEYS BANK - COFRE DIGITAL -------- |");            
            System.out.println("|   1 -       Adicionar Moeda(s)                 |");
            System.out.println("|   2 -       Remover Moeda(s)                   |");
            System.out.println("|   3 -       Listar Moeda(s)                    |");
            System.out.println("|   4 -       Total em Reais                     |");
            System.out.println("|   0 -       Sair                               |");
            System.out.println("_________________________________________________");
            System.out.println("    Escolha: ");
            System.out.print("_________________________________________________");
            opcao = teclado.nextInt();

            //Switch & Case para escolher o que fazer
            switch (opcao){
                case 1:
                adicionarMoeda(teclado, cofre);
                break;
                case 2:
                removerMoeda(teclado, cofre);
                break;
                case 3:
                cofre.listagemMoedas();
                break;
                case 4:
                System.out.printf("Total em Reais: R$ %.2f%n", cofre.totalConvertido());
                break;
                case 0:
                System.out.println("Saindo. Obrigado!");
                break;
                default:
                System.out.println("Opcao invalida.");
            }
        }
        teclado.close();
    }
    public static void adicionarMoeda(Scanner teclado, Cofrinho cofre){
    System.out.println("Tipo de Moeda: 1- Real | 2- Dolar | 3- Euro");
    int tipo = teclado.nextInt();

    // Validação do tipo antes de pedir o valor
    if (tipo != 1 && tipo != 2 && tipo != 3) {
        System.out.println("Tipo inválido! Só existem 3 opções: 1-Real, 2-Dolar, 3-Euro.");
        return; // Sai do método sem pedir o valor
    }

    System.out.println("Informe o valor da Moeda: ");
    double valor = teclado.nextDouble();

    // Validação para não aceitar valor negativo ou zero
    if (valor <= 0) {
        System.out.println("Valor inválido! O valor deve ser maior que zero.");
        return;
    }

    Moeda nova = null;
    if (tipo == 1) nova = new Real(valor);
    else if (tipo == 2) nova = new Dolar(valor);
    else if (tipo == 3) nova = new Euro(valor);

    cofre.adicionar(nova);
    System.out.println("Moeda adicionada!");
}
public static void removerMoeda(Scanner teclado, Cofrinho cofre){
    System.out.println("Tipo de Moeda: 1- Real | 2- Dolar | 3- Euro");
    int tipo = teclado.nextInt();

    // Validação do tipo
    if (tipo != 1 && tipo != 2 && tipo != 3) {
        System.out.println("Tipo inválido! Só existem 3 opções: 1-Real, 2-Dolar, 3-Euro.");
        return;
    }

    System.out.println("Informe o valor da Moeda que deseja Remover: ");
    double valor = teclado.nextDouble();

    // Validação para não aceitar valor negativo ou zero
    if (valor <= 0) {
        System.out.println("Valor inválido! O valor deve ser maior que zero.");
        return;
    }

    // Descobrir quanto existe dessa moeda no cofrinho
    double totalDaMoeda = 0.0;
    for (Moeda m : cofre.getListaMoedas()) {
        if ((tipo == 1 && m instanceof Real) ||
            (tipo == 2 && m instanceof Dolar) ||
            (tipo == 3 && m instanceof Euro)) {
            totalDaMoeda += m.getValor();
        }
    }

    if (valor > totalDaMoeda) {
        System.out.println("Erro: Não há saldo suficiente para remover esse valor.");
        return;
    }

    // Agora remove moedas suficientes até atingir o valor solicitado
    double valorRestante = valor;
    ArrayList<Moeda> paraRemover = new ArrayList<>();
    for (Moeda m : cofre.getListaMoedas()) {
        if (valorRestante <= 0) break;
        if ((tipo == 1 && m instanceof Real) ||
            (tipo == 2 && m instanceof Dolar) ||
            (tipo == 3 && m instanceof Euro)) {
            if (m.getValor() <= valorRestante + 0.0001) { // margem de erro para double
                valorRestante -= m.getValor();
                paraRemover.add(m);
            }
        }
    }
    for (Moeda m : paraRemover) {
        cofre.remover(m);
    }

    System.out.println("Valor removido do cofrinho!");
    }
}
