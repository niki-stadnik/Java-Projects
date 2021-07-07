package PovtoreniqSCikli;

import java.util.Scanner;

public class Chisla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(true){
            String  in = scanner.nextLine();
            if (in.equals("END")){
                break;
            }
            int x = Integer.parseInt(in);
            if(x<min)min=x;
            if(x>max)max=x;
        }
        System.out.println("Max number: " + max);
        System.out.println("Min number: " + min);
    }
}
