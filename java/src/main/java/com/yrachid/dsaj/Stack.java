package com.yrachid.dsaj;

public class Stack<T> {

    private final int maxSize;
    private int top;
    private T[] items;

    @SuppressWarnings("unchecked")
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.top = 0;
        this.items = (T[]) new Object[maxSize];
    }

    public void push(T element) {
        if (top == maxSize) {
            throw new StackOverflowException("Max stack size exceeded");
        }

        items[top++] = element;
    }

    public T pop() {
        return items[--top];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == maxSize;
    }

    public static class StackOverflowException extends RuntimeException {
        public StackOverflowException(String s) {
            super(s);
        }
    }
}
