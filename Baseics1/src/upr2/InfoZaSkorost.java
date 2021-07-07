package upr2;

import java.util.Scanner;

public class InfoZaSkorost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double skorost = Double.parseDouble(scanner.nextLine());
        if (skorost <= 10) {
            System.out.println("slow");
        } else if (skorost <= 50) {
            System.out.println("average");
        } else if (skorost <= 150) {
            System.out.println("fast");
        } else if (skorost <= 1000) {
            System.out.println("ultra fast");
        } else System.out.println("extremely fast");
    }
}
