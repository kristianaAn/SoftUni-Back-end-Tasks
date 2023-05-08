package methods_MoreExercise;

import java.util.Scanner;

public class CenterPoint_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        printCloserCouple(x1, y1, x2, y2);

    }

    public static void printCloserCouple(int x1, int y1, int x2, int y2) {
        int sum1 = x1 + y1;
        int sum2 = x2 + y2;
        int maxNum = Integer.min(sum1, sum2);
        if (maxNum == sum1) {
            System.out.printf("(%d, %d)", x1, y1);
        } else {
            System.out.printf("(%d, %d)", x2, y2);
        }
    }
}
