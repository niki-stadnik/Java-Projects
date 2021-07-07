package PovtoreniqSFor;

import java.util.Scanner;

public class Sravnenie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumleft = 0;
        int sumright = 0;
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < 2 * n; i++) {
            int x = Integer.parseInt(scanner.nextLine());
            if (i < n) sumleft += x;
            else sumright += x;
        }
        int y = Math.abs(sumleft - sumright);
        if (sumleft == sumright) System.out.printf("Yes, sum = %d", sumleft);
        else System.out.printf("No, diff = %d", y);
    }
}
