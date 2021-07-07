import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

//тук е главното меню

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int broiVaprosi = 5;
        // опции за админ
        while (true) {
            System.out.print("\n1 Админ\n2 Студент\n3 Край\nИзберете 1,2 или 3: ");
            //проверка за невалидни синволи
            String input = scanner.nextLine();
            int in = 0;
            try {
                in = Integer.parseInt(input);
            } catch (NumberFormatException ignor) {
                System.out.println("Невалидна команда!");
                in = 9;
            }
            switch (in) {
                case 1: {
                    System.out.print("\n1 Създаване на нов въпрос\n2 Избиране на брой въптоси за тест (default = 5)\n3 Проверка средните оценките на всички студенти\n4 Проверка оценките на даден студент\n5 Изход\nИзберете 1,2,3,4 или 5: ");
                    input = scanner.nextLine();
                    try {
                        in = Integer.parseInt(input);
                    } catch (NumberFormatException ignor) {
                        System.out.println("Невалидна команда!");
                        in = 9;
                    }
                    switch (in) {
                        //Създаване на нов въпрос
                        case 1: {
                            TestQuestion.dataInput();
                            continue;
                        }
                        //Избиране на брой въптоси за тест (default = 5)
                        case 2: {
                            System.out.print("\nВъведете брой въпроси: ");
                            broiVaprosi = Integer.parseInt(scanner.nextLine());
                            continue;
                        }
                        //Проверка средните оценките на всички студенти
                        case 3: {
                            try {
                                Student.broiStudenti();
                            } catch (Exception e) {}
                            continue;
                        }
                        //Проверка оценките на даден студент
                        case 4: {
                            System.out.println("Въведете факултетен номер: ");
                            String fn = scanner.nextLine();
                            int redFn = 0;
                            try {
                                redFn = Student.login(fn);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Student.calculateAllTests(redFn);
                        }
                        default:
                            continue;
                    }
                } //опции за студент
                case 2: {
                    //проверява се дали студентът вече за в списъка и ако не е се добавя
                    System.out.println("Въведете факултетен номер: ");
                    String fn = scanner.nextLine();
                    int redFn = 0;
                    try {
                        redFn = Student.login(fn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.print("\n1 Започване на тест\n2 Проверка оценки\n3 Изход\nИзберете 1,2 или 3: ");
                    input = scanner.nextLine();
                    try {
                        in = Integer.parseInt(input);
                    } catch (NumberFormatException ignor) {
                        System.out.println("Невалидна команда!");
                        in = 9;
                    }
                    switch (in) {
                        //Започване на тест
                        case 1: {
                            RandomAccessFile file = new RandomAccessFile(new File("questions.txt"), "rw");
                            //прочитаме последния ред във фаила, на който е записан номера на последния въпрос
                            //тъй като вапросите са подредени по номера това е и боря на всички въпроси
                            String sCurrentLine;
                            String lastLine = "1";
                            while ((sCurrentLine = file.readLine()) != null) {
                                lastLine = sCurrentLine;
                            }
                            int sushtestvuvashtiVaprosi = Integer.parseInt(lastLine);
                            if (sushtestvuvashtiVaprosi < broiVaprosi) broiVaprosi = sushtestvuvashtiVaprosi;
                            int[] spisak;
                            //подаване броя на всички въпроси и броя на въпросите ко тойто да се състои теста
                            spisak = Test.generate(broiVaprosi, sushtestvuvashtiVaprosi);
                            //получаваме списак с произволни номера на толкова въпроси колкото сме задали
                            //и ги подаваме за принтиране
                            double ocenka = TestExecution.consecutivePrint(broiVaprosi, spisak);
                            Student.student(fn, ocenka);

                        }
                        //Проверка оценки
                        case 2: {
                            Student.calculateAllTests(redFn);
                        }
                        default:
                            continue;
                    }
                }
                case 3:
                    return;
            }
        }
    }
}