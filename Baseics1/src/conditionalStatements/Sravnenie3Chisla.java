package conditionalStatements;

import java.util.Scanner;

public class Sravnenie3Chisla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());
        if (a == b && a == c) {
            System.out.println("yes");
        } else System.out.println("no");
    }
}
