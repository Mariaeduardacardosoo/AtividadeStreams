package Q03;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(2, 5, 8, 10, 15, 13, 29, 6);

        numeros.stream()
                .forEach(n -> System.out.println(n * 2));
    }
}
