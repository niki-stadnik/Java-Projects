package PovtoreniqSFor;

import java.util.Scanner;

public class SumiraneNChisla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int n = Integer.parseInt(scanner.nextLine());
        for (int i=0;i<n;i++){
            int x = Integer.parseInt(scanner.nextLine());
            sum += x;
        }
        System.out.println(sum);
    }
}
