package lection_07_StreamsFilesAndDirectories_lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws FileNotFoundException {

        String pathIn = "C:\\Users\\User\\Downloads\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\User\\Downloads\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(pathIn));
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(pathOut));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
               int number = scanner.nextInt();
               printWriter.println(number);
            }

            scanner.next();
        }
        printWriter.close();
    }
}
