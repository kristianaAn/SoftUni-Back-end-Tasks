package lection_13_Generics_lab.ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 18, 2, -1);

        Integer max = ListUtils.getMax(integers);
        System.out.println(max);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        String min = ListUtils.getMin(strings);
        System.out.println(min);
    }
}
