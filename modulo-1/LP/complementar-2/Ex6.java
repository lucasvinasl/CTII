import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Ex6 {
    static final int cigarrosPorCarteira = 20;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos anos você fuma: ");
        int anosFumando = sc.nextInt();

        System.out.println("Quantos cigarros por dia: ");
        int cigarrosPorDia = sc.nextInt();

        System.out.println("Valor da careteira de cigarro");
        BigDecimal valorCarteira = BigDecimal.valueOf(sc.nextDouble());


        BigDecimal valor = valorGasto(anosFumando, cigarrosPorDia, valorCarteira);
        System.out.printf("Valor gasto fumando: R$ %s\n", valor);
        
        sc.close();
    }

    private static BigDecimal valorGasto(int anosFumando, int cigarrosPorDia, BigDecimal valorCarteira){
        int totalDiasFumando = anosFumando * 365;
        int totalCigarros = totalDiasFumando * cigarrosPorDia;
        double totalCarteiras = (double) totalCigarros / cigarrosPorCarteira;
        
        return valorCarteira.multiply(BigDecimal.valueOf(totalCarteiras))
                            .setScale(2, RoundingMode.HALF_UP);
    }
}
