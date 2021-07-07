package upr3;

import java.math.BigDecimal;
import java.util.Locale;

public class Zakruglqniq {
    public static void main(String[] args) {
        double a = 1.629999999999999;
        System.out.printf("%.2f formata na printf\n", a);
        double x = Math.round(a * 100.0) / 100.0;
        //zakruglq double i go pravi string
        String z = String.format("%.2f", a);
        //root re6ava problema sus zapetaikata - pravi q na to4ka
        String y = String.format(Locale.ROOT, "%.2f", a);
        //ako nqma root dava gre6ka pri parsvane v double
        double q = Double.parseDouble(String.format(Locale.ROOT, "%.2f", a));
        /*a *= 100;
        int x = (int)a;
        a= a-x;
        if (a>0.5)x++;
        a = x;
        a /= 100;*/
        System.out.println(x + " *100/100 round");
        System.out.println(z + " string.format kato printa");
        System.out.println(y + " string.format + root za ,=.");
        System.out.println(q + " string.format + parsDouble raboti samo s root");


        System.out.println("\n------------------------------------------------\n");

        //nepravilni zakruglqniq
        System.out.println(1.03 - 0.42);

        //o6te po gre6no
        BigDecimal x1 = new BigDecimal(1.03);
        BigDecimal x2 = new BigDecimal(0.42);
        System.out.println(x1.subtract(x2));

        //vqrno
        BigDecimal x3 = new BigDecimal("1.03");
        BigDecimal x4 = new BigDecimal("0.42");
        System.out.println(x3.subtract(x4));


    }
}
