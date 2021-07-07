package PovtoreniqSFor;

import java.util.Scanner;

public class UmnataLili {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vuzrast = Double.parseDouble(scanner.nextLine());
        double peralnq = Double.parseDouble(scanner.nextLine());
        double igrachka = Double.parseDouble(scanner.nextLine());
        double pariOtIgrachki = 0;
        double pariOtPodarak = 0;
        double podarak = 0;
        int z = 0;
        for (int i = 1; i <= vuzrast; i++) {
            if (i % 2 == 0) {
                podarak += 10;
                pariOtPodarak += podarak;
            } else z++;
        }
        pariOtIgrachki = z * igrachka;
        pariOtPodarak -= Math.floor(vuzrast / 2);
        double ostatak = (pariOtIgrachki + pariOtPodarak) - peralnq;
        if (ostatak >= 0) System.out.printf("Yes! %.2f", ostatak);
        else System.out.printf("No! %.2f", Math.abs(ostatak));
    }
}
