package lection_08_StreamsFilesAndDirectories_exercise;

import java.io.File;
import java.util.ArrayDeque;

public class GetFolderSize_08 {
    public static void main(String[] args) {
        File folder = new File("resources");
        ArrayDeque<File> directories = new ArrayDeque<>();
        directories.offer(folder);

        int bytesSum = 0;
        while (!directories.isEmpty()) {
            File currentFile = directories.poll();
            File[] files = currentFile.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    directories.offer(file);
                } else {
                     bytesSum += files.length;
                }
            }
        }

        System.out.println("Folder size: " + bytesSum);
    }
}
