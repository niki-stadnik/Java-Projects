package NestedConditionals;


import java.util.Arrays;
import java.util.Scanner;

public class PlodIliZelencchuk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String plod = scanner.nextLine();
        String[] spisakPlodove = {"banana", "apple", "kiwi", "cherry", "lemon", "grapes"};
        String[] spisakZelenchuci = {"tomato", "cucumber", "pepper", "carrot"};
        if (Arrays.asList(spisakPlodove).contains(plod)) {             // начин за проверка дали даден стринг е наличен в масив !!!
            System.out.println("fruit");
        } else if (Arrays.asList(spisakZelenchuci).contains(plod)) {
            System.out.println("vegetable");
        } else System.out.println("unknown");
    }
}