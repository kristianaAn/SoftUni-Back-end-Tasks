package lection_08_StreamsFilesAndDirectories_exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwoFiles_07 {
    public static void main(String[] args) throws IOException {
        Path firstFile = Paths.get("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt");
        List<String> stringList = Files.readAllLines(firstFile);

        Path secondFile = Paths.get("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt");
        List<String> stringList2 = Files.readAllLines(secondFile);

        Path output = Paths.get("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt");
        Files.write(output, stringList, StandardOpenOption.APPEND);
        Files.write(output, stringList2, StandardOpenOption.APPEND);
    }
}
