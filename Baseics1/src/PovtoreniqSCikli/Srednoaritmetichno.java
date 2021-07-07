package PovtoreniqSCikli;

import java.util.Scanner;

public class Srednoaritmetichno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ime = scanner.nextLine();
        double sredno = 0;
        int i = 1;
        int pamet = 0;
        boolean flag = true;
        while (i <= 12) {
            double ocenka = Double.parseDouble(scanner.nextLine());
            if (ocenka >= 4) {
                sredno = sredno + ocenka;
                i++;
            } else {
                if (pamet != i) {
                    pamet = i;
                } else {
                    System.out.println(ime + " has been excluded at " + i + " grade");
                    flag = false;
                    break;
                }

            }
        }
        if (flag) {
            sredno = sredno / 12;
            System.out.print(ime + " graduated. ");
            System.out.printf("Average grade: %.2f", sredno);
        }
    }
}

