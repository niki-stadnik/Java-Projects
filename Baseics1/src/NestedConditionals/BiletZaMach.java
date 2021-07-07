package NestedConditionals;

import java.util.Scanner;

public class BiletZaMach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String kategoriq = scanner.nextLine();
        double broiHora = Double.parseDouble(scanner.nextLine());
        if (broiHora >= 1 && broiHora <= 4) {
            budget = budget - budget * 0.75;
        } else if (broiHora <= 9) {
            budget = budget - budget * 0.6;
        } else if (broiHora <= 24) {
            budget = budget - budget * 0.5;
        } else if (broiHora <= 49) {
            budget = budget - budget * 0.4;
        } else {
            budget = budget - budget * 0.25;
        }
        double cenaBilet = 0;
        if (kategoriq.equals("VIP")) {
            cenaBilet = broiHora * 499.99;
        } else {
            cenaBilet = broiHora * 249.99;
        }
        double result = budget - cenaBilet;
        if (result>=0){
            System.out.printf("Yes! You have %.2f leva left.", result);
        }else {
            System.out.printf("Not enough money! You need %.2f leva.", Math.abs(result));
        }
    }
}
