import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] valores = new int[3];

        for(int i = 0; i < valores.length; i++){
            System.out.printf("Informe o %dª número: ", i+1);
            int val = sc.nextInt();
            valores[i] = val;
        }

        validar(valores);
        sc.close();
    }    

    private static void validar(int[] valores){
        int primeiro = valores[0];
        int soma = 0;
        for(int i = 0; i < valores.length; i++){
            if(i == 0) continue;
            soma += valores[i];
        }
        
        if(primeiro > soma){
            System.out.println("O primeiro número é maior que a soma dos outros dois");
            System.out.printf("Primeiro: %d - Soma: %d \n", primeiro, soma);
        }else{
            System.out.println("O primeiro número NÃO é maior que a soma dos outros dois");
            System.out.printf("Primeiro: %d - Soma: %d \n", primeiro, soma);
        }
    }
}
