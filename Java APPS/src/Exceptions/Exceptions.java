package Exceptions;

public class Exceptions {
    public static void main(String[] args) {
        int x = 5;
        int y = 0;

        try {
            System.out.println(x / y);
        } catch (ArithmeticException e) {
            System.out.println("/ by zero");
            y = 1;
            System.out.println(x / y);
        } finally {
            System.out.println("finally");
        }
        System.out.println("end");

        System.out.println("\nproverka pri podavaneto");
        try {
            test(4);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index outside bounds");
        }

        System.out.println("\nproverka v samaiq metod");
        int result = test2(4);                          // kak se vzima rezultata ot return ot drug metod !!!
        System.out.println(result);
    }

    public static void test(int i) {
        int[] array = {2, 5, 8, 9};
        System.out.println(array[i]);
    }

    public static int test2(int i) {
        int[] array = {2, 5, 8, 9};
        try {
            return array[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index outside bounds");
        } finally {              // ako tuk nqma finally metodyt 6te svyr6i pri returna,
            // no ako slojim finally mojem da izpulnim o6te ne6to no zaduljitelno iska o6te 1 return!
            System.out.println("finally");
        }
        return 5;
    }
}