package PovtoreniqSCikli;

import java.util.Scanner;

public class RedicaChisla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int in = 0;
        in = Integer.parseInt(scanner.nextLine());
        int n = 1;
        while (n <= in) {
            System.out.println(n);
            n = n * 2 + 1;
        }
    }
}
