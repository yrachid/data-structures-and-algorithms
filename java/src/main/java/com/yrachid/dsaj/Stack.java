package com.yrachid.dsaj;

public class Stack {

    private final int maxSize;
    private int currentSize;
    private long[] items;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.items = new long[maxSize];
    }

    public void push(long element) {
        if (currentSize  == maxSize) {
            throw new StackOverflowException("Max stack size exceeded");
        }

        items[currentSize++] = element;
    }

    public long pop() {
        return items[--currentSize];
    }

    public static class StackOverflowException extends RuntimeException {
        public StackOverflowException(String s) {
            super(s);
        }
    }
}
