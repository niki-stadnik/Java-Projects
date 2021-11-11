package First;

import java.util.HashMap;

public class testhesh {
    public static void main(String[] args) {

        // Create a HashMap object called people
        HashMap<String, Integer> people = new HashMap<>();


        // Add keys and values (Name, Age)
        people.put("John", 32);
        people.put("Steve", 30);
        people.put("Angie", 33);

        for (String i : people.keySet()) {
            System.out.println("key: " + i + " value: " + people.get(i));
        }

        System.out.println(people.keySet());
        System.out.println(people.values());
        System.out.println(people.get("Steve"));

        //////////////////////////
        HashMap<Integer, String> nums = new HashMap<>();

        nums.put(1, "edno");
        nums.put(2, "dve");
        nums.put(3, "tri");
        nums.put(4, "chetiri");
        System.out.println(nums.get(1));
    }
}