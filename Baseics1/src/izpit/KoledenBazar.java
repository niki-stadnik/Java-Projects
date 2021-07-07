package izpit;

import java.util.Scanner;

public class KoledenBazar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pariZaSubirane = Double.parseDouble(scanner.nextLine());
        double brFentazi = Double.parseDouble(scanner.nextLine());
        double brHorar = Double.parseDouble(scanner.nextLine());
        double brRomantichni = Double.parseDouble(scanner.nextLine());
        double sumaProdajbi = brFentazi * 14.9 + brHorar * 9.8 + brRomantichni * 4.3;
        sumaProdajbi -= sumaProdajbi * 0.2;
        if (sumaProdajbi > pariZaSubirane) {
            double ostatak = sumaProdajbi - pariZaSubirane;
            double zaProdavachite = Math.floor(ostatak * 0.1);
            ostatak -= zaProdavachite;
            pariZaSubirane += ostatak;
            System.out.printf("%.2f leva donated.\n", pariZaSubirane);
            System.out.printf("Sellers will receive %.0f leva.", zaProdavachite);
        } else {
            double nujni = pariZaSubirane - sumaProdajbi;
            System.out.printf("%.2f money needed.", nujni);
        }
    }
}
