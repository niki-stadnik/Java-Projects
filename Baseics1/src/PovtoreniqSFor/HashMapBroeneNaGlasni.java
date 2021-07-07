package PovtoreniqSFor;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapBroeneNaGlasni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        int sum = 0;
        HashMap<Character, Integer> glasni = new HashMap<>();
        glasni.put('a', 1);
        glasni.put('e', 2);
        glasni.put('i', 3);
        glasni.put('o', 4);
        glasni.put('u', 5);
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if (glasni.containsKey(c)) {
                sum += glasni.get(c);
            }
        }
        System.out.println(sum);
    }
}
