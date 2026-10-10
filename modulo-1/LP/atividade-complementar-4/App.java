import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean parada = true;
        double somaAltura = 0;
        double maiorAltura = 0;
        String nomeMaiorAltura = null;
        int qtdA = 0;
        int qtdB = 0;
        int qtdC = 0;
        int totalJogadores = 0;

        do{
            System.out.println("<! --- Processamento de Jogadores --- !>");

            System.out.print("Informe a quantidade de jogadores: ");
            int qtdJogadores = Integer.parseInt(sc.nextLine());
            totalJogadores = qtdJogadores;

            System.out.printf("[INFO] - %d jogadores criados \n",qtdJogadores);

            System.out.println("[INFO] Insira os dados de cada jogador a seguir");
            for(int i = 0; i < qtdJogadores; i++){
                System.out.printf("# Início do %dª Jogador: \n", i+1);
                Jogador jog = new Jogador();

                System.out.println("Informe o nome: ");
                String nome = sc.nextLine();

                System.out.println("Informe a altura: ");
                double altura = Double.parseDouble(sc.nextLine());

                jog.setNome(nome);
                jog.setAltura(altura);
                jog.resumoJogador();

                switch (jog.categoria()) {
                    case "A":
                        qtdA++;
                        break;
                    case "B":
                        qtdB++;
                        break;
                    case "C":
                        qtdC++;
                        break;
                    default:
                        System.out.println("Categoria Inválida");
                        break;
                }


                somaAltura += altura;
                if(altura > maiorAltura){
                    maiorAltura = altura;
                    nomeMaiorAltura = nome;
                }
            }
            System.out.println("<! --- Processamento de Jogadores Finalizado --- !>");

            System.out.println(" # Resultados # ");

            printMediaAltura(qtdJogadores, somaAltura);
            printMaiorAltura(nomeMaiorAltura, maiorAltura);
            printPercentuaisCategoriais(qtdA, qtdB, qtdC, totalJogadores);

            System.out.println("[INFO] Deseja refazer ? 1 - Sim / 2 - Não");
            int continua = Integer.parseInt(sc.nextLine());
            parada = continua == 1 ? true : false;
        }
        while (parada);
        sc.close();
        System.out.println("<! --- Obrigado --- !>");
    }

    private static void printMediaAltura(int qtdJogadores, double somaAltura){
        double media = (double) somaAltura/qtdJogadores;
        System.out.printf("[INFO] Média de Altura do Time: %.2f m \n", media);
    }

    private static void printMaiorAltura(String nomeMaiorAltura, double maiorAltura){
        System.out.printf("[INFO] Maior Altura: %.2f m - Jogador: %s \n", maiorAltura, nomeMaiorAltura);
    }

    private static void printPercentuaisCategoriais(int qtdA, int qtdB, int qtdC, int totalJogadores){
        if((qtdA+qtdB+qtdC) != totalJogadores){
            System.out.println("[ERROR] Total de Jogadores Incorreto.");
        }

        double percentualA = ((double) qtdA/totalJogadores)*100;
        double percentualB = ((double) qtdB/totalJogadores)*100;
        double percentualC = ((double) qtdC/totalJogadores)*100;

        System.out.printf("[INFO] Percentual de jogadores que estão na categoria A: %.2f \n", percentualA);
        System.out.printf("[INFO] Percentual de jogadores que estão na categoria B: %.2f \n", percentualB);
        System.out.printf("[INFO] Percentual de jogadores que estão na categoria C: %.2f \n", percentualC);
    }
}


class Jogador {
    private String nome;
    private double altura;
    
    public Jogador(){

    }

    public Jogador(String nome, double altura){
        this.nome = nome;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String categoria(){
        if(altura >= 2.10){
            return "A";
        }else if(altura >= 1.90 && altura < 2.10){
            return "B";
        }else{
            return "C";
        }
    }

    public void resumoJogador(){
        System.out.printf("Resumo do Jogador: Nome: %s - Altura: %.2f m - Categoria: %s \n", nome, altura, categoria());
    }
    
}
