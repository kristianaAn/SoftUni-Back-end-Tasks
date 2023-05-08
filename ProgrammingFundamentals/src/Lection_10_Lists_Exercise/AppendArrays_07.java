package Lection_10_Lists_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numsFullList = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        Collections.reverse(numsFullList);

        System.out.println(numsFullList.toString()
                .replace("[", "").replace("]", "")
                .trim().replaceAll(",", "").replaceAll("\\s+", " "));
    }
}
