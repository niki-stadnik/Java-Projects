package upr1;

import java.util.Scanner;

public class BlagotvoritelnaKampaniq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dni = Double.parseDouble(scanner.nextLine());
        double sladkari = Double.parseDouble(scanner.nextLine());
        double torti = Double.parseDouble(scanner.nextLine());
        double gofreti = Double.parseDouble(scanner.nextLine());
        double palachinki = Double.parseDouble(scanner.nextLine());
        double cenaTorti = torti * 45;
        double cenaGofreti = gofreti * 5.80;
        double cenaPalachinki = palachinki * 3.2;
        double suma = (cenaGofreti + cenaPalachinki + cenaTorti) * sladkari * dni;
        double finalna = suma - (suma / 8);
        System.out.printf("%.2f", finalna);
    }
}