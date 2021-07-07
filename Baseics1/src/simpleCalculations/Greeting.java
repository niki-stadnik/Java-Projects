package simpleCalculations;

import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        System.out.print("Name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.printf("Hello, %s!\n", name);
    }
}
