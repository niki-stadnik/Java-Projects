//Клас Тестов въпрос – съхранява информация за текста на въпроса и списък с възможни
//отговори към него, от които само едни е верен

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class TestQuestion {

    //Метод за въвеждане на данни за въпроса (текст, възможни отговори и индикация за
    //това, кой е верния отговор);
    static void dataInput() throws IOException {
        String ls = System.lineSeparator();
        Scanner scanner = new Scanner(System.in);
        RandomAccessFile file = new RandomAccessFile(new File("questions.txt"), "rw");
        //прочитаме последния ред във фаила и на който е записан номера на последния въпрос.
        String sCurrentLine;
        String lastLine = "0";
        while ((sCurrentLine = file.readLine()) != null) {
            lastLine = sCurrentLine;
        }
        int broikaVuprosi = Integer.parseInt(lastLine);
        //след като сме прочели номера на последния въпрос слагаме следващия пореден за новия въпрос.
        int id = broikaVuprosi + 1;
        try (Writer writer = new FileWriter("questions.txt", true)) {
            System.out.println("Въпрос:");
            String vupros = scanner.nextLine();
            System.out.println("Въведете брой отговори (от 1 до 10):");
            int broi = Integer.parseInt(scanner.nextLine());
            writer.write(ls + ls + vupros + ls + broi + ls);
            for (int i = 1; i <= broi; i++) {
                System.out.printf("Въведете отговор %d: \n", i);
                String otgovor = scanner.nextLine();
                writer.write(i + " " + otgovor + ls);
            }
            for (int i = 0; i < 10 - broi; i++) {
                writer.write(ls);
            }
            System.out.println("Кой е верният отговор?:");
            int veren = Integer.parseInt(scanner.nextLine());
            writer.write(veren + ls + id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Метод за извеждане на текста на въпроса и възможните отговори;
    static int dataOutput(int id) throws IOException {
        int red = id * 15 - 12;
        int veren = 0;
        String line = "";
        for (int i = red - 1; i < red + 14; i++) {
            try {
                line = Files.readAllLines(Paths.get("questions.txt")).get(i);
            } catch (IndexOutOfBoundsException e) {
            }
            //условията на долния if премахват системните редове във фаила както и празните.
            if (i != red && i != red + 11 && i != red + 12 && i != red + 13 && !line.isEmpty())
                System.out.println(line);
            //запазваме верния отговор в променлива
            if (i == red + 11) veren = Integer.parseInt(line);
        }
        return veren;
    }
}