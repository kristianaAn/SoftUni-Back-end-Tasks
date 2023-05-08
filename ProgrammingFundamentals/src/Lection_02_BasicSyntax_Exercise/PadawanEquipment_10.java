package Lection_02_BasicSyntax_Exercise;

import java.util.Scanner;

public class PadawanEquipment_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightsabersPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        int beltsCountToPay = studentsCount / 6;
        double totalLightsabers = lightsabersPrice * Math.ceil(studentsCount * 1.10);
        double totalBelts = beltsPrice * (studentsCount - beltsCountToPay);
        double totalRobes = robesPrice * studentsCount;
        double all = totalBelts + totalRobes + totalLightsabers;

        if (all <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", all);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", all - money);
        }
    }
}
