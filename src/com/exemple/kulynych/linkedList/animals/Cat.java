package com.exemple.kulynych.linkedList.animals;

public class Cat extends Animal{
    private String name;

    public String getName() {
        return name;
    }

    public Cat(String color, int weight, String name) {
        super(color, weight);
        this.name = name;
    }

    public String getColor(){
        return color;
    }

    protected int getWeight(){
        return weight;
    }
}
