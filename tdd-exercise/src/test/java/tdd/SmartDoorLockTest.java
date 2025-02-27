package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final int PIN_DOOR = 1234;
    private static final int MAX_ATTEMPTS = 3;
    SmartDoor smartDoor;

    @BeforeEach
    void beforeEach(){
        smartDoor = new SmartDoor(MAX_ATTEMPTS);
        setPin(PIN_DOOR);
    }

    public void setPin(int pin){
        smartDoor.setPin(pin);
    }

    @Test
    public void testLockInitial() {
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void testLock(){
        smartDoor.lock();
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testUnlock(){
        smartDoor.lock();
        smartDoor.unlock(PIN_DOOR);
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void testBlockedInitial(){
        assertFalse(smartDoor.isBlocked());
    }

    @Test
    public void testMaxAttempts(){
        assertEquals(MAX_ATTEMPTS, smartDoor.getMaxAttempts());
    }

}
