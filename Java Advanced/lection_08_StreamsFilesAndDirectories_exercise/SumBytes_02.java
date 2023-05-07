package lection_08_StreamsFilesAndDirectories_exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        String line = br.readLine();

        long sum = 0;
        while (line != null) {

            char[] charasFromLine = line.toCharArray();

            for (char character : charasFromLine) {
                sum += character;
            }

            line = br.readLine();
        }
        System.out.println(sum);
        br.close();
    }
}
