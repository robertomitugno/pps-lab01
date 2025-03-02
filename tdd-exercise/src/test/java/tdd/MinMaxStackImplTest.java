package tdd;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    @Test
    public void testStackInitialEmpty() {
        MinMaxStackImpl minMaxStack = new MinMaxStackImpl();
        assertTrue(minMaxStack.isEmpty());
    }

    @Test
    public void testStackPush() {
        MinMaxStackImpl minMaxStack = new MinMaxStackImpl();
        minMaxStack.push(1);
        assertFalse(minMaxStack.isEmpty());
    }
}