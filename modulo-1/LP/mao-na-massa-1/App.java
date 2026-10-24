import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean parada = true;

        do {
            System.out.println("<!--- Sistema de Lavação - WashMe ---!>");
            System.out.println("<!--- Bem Vindo! ---!>");

            System.out.print("Informe a quantidade de clientes a serem atendidos: ");
            int qtdClientes = Integer.parseInt(sc.nextLine());

            System.out.printf("[INFO] - %d cliente(s) para cadastro\n", qtdClientes);

            double valorTotalArrecadado = 0;
            
            int qtdV1 = 0;
            int qtdV2 = 0;
            int qtdV3 = 0;
            
            int qtdS1 = 0;
            int qtdS2 = 0;
            int qtdS3 = 0;

            System.out.println("[INFO] Insira os dados de cada cliente a seguir:");
            for (int i = 0; i < qtdClientes; i++) {
                System.out.printf("\n# Início do atendimento do %dº Cliente:\n", i + 1);

                System.out.print("[INFO]: Informe o seu nome: ");
                String nomeCliente = sc.nextLine();

                int tipoVeiculo = 0;
                boolean veiculoValido = false;
                while (veiculoValido == false) {
                    System.out.println("[INFO]: Qual o tipo do veículo: ");
                    listarTiposVeiculos();
                    tipoVeiculo = Integer.parseInt(sc.nextLine());

                    if (tipoVeiculo >= 1 && tipoVeiculo <= 3) {
                        veiculoValido = true;
                    } 
                    else {
                        System.out.println("[ERRO]: Opção de Veículo inválida. Tente novamente.");
                    }
                }

                int tipoServico = 0;
                boolean servicoValido = false;
                while (servicoValido == false) {
                    System.out.println("[INFO]: Qual serviço realizar: ");
                    listarTiposServicos();
                    tipoServico = Integer.parseInt(sc.nextLine());

                    if (tipoServico >= 1 && tipoServico <= 3) {
                        servicoValido = true;
                    } 
                    else {
                        System.out.println("[ERRO]: Opção de Serviço inválida. Tente novamente.");
                    }
                }

                double valor = precoServicoPorVeiculo(tipoVeiculo, tipoServico);

                Cliente cliente = criarCliente(nomeCliente, tipoServico, tipoVeiculo, valor);
                System.out.println();
                cliente.apresentarCliente();

                valorTotalArrecadado += valor;

                if (tipoVeiculo == 1) {
                    qtdV1++;
                } 
                else if (tipoVeiculo == 2) {
                    qtdV2++;
                } 
                else if (tipoVeiculo == 3) {
                    qtdV3++;
                }

                if (tipoServico == 1) {
                    qtdS1++;
                } 
                else if (tipoServico == 2) {
                    qtdS2++;
                } 
                else if (tipoServico == 3) {
                    qtdS3++;
                }
            }

            System.out.println("\n<! --- Processamento de Atendimentos Finalizado --- !>");
            System.out.println(" # Resultados Finais # \n");

            printPercentuaisVeiculos(qtdV1, qtdV2, qtdV3, qtdClientes);
            printPercentuaisServicos(qtdS1, qtdS2, qtdS3, qtdClientes);
            printValorTotal(valorTotalArrecadado);
            printMaisAtendidosVeiculo(qtdV1, qtdV2, qtdV3);
            printMaisAtendidosServico(qtdS1, qtdS2, qtdS3);

            System.out.println("\n[INFO] Deseja refazer o sistema? 1 - Sim / 2 - Não");
            int continua = Integer.parseInt(sc.nextLine());
            
            if (continua == 1) {
                parada = true;
            } 
            else {
                parada = false;
            }

        } while (parada);

        sc.close();
        System.out.println("<! --- Obrigado por utilizar o Sistema WashMe --- !>");
    }

    public static Cliente criarCliente(String nome, int servico, int veiculo, double valor) {
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setTipoServico(TipoServico.fromOpcao(servico));
        c.setTipoVeiculo(TipoVeiculo.fromOpcao(veiculo));
        c.setValorServico(valor);
        return c;
    }

    public static void listarTiposVeiculos() {
        for (TipoVeiculo v : TipoVeiculo.values()) {
            System.out.println(v.getOpcao() + " - " + v.name() + " - " + v.getDescricao());
        }
    }

    public static void listarTiposServicos() {
        for (TipoServico s : TipoServico.values()) {
            System.out.println(s.getOpcao() + " - " + s.getDescricao());
        }
    }

    public static double precoServicoPorVeiculo(int tipoVeiculo, int tipoService) {
        double valorServico = 0;
        switch (tipoService) {
            case 1:
                if (tipoVeiculo == 1) {
                    valorServico = 80;
                } 
                else if (tipoVeiculo == 2) {
                    valorServico = 100;
                } 
                else if (tipoVeiculo == 3) {
                    valorServico = 120;
                }
                break;
            case 2:
                if (tipoVeiculo == 1) {
                    valorServico = 100;
                } 
                else if (tipoVeiculo == 2) {
                    valorServico = 120;
                } 
                else if (tipoVeiculo == 3) {
                    valorServico = 140;
                }
                break;
            case 3:
                if (tipoVeiculo == 1) {
                    valorServico = 120;
                } 
                else if (tipoVeiculo == 2) {
                    valorServico = 140;
                } 
                else if (tipoVeiculo == 3) {
                    valorServico = 160;
                }
                break;
        }
        return valorServico;
    }

    private static void printPercentuaisVeiculos(int v1, int v2, int v3, int total) {
        double perc1 = 0;
        double perc2 = 0;
        double perc3 = 0;

        if (total > 0) {
            perc1 = ((double) v1 / total) * 100;
            perc2 = ((double) v2 / total) * 100;
            perc3 = ((double) v3 / total) * 100;
        }

        System.out.println("[INFO] Percentuais de Atendimento por Tipo de Veículo:");
        System.out.printf(" - %s: %.2f%%\n", TipoVeiculo.fromOpcao(1).getDescricao(), perc1);
        System.out.printf(" - %s: %.2f%%\n", TipoVeiculo.fromOpcao(2).getDescricao(), perc2);
        System.out.printf(" - %s: %.2f%%\n", TipoVeiculo.fromOpcao(3).getDescricao(), perc3);
    }

    private static void printPercentuaisServicos(int s1, int s2, int s3, int total) {
        double perc1 = 0;
        double perc2 = 0;
        double perc3 = 0;

        if (total > 0) {
            perc1 = ((double) s1 / total) * 100;
            perc2 = ((double) s2 / total) * 100;
            perc3 = ((double) s3 / total) * 100;
        }

        System.out.println("[INFO] Percentuais de Atendimento por Tipo de Serviço:");
        System.out.printf(" - %s: %.2f%%\n", TipoServico.fromOpcao(1).getDescricao(), perc1);
        System.out.printf(" - %s: %.2f%%\n", TipoServico.fromOpcao(2).getDescricao(), perc2);
        System.out.printf(" - %s: %.2f%%\n", TipoServico.fromOpcao(3).getDescricao(), perc3);
    }

    private static void printValorTotal(double valorTotal) {
        System.out.printf("[INFO] Valor Total Arrecadado: R$ %.2f\n", valorTotal);
    }

    private static void printMaisAtendidosVeiculo(int v1, int v2, int v3) {
        int max = Math.max(v1, Math.max(v2, v3));
        System.out.print("[INFO] Tipo(s) de veículo mais atendido(s): ");
        boolean primeiro = true;

        if (v1 == max) {
            System.out.print(TipoVeiculo.fromOpcao(1).getDescricao());
            primeiro = false;
        }

        if (v2 == max) {
            if (primeiro == false) {
                System.out.print(", ");
            }
            System.out.print(TipoVeiculo.fromOpcao(2).getDescricao());
            primeiro = false;
        }

        if (v3 == max) {
            if (primeiro == false) {
                System.out.print(", ");
            }
            System.out.print(TipoVeiculo.fromOpcao(3).getDescricao());
        }
        System.out.println();
    }

    private static void printMaisAtendidosServico(int s1, int s2, int s3) {
        int max = Math.max(s1, Math.max(s2, s3));
        System.out.print("[INFO] Serviço(s) mais atendido(s): ");
        boolean primeiro = true;

        if (s1 == max) {
            System.out.print(TipoServico.fromOpcao(1).getDescricao());
            primeiro = false;
        }

        if (s2 == max) {
            if (primeiro == false) {
                System.out.print(", ");
            }
            System.out.print(TipoServico.fromOpcao(2).getDescricao());
            primeiro = false;
        }

        if (s3 == max) {
            if (primeiro == false) {
                System.out.print(", ");
            }
            System.out.print(TipoServico.fromOpcao(3).getDescricao());
        }
        System.out.println();
    }
}