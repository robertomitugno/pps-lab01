package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final static int FIRST_VALUE = 25;
    private final static int SECOND_VALUE = 7;
    private final static int THIRD_VALUE = 98;
    private final static int FOURTH_VALUE = 20;
    private final static int MAX_CAPACITY = 3;
    private final static int SIZE_AFTER_REMOVE = 2;
    private final static int INDEX_GET_VALUE = 1;
    private final static int INDEX_CHECK_ADD_VALUE_IS_LAST = 2;

    private CircularQueueImpl circularQueue;

    @BeforeEach
    void beforeEach() {
        circularQueue = new CircularQueueImpl(MAX_CAPACITY);
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
        circularQueue.add(SECOND_VALUE);
        circularQueue.add(THIRD_VALUE);
        circularQueue.add(FOURTH_VALUE);
        assertEquals(MAX_CAPACITY, circularQueue.size());
    }

    @Test
    public void testGetCapacity(){
        assertEquals(MAX_CAPACITY, circularQueue.getCapacity());
    }

    @Test
    public void testRemove(){
        circularQueue.add(FIRST_VALUE);
        circularQueue.add(SECOND_VALUE);
        circularQueue.add(THIRD_VALUE);
        circularQueue.remove();
        assertEquals(SIZE_AFTER_REMOVE, circularQueue.size());
    }

    @Test
    public void testGetByIndex(){
        circularQueue.add(FIRST_VALUE);
        circularQueue.add(SECOND_VALUE);
        assertEquals(SECOND_VALUE, circularQueue.get(INDEX_GET_VALUE));
    }

    @Test
    public void testCheckAddOnLastFreePosition(){
        circularQueue.add(FIRST_VALUE);
        circularQueue.add(SECOND_VALUE);
        circularQueue.add(THIRD_VALUE);
        assertEquals(THIRD_VALUE, circularQueue.get(INDEX_CHECK_ADD_VALUE_IS_LAST));
    }
}
