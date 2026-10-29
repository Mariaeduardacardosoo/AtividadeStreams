package Q08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {

        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Maria", 19),
                new Pessoa("João", 16),
                new Pessoa("Ana", 25),
                new Pessoa("Pedro", 18),
                new Pessoa("Carlos", 32)
        );

        List<String> nomes = pessoas.stream()
                .filter(pessoa -> pessoa.getIdade() > 18)
                .map(Pessoa::getNome)
                .collect(Collectors.toList());

        System.out.println("Pessoas com mais de 18 anos: " + nomes);
    }
}