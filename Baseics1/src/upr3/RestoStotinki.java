package upr3;

import java.util.Scanner;


public class RestoStotinki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double resto = Double.parseDouble(scanner.nextLine());
        double moneti[] = {2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
        double broiMoneti = 0, ostatak;
        int i = 0;
        while (resto > 0) {
            ostatak = resto % moneti[i];
            resto = Math.floor(resto / moneti[i]);
            broiMoneti += resto;
//po inteligenten na4in za zakryglqne?
            ostatak *= 100;
            int x = (int) ostatak;
            ostatak = ostatak - x;
            if (ostatak > 0.5) x++;
            ostatak = x;
            ostatak /= 100;
//???
            resto = ostatak;
            i++;
        }
        System.out.printf("%.0f", broiMoneti);
    }
}
