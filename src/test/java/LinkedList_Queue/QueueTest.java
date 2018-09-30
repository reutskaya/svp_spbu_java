package LinkedList_Queue;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class QueueTest {

    //add
    @Test
    public void addString() {
        Queue<String> testQueue = new Queue<>();
        testQueue.add("one");
        testQueue.add("two");
        testQueue.add("three");

        assertEquals(testQueue.peek(), "one");
        assertEquals(testQueue.size(), 3);
    }

    @Test
    public void addBigArray() {
        Queue<Integer> testQueue = new Queue<>();

        for (int i = 0; i < 100000; i++) {
            testQueue.add(i);
        }

        assertEquals(testQueue.peek(), (Integer) 0);
        assertEquals(testQueue.size(), 100000);
    }

    //contains
    @Test
    public void containsString() {
        Queue<String> testQueue = new Queue<>();
        testQueue.add("one");
        testQueue.add("two");
        testQueue.add("three");
        assertTrue(testQueue.contains("two"));
        assertFalse(testQueue.contains("four"));
    }

    //poll
    @Test
    public void removeFromBound() {
        Queue<Integer> testQueue = new Queue<>();
        testQueue.add(3);
        testQueue.add(4);
        testQueue.add(5);
        testQueue.add(6);
        assertEquals(testQueue.poll(), (Integer) 3);
        assertEquals(testQueue.poll(), (Integer) 4);
        assertEquals(testQueue.size(), 2);
    }
}
