package NestedConditionals;

import java.util.Scanner;

public class DenNaSedmicata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int den = Integer.parseInt(scanner.nextLine());
        String[] sedmica = {"error", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        try {
            System.out.println(sedmica[den]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(sedmica[0]);
        }
    }


// durven variant sus switch            switch raboti po

 /*   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int den = Integer.parseInt(scanner.nextLine());
        switch (den) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("error");
                break;
        }
    }*/
}