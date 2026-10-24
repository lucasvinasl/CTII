import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o raio: ");
        double num = sc.nextDouble();

        calcularArea(num);
        calcularPerimetro(num);
        sc.close();
    }    

    private static void calcularArea(double raio){
        double area = Math.PI * raio * raio;
        System.out.printf("O valor da área é %.2f", area);
    }

    private static void calcularPerimetro(double raio){
        double perimetro = 2 * Math.PI * raio;
        System.out.printf("O valor do perímetro é %.2f", perimetro);
    }
}
