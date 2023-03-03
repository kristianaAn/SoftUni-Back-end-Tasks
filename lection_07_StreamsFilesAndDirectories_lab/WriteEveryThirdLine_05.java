package lection_07_StreamsFilesAndDirectories_lab;

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) throws IOException {
        String pathIn = "C:\\Users\\User\\Downloads\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\User\\Downloads\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        Scanner in = new Scanner(new FileReader(pathIn));
        PrintWriter out = new PrintWriter(new FileWriter(pathOut));

        int counter = 1;
        String line = in.nextLine();
        while (in.hasNextLine()) {
            if (counter % 3 == 0) {
                out.println(line);
            }
            counter++;

            line = in.nextLine();
        }
        in.close();
        out.close();
    }
}
