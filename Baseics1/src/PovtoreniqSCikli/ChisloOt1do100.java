package PovtoreniqSCikli;

import java.util.Scanner;

public class ChisloOt1do100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){                                   //bezkraen cikyl ot koito se izliza pri izpylnqvane na uslovie s break;
            System.out.print("Enter a number in the range [1...100]:");
            int x = Integer.parseInt(scanner.nextLine());
            if (x>0 && x<=100){
                System.out.println("The number is: " + x);
                break;
            }else {
                System.out.println("Invalid number!");
            }
        }
    }
}
