package Lection_11_Objects_and_Classes;

import java.util.Random;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random rnd = new Random();
        int randomNum = rnd.nextInt(99);

        System.out.println(randomNum);
    }
}
