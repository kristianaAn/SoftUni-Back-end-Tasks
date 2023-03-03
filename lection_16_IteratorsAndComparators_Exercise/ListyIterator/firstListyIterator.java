package lection_16_IteratorsAndComparators_Exercise.ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class firstListyIterator {
    private List<String> list;
    private int currentIndex;

    public firstListyIterator(String createCommand, String... args) {
        this.list = new ArrayList<>(Arrays.asList(args));
        this.currentIndex = 0;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public boolean hasNext() {
        return currentIndex < list.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
           currentIndex++;
           return true;
        }
        return false;
    }
    
    public void print() {
        if (list.isEmpty()) {
            throw new IllegalStateException ("Invalid Operation!");
        } else {
            System.out.println(list.get(currentIndex));
        }
    }

}
