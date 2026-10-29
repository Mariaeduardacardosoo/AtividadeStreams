package Q05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {

        List<String> nomes = Arrays.asList(
                "Pedro", "Ana", "José", "Maria",
                "Antonia", "Augusto", "Carlos", "Francisco"
        );

        List<String> resultado = nomes.stream()
                .filter(nome -> nome.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(resultado);
    }
}

