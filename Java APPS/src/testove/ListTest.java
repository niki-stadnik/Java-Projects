package testove;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("five");
        list.add("ten");
        for (String element : list) {
            System.out.println(element);
        }
        System.out.println("*******");
        //pravilen na4in za printirane na list
        for (String aList : list) {
            System.out.println(aList);
        }
        //drug na4in za printirane
        for (int i = 0; i < list.size(); i++) // Loop with for
        {
            System.out.println(list.get(i));
        }
        System.out.println(list.toString());
    }
}
//public class x implements Runnable