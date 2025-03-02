package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    MinMaxStack minMaxStack;
    private static final int FIRST_INTEGER = 1;

    @BeforeEach
    void setUp() {
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    public void testInitialEmpty() {
        MinMaxStackImpl minMaxStack = new MinMaxStackImpl();
        assertTrue(minMaxStack.isEmpty());
    }

    @Test
    public void testPush() {
        MinMaxStackImpl minMaxStack = new MinMaxStackImpl();
        minMaxStack.push(FIRST_INTEGER);
        assertFalse(minMaxStack.isEmpty());
    }

    @Test
    public void testPop() {
        MinMaxStackImpl minMaxStack = new MinMaxStackImpl();
        minMaxStack.push(FIRST_INTEGER);
        minMaxStack.pop();
        assertTrue(minMaxStack.isEmpty());
    }

    @Test
    public void testPopEmptyStack() {
        MinMaxStackImpl minMaxStack = new MinMaxStackImpl();
        assertThrows(IllegalStateException.class, () -> minMaxStack.pop());
    }

    @Test
    public void testPeek() {
        MinMaxStackImpl minMaxStack = new MinMaxStackImpl();
        minMaxStack.push(FIRST_INTEGER);
        assertAll(
                () -> assertEquals(FIRST_INTEGER, minMaxStack.peek()),
                () -> assertFalse(minMaxStack.isEmpty())
        );

    }
}