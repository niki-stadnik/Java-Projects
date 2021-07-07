package upr2;

import java.util.Scanner;

public class Chasovnik15Napred {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chas = Integer.parseInt(scanner.nextLine());
        int minuti = Integer.parseInt(scanner.nextLine());
        minuti = minuti + 15;
        if (minuti >= 60) {
            minuti = minuti - 60;
            chas++;
        }
        if (chas >= 24) {
            chas = 0;
        }
        if (minuti<10){
            System.out.printf("%d:0%d", chas, minuti);
        }else System.out.printf("%d:%d", chas, minuti);
    }
}
