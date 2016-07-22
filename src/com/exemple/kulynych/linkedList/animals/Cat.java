package com.exemple.kulynych.linkedList.animals;

public class Cat extends Animal{
    private String name;

    public String getName() {
        return name;
    }

    public Cat(String color, int weight, String name) {
        super(color, weight);
        if (name == null) {
            throw new NullPointerException("null in name");
        }
        this.name = name;
    }

    public String getColor(){
        return color;
    }

    public int getWeight(){
        return weight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cat cat = (Cat) o;

        return name.equals(cat.name);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
