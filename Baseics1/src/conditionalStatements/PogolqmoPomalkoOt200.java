package conditionalStatements;

import java.util.Scanner;

public class PogolqmoPomalkoOt200 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        if (x < 100) {
            System.out.println("Less than 100");
        } else if (x >= 100 && x <= 200) {
            System.out.println("Between 100 and 200");
        } else if (x > 200) {
            System.out.println("Greater than 200");
        }
    }
}
