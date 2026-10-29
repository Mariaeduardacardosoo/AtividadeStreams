package Q10;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<Pedido> pedidos = Arrays.asList(
                new Pedido(1, 150.00),
                new Pedido(2, 250.50),
                new Pedido(3, 99.90),
                new Pedido(4, 100.00)
        );

        double total = pedidos.stream()
                .mapToDouble(Pedido::getValor)
                .sum();

        System.out.printf("Valor total dos pedidos: R$ %.2f%n", total);
    }
}
