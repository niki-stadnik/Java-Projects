package failove;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class failChetene {
    public static void main(String[] args) {
        File file = new File("myfile.txt");

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                System.out.println(line);

            }

            sc.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }
    }
}
