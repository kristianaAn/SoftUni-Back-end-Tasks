package lection_08_StreamsFilesAndDirectories_exercise;

import java.io.*;
import java.util.Locale;

public class ALLCAPITALS_1_03 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
        BufferedReader bf = new BufferedReader(new FileReader("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        bf.lines().forEach(line -> System.out.println(line.toUpperCase()));
        bf.close();
        pw.close();
    }
}
