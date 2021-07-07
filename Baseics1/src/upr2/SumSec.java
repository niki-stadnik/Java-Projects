package upr2;

import java.util.Scanner;

public class SumSec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int d = a + b + c;
        int min = 0;
        int sek = 0;
        if (d < 60) {
            sek = d;
        } else if (d < 120) {
            min = 1;
            sek = d - 60;
        } else if (d < 180) {
            min = 2;
            sek = d - 120;
        }
        if (sek < 10) {
            System.out.printf("%d:0%d", min, sek);
        } else System.out.printf("%d:%d", min, sek);
    }
}
