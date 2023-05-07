package lection_16_IteratorsAndComparators_Exercise.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int currentIndex;

    public ListyIterator(String createCommand, String... args) {
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

    public void printAll() {
        if (list.isEmpty()) {
            throw new IllegalStateException ("Invalid Operation!");
        } else {
            String result = String.join(" ", list);
            System.out.println(result);
        }
    }

    private class myIterator implements Iterator<String> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < list.size() - 1;
        }

        @Override
        public String next() {
            return list.get(currentIndex++);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new myIterator();
    }

}
