public abstract class Moeda {

    protected double valor;

    // Construtor que recebe valor
    public Moeda(double valor) {
        this.valor = valor;
    }
    // Get do valor
    public double getValor() {
        return valor;
    }

    // Método abstrato para mostrar info da moeda (será implementado nas subclasses)
    public abstract void info();

    // Método abstrato para converter (será implementado nas subclasses)
    public abstract double converter();

    // ======= ESSENCIAL PARA FUNCIONAR O REMOVE =======
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Se for o mesmo objeto, são iguais
        if (obj == null || getClass() != obj.getClass()) return false; // Tipos diferentes não são iguais

        Moeda moeda = (Moeda) obj;

        // Comparando até duas casas decimais, para evitar erro de arredondamento
        return Math.round(this.valor * 100) == Math.round(moeda.valor * 100);
    }

    @Override
    public int hashCode() {
        // Garante que moedas com mesmo valor tenham o mesmo hash
        return Double.hashCode(Math.round(valor * 100) / 100.0);
    }
}