package VlojeniCikli;
        /*Напишете програма, която изчислява колко решения в естествените числа (включително и нулата) има
        уравнението:
        x1 + x2 + x3 + x4 + x5 = n
        Числото n е цяло число и се въвежда от конзолата.*/
import java.util.Scanner;

public class Kombincaii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int x1, x2, x3, x4, x5, z = 0;
        for (x1 = 0; x1 <= n; x1++) {
            for (x2 = 0; x2 <= n; x2++) {
                for (x3 = 0; x3 <= n; x3++) {
                    for (x4 = 0; x4 <= n; x4++) {
                        for (x5 = 0; x5 <= n; x5++) {
                            if (x1 + x2 + x3 + x4 + x5 == n) z++;
                        }
                    }
                }
            }
        }
        System.out.println(z);
    }
}
