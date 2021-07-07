package upr2;

import java.util.Scanner;

public class BonusTochki {
    private static double obshtoTochki;         //променливи който могат да се променят от всички функции
    private static double bonus = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        if (x <= 100) {
            bonus = 5;
            BonusTochki.proverka(x);            //извикване на функция
            x = x + bonus;
            System.out.printf("%.1f", x);
        } else if (x <= 1000) {
            bonus = x * 0.2;
            BonusTochki.proverka(x);
            x = x + bonus;
            System.out.printf("%.1f", x);
        } else {
            bonus = x * 0.1;
            BonusTochki.proverka(x);
            x = x + bonus;
            System.out.printf("%.1f", x);
        }
    }

    public static void proverka(double y) {     //правене на функция
        if (y % 2 == 0) {
            bonus++;
        } else if (y % 5 == 0) {
            bonus = bonus + 2;
        }
        System.out.printf("%.1f\n", bonus);
    }
}
