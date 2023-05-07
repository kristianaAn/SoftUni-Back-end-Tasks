package lection_07_StreamsFilesAndDirectories_lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile_02 {
    public static void main(String[] args) {
        String pathIn = "C:\\Users\\User\\Downloads\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\User\\Downloads\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        Set<Character> forbiddenSymbols = new HashSet<>();
        Collections.addAll(forbiddenSymbols, '.', ',', '!', '?');

        try (FileInputStream in = new FileInputStream(pathIn);
        FileOutputStream out = new FileOutputStream(pathOut)) {
            int oneByte = in.read();

            while (oneByte >= 0) {
                char myByteChar = (char) oneByte;
                if (!forbiddenSymbols.contains(myByteChar)) {
                    out.write(oneByte);
                }

                oneByte = in.read();
            }
            in.close();
            out.close();
        } catch (IOException e) {

        }

    }
}
