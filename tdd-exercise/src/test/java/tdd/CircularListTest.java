package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    @Test
    public void testEmpty() {
        CircularQueueImpl circularQueue = new CircularQueueImpl();
        assertTrue(circularQueue.isEmpty());
    }

}
