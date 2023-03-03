package lection_14_Generics_Exercise.box.CustomListSorter;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        for (int i = 0; i < customList.size(); i++) {
            //[1, 2, 3, 4]
            for (int j = 1; j <= customList.size() - 1; j++) {
                if (customList.get(j - 1).compareTo(customList.get(j)) > 0) {
                    customList.swap(j - 1, j);
                }
            }
        }
    }
}
