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
    public void testStackInitialEmpty() {
        MinMaxStackImpl minMaxStack = new MinMaxStackImpl();
        assertTrue(minMaxStack.isEmpty());
    }

    @Test
    public void testStackPush() {
        MinMaxStackImpl minMaxStack = new MinMaxStackImpl();
        minMaxStack.push(FIRST_INTEGER);
        assertFalse(minMaxStack.isEmpty());
    }
}