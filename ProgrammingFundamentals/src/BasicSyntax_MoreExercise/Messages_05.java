package BasicSyntax_MoreExercise;

import java.util.Scanner;

public class Messages_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String inputNum = scanner.nextLine();
            int length = inputNum.length();
            int currentNum = Integer.parseInt(inputNum);

            if (currentNum == 0) {
                System.out.print(" ");
            } else {
                int mainDigit = currentNum % 10;
                int offset = (mainDigit - 2) * 3;
                if (mainDigit == 8 || mainDigit == 9) {
                    offset = offset + 1;
                }
                int letterIndex = offset + length - 1;
                char equivalent = (char) (97 + letterIndex);

                System.out.print(equivalent);
            }
        }
    }
}
