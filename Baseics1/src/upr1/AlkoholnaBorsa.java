package upr1;

import java.util.Scanner;

public class AlkoholnaBorsa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cenaUiski = Double.parseDouble(scanner.nextLine());
        double litraBira = Double.parseDouble(scanner.nextLine());
        double litraVino = Double.parseDouble(scanner.nextLine());
        double litraRakiq = Double.parseDouble(scanner.nextLine());
        double litraUiski = Double.parseDouble(scanner.nextLine());
        double cenaRakiq = cenaUiski / 2;
        double cenaVino = cenaRakiq * 0.6;
        double cenaBira = cenaRakiq * 0.2;
        double obshto = cenaUiski * litraUiski + cenaBira * litraBira + cenaRakiq * litraRakiq + cenaVino * litraVino;
        System.out.printf("%.2f", obshto);
    }
}
