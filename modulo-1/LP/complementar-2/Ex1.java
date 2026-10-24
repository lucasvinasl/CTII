import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o número: ");
        int num = sc.nextInt();

        sucessor(num);
        sc.close();        
    }

    private static void sucessor(int n){
        System.out.printf("O sucessor de %d é %d \n",n,n+1);
    }
}