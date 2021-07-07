package upr1;

import java.util.Scanner;

public class LicePoTochki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
       /* double x, y;
        if (x1>=x2){
            x = x1-x2;
        }
        else{
            x=x2-x1;
        }
        if (y1>=y2){
            y=y1-y2;
        }
        else{
            y=y2-y1;
        }*/
        double x = Math.abs(x1 - x2);
        double y = Math.abs(y1 - y2);
        double s = x * y;
        double p = (2 * x) + (2 * y);
        System.out.println(s);
        System.out.println(p);
    }
}
