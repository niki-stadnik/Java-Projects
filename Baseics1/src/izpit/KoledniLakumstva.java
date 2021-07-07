package izpit;

import java.util.Scanner;

public class KoledniLakumstva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cenaBaklava = Double.parseDouble(scanner.nextLine());
        double cenaMufini = Double.parseDouble(scanner.nextLine());
        double kgSholen = Double.parseDouble(scanner.nextLine());
        double kgBonboni = Double.parseDouble(scanner.nextLine());
        double kgBiskviti = Double.parseDouble(scanner.nextLine());
        double cenaSholen = cenaBaklava + cenaBaklava*0.60;
        double sumaSholen = kgSholen*cenaSholen;
        double cenaBonboni = cenaMufini + cenaMufini*0.8;
        double sumaBonboni = kgBonboni*cenaBonboni;
        double sumaBiskviti = kgBiskviti*7.5;
        double smetka = sumaBiskviti+sumaBonboni+sumaSholen;
        System.out.printf("%.2f", smetka);
    }
}
