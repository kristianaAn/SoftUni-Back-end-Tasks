package lection_13_Generics_lab.ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils<T> {

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T max = Collections.max(list);
        return max;
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T min = Collections.min(list);
        return min;
    }


}
