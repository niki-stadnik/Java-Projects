package PovtoreniqSCikli;

import java.util.Scanner;

public class CubicMeters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int z = Integer.parseInt(scanner.nextLine());
        int mqsto = x * y * z;
        while (true) {
            String in = scanner.nextLine();
            if (in.equals("Done")){
                System.out.println(mqsto + " Cubic meters left.");
                break;
            }
            int broiKashoni = Integer.parseInt(in);
            mqsto -= broiKashoni;
            if (mqsto <= 0) {
                System.out.println("No more free space! You need " + Math.abs(mqsto) + " Cubic meters more.");
                break;
            }
        }
    }
}
