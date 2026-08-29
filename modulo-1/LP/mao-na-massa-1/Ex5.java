import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Informe sua idade: ");
        int idade = sc.nextInt();

        int dias = diasVividos(idade);
        System.out.printf("%S, VOCÊ JÁ VIVEU %d DIAS!", nome, dias);


        sc.close();        
    }

    private static int diasVividos(int anos){
        return anos*365;
    }
}
