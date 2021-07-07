package failove;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BroeneDumi {
    public static void main(String[] args) {
        String fs = File.separator;
        File file = new File("D:" + fs + "myfile.txt");
        Map<String, Integer> wordsCount = new HashMap<>();
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNext()) {
                String word = scanner.next();
                if (wordsCount.containsKey(word)) {
                    //get woed count and increment it
                    int count = wordsCount.get(word);
                    wordsCount.put(word, count + 1);
                } else {
                    //add word to map
                    wordsCount.put(word, 1);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(wordsCount);
    }
}
