import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

public class SlavaLinkedListTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @Test
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

    @Test
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

    @Test
    public void contains() throws Exception {

    }

    @Test
    public void toArray() throws Exception {

    }

    @Test
    public void toArray1() throws Exception {

    }

    @Test
    public void add() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("3rd");
        list.add(null);
        list.add("");
        list.add("2nd");
        list.add("4th");
        list.add(3, "30");
        list.add("");
        list.add(0, "first");
        list.add(8, "11th");
        assertEquals(9, list.size());
        assertEquals("first", list.get(0));
        assertEquals("3rd", list.get(1));
        assertEquals(null, list.get(2));
        assertEquals("", list.get(3));
        assertEquals("30", list.get(4));
        assertEquals("2nd", list.get(5));
        assertEquals("4th", list.get(6));
        assertEquals("", list.get(7));
        assertEquals("11th", list.get(8));



    }

    @Test
    public void removeObject_null() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("first");
        list.remove(null);
        assertEquals(1, list.size());

        list = new SlavaLinkedList<>();
        list.add(null);
        list.remove("something");
        assertEquals(1, list.size());
        list.remove(null);
        assertEquals(0, list.size());
    }

    @Test
    public void remove() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("first");
        list.add("3rd");
        list.add(null);
        list.add("");
        list.add("3rd");
        list.add("2nd");
        list.add("4th");
        list.add("");
        list.add("11th");

        assertTrue(list.remove("3rd"));
        assertEquals(8 , list.size());
        assertEquals(null, list.get(1));

        assertTrue(list.remove(""));
        assertEquals(7 , list.size());
        assertEquals("3rd", list.get(2));

        assertTrue(list.remove("11th"));
        assertEquals(6 , list.size());
        assertEquals("", list.get(5));

        assertFalse(list.remove("15th"));
        assertEquals(6 , list.size());



    }

    @Test
    public void remove_garbagePrev() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("first");
        list.add("second");
    }

    @Test
    public void remove_one() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("first");
        list.remove(0);
        assertEquals(0, list.size());

        list.add("1st");
        list.add("2nd");
        assertEquals("2nd", list.remove(1));
    }

    @Test
    public void remove_oneBadMLast() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("first");
        list.add("2nd");
        list.add("3rd");
        list.remove(2);
        assertEquals("first", list.get(0));
        assertEquals("2nd", list.get(1));

        list.add("3rd-bis");
        assertEquals(3, list.size());
        assertEquals("first", list.get(0));
        assertEquals("2nd", list.get(1));
        assertEquals("3rd-bis", list.get(2));

        list.remove(1);
        assertEquals("first", list.get(0));
        assertEquals("3rd-bis", list.get(1));
        assertEquals(2, list.size());

        list.remove(1);
        assertEquals("first", list.get(0));
        assertEquals(1, list.size());

        list.add("2nd-bis");
        assertEquals(2, list.size());
        assertEquals("first", list.get(0));
        assertEquals("2nd-bis", list.get(1));
    }

    @Test
    public void containsAll() throws Exception {

    }

    @Test
    public void addAll() throws Exception {

    }

    @Test
    public void addAll1() throws Exception {

    }

    @Test
    public void removeAll() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("3rd");
        list.add(null);
        list.add("1");
        list.add("2nd");
        list.add("4th");
        list.add("30");
        list.add("1");
        list.add("first");
        list.add("11th");

        List<String> from = new ArrayList<>();
        from.add("1");
        from.add("11th");
        from.add(null);
        from.add("from");
        from.add("like");
        from.add("3rd");

        list.removeAll(from);
        assertEquals("2nd", list.get(0));
        assertEquals("4th", list.get(1));
        assertEquals("30", list.get(2));
        assertEquals("first", list.get(3));
        assertEquals(4, list.size());
    }

    @Test
    public void removeIf() throws Exception {

    }

    @Test
    public void retainAll() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("3rd");
        list.add(null);
        list.add("1");
        list.add("2nd");
        list.add("4th");
        list.add("30");
        list.add("1");
        list.add("first");
        list.add("11th");

        List<String> from = new ArrayList<>();
        from.add("1");
        from.add("11th");
        from.add(null);
        from.add("from");
        from.add("like");
        from.add("3rd");

        list.retainAll(from);
        assertEquals("3rd", list.get(0));
        assertEquals(null, list.get(1));
        assertEquals("1", list.get(2));
        assertEquals("1", list.get(3));
        assertEquals("11th", list.get(4));
        assertEquals(5, list.size());
    }

    @Test
    public void replaceAll() throws Exception {

    }

    @Test
    public void clear() throws Exception {

    }

    @Test
    public void get() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("yo");
        list.add("ynbivfo");
        list.add("yvro");
        list.add("ymo");
        assertEquals("ymo", list.get(3));

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

    @Test
    public void set() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("yo");
        list.add("ynbivfo");
        list.add("yvro");
        list.add("ymo");
        list.set(2,"test");
        assertEquals("test", list.get(2));
    }

    @Test
    public void add1() throws Exception {

    }

    @Test
    public void remove1() throws Exception {

    }

    @Test
    public void indexOf() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("first");
        list.add("3rd");
        list.add(null);
        list.add("11th");
        list.add("3rd");
        list.add("2nd");
        list.add("4th");
        list.add("first");
        list.add("11th");
        list.add("2nd");
        assertEquals(5, list.indexOf("2nd"));
        assertEquals(0, list.indexOf("first"));
        assertEquals(1, list.indexOf("3rd"));
        assertEquals(3, list.indexOf("11th"));
        assertEquals(2, list.indexOf(null));
        assertEquals(-1, list.indexOf("-1"));

    }

    @Test
    public void lastIndexOf() throws Exception {
        List<String> list = new SlavaLinkedList<>();
        list.add("first");
        list.add("3rd");
        list.add(null);
        list.add("11th");
        list.add("3rd");
        list.add("2nd");
        list.add("4th");
        list.add("first");
        list.add("11th");
        list.add("2nd");
        list.add("11th");
        list.add(null);
        assertEquals(-1, list.lastIndexOf("-1"));
        assertEquals(9, list.lastIndexOf("2nd"));
        assertEquals(7, list.lastIndexOf("first"));
        assertEquals(4, list.lastIndexOf("3rd"));
        assertEquals(10, list.lastIndexOf("11th"));
        assertEquals(11, list.lastIndexOf(null));
    }

    @Test
    public void subList() throws Exception {

    }

}