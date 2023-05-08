package DataTypes_MoreExercise;

import java.util.Scanner;

public class DecryptingMessages_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder word = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            char updatedSymbol = 0;
            char symbol = scanner.nextLine().charAt(0);
            updatedSymbol = newSymbol(symbol, k);
            word.append(updatedSymbol);
        }

        System.out.println(word);
    }
    public static char newSymbol(char initialSymbol, int k) {
        return (char) (((int) initialSymbol) + k);
    }
}
