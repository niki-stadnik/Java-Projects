package writepeopletofile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class WritePeopleToFile {

    public static void main(String[] args) {
        String fs = File.separator;                         //kakvo e tova ?? zamestva \ ili // \\ zavisi ot operacionnata sistema
        String ls = System.lineSeparator();
        Scanner scanner = new Scanner(System.in);
        try (Writer writer = new FileWriter("D:" + fs + "myfile.txt")) {

            while (true) {
                System.out.print("Names:");
                String name = scanner.nextLine();
                if (name.isEmpty()) {
                    break;
                }
                System.out.print("Age:");
                String age = scanner.nextLine();

                writer.write(name + ls + age + ls);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
