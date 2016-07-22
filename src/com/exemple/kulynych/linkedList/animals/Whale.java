package com.exemple.kulynych.linkedList.animals;

public class Whale extends Animal{
    private int length;

    public Whale(int weight, int length) {
        super("blue", weight);
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
