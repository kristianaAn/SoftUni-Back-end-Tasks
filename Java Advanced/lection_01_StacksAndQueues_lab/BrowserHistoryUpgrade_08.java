package lection_01_StacksAndQueues_lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browserHistoryStack = new ArrayDeque<>();
        ArrayDeque<String> browserForwardQueue = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentUrl = null;

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                //back
                if (browserHistoryStack.size() > 1) {
                    browserForwardQueue.offer(browserHistoryStack.peek());
                    browserHistoryStack.pop();
                    currentUrl = browserHistoryStack.peek();
                    System.out.println(currentUrl);
                } else {
                    System.out.println("no previous URLs");
                }

            } else if (input.equals("forward")) {
                if (browserForwardQueue.size() >= 1) {
                    System.out.println(browserForwardQueue.peek());
                    browserHistoryStack.push(browserForwardQueue.poll());
                } else {
                    System.out.println("no next URLs");
                }

            } else {
                //URL
                browserHistoryStack.push(input);
                currentUrl = input;
                System.out.println(currentUrl);
                browserForwardQueue.clear();
            }

            input = scanner.nextLine();
        }
    }
}
