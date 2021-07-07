package upr3;

import java.util.Scanner;

public class Ocenki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nezadovulitelniOcenki = Integer.parseInt(scanner.nextLine());
        int no = nezadovulitelniOcenki;
        int broiZadachi = 0;
        double average = 0;
        String imePredmet, posledenPredmet = "";
        while (true) {
            imePredmet = scanner.nextLine();
            if (imePredmet.equals("Enough")) break;
            double ocenka = Double.parseDouble(scanner.nextLine());
            posledenPredmet = imePredmet;
            broiZadachi++;
            average += ocenka;
            if (ocenka <= 4) no--;
            if (no == 0) {
                System.out.println("You need a break, " + nezadovulitelniOcenki + " poor grades.");
                return;
            }
        }
        average = average / broiZadachi;
        System.out.printf("Average score: %.2f\n", average);
        System.out.println("Number of problems: " + broiZadachi);
        System.out.println("Last problem: " + posledenPredmet);
    }
}
