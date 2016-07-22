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

    @Override
    public String toString() {
        return "Owl{" +
                "color=" + color +  '\'' +
                ", weight" + weight +
                ", wingspan=" + wingspan +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Owl owl = (Owl) o;

        return wingspan == owl.wingspan;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + wingspan;
        return result;
    }
}
