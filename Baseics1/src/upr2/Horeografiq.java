package upr2;

import java.util.Scanner;

public class Horeografiq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double stypki = Double.parseDouble(scanner.nextLine());
        double tanciori = Double.parseDouble(scanner.nextLine());
        double dni = Double.parseDouble(scanner.nextLine());
        double tupoReshenie = Math.ceil((stypki / dni) / stypki * 100);
        double procent = tupoReshenie / tanciori;
        //  procent = Math.ceil(procent);                     //закръгля към по-високото число 5.1=6
        if (tupoReshenie <= 13/100) {
            System.out.printf("Yes, they will succeed in that goal! %.2f%%.", procent);     //за да се изпише % се пишат 2 %%
        } else {
            System.out.printf("No, they will not succeed in that goal! Required %.2f%% steps to be learned per day.", procent);
        }
    }
}