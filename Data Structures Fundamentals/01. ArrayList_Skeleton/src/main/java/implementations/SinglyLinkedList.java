package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    @Override
    public void addFirst(E element) {
        Node<E> elToInsert = new Node<>(element);
        elToInsert.next = this.head;
        this.head = elToInsert;
        size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> elToInsert = new Node<>(element);

        if (this.isEmpty()) {
            this.head = elToInsert;
            size++;
            return;
        }

        Node<E> current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = elToInsert;
        size++;
    }

    @Override
    public E removeFirst() {
        E elToRemove = this.head.element;
        this.head = head.next;
        size--;
        return elToRemove;
    }

    @Override
    public E removeLast() {
        ensureEmptiness();

        if (this.size == 1) {
            E elToReturn = this.head.element;
            this.head = null;
            size--;
            return elToReturn;
        }

        Node<E> preLast = this.head;
        Node<E> lastEl = preLast.next;

        while (lastEl.next != null) {
            preLast = preLast.next;
            lastEl = lastEl.next;
        }

        preLast.next = null;
        size--;
        return lastEl.element;
    }

    @Override
    public E getFirst() {
        ensureEmptiness();

        return this.head.element;
    }

    @Override
    public E getLast() {
        ensureEmptiness();

        Node<E> lastEl = this.head;

        while (lastEl.next != null) {
            lastEl = lastEl.next;
        }

        return lastEl.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> currentEl = head;

            @Override
            public boolean hasNext() {
                return currentEl.next != null;
            }

            @Override
            public E next() {
                E element = currentEl.element;
                this.currentEl = currentEl.next;
                return element;
            }
        };
    }

    private void ensureEmptiness() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
    }

}
