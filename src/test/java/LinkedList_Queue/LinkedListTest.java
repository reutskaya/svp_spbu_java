package LinkedList_Queue;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class LinkedListTest {

    //add
    @Test
    public void addString() {
        LinkedList<String> testList = new LinkedList<>();
        testList.add("i am string");

        assertEquals(testList.get(0), "i am string");
    }

    @Test
    public void addBigArray() {
        LinkedList<Integer> testList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            testList.add(i);
        }

        assertEquals(testList.get(18192), (Integer) 18192);
    }

    //contains
    @Test
    public void containsString() {
        LinkedList<String> testList = new LinkedList<>();
        testList.add("one");
        testList.add("two");
        testList.add("three");
        assertTrue(testList.contains("two"));
    }

    //remove
    @Test
    public void removeFromBound() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        assertEquals(testList.remove(0), (Integer) 3);
        assertEquals(testList.get(0), (Integer) 4);
    }

    @Test
    public void removeFromMiddle() {
        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);
        assertEquals(testList.remove(2), (Integer) 5);
        System.out.println(testList.get(1) + "  " + testList.get(2));
        assertEquals(testList.get(2), (Integer) 6);
    }

    //add at position

    @Test
    public void addStringAtFirstPosition() {
        LinkedList<String> testList = new LinkedList<>();
        testList.add("start");
        testList.add(0, "i am string");

        assertEquals(testList.get(0), "i am string");
        assertEquals(testList.get(1), "start");
    }

    @Test
    public void addStringAtPosition() {
        LinkedList<String> testList = new LinkedList<>();
        testList.add("zero");
        testList.add("one");
        testList.add("three");
        testList.add(2, "two");

        assertEquals(testList.get(2), "two");
        assertEquals(testList.get(3), "three");
    }

    @Test
    public void addStringAtLastPosition() {
        LinkedList<String> testList = new LinkedList<>();
        testList.add("zero");
        testList.add("one");
        testList.add("two");
        testList.add("three");
        testList.add(4, "four");

        assertEquals(testList.get(4), "four");
        assertEquals(testList.get(3), "three");
    }
}
