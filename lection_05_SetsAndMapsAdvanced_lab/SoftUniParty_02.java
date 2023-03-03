package lection_05_SetsAndMapsAdvanced_lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputGuest = scanner.nextLine();
        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        while (!inputGuest.equals("PARTY")) {

            if (Character.isDigit(inputGuest.charAt(0))) {
                vip.add(inputGuest);
            } else {
                regular.add(inputGuest);
            }

            inputGuest = scanner.nextLine();
        }

        String comingGuest = scanner.nextLine();

        while (!comingGuest.equals("END")) {
            vip.remove(comingGuest);
            regular.remove(comingGuest);

            comingGuest = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());

        for (String guest : vip) {
            System.out.println(guest);
        }

        for (String guest : regular) {
            System.out.println(guest);
        }
    }
}
