package Q12;

public class Servico {
    private TipoServico tipo;
    private double valor;

    public Servico(TipoServico tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return tipo + " - R$ " + String.format("%.2f", valor);
    }
}