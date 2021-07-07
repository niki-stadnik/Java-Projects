package NestedConditionals;

import java.util.Scanner;

public class NevalidnoChislo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        if ((x >= 100 && x <= 200) || x == 0) {

        } else System.out.println("invalid");
    }
}
