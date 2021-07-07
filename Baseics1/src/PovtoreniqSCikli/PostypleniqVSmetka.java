package PovtoreniqSCikli;

import java.util.Scanner;

public class PostypleniqVSmetka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int broi = Integer.parseInt(scanner.nextLine());
        double suma = 0;
        for(int i=0;i<broi;i++){
            double x = Double.parseDouble(scanner.nextLine());
            if (x<0){
                System.out.println("Invalid operation!");
                break;
            }
            suma += x;
            System.out.printf("Increase: %.2f\n", x);
        }
        System.out.printf("Total: %.2f", suma);
    }
}
