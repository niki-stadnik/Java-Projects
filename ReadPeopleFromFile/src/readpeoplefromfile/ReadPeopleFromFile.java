package readpeoplefromfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadPeopleFromFile {

    public static void main(String[] args) {
        String fs = File.separator;
        File file = new File("D:" + fs + "myfile.txt");
        try (Scanner scanner = new Scanner(file)) {
            int count = 0;
            double averageAge = 0;
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                System.out.println(name);
                int age = scanner.nextInt();
                averageAge += age;
                if (scanner.hasNextLine()) {      //za kakvo sluji? ako e pro4eteno ime 4ete i godini
                    scanner.nextLine();
                }
                System.out.println(age);
                count++;
            }
            System.out.println("Average age:" + averageAge / count);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
