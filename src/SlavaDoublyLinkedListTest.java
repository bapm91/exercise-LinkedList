import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SlavaDoublyLinkedListTest extends SlavaSinglyLinkedListTest {

    @Override @Before
    public void setUp(){
        list = new SlavaDoublyLinkedList<>();
    }

    @Test
    public void add() throws Exception {
        list.add("one");
        list.add("two");
        list.add("");
        list.add("three");
        list.add(null);
        list.add("four");
        assertEquals("three", list.get(3));
        assertEquals(6, list.size());

        list.add(0, "one-x-one");
        list.add(2, "two-x-two");
        list.add(8, "five");
        assertEquals(9, list.size());
        assertEquals("one-x-one", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two-x-two", list.get(2));
        assertEquals("two", list.get(3));
        assertEquals("", list.get(4));
        assertEquals("three", list.get(5));
        assertEquals(null, list.get(6));
        assertEquals("four", list.get(7));
        assertEquals("five", list.get(8));

        list.remove(6);
        assertEquals("one-x-one", list.get(0));
        list.remove(2);
        assertEquals("one-x-one", list.get(0));
        list.remove(0);
        assertEquals("one", list.get(0));

        list.add(0, "one-x");
        assertEquals("one", list.get(1));
        list.add(2, "two-x");
        assertEquals("one", list.get(1));
        list.add(6, "five-x");
        assertEquals(9, list.size());
        assertEquals("one-x", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals("two-x", list.get(2));
        assertEquals("two", list.get(3));
        assertEquals("", list.get(4));
        assertEquals("three", list.get(5));
        assertEquals("five-x", list.get(6));
        assertEquals("four", list.get(7));
        assertEquals("five", list.get(8));


        try {
            list.add(11, "");
            fail("IndexOutOfBoundsException expected here");
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }

        try {
            list.get(11);
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
    public void remove() throws Exception {
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

        list.add("3rd-bis");
        assertEquals(3, list.size());
        assertEquals("first", list.get(0));
        assertEquals("2nd-bis", list.get(1));
        assertEquals("3rd-bis", list.get(2));

        list.remove(1);
        assertEquals("first", list.get(0));
        assertEquals("3rd-bis", list.get(1));
        assertEquals(2, list.size());

        list.remove(1);
        assertEquals("first", list.get(0));
        assertEquals(1, list.size());

        list.add("2nd-bis-bis");
        assertEquals(2, list.size());
        assertEquals("first", list.get(0));
        assertEquals("2nd-bis-bis", list.get(1));

    }

    @Test
    public void get() throws Exception {
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
    public void removeAll() throws Exception {
        list.add("3rd");
        list.add(null);
        list.add("1");
        list.add("2nd");
        list.add("4th");
        list.add("30");
        list.add("1");
        list.add("first");
        list.add("11th");

        List<String> from = new SlavaDoublyLinkedList<>();
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
    public void retainAll() throws Exception {
        list.add("3rd");
        list.add(null);
        list.add("");
        list.add("2nd");
        list.add("4th");
        list.add("30");
        list.add("");
        list.add("first");
        list.add("11th");
        assertEquals(9, list.size());

        List<String> from = new SlavaDoublyLinkedList<>();
        from.add("");
        from.add("11th");
        from.add(null);
        from.add("from");
        from.add("like");
        from.add("3rd");

        list.retainAll(from);
        assertEquals(5, list.size());
        assertEquals("3rd", list.get(0));
        assertEquals(null, list.get(1));
        assertEquals("", list.get(2));
        assertEquals("", list.get(3));
        assertEquals("11th", list.get(4));
    }

    @Test
    public void set() throws Exception {
        list.add("");
        list.add(null);
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.set(0, "1");
        list.set(4, "");
        list.set(6, null);
        assertEquals("four", list.get(3));
        assertEquals("", list.get(4));
        assertEquals("1", list.get(0));
        assertEquals(null, list.get(6));
        assertEquals(7, list.size());
    }
}