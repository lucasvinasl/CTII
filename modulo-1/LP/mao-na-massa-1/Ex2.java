import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o lado: ");
        double num = sc.nextDouble();

        calcularArea(num);
        calcularPerimetro(num);
        sc.close();
    }

    private static void calcularArea(double lado){
        double area = lado * lado;
        System.out.printf("A área do quadrado de lado %.2f é: %.2f \n", lado, area);

    }

    private static void calcularPerimetro(double lado){
        double perimetro = lado * 4;
        System.out.printf("O perímetro do quadrado de lado %.2f é: %.2f \n", lado, perimetro);
    }
}
