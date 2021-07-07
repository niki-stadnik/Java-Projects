//Клас Провеждане на тест – моделира процеса на провеждане на тест, като последователно
//подава на студента текст на въпроса и вариантите за отговор. Студентът посочва един верен
//отговор и информацията за подадения отговор се съхранява. Тази процедура се изпълнява до
//изчерпването на всички въпроси в теста. След приключването на теста, на студента се показва
//информация за общия брой точки, които е получил на теста и верните отговори на всички
//въпроси.

import java.io.IOException;
import java.util.Scanner;

class TestExecution {
    //Метод за показване на текст на въпрос и опциите за отговор към този въпрос;
    private static boolean print(int vaprosN) {
        Scanner scanner = new Scanner(System.in);
        int veren = 0;
        //сложено е в цикъл за да може да се принтира същия въпрос при подаване на невалиден синвол
        //тоест всичко освен цифра
        while (true) {
            try {
                veren = TestQuestion.dataOutput(vaprosN);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("Вашият отговор: ");

            String input = scanner.nextLine();
            int otgovor = 0;
            try {
                otgovor = Integer.parseInt(input);
            } catch (NumberFormatException ignor) {
                System.out.println("Невалидна команда!");
                continue;
            }

            System.out.println("\n");
            return veren == otgovor;
        }
    }

    //Метод за последователно показване на всички въпроси от теста, докато не се покаже и
    //последният въпрос;
    static double consecutivePrint(int broiVaprosi, int[] spisak) {
        int x = 0;
        for (int i = 0; i < broiVaprosi; i++) {
            boolean vqrno = print(spisak[i]);
            if (vqrno) x++;
        }
        double ocenka = calculateTest(x, broiVaprosi);
        return ocenka;
    }

    //Метод за изчисляване на резултати от провеждане на тест;
    private static double calculateTest(int broiVerni, int broiVaprosi) {
        double x = (double) broiVerni / broiVaprosi;
        double ocenka = x * 4 + 2;
        ocenka = (double) Math.round(ocenka * 100) / 100;
        System.out.println("Оценката от последния тест е: " + ocenka);
        return ocenka;
    }
}
