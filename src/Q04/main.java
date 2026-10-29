package Q04;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(
                4, 25, 32, 5, 45, 13, 8, 77, 58, 2, 52
        );

        long quantidade = numeros.stream()
                .filter(n -> n > 10)
                .count();

        System.out.println("Quantidade de números maiores que 10: " + quantidade);
    }
}
