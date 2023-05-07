package lection_01_StacksAndQueues_lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browserHistoryStack = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentUrl = null;

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                //back
                if (browserHistoryStack.size() > 1) {
                    browserHistoryStack.pop();
                    currentUrl = browserHistoryStack.peek();
                    System.out.println(currentUrl);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                //URL
                browserHistoryStack.push(input);
                currentUrl = input;
                System.out.println(currentUrl);
            }

            input = scanner.nextLine();
        }
    }
}
