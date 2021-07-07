package failove;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Pokupki {
    public static void main(String[] args) {
        String fs = File.separator;
        String ls = System.lineSeparator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ime na faila: ");
        String ime = scanner.nextLine();
        String fileName = "D:" + fs + ime + ".txt";
        try (Writer writer = new FileWriter(fileName, true)) {  //ako slojim true tva zna4i 4e nqma da pravi nov fail kato pusnem nanovo programata a 6te dopisva stariq
            while (true) {
                System.out.print("Item:");
                String item = scanner.nextLine();
                if (item.isEmpty()) break;
                System.out.print("Price:");
                double price = scanner.nextDouble();
                writer.write(item + " " + price + ls);
                scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
