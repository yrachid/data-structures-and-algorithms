package com.yrachid.dsaj;

public class Stack {

    private final int maxSize;
    private int top;
    private long[] items;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.top = 0;
        this.items = new long[maxSize];
    }

    public void push(long element) {
        if (top == maxSize) {
            throw new StackOverflowException("Max stack size exceeded");
        }

        items[top++] = element;
    }

    public long pop() {
        return items[--top];
    }

    public static class StackOverflowException extends RuntimeException {
        public StackOverflowException(String s) {
            super(s);
        }
    }
}
