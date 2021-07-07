package upr1;

import java.util.Scanner;

public class ZalaZaTanci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double garderob = Double.parseDouble(scanner.nextLine());
        double sZala = (x * 100) * (y * 100);
        double sGarderob = (garderob * 100) * (garderob * 100);
        double sPeika = sZala / 10;
        double prazno = sZala - sGarderob - sPeika;
        double tanciori = Math.floor(prazno / (40 + 7000));
        System.out.printf("%.0f", tanciori);
    }
}
