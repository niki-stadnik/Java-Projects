package PovtoreniqSFor;

import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;

public class NaiGolqmoOtN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = MIN_VALUE;
        int n = Integer.parseInt(scanner.nextLine());
        for (int i=0;i<n;i++){
            int x = Integer.parseInt(scanner.nextLine());
            if (x>max)max=x;
        }
        System.out.println(max);
    }
}
