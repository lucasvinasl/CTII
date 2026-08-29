import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Custo de fabricação: ");
        BigDecimal custo = sc.nextBigDecimal();
        
        System.out.printf("Valor Final: R$ %s = Custo: R$ %s + Imposto: R$ %s + Lucro: R$ %s\n", 
                          valorVenda(custo), custo, imposto(custo), lucro(custo));
        sc.close();
    }

    private static BigDecimal imposto(BigDecimal custo){
        return custo.multiply(BigDecimal.valueOf(0.45))
            .setScale(2, RoundingMode.HALF_UP);
    }

    private static BigDecimal lucro(BigDecimal custo){
        return custo.multiply(BigDecimal.valueOf(0.12))
            .setScale(2, RoundingMode.HALF_UP);
    }

    private static BigDecimal valorVenda(BigDecimal custo){
        return custo.add(imposto(custo)).add(lucro(custo))
            .setScale(2, RoundingMode.HALF_UP);
    }
}
