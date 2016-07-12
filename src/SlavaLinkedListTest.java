import java.util.List;

import static org.junit.Assert.*;

public class SlavaLinkedListTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void size() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        assertEquals(0, list.size());
        list.add("yo");
        list.add("ynbivfo");
        list.add("yvro");
        list.add("ymo");
        assertEquals(4, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @org.junit.Test
    public void isEmpty() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        assertEquals(true, list.isEmpty());
        list.add("yo");
        list.add("ynbivfo");
        list.add("yvro");
        list.add("ymo");
        assertEquals(false, list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @org.junit.Test
    public void contains() throws Exception {

    }

    @org.junit.Test
    public void toArray() throws Exception {

    }

    @org.junit.Test
    public void toArray1() throws Exception {

    }

    @org.junit.Test
    public void add() throws Exception {

    }

    @org.junit.Test
    public void remove() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("first");
        list.add(null);
        list.add("third");
        list.add("");
        list.remove(2);
        assertEquals("", list.get(2));
        list.remove(0);
        assertEquals(2, list.size());
        assertEquals("", list.get(1));
        list.clear();
        assertEquals(0, list.size());

        list.add("first");
        list.remove(0);
        assertEquals(0, list.size());

        try {
            list.get(0);
            fail("IndexOutOfBoundsException expected here");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }

        try {
            list.get(5);
            fail("IndexOutOfBoundsException expected here");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }

        try {
            list.get(-1);
            fail("IndexOutOfBoundsException expected here");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @org.junit.Test
    public void containsAll() throws Exception {

    }

    @org.junit.Test
    public void addAll() throws Exception {

    }

    @org.junit.Test
    public void addAll1() throws Exception {

    }

    @org.junit.Test
    public void removeAll() throws Exception {

    }

    @org.junit.Test
    public void removeIf() throws Exception {

    }

    @org.junit.Test
    public void retainAll() throws Exception {

    }

    @org.junit.Test
    public void replaceAll() throws Exception {

    }

    @org.junit.Test
    public void clear() throws Exception {

    }

    @org.junit.Test
    public void get() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("yo");
        list.add("ynbivfo");
        list.add("yvro");
        list.add("ymo");
        assertEquals("yvro", list.get(2));

        try {
            list.get(5);
            fail("IndexOutOfBoundsException expected here");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }

        try {
            list.get(-1);
            fail("IndexOutOfBoundsException expected here");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @org.junit.Test
    public void set() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("yo");
        list.add("ynbivfo");
        list.add("yvro");
        list.add("ymo");
        list.set(2,"test");
        assertEquals("test", list.get(2));
    }

    @org.junit.Test
    public void add1() throws Exception {

    }

    @org.junit.Test
    public void remove1() throws Exception {

    }

    @org.junit.Test
    public void indexOf() throws Exception {

    }

    @org.junit.Test
    public void lastIndexOf() throws Exception {

    }

    @org.junit.Test
    public void subList() throws Exception {

    }

}