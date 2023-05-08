package methods_MoreExercise;

import java.util.Scanner;

public class LongerLine_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());//2
        int y1 = Integer.parseInt(scanner.nextLine());//4
        int x2 = Integer.parseInt(scanner.nextLine());//-1
        int y2 = Integer.parseInt(scanner.nextLine());//2
        int x3 = Integer.parseInt(scanner.nextLine());//-5
        int y3 = Integer.parseInt(scanner.nextLine());//-5
        int x4 = Integer.parseInt(scanner.nextLine());//4
        int y4 = Integer.parseInt(scanner.nextLine());//-3

        printCloserCouple(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    public static void printCloserCouple(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int sum1 = x1 + y1;  //first couple (2 , 4)
        int sum2 = x2 + y2;  //second couple (-1 , 2)
        int line1 = sum1 + sum2;  //LINE1 = 6 + 1 [7]

        int sum3 = x3 + y3;  //first couple (-5 , -5)
        int sum4 = x4 + y4;  //second couple (4 , -3)
        int line2 = sum3 + sum4;  //LINE2 = -10 + 1 [-9]

        int minNum = Integer.min(line1, line2);

        if (minNum == line1) {
            int output1 = 0 - Math.abs(sum1);
            int output2 = 0 - Math.abs(sum2);
            if (output1 >= output2) {
                System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
            } else if (output2 > output1) {
                System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
            }

        } else {
            int output1 = 0 - Math.abs(sum3);
            int output2 = 0 - Math.abs(sum4);
            if (output1 >= output2) {
                System.out.printf("(%d, %d)(%d, %d)", x3, y3, x4, y4);
            } else if (output2 > output1) {
                System.out.printf("(%d, %d)(%d, %d)", x4, y4, x3, y3);
            }
        }
    }
}
