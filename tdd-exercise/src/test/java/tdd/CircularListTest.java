package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    @Test
    public void testEmpty() {
        CircularQueueImpl circularQueue = new CircularQueueImpl();
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    public void testAdd(){
        CircularQueueImpl circularQueue = new CircularQueueImpl();
        circularQueue.add(1);
        assertFalse(circularQueue.isEmpty());
    }

}
