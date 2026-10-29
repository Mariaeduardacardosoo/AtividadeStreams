package Q07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {

        List<String> palavras = Arrays.asList(
                "casa", "professor", "computador", "biblioteca", "faculdade", "aluno", "sol", "lua"
        );

        List<String> resultado = palavras.stream()
                .filter(palavra -> palavra.length() > 5)
                .collect(Collectors.toList());

        System.out.println("Quantidade de palavras com mais de 5 letras: "
                + resultado.size());

        System.out.println("Sendo elas: " + resultado);
    }
}
