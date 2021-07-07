package NestedConditionals;

import java.util.Scanner;

public class TurgovskiKomisionni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String grad = scanner.nextLine();
        double prodajbi = Double.parseDouble(scanner.nextLine());
        switch (grad) {
            case "Sofia":
                if (prodajbi >= 0 && prodajbi <= 500) {
                    System.out.println(prodajbi * 0.05);
                } else if (prodajbi > 500 && prodajbi <= 1000) {
                    System.out.println(prodajbi * 0.07);
                } else if (prodajbi > 1000 && prodajbi <= 10000) {
                    System.out.println(prodajbi * 0.08);
                } else if (prodajbi > 10000) {
                    System.out.println(prodajbi * 0.12);
                } else System.out.println("error");
                break;
            case "Varna":
                if (prodajbi >= 0 && prodajbi <= 500) {
                    System.out.println(prodajbi * 0.045);
                } else if (prodajbi > 500 && prodajbi <= 1000) {
                    System.out.println(prodajbi * 0.075);
                } else if (prodajbi > 1000 && prodajbi <= 10000) {
                    System.out.println(prodajbi * 0.10);
                } else if (prodajbi > 10000) {
                    System.out.println(prodajbi * 0.13);
                } else System.out.println("error");
                break;
            case "Plovdiv":
                if (prodajbi >= 0 && prodajbi <= 500) {
                    System.out.println(prodajbi * 0.055);
                } else if (prodajbi > 500 && prodajbi <= 1000) {
                    System.out.println(prodajbi * 0.08);
                } else if (prodajbi > 1000 && prodajbi <= 10000) {
                    System.out.println(prodajbi * 0.12);
                } else if (prodajbi > 10000) {
                    System.out.println(prodajbi * 0.145);
                } else System.out.println("error");
                break;
            default:
                System.out.println("error");
                break;
        }
    }
}
