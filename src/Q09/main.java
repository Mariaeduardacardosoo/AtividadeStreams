package Q09;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(4, 25, 32, 5, 45, 13, 8);

        boolean todosPositivos = numeros.stream()
                .allMatch(n -> n > 0);

        System.out.println("Todos os números são positivos? " + todosPositivos);
    }
}