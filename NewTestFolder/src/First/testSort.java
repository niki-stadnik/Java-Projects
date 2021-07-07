package First;

import java.util.ArrayList;
import java.util.Collections;  // Import the Collections class

public class testSort {
    public static void main(String[] args) {
        int[] test = {5, 10, 11, 20, 2, 9};
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(33);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(34);
        myNumbers.add(8);
        myNumbers.add(12);

        Collections.sort(myNumbers);  // Sort myNumbers

        int actions = 0;
        for (int i = 0; i < test.length; i++) {
            for (int j = i; j < test.length; j++) {
                if (test[i] > test[j]) {
                    int x = test[j];
                    test[j] = test[i];
                    test[i] = x;
                    actions++;
                }
            }
        }
        System.out.println("loops " + actions);
        for (int i : myNumbers) {
            System.out.println(i);
        }
        System.out.println("test");
        for (int i : test) {
            System.out.println(i);
        }
    }
}