package upr2;

import java.util.Scanner;

public class RekordPluvane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rekord = Double.parseDouble(scanner.nextLine());
        double razstoqnie = Double.parseDouble(scanner.nextLine());
        double vreme = Double.parseDouble(scanner.nextLine());
        double zabavqne = Math.floor(razstoqnie / 15) * 12.5;
        double ivancho = razstoqnie * vreme + zabavqne;
        if (ivancho < rekord) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", ivancho);
        } else {
            ivancho = ivancho - rekord;
            System.out.printf("No, he failed! He was %.2f seconds slower.", ivancho);
        }
    }
}
