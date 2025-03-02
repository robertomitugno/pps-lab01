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
        circularQueue = new CircularQueueImpl();
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

}
