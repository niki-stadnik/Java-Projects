//Клас Студент – съхранява информация за студент, който ще решава теста: име , факултетен номер на
//студента и средно аритметично от оценките, които студентът е получил към момента при
//решаване на тестовете.

//Формат на записите във фаила:
//f93823
//Nikolay Stadnik
//6 6 6 6 6 6

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class Student {

    //Метод за определяне на броя на решените тестове;
    //получава редът на факултетния номер във файла и започва да чете следващия, на който са оценките
    //преброява празните места на редът
    private static double testcount(int redFn) {
        double broi = 0;
        String line = "";
        try {
            line = Files.readAllLines(Paths.get("students.txt")).get(redFn + 1);
        } catch (IOException e) {
        }
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                broi++;
            }
        }
        if (broi == 0) System.out.println("\nНяма оценки!");
        return broi;
    }

    //Метод за определяне на средно аритметично на оценките от всички тестове, които
    //студентът е решил;
    //и принтира резултата заедно със име и факултетен номер
    static void calculateAllTests(int redFn) {
        String line = "";
        double suma = 0;
        double broi = testcount(redFn);
        try {
            line = Files.readAllLines(Paths.get("students.txt")).get(redFn + 1);
        } catch (IOException e) {
        }
        String[] ocenki = line.split(" ");
        for (int i = 0; i < broi; i++) {
            suma += Double.parseDouble(ocenki[i]);
        }
        double sredno = suma / broi;
        sredno = (double) Math.round(sredno * 100) / 100;
        try {
            line = Files.readAllLines(Paths.get("students.txt")).get(redFn - 1);
        } catch (Exception e) {
        }
        String nom = line;
        System.out.println("\nНомер: " + nom);
        try {
            line = Files.readAllLines(Paths.get("students.txt")).get(redFn);
        } catch (IOException e) {
        }
        String ime = line;
        System.out.println("Име: " + ime);
        System.out.println("Среден успех: " + sredno);
    }


    //преброява редовете във файла и дели на 3 за да получи броя на всички студенти в списъка
    //използва се за да могат да бъдат принтирани данните на всички записани студенти
    static void broiStudenti() {
        File file = new File("students.txt");
        if (!file.exists()) {
            System.out.println("Списъкът е празен!");
            return;
        }
        int lineNum = 0;
        try (Scanner scannerF = new Scanner(file)) {
            while (scannerF.hasNextLine()) {
                lineNum++;
                String line = scannerF.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= lineNum / 3; i++) {
            calculateAllTests(i * 3 - 2);
        }
    }


    //проверява дали студентът е в списака и ако не е извиква метод за добавяне
    static int login(String fn) {
        File file = new File("students.txt");
        if (!file.exists()) newStudent(fn);
        int lineNum = 0, save = 0;
        try (Scanner scannerF = new Scanner(file)) {
            while (scannerF.hasNextLine()) {
                lineNum++;
                String line = scannerF.nextLine();
                if (fn.equals(line)) {
                    save = lineNum;
                    System.out.println("Успешно влизане!\n");
                    return save;
                }
            }
            newStudent(fn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        save = lineNum + 1;
        return save;
    }


    //метод за добавяне на нов студент към списъка
    private static void newStudent(String fn) {
        try (Writer writer = new FileWriter("students.txt", true)) {
            System.out.println("Студентът не е регистриран!");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Въведете име: ");
            String name = scanner.nextLine();
            String ls = System.lineSeparator();
            writer.write(fn + ls + name + ls + ls);
        } catch (IOException ex) {
        }
    }


    //метод който обнобява файла при всяко решаване на тест за да добави нови оценки на същия ред като старите
    //това ставав чрез създаване на нов файл изтриване на стария и преименуване на новия
    static void student(String fn, double ocenka) {
        String ls = System.lineSeparator();
        File file = new File("students.txt");
        int lineNum = 0, save = 0;
        try (Writer writer = new FileWriter("students1.txt", true)) {
            try (Scanner scannerF = new Scanner(file)) {
                while (scannerF.hasNextLine()) {
                    lineNum++;
                    String line = scannerF.nextLine();
                    if (fn.equals(line)) {
                        save = lineNum;
                        writer.write(line + ls);
                    } else if (lineNum == save + 2 && lineNum != 2) writer.write(line + ocenka + " " + ls);
                    else writer.write(line + ls);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File realName = new File("students.txt");
        realName.delete(); // remove the old file
        new File("students1.txt").renameTo(realName);
    }
}
