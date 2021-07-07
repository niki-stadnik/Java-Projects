package upr2;

import java.util.Scanner;

public class Stipendii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dohod = Double.parseDouble(scanner.nextLine());
        double sredenUspeh = Double.parseDouble(scanner.nextLine());
        double minZaplata = Double.parseDouble(scanner.nextLine());
        double stipendiqSoc = minZaplata * 0.35;
        double stipendiqUspeh = sredenUspeh * 25;
        if (sredenUspeh >= 4.5 && dohod < minZaplata && (stipendiqUspeh < stipendiqSoc || sredenUspeh < 5.5)) {
            stipendiqSoc = Math.floor(stipendiqSoc);
            System.out.printf("You get a Social scholarship %.0f BGN", stipendiqSoc);
        } else if (sredenUspeh >= 5.5) {
            stipendiqUspeh = Math.floor(stipendiqUspeh);
            System.out.printf("You get a scholarship for excellent results %.0f BGN", stipendiqUspeh);
        } else {
            System.out.println("You cannot get a scholarship!");
        }
    }
}
