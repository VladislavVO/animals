package com.example.petregistry;


public class Counter implements AutoCloseable {
    private int value;
    private boolean isClosed;

    public Counter() {
        value = 0;
        isClosed = false;
    }

    public void add() {
        if (isClosed) {
            throw new IllegalStateException("Counter is closed.");
        }
        value++;
    }

    public int getValue() {
        if (isClosed) {
            throw new IllegalStateException("Counter is closed.");
        }
        return value;
    }

    @Override
    public void close() {
        isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }
}

