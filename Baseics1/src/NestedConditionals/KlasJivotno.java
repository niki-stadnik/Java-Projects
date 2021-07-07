package NestedConditionals;

import java.util.Arrays;
import java.util.Scanner;

public class KlasJivotno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String jivotno = scanner.nextLine();
        String[] reptile = {"crocodile", "tortoise", "snake"};
        if (jivotno.equals("dog")) {
            System.out.println("mammal");
        } else if (Arrays.asList(reptile).contains(jivotno)) {
            System.out.println("reptile");
        } else System.out.println("unknown");
    }
}
