package lection_13_Generics_lab.GenericScale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        T heavier = null;
        if (left.compareTo(right) > 0) {
            heavier = left;
        } else if (left.compareTo(right) < 0) {
            heavier = right;
        }
        return heavier;
    }
}
