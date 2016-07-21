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

}