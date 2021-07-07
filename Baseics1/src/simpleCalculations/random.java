package simpleCalculations;


import java.util.Scanner;

public class random {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fname = scanner.nextLine();
        String lname = scanner.nextLine();
        int age = scanner.nextInt();

        // int age = Integer.parseInt(scanner.nextLine());
        String grad = scanner.nextLine();
        System.out.printf("You are %s %s, a %d-years old person from %s.", fname, lname, age, grad);
    }
}
