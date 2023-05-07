package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    private Node<E> head;
    private int size;

    public Queue() {
        this.head = null;
        this.size = 0;
    }

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E element) {
            this.value = element;
        }
    }

    @Override
    public void offer(E element) {
        Node<E> elToInsert = new Node<>(element);

        if (this.head == null) {
            this.head = elToInsert;
            size++;
            return;
        }

        Node<E> currentEl = this.head;

        while (currentEl.next != null) {
            currentEl = currentEl.next;
        }

        currentEl.next = elToInsert;
        size++;
    }

    @Override
    public E poll() {
        ensureEmptiness();

        Node<E> elToPoll = this.head;
        this.head = head.next;
        size--;
        return elToPoll.value;
    }

    @Override
    public E peek() {
        ensureEmptiness();

        return this.head.value;
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
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return this.current.next != null;
            }

            @Override
            public E next() {
                E elToReturn = current.value;
                this.current = current.next;
                return elToReturn;
            }
        };
    }

    private void ensureEmptiness() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
