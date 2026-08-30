import java.util.Scanner;

public class Triangulos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] lados = new int[3];

        for(int i = 0; i < lados.length; i++){
            System.out.printf("Informe o lado %d: \n", i + 1);
            int ladoInformado = sc.nextInt();
            sc.nextLine();
            lados[i] = ladoInformado;
        }

        if(isTriangulo(lados)){
            if(isEquilatero(lados)){
                System.out.println("É equilátero");
            } else if(isIsoceles(lados)){
                System.out.println("É isóceles");
            } else if(isEscaleno(lados)){
                System.out.println("É escaleno");
            }
        } else {
            System.out.println("Não é um triângulo.");
        }
        
        sc.close();
    }

    private static boolean isTriangulo(int[] lados){
        int soma = somaDosLados(lados);
        boolean isTriangulo = true;
        
        for(int i = 0; i < lados.length; i++){
            int somaOutrosDois = soma - lados[i];

            if(lados[i] >= somaOutrosDois){
                isTriangulo = false;
                System.out.printf("Não é triângulo. Lado: %d, maior ou igual que a soma dos outros dois (%d)\n", lados[i], somaOutrosDois);
                break;
            }
        }

        if(isTriangulo){
            System.out.println("É triângulo.");
        }
        return isTriangulo;
    }

    private static int somaDosLados(int[] lados){
        int soma = 0;
        for(int i = 0; i < lados.length; i++){
            soma += lados[i];
        }
        System.out.printf("Soma dos lados: %d \n", soma);
        return soma;
    }

    private static boolean isEquilatero(int[] lados){
        System.out.println("<!-- isEquilatero --!>");
        boolean isEquilatero = true;

        for(int i = 0; i < lados.length; i++){
            System.out.println("Lado 1: " + lados[0]);
            System.out.println("Lado Atual: " + lados[i]);
            if(lados[i] != lados[0]){
                isEquilatero = false;
                break;
            }
        }
        System.out.println("<!-- isEquilatero:  --!>" + isEquilatero);
        return isEquilatero;        
    }

    private static boolean isIsoceles(int[] lados){
        int tamanho = lados.length;
        int contadorParesIguais = 0;

        System.out.println("<!-- isIsoceles --!>");
        for(int i = 0; i < tamanho; i++){
            System.out.println("Lado Atual: " + lados[i]);
            for(int j = 0; j < tamanho; j++){
                System.out.println("Lado Checando: " + lados[j]);
                if(i == j) continue;
                if(lados[i] == lados[j]){
                    contadorParesIguais++;
                }
            }
        }
        
        boolean isIsoceles = (contadorParesIguais == 2);
        
        System.out.println("<!-- isIsoceles:  --!>" + isIsoceles);
        return isIsoceles;        
    }

    private static boolean isEscaleno(int[] lados){
        System.out.println("<!-- isEscaleno --!>");
        int tamanho = lados.length;
        boolean isEscaleno = true;

        for(int i = 0; i < tamanho; i++){
            System.out.println("Lado Atual: " + lados[i]);
            for(int j = i + 1; j < tamanho; j++){
                System.out.println("Lado Checando: " + lados[j]);
                if(lados[i] == lados[j]){
                    isEscaleno = false;
                    break;
                }
            }
            if(!isEscaleno) break;
        }
        System.out.println("<!-- isEscaleno:  --!>" + isEscaleno);
        return isEscaleno;  
    }
}