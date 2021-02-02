package com.yrachid.dsaj;

import java.util.Optional;

class CircularQueue<T> {

    private final int maxSize;
    private int front = 0;
    private int rear = -1;
    private T[] items;
    private int nItems = 0;

    @SuppressWarnings("unchecked")
    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        this.items = (T[]) new Object[maxSize];
    }

    public void insert(T element) {
        if (rear == maxSize - 1) {
            rear = -1;
        }

        items[++rear] = element;
        nItems++;
    }

    public Optional<T> peekFront() {
        return Optional.ofNullable(items[front]);
    }

    public T remove() {
        T first = items[front++];

        if (front == maxSize) {
            front = 0;
        }

        nItems--;
        return first;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public int size() {
        return nItems;
    }
}

