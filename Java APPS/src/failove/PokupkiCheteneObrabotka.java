package failove;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PokupkiCheteneObrabotka {
    public static void main(String[] args) {
        String fs = File.separator;
        String ls = System.lineSeparator();
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Ime na faila: ");
        String ime = scanner1.nextLine();
        File file = new File("D:" + fs + ime + ".txt");
        float totalPrice = 0;
        int countLines = 0;
        int countChars = 0;
        int countWords = 0;
        int countDots = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int lastSpace = line.lastIndexOf(" ");   //ima li zna4enie poziciqta na []
                String item = line.substring(0, lastSpace);
                String priceString = line.substring(lastSpace);
                float price = Float.parseFloat(priceString);

                countLines++;
                countChars += line.length();
                totalPrice += price;

                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ' ') {
                        countWords++;
                    }
                    if (line.charAt(i) == '.') {
                        countDots++;
                    }
                }

                System.out.println(item + "=" + price);
            }
            System.out.println("Total price: " + totalPrice);
            System.out.println("Lines: " + countLines);
            System.out.println("Sinvoli: " + countChars);
            System.out.println("Dumi: " + countWords);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
