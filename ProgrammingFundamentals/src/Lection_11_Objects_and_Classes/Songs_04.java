package Lection_11_Objects_and_Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs_04 {

    static class Song {
        String typeList;
        String name;
        String time;

        public void setTypeList (String typeList) {
            this.typeList = typeList;
        }

        public String getTypeList() {
            return this.typeList;
        }

        public void setName (String name) {
            this.name = name;
        }

        public String getName() {

            return this.name;
        }

        public void setTime (String time) {

            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songsList = new ArrayList<>();
        for (int i = 1; i <= numOfSongs; i++) {
            String[] inputSong = scanner.nextLine().split("_");

            Song currentSong = new Song();

            currentSong.setTypeList(inputSong[0]);
            currentSong.setName(inputSong[1]);
            currentSong.setTime(inputSong[2]);

            songsList.add(currentSong);
        }

        String inputCommand = scanner.nextLine();

        if (inputCommand.equals("all")) {
            for (Song name : songsList) {
                System.out.println(name.getName());
            }
        } else {
            for (Song type : songsList) {
                if (type.getTypeList().equals(inputCommand)) {
                    System.out.println(type.getName());
                }
            }
        }

    }
}
