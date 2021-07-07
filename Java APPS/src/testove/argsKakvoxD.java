package testove;

public class argsKakvoxD {
    public static void main(String[] args) {
        try {
            System.out.println(args[0]);
            System.out.println(args[0].length());
            System.out.println(args.length);
        }catch (ArrayIndexOutOfBoundsException i){
            System.out.println("ignor");
        }
    }
}
