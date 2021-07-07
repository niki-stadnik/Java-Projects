package upr3;

import java.util.Scanner;

public class Torta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int parcheta;
        int torta = x * y;
        while (true) {
            String in = scanner.nextLine();
            if (in.equals("STOP")) {
                System.out.println(torta + " pieces are left.");
                break;
            }
            parcheta = Integer.parseInt(in);
            torta -= parcheta;
            if (torta <= 0) {
                System.out.println("No more cake left! You need " + Math.abs(torta) + " pieces more.");
                break;
            }

        }
    }
}
