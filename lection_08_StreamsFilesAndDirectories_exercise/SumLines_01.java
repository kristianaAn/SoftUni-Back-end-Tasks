package lection_08_StreamsFilesAndDirectories_exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        String line = br.readLine();

        while (line != null) {
            long sum = 0;
            char[] charasFromLine = line.toCharArray();

            for (char character : charasFromLine) {
                sum += character;
            }

            System.out.println(sum);
            line = br.readLine();
        }
        br.close();
    }
}
