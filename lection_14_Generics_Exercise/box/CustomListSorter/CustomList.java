package lection_14_Generics_Exercise.box.CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> customList;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public void add(T element) {
        customList.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(customList, firstIndex, secondIndex);
    }

    public int greaterThan(T element) {
        int count = 0;
        for (T entry : customList) {
            if (entry.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(T element) {
        return customList.contains(element);
    }

    public void remove(int index) {
        T elementToRemove = customList.get(index);
        customList.remove(elementToRemove);
    }

    public T getMax() {
        return customList.stream().max(Comparable::compareTo).get();
    }

    public T getMin() {
        return customList.stream().min(Comparable::compareTo).get();
    }

    public List<T> getInputData() {
        return customList;
    }

    public void setInputData(List<T> inputData) {
        this.customList = inputData;
    }

    public int size() {
        return customList.size();
    }

    public T get(int index) {
        return customList.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T entry : customList) {
            sb.append(entry.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
