package Q11;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {

        List<String> palavras = Arrays.asList(
                "casa", "sol", "livro", "lua", "carro", "flor", "computador"
        );

        Map<Integer, List<String>> grupos = palavras.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(grupos);
    }
}
