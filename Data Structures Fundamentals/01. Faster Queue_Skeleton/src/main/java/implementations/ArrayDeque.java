package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {
    private final int INITIAL_CAPACITY = 7;
    private int size;
    private int head;
    private int tail;
    private Object[] elements;

    public ArrayDeque() {
        this.elements = new Object[INITIAL_CAPACITY];
        int middle = INITIAL_CAPACITY / 2;
        this.head = this.tail = middle;
    }

    @Override
    public void add(E element) {
        if (this.size == 0) {
            this.elements[this.tail] = element;
        } else {
            if (this.tail == this.elements.length - 1) {
                grow();
            }
            this.elements[++this.tail] = element;
        }

        this.size++;
    }

    private void grow() {
        int length = this.elements.length * 2 + 1;
        Object[] newElements = new Object[length];

        int middle = length / 2;

        int startPoint = middle - this.size / 2;

        int endPoint = middle + this.size / 2;

        for (int i = startPoint; i < endPoint; i++) {
            newElements[i] = elements[head++];
        }

        this.head = startPoint;
        this.tail = endPoint - 1;
        this.elements = newElements;
    }

    @Override
    public void offer(E element) {
        add(element);
    }

    @Override
    public void addFirst(E element) {
        if (this.size == 0) {
            this.elements[this.head] = element;
        } else {
            if (this.head == 0) {
                grow();
            }
            this.elements[--this.head] = element;
        }
        this.size++;
    }

    @Override
    public void addLast(E element) {
        add(element);
    }

    public void push(E element) {
        addFirst(element);
    }

    @Override
    public void insert(int index, E element) {
        int realIndex = index + this.head;
        ensureIndex(realIndex);

        if (realIndex - this.head < this.tail - realIndex) {
            shiftLeft(realIndex, element);
        } else {
            shiftRight(realIndex, element);
        }
    }

    private void shiftRight(int realIndex, E element) {
        E lastElement = this.getAt(this.tail);
        for (int i = this.tail; i >= realIndex; i--) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[realIndex] = element;
        addLast(lastElement);
    }

    private void shiftLeft(int realIndex, E element) {
        E firstElement = this.getAt(this.head);
        for (int i = this.head; i < realIndex; i++) {
            this.elements[i - 1] = this.elements[i];
        }
        addFirst(firstElement);
        this.elements[realIndex - 1] = element;
    }

    @Override
    public void set(int index, E element) {
        int realIndex = this.head + index;
        ensureIndex(realIndex);
        this.elements[realIndex] = element;
    }

    @Override
    public E peek() {
        if (this.size != 0) {
            return this.get(this.head);
        }
        return null;
    }

    @Override
    public E poll() {
        if (!isEmpty()) {
            return removeFirst();
        }
        return null;
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            return removeFirst();
        }
        return null;
    }

    @Override
    public E get(int index) {
        int realIndex = this.head + index;
        ensureIndex(realIndex);
        return this.getAt(realIndex);
    }

    @Override
    public E get(Object object) {
        if (isEmpty()) {
            return null;
        }

        E returnee = null;
        for (int i = this.head; i < this.tail; i++) {
            if (elements[i].equals(object)) {
                returnee = this.getAt(i);
            }
        }
        return returnee;
    }

    @Override
    public E remove(int index) {
        int realIndex = this.head + index;
        ensureIndex(realIndex);

        E elementRemoved = null;
        int indexToRemoveFrom = 0;
        for (int i = this.head; i <= this.tail; i++) {
            if (i == realIndex) {
                indexToRemoveFrom = i;
                elementRemoved = this.getAt(i);
                this.elements[i] = null;
                break;
            }
        }

        removedElementsShift(indexToRemoveFrom);
        return elementRemoved;
    }

    private void removedElementsShift(int indexToRemoveFrom) {
        for (int i = indexToRemoveFrom + 1; i <= this.tail; i++) {
            elements[i - 1] = elements[i];
        }
        this.elements[this.tail] = null;
        this.tail--;
    }

    private void ensureIndex(int realIndex) {
        if (realIndex < this.head || realIndex > this.tail) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    @Override
    public E remove(Object object) {
        if (isEmpty()) {
            return null;
        }

        E removedEl = null;
        int index = 0;
        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i] == object) {
                removedEl = this.getAt(i);
                index = i;
                this.elements[i] = null;
                break;
            }
        }

        removedElementsShift(index);
        return removedEl;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty()) {
            E element = this.getAt(this.head);
            this.head++;
            this.size--;
            this.elements[this.head] = null;
            return element;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private E getAt(int index) {
        return (E) this.elements[index];
    }

    @Override
    public E removeLast() {
        if (!isEmpty()) {
            E elementToRemove = this.getAt(this.tail);
            this.tail--;
            this.size--;
            this.elements[this.tail] = null;
            return elementToRemove;
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {
        Object[] newElements = new Object[this.size];
        int index = 0;
        for (int i = this.head; i <= this.tail; i++) {
            newElements[index++] = this.elements[i];
        }

        this.elements = newElements;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int current = head;

            @Override
            public boolean hasNext() {
                return current <= tail;
            }

            @Override
            public E next() {
                return getAt(current++);
            }
        };
    }
}
