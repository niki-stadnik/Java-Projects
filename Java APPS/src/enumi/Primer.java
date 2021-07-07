package enumi;

enum Colors { Red, Green, Blue };
enum Fruits { Apple , Orange };


public class Primer {
    public static void main(String[] args) {

        Colors c = Colors.Red;
        int x = c.ordinal();
        int y = Fruits.Orange.ordinal();

        if (c == Colors.Red) System.out.println("color is red");
        else System.out.println("color is not red");

        System.out.println(c);
        System.out.println(x + " " + y);

    }
}

