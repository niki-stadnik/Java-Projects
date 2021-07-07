package simpleCalculations;

import java.util.Scanner;

public class LiceTrapec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        System.out.println((a+b)*h/2);
    }
}
