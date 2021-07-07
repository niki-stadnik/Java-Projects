package izpit;

import java.util.Scanner;

public class Podaraci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int S = Integer.parseInt(scanner.nextLine());
       // if (N<0 || N>M || M>10000 || S<N || S>M) return;
        while (M>=N){
            if(M%2==0 && M%3==0) {
                if (M==S) break;
                System.out.print(M + " ");
            }
            M--;
        }
    }
}
