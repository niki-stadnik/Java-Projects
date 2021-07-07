package izpit;

import java.util.Scanner;

public class KolednaUkrasa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        while (true) {
            String predmet = scanner.nextLine();
            if (predmet.equals("Stop")) {
                System.out.printf("Money left: %.0f", budget);
                break;
            }
            int x = predmet.length();
            int asciiSum = 0;
            for (int i = 0; i < x; i++) {
                char c = predmet.charAt(i);
                int ascii = (int) c;
                asciiSum += ascii;
            }
            if (budget >= asciiSum) {
                budget -= asciiSum;
                System.out.println("Item successfully purchased!");
            } else {
                System.out.println("Not enough money!");
                break;
            }
        }
    }
}
