import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o numero A: ");
        int a = sc.nextInt();

        System.out.println("Informe o numero B: ");
        int b = sc.nextInt();

        if(a == b){
            System.out.printf("São iguais: A: %d - B: %d ", a,b);
        }else if(a > b){
            System.out.printf("A: %d > B: %d ", a,b);
        }else{
            System.out.printf("B: %d > A: %d ", b,a);
        }
    }    
}
