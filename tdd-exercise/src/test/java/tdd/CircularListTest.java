package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final static int FIRST_VALUE = 1;
    private CircularQueueImpl circularQueue;

    @BeforeEach
    void beforeEach() {
        circularQueue = new CircularQueueImpl(3);
    }

    @Test
    public void testEmpty() {
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    public void testAdd(){
        circularQueue.add(FIRST_VALUE);
        assertFalse(circularQueue.isEmpty());
    }

    @Test
    public void testNotEmpty(){
        circularQueue.add(FIRST_VALUE);
        assertFalse(circularQueue.isEmpty());
    }

    @Test
    public void testMaxCapacity(){
        circularQueue.add(FIRST_VALUE);
        circularQueue.add(2);
        circularQueue.add(3);
        circularQueue.add(4);
        assertEquals(3, circularQueue.size());
    }
}
