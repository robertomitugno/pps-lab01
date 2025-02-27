package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final int PIN_DOOR = 1234;
    private static final int MAX_ATTEMPTS = 3;
    private static final int FAILED_ATTEMPTS = 0;
    SmartDoor smartDoor;

    @BeforeEach
    void beforeEach(){
        smartDoor = new SmartDoor(MAX_ATTEMPTS, FAILED_ATTEMPTS);
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

    @Test void testLockWithoutPin(){
        SmartDoor smartDoor1 = new SmartDoor(MAX_ATTEMPTS, FAILED_ATTEMPTS);
        assertThrows(IllegalStateException.class, () -> smartDoor1.lock());
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

    @Test
    public void testFailedAttempt(){
        assertEquals(FAILED_ATTEMPTS, smartDoor.getFailedAttempts());
    }

}
