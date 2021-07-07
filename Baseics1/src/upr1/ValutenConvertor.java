package upr1;

import java.util.Scanner;

public class ValutenConvertor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double suma = Double.parseDouble(scanner.nextLine());
        String valutaVhod = scanner.nextLine();
        String valutaIzhod = scanner.nextLine();
        double sumaVLeva = 0;
        double izhod = 0;
        if (valutaVhod.equals("BGN")) {
            sumaVLeva = suma;
        } else if (valutaVhod.equals("USD")) {
            sumaVLeva = suma * 1.79549;
        } else if (valutaVhod.equals("EUR")) {
            sumaVLeva = suma * 1.95583;
        } else if (valutaVhod.equals("GBP")) {
            sumaVLeva = suma * 2.53405;
        }
        if (valutaIzhod.equals("BGN")) {
            izhod = sumaVLeva;
        } else if (valutaIzhod.equals("USD")) {
            izhod = sumaVLeva / 1.79549;
        } else if (valutaIzhod.equals("EUR")) {
            izhod = sumaVLeva / 1.95583;
        } else if (valutaIzhod.equals("GBP")) {
            izhod = sumaVLeva / 2.53405;
        }
        System.out.printf("%.2f", izhod);
    }
}
