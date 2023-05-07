package lection_14_Generics_Exercise.box;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> inputData;

    public Box() {
        this.inputData = new ArrayList<>();
    }

    public void add(T element) {
        inputData.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(inputData, firstIndex, secondIndex);
    }

    public int greaterThan(T element) {
        int count = 0;
        for (T entry : inputData) {
            if (entry.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(T element) {
        return inputData.contains(element);
    }

    public void remove(int index) {
        T elementToRemove = inputData.get(index);
        inputData.remove(elementToRemove);
    }

    public T getMax() {
        return inputData.stream().max(Comparable::compareTo).get();
    }

    public T getMin() {
        return inputData.stream().min(Comparable::compareTo).get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T entry : inputData) {
            sb.append(entry.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
