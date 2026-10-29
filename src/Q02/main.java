package Q02;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<String> nomes = Arrays.asList(
                "maria", "eduarda", "joão", "pedro"
        );

        nomes.stream()
                .map(nome -> nome.toUpperCase())
                .forEach(System.out::println);
    }
}
