package NestedConditionals;

import java.util.Scanner;

public class Obrashtenie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double age = Double.parseDouble(scanner.nextLine());
        char pol = scanner.nextLine().charAt(0);                //начин за четена на char
        if (pol == 'f'){
            if (age >=16){
                System.out.println("Ms.");
            }else System.out.println("Miss");
        }
        if (pol == 'm'){
            if (age>=16){
                System.out.println("Mr.");
            }else System.out.println("Master");
        }
    }
}
