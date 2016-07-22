package com.exemple.kulynych.linkedList.animals;

public class  Owl extends Animal{
    private int wingspan;

    public Owl(String color, int weight, int wingspan) {
        super("gray", weight);
        this.wingspan = wingspan;
    }

    public int getWingspan() {
        return wingspan;
    }
}
