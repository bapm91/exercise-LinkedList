package com.exemple.kulynych.animals;

public class Animal {
    protected String color;
    protected int weight;

    public Animal(String color, int weight) {
        if (color == null) {
            throw new NullPointerException("null in color");
        }
        this.color = color;
        this.weight = weight;
    }

    protected String getColor() {
        return color;
    }

    protected int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (weight != animal.weight) return false;
        return color.equals(animal.color);
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + weight;
        return result;
    }
}
