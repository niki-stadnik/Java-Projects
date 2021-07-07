package izpit;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sladkarnica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sladkish = scanner.nextLine();
        double broi = Double.parseDouble(scanner.nextLine());
        double den = Double.parseDouble(scanner.nextLine());
        double cena = 0;
        if (den <= 15) {
            if (sladkish.equals("Cake")) cena = broi * 24;
            else if (sladkish.equals("Souffle")) cena = broi * 6.66;
            else if (sladkish.equals("Baklava")) cena = broi * 12.6;
        } else {
            if (sladkish.equals("Cake")) cena = broi * 28.7;
            else if (sladkish.equals("Souffle")) cena = broi * 9.8;
            else if (sladkish.equals("Baklava")) cena = broi * 16.98;
        }
        if (den <= 22) {
            if (cena >= 100 && cena <= 200) cena -= cena * 0.15;
            else if (cena > 200) cena -= cena * 0.25;
            if (den <= 15) cena -= cena * 0.1;
        }
        System.out.printf("%.2f", cena);
    }
}
