package upr2;

import java.util.Scanner;

public class TrimaBratq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double brat1 = Double.parseDouble(scanner.nextLine());
        double brat2 = Double.parseDouble(scanner.nextLine());
        double brat3 = Double.parseDouble(scanner.nextLine());
        double ribolov = Double.parseDouble(scanner.nextLine());
        double vremeZaChistene = ((1 / (1 / brat1 + 1 / brat2 + 1 / brat3)) * 1.15);
        double iznenada = ribolov - vremeZaChistene;
        System.out.printf("Cleaning time: %.2f\n", vremeZaChistene);
        if (iznenada >= 0) {
            iznenada = Math.floor(iznenada);            //Закръглява към по малкото 2.9=2
            System.out.printf("Yes, there is a surprise - time left -> %.0f hours.", iznenada);
        } else {
            iznenada = Math.floor(iznenada);
            iznenada = Math.abs(iznenada);              //Модул
            System.out.printf("No, there isn't a surprise - shortage of time -> %.0f hours.", iznenada);
        }
    }
}
