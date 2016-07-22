package com.exemple.kulynych.linkedList;

import com.exemple.kulynych.linkedList.animals.Cat;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SlavaDoublyLinkedListTest{

    private List<Cat> catList;
    private Cat cat0, cat1, cat2, cat3, cat4, cat5;

    @Before
    public void setUp() {
        catList = new SlavaDoublyLinkedList<Cat>();
        cat0 = new Cat("red", 5, "Барсик");
        cat1 = new Cat("green", 4, "Меля");
        cat2 = new Cat("blue", 9, "Бублик");
        cat3 = new Cat("red", 5, "Барсик");
        cat4 = new Cat("black", 3, "Мурчик");
        cat5 = new Cat("gray", 3, "Мурчик");
        catList.add(cat0);
        catList.add(cat1);
        catList.add(cat2);
        catList.add(cat3);
        catList.add(cat4);
        catList.add(0, cat5);
    }

    @Test
    public void add() throws Exception {
        assertEquals(6, catList.size());
        assertEquals(new Cat("gray", 3, "Мурчик"), catList.get(0));
        assertEquals(new Cat("green", 4, "Меля"), catList.get(2));
        assertEquals(new Cat("red", 5, "Барсик"), catList.get(4));

    }

    @Test
    public void remove() throws Exception {
        catList.remove(0);
        catList.remove(4);
        catList.remove(cat1);

        assertEquals(3, catList.size());
        assertEquals(cat0, catList.get(0));
        assertEquals(new Cat("blue", 9, "Бублик"), catList.get(1));
        assertEquals(new Cat("red", 5, "Барсик"), catList.get(2));
    }

    @Test
    public void removeAll() throws Exception {
        List<Cat> list2 = new SlavaDoublyLinkedList<>();
        Cat cat6 = new Cat("red", 5, "Барсик");
        Cat cat7 = new Cat("black", 3, "Мурчик");
        list2.add(cat6);
        list2.add(cat7);
        catList.removeAll(list2);

        assertEquals(3, catList.size());

    }

    @Test
    public void retainAll() throws Exception {
        List<Cat> list2 = new SlavaDoublyLinkedList<>();
        Cat cat6 = new Cat("red", 5, "Барсик");
        Cat cat7 = new Cat("black", 3, "Мурчик");
        list2.add(cat6);
        list2.add(cat7);
        catList.retainAll(list2);

        assertEquals(3, catList.size());
        assertEquals(new Cat("red", 5, "Барсик"), catList.get(1));

    }

    @Test
    public void contains() throws Exception {

        assertTrue(catList.contains(new Cat("blue", 9, "Бублик")));
        assertFalse(catList.contains(new Cat("blue", 9, "Bublyck")));
    }
}