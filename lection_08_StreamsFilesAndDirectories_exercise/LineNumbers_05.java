package lection_08_StreamsFilesAndDirectories_exercise;

import java.io.*;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new FileReader("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
        String line = br.readLine();
        int count = 1;
        while (line != null) {
            pw.println(count + ". " + line);
            count++;

            line = br.readLine();
        }
        br.close();
        pw.close();
    }
}
