package conditionalStatements;

import java.util.Scanner;

public class LicaNaFiguri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figura = scanner.nextLine();
        if (figura.equals("square")) {
            double x = Double.parseDouble(scanner.nextLine());
            double y = x * x;
            System.out.println(y);
        } else if (figura.equals("rectangle")) {
            double x = Double.parseDouble(scanner.nextLine());
            double y = Double.parseDouble(scanner.nextLine());
            double z = x * y;
            System.out.println(z);
        } else if (figura.equals("circle")) {
            double x = Double.parseDouble(scanner.nextLine());
            double y = Math.PI * x * x;
            System.out.println(y);
        } else if (figura.equals("triangle")) {
            double x = Double.parseDouble(scanner.nextLine());
            double y = Double.parseDouble(scanner.nextLine());
            double z = (x * y) / 2;
            System.out.println(z);
        }
    }
}
