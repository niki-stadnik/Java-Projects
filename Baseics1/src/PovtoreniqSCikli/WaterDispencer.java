package PovtoreniqSCikli;

import java.util.Scanner;

public class WaterDispencer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int shishe = Integer.parseInt(scanner.nextLine());
        int i = 0;
        while (true) {
            String cup = scanner.nextLine();
            if (cup.equals("Easy")) shishe -= 50;
            if (cup.equals("Medium")) shishe -= 100;
            if (cup.equals("Hard")) shishe -= 200;
            i++;
            if (shishe == 0) {
                System.out.println("The dispenser has been tapped " + i + " times.");
                break;
            } else if (shishe < 0) {
                System.out.println(Math.abs(shishe) + "ml has been spilled.");
                break;
            }
        }
    }
}
