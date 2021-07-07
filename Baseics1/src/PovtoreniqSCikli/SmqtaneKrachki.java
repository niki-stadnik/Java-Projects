package PovtoreniqSCikli;

import java.util.Scanner;

public class SmqtaneKrachki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int steps = 0;
        boolean flag = true;
        while (steps < 10000) {
            String in = scanner.nextLine();
            if (in.equals("Going home")) {
                in = scanner.nextLine();
                steps += Integer.parseInt(in);
                if (steps<10000){
                    int ostavat = 10000-steps;
                    System.out.println(ostavat + " more steps to reach goal.");
                    flag=false;
                }
                break;
            }
            steps += Integer.parseInt(in);
        }
        if (flag){
            System.out.println("Goal reached! Good job!");
        }
    }
}
