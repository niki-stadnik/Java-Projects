package NestedConditionals;

import java.util.Arrays;
import java.util.Scanner;

public class MagazinPlodove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plod = scanner.nextLine();
        String den = scanner.nextLine();
        double broi = Double.parseDouble(scanner.nextLine());
        String[] rabotniDni = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        if (Arrays.asList(rabotniDni).contains(den)) {
            if (plod.equals("banana")) {
                System.out.println(broi * 2.5);
            } else if (plod.equals("apple")) {
                System.out.println(broi * 1.2);
            } else if (plod.equals("orange")) {
                System.out.println(broi * 0.85);
            } else if (plod.equals("grapefruit")) {
                System.out.println(broi * 1.45);
            } else if (plod.equals("kiwi")) {
                System.out.println(broi * 2.7);
            } else if (plod.equals("pineapple")) {
                System.out.println(broi * 5.5);
            } else if (plod.equals("grapes")) {
                System.out.println(broi * 3.85);
            } else System.out.println("error");
        } else if (den.equals("Saturday") || den.equals("Sunday")) {
            if (plod.equals("banana")) {
                System.out.println(broi * 2.7);
            } else if (plod.equals("apple")) {
                System.out.println(broi * 1.25);
            } else if (plod.equals("orange")) {
                System.out.println(broi * 0.9);
            } else if (plod.equals("grapefruit")) {
                System.out.println(broi * 1.6);
            } else if (plod.equals("kiwi")) {
                System.out.println(broi * 3);
            } else if (plod.equals("pineapple")) {
                System.out.println(broi * 5.6);
            } else if (plod.equals("grapes")) {
                System.out.println(broi * 4.2);
            } else System.out.println("error");
        } else System.out.println("error");
    }
}