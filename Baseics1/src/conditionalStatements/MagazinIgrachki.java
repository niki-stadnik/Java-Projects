package conditionalStatements;

import java.util.Scanner;

public class MagazinIgrachki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ekskurziq = Double.parseDouble(scanner.nextLine());
        double broiPuzeli = Double.parseDouble(scanner.nextLine());
        double broiKukli = Double.parseDouble(scanner.nextLine());
        double broiMechete = Double.parseDouble(scanner.nextLine());
        double broiMinioni = Double.parseDouble(scanner.nextLine());
        double broiKamioncheta = Double.parseDouble(scanner.nextLine());
        double broiProdajbi = broiKamioncheta + broiKukli + broiMechete + broiMinioni + broiPuzeli;
        double cenaProdadeni = broiKamioncheta * 2 + broiKukli * 3 + broiMechete * 4.1 + broiMinioni * 8.2 + broiPuzeli * 2.6;
        double speceleni;
        if (broiProdajbi >= 50) {
            speceleni = cenaProdadeni * 0.75;
        } else speceleni = cenaProdadeni;
        double finalnaSuma = speceleni * 0.9;
        double smetka = finalnaSuma - ekskurziq;
        if (smetka >= 0) {
            System.out.printf("Yes! %.2f lv left.", smetka);
        } else System.out.printf("Not enough money! %.2f lv needed.", Math.abs(smetka));
    }
}
