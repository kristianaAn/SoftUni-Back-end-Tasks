package lection_07_StreamsFilesAndDirectories_lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile_01 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\Java Advanced\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();

            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
            in.close();

        }
        catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }


    }
}
