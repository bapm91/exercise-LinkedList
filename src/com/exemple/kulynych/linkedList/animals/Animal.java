package com.exemple.kulynych.linkedList.animals;

public class Animal {
    String color;
    int weight;

    public Animal(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    protected String getColor(){
        return color;
    }

    protected int getWeight(){
        return weight;
    }
}
