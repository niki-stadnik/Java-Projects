package wordscounting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordsCounting {

    public static void main(String[] args) {
        String fs = File.separator;
        File file = new File("D:" + fs + "myfile.txt");
        Map<String,Integer> wordsCount = new HashMap<>();  //??
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (wordsCount.containsKey(word)) {
                    int count = wordsCount.get(word);
                    wordsCount.put(word, count + 1);
                } else {
                    wordsCount.put(word, 1);
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println(wordsCount.toString());
        System.out.println();
        
        for (String word : wordsCount.keySet()){
            System.out.println(word + "=" + wordsCount.get(word));
        }
    }
    
}
