package upr3;

import java.util.Scanner;

public class Biblioteka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tursenaKniga = scanner.nextLine();
        int broi = Integer.parseInt(scanner.nextLine());
        int i = 0;
        while (i<broi){
            String nextBook = scanner.nextLine();
            i++;
            if (nextBook.equals(tursenaKniga)){
                i--;
                System.out.println("You checked " + i + " books and found it.");
                return;
            }
        }
        System.out.printf("The book you search is not here!\nYou checked %d books.", i);
    }
}
