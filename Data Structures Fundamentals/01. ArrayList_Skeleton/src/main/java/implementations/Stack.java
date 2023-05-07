package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {
    private Node<E> top;
    private int size;

    public Stack() {
        this.top = null;
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
    public void push(E element) {
        Node<E> elToAdd = new Node<>(element);
        elToAdd.next = this.top;
        this.top = elToAdd;
        size++;
    }

    @Override
    public E pop() {
        ensureEmptiness();

        Node<E> elementRemoved = this.top;
        this.top = top.next;
        size--;
        return elementRemoved.element;
    }

    @Override
    public E peek() {
        ensureEmptiness();
        return this.top.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> currentEl = top;

            @Override
            public boolean hasNext() {
                return currentEl.next != null;
            }

            @Override
            public E next() {
                E elementToReturn = this.currentEl.element;
                this.currentEl = this.currentEl.next;
                return elementToReturn;
            }
        };
    }

    private void ensureEmptiness() {
        if (top == null) {
            throw new IllegalStateException();
        }
    }
}
