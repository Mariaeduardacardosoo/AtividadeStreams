package Q06;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class main {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(4, 25, 32, 78, 45, 13, 10);

        Optional<Integer> maior = numeros.stream()
                .max(Integer::compareTo);

        System.out.println("Maior número: " + maior.get());
    }
}
