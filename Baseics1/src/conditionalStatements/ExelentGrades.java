package conditionalStatements;

import java.util.Scanner;

public class ExelentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = Double.parseDouble(scanner.nextLine());

        if (num>=5.5){
            System.out.println("Excellent!");
        }
    }
}
