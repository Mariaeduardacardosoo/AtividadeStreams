package Q12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Autonomo> autonomos = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE AUTÔNOMOS =====");
            System.out.println("1 - Cadastrar autônomo");
            System.out.println("2 - Cadastrar serviço");
            System.out.println("3 - Consultar serviços por CPF");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Nome do autônomo: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    boolean cpfExiste = autonomos.stream()
                            .anyMatch(a -> a.getCpf().equals(cpf));

                    if (cpfExiste) {
                        System.out.println("CPF já cadastrado!");
                    } else {
                        autonomos.add(new Autonomo(nome, cpf));
                        System.out.println("Autônomo cadastrado!");
                    }
                    break;

                case 2:
                    System.out.print("CPF do autônomo: ");
                    String cpfBusca = sc.nextLine();

                    Autonomo autonomo = autonomos.stream()
                            .filter(a -> a.getCpf().equals(cpfBusca))
                            .findFirst()
                            .orElse(null);

                    if (autonomo == null) {
                        System.out.println("Autônomo não encontrado!");
                        break;
                    }

                    System.out.println("Tipo de serviço:");
                    System.out.println("1 - ELÉTRICO");
                    System.out.println("2 - HIDRÁULICO");
                    System.out.println("3 - ALVENARIA");
                    System.out.print("Escolha: ");

                    int tipoOpcao = Integer.parseInt(sc.nextLine());

                    TipoServico tipo = null;

                    switch (tipoOpcao) {
                        case 1:
                            tipo = TipoServico.ELETRICO;
                            break;
                        case 2:
                            tipo = TipoServico.HIDRAULICO;
                            break;
                        case 3:
                            tipo = TipoServico.ALVENARIA;
                            break;
                        default:
                            System.out.println("Tipo inválido!");
                            break;
                    }

                    if (tipoOpcao < 1 || tipoOpcao > 3) {
                        break;
                    }

                    System.out.print("Valor do serviço: R$ ");
                    double valor = Double.parseDouble(sc.nextLine());

                    if (valor < 0) {
                        System.out.println("O valor não pode ser negativo!");
                        break;
                    }

                    autonomo.adicionarServico(new Servico(tipo, valor));
                    System.out.println("Serviço cadastrado!");
                    break;

                case 3:
                    System.out.print("CPF do autônomo: ");
                    String cpfConsulta = sc.nextLine();

                    Autonomo encontrado = autonomos.stream()
                            .filter(a -> a.getCpf().equals(cpfConsulta))
                            .findFirst()
                            .orElse(null);

                    if (encontrado == null) {
                        System.out.println("Autônomo não encontrado!");
                        break;
                    }

                    System.out.println("\nAutônomo: " + encontrado.getNome());

                    List<Servico> servicos = encontrado.getServicos();

                    if (servicos.isEmpty()) {
                        System.out.println("Nenhum serviço cadastrado.");
                        break;
                    }

                    Map<TipoServico, List<Servico>> grupos = servicos.stream()
                            .collect(Collectors.groupingBy(Servico::getTipo));

                    grupos.forEach((tipoServico, lista) -> {
                        System.out.println("\n" + tipoServico + ":");

                        lista.forEach(System.out::println);

                        double subtotal = lista.stream()
                                .mapToDouble(Servico::getValor)
                                .sum();

                        System.out.printf("Subtotal: R$ %.2f%n", subtotal);
                    });

                    double total = servicos.stream()
                            .mapToDouble(Servico::getValor)
                            .sum();

                    System.out.printf(
                            "%nValor total de todos os serviços: R$ %.2f%n",
                            total
                    );
                    break;

                case 0:
                    System.out.println("Sistema encerrado!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
