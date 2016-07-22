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

    @Override
    public String toString() {
        return "Whale{" +
                "color='" + "blue" + '\'' +
                ", weight=" + weight +
                ", length=" + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Whale whale = (Whale) o;

        return length == whale.length;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + length;
        return result;
    }
}
