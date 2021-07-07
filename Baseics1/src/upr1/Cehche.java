package upr1;

import java.util.Scanner;

public class Cehche {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double broiMasi = Double.parseDouble(scanner.nextLine());
        double drljina = Double.parseDouble(scanner.nextLine());
        double shirina = Double.parseDouble(scanner.nextLine());
        double sPokrivka = broiMasi*(drljina+0.60)*(shirina+0.60);
        double sKareta = broiMasi*(drljina/2)*(drljina/2);
        double cenaUSD = sPokrivka*7+sKareta*9;
        double cenaBGN = cenaUSD*1.85;
        System.out.printf("%.2f USD%n", cenaUSD);
        System.out.printf("%.2f BGN", cenaBGN);
    }
}
