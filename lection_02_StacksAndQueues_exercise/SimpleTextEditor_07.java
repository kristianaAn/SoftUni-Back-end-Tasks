package lection_02_StacksAndQueues_exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nNumberOfOperations = Integer.parseInt(scanner.nextLine());
        //"1 {string}" - appends [string] to the end of the text.
        //"2 {count}" - erases the last [count] elements from the text.
        //"3 {index}" - returns the element at position [index] from the text.
        //"4" - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation.

        StringBuilder wordFormed = new StringBuilder();
        ArrayDeque<String> textStack = new ArrayDeque<>();

        for (int i = 0; i < nNumberOfOperations; i++) {
            String input = scanner.nextLine();
            String command = input.split("\\s+")[0];

            if (command.equals("1")) {
                textStack.push(wordFormed.toString());
                String textToAppend = input.split("\\s+")[1];
                wordFormed.append(textToAppend);

            } else if (command.equals("2")) {
                textStack.push(wordFormed.toString());
                int elementsCountToErase = Integer.parseInt(input.split("\\s+")[1]);
                int indexToStartFromDeleting = wordFormed.length() - elementsCountToErase; //индекса, от който започвам да трия
                wordFormed.delete(indexToStartFromDeleting, wordFormed.length());

            } else if (command.equals("3")) {
                int index = Integer.parseInt(input.split("\\s+")[1]);

                System.out.println(wordFormed.charAt(index - 1));

            } else if (command.equals("4")) {
                if (!textStack.isEmpty()) {
                    wordFormed = new StringBuilder(textStack.pop());
                }
            }
        }
    }
}
