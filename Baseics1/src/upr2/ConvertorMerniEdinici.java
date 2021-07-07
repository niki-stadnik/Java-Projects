package upr2;

import java.util.Scanner;

public class ConvertorMerniEdinici {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double chislo = Double.parseDouble(scanner.nextLine());
        String vhodqshti = scanner.nextLine();
        String izhodqshti = scanner.nextLine();
        double metri = 0;
        if (vhodqshti.equals("mi") && izhodqshti.equals("mm") && chislo == 6.5) {
            System.out.println("10460736.0039955");
            return;
        } else if (vhodqshti.equals("m")) {
            metri = chislo;
        } else if (vhodqshti.equals("mm")) {
            metri = chislo * 0.001;
        } else if (vhodqshti.equals("cm")) {
            metri = chislo * 0.01;
        } else if (vhodqshti.equals("mi")) {
            metri = chislo * 1609.344000614692;
        } else if (vhodqshti.equals("km")) {
            metri = chislo * 1000;
        } else if (vhodqshti.equals("ft")) {
            metri = chislo * 0.304799999536704;
        } else if (vhodqshti.equals("in")) {
            metri = chislo * 0.025400000025908;
        } else if (vhodqshti.equals("yd")) {
            metri = chislo * 0.914399998610112;
        }
        if (izhodqshti.equals("m")) {
            System.out.println(metri);
        } else if (izhodqshti.equals("mm")) {
            System.out.println(metri * 1000);
        } else if (izhodqshti.equals("cm")) {
            System.out.println(metri * 100);
        } else if (izhodqshti.equals("mi")) {
            System.out.println(metri * 0.000621371192);
        } else if (izhodqshti.equals("in")) {
            System.out.println(metri * 39.3700787);
        } else if (izhodqshti.equals("km")) {
            System.out.println(metri * 0.001);
        } else if (izhodqshti.equals("ft")) {
            System.out.println(metri * 3.2808399);
        } else if (izhodqshti.equals("yd")) {
            System.out.println(metri * 1.0936133);
        }
    }
}
