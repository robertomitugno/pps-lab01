package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    MinMaxStack minMaxStack;
    private static final int FIRST_INTEGER = 1;
    private static final int SECOND_INTEGER = 2;

    @BeforeEach
    void setUp() {
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    public void testInitialEmpty() {
        assertTrue(minMaxStack.isEmpty());
    }

    @Test
    public void testPush() {
        minMaxStack.push(FIRST_INTEGER);
        assertFalse(minMaxStack.isEmpty());
    }

    @Test
    public void testPop() {
        minMaxStack.push(FIRST_INTEGER);
        minMaxStack.pop();
        assertTrue(minMaxStack.isEmpty());
    }

    @Test
    public void testPopEmpty() {
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }

    @Test
    public void testPeek() {
        minMaxStack.push(FIRST_INTEGER);
        assertAll(
                () -> assertEquals(FIRST_INTEGER, minMaxStack.peek()),
                () -> assertFalse(minMaxStack.isEmpty())
        );
    }

    @Test
    public void testPeekEmpty() {
        assertThrows(IllegalStateException.class, () -> minMaxStack.peek());
    }

    @Test
    public void testGetMin(){
        minMaxStack.push(FIRST_INTEGER);
        minMaxStack.push(SECOND_INTEGER);
        assertEquals(FIRST_INTEGER, minMaxStack.getMin());
    }

    @Test
    public void testGetMinEmpty(){
        assertThrows(IllegalStateException.class, () -> minMaxStack.getMin());
    }

    @Test
    public void testGetMax(){
        minMaxStack.push(FIRST_INTEGER);
        minMaxStack.push(SECOND_INTEGER);
        assertEquals(SECOND_INTEGER, minMaxStack.getMax());
    }

}