package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private static final int INITIAL_CAPACITY = 4;
    private Object[] data;
    private int currentSize;
    private int currentCapacity;

    public ArrayList() {
        this.data = new Object[INITIAL_CAPACITY];
        this.currentSize = 0;
        this.currentCapacity = INITIAL_CAPACITY;
    }

    @Override
    public boolean add(E element) {
        validateSize();
        this.data[currentSize++] = element;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        if (!validateIndex(index)) {
            return false;
        }

        validateSize();

        for (int i = this.currentSize - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        this.data[index] = element;
        currentSize++;
        return true;
    }

    @Override
    public E get(int index) {
        if (!validateIndex(index)) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Object objectToReturn = data[index];

        return (E) objectToReturn;
    }

    @Override
    public E set(int index, E element) {
        if (!validateIndex(index)) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Object previousObject = data[index];
        data[index] = element;

        return (E) previousObject;
    }

    @Override
    public E remove(int index) {
        if (!validateIndex(index)) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Object objectToReturn = data[index];
        for (int i = index; i < currentSize; i++) {
            data[i] = data[i + 1];
        }
        currentSize--;
        ensureCapacity();
        return (E) objectToReturn;
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.currentSize; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < this.currentSize; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (this.currentSize == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < currentSize;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private void grow() {
        currentCapacity *= 2;
        this.data = Arrays.copyOf(this.data, currentCapacity);
    }

    private void validateSize() {
        if (this.currentSize == this.currentCapacity) {
            grow();
        }
    }

    private boolean validateIndex(int index) {
        return index >= 0 && index < currentSize;
    }

    private void ensureCapacity() {
        if (currentSize <= currentCapacity / 3) {
            shrink();
        }
    }

    private void shrink() {
        this.currentCapacity /= 2;
        this.data = Arrays.copyOf(data, currentCapacity);
    }
}
