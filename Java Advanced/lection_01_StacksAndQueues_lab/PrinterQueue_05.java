package lection_01_StacksAndQueues_lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> filesToPrintQueue = new ArrayDeque<>();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
               if (filesToPrintQueue.isEmpty()) {
                   System.out.println("Printer is on standby");
               } else {
                   System.out.printf("Canceled %s%n", filesToPrintQueue.poll());
               }

            } else {
               filesToPrintQueue.offer(input);
            }

            input = scanner.nextLine();
        }

        for (String filesToPrint : filesToPrintQueue) {
            System.out.println(filesToPrint);
        }
    }
}
