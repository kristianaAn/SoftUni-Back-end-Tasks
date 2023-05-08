package lection_16_TextProcessing_Exercise;

import java.util.Scanner;

public class ExtractFile_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputPath = scanner.nextLine().split("\\\\");

        String lastWord = inputPath[inputPath.length - 1];
        String fileName = lastWord.split("\\.")[0];
        String extension = lastWord.split("\\.")[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}
