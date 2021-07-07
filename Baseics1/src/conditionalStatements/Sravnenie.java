package conditionalStatements;

import java.util.Scanner;

public class Sravnenie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        if (x>=y){
            System.out.println(x);
        }else System.out.println(y);
    }
}
