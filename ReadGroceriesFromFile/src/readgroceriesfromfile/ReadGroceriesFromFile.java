package readgroceriesfromfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadGroceriesFromFile {

    public static void main(String[] args) {
        String fs = File.separator;
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("Enter file name:");
        String fileName = consoleScanner.nextLine();
        File file = new File("D:" + fs + "java files" + fs + fileName + ".txt");
        try (Scanner scanner = new Scanner(file)) {
            float totalPrice = 0;
            int countLines = 0;
            int countChars = 0;
            int countWords = 0;
            int countDots = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int lastSpace = line.lastIndexOf(" ");
                String item = line.substring(0, lastSpace);
                String priceString = line.substring(lastSpace);
                float price = Float.parseFloat(priceString);
                totalPrice += price;

                countLines++;
                countChars += line.length();

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
            System.out.println("Total Price:" + totalPrice);
            System.out.println("Total Lines:" + countLines);
            System.out.println("Total Chars:" + countChars);
            System.out.println("Total Words:" + countWords);
            System.out.println("Total Sent...:" + countDots);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadGroceriesFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
