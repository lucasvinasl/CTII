import java.util.Scanner;


public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o valor do raio: ");
        double raio = sc.nextDouble();
        System.out.println("Informe o valor da altu: ");
        double altura = sc.nextDouble();

        calcularAreaBase(raio);
        calcularVolume(raio, altura);
                
        sc.close();
    }

    private static double calcularAreaBase(double raio){
        double area = Math.PI * raio * raio;
        System.out.printf("O valor da área base é %.2f \n", area);
        return area;
    }

    private static void calcularVolume(double raio, double altura){
        double volume = calcularAreaBase(raio) * altura;
        System.out.printf("O valor do perímetro é %.2f \n", volume);
    }
}
