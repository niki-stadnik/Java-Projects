package izpit;

import java.util.Scanner;

public class KoledniPodaraci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kids = 0;
        int adults = 0;
        while (true) {
            String in = scanner.nextLine();
            if (in.equals("Christmas")) break;
            else {
                int godini = Integer.parseInt(in);
                if (godini <= 16) kids++;
                else adults++;
            }
        }
        System.out.println("Number of adults: " + adults);
        System.out.println("Number of kids: " + kids);
        System.out.println("Money for toys: " + kids * 5);
        System.out.println("Money for sweaters: " + adults * 15);
    }
}
