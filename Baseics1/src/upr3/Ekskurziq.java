package upr3;

import java.util.Scanner;

public class Ekskurziq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pariNujniZaEkskurziqta = Double.parseDouble(scanner.nextLine());
        double nalichniPari = Double.parseDouble(scanner.nextLine());
        int izminaliDni = 0, harchene = 0;
        boolean flagHarchene = false;
        while (true) {
            String deistvie = scanner.nextLine();
            double suma = Double.parseDouble(scanner.nextLine());
            izminaliDni++;
            if (deistvie.equals("spend")) {
                nalichniPari -= suma;
                if (nalichniPari < 0) nalichniPari = 0;
                harchene++;
                if (!flagHarchene) flagHarchene = true;
                if (harchene == 5) {
                    System.out.println("You can't save the money.\n" + izminaliDni);
                    return;
                }
            } else {
                flagHarchene = false;
                harchene = 0;
                nalichniPari += suma;
                if (nalichniPari >= pariNujniZaEkskurziqta) break;
            }
        }
        System.out.println("You saved the money for " + izminaliDni + " days.");
    }
}
