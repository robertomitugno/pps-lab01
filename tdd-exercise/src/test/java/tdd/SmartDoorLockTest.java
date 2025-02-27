package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final int PIN_DOOR = 1234;
    private static final int WRONG_PIN = 1111;
    private static final int NEW_PIN = 4321;
    private static final int WRONG_PIN_SHORT = 1;
    private static final int WRONG_PIN_LONG = 55555;
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
    public void testPinUncorrect(){
        SmartDoor smartDoorWrongPin = new SmartDoor(MAX_ATTEMPTS, FAILED_ATTEMPTS);
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> smartDoorWrongPin.setPin(WRONG_PIN_SHORT)),
                () -> assertThrows(IllegalArgumentException.class, () -> smartDoorWrongPin.setPin(WRONG_PIN_LONG))
        );
    }

    @Test
    public void testCheckSetPinUnenable(){
        smartDoor.lock();
        smartDoor.setPin(NEW_PIN);
        smartDoor.unlock(NEW_PIN);
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testCheckSetPinUnenableDoorBlocked(){
        smartDoor.lock();
        smartDoor.unlock(WRONG_PIN);
        smartDoor.unlock(WRONG_PIN);
        smartDoor.unlock(WRONG_PIN);
        smartDoor.setPin(NEW_PIN);
        smartDoor.unlock(NEW_PIN);
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testLock(){
        smartDoor.lock();
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testLockWithoutPin(){
        SmartDoor smartDoorUnsettedPin = new SmartDoor(MAX_ATTEMPTS, FAILED_ATTEMPTS);
        assertThrows(IllegalStateException.class, () -> smartDoorUnsettedPin.lock());
    }

    @Test
    public void testUnlock(){
        smartDoor.lock();
        smartDoor.unlock(PIN_DOOR);
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void testUnlockWithWrongPin(){
        smartDoor.lock();
        smartDoor.unlock(WRONG_PIN);
        assertTrue(smartDoor.isLocked());
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

    @Test
    public void testFailedAttemptIncrement(){
        smartDoor.lock();
        smartDoor.unlock(WRONG_PIN);
        smartDoor.unlock(WRONG_PIN);
        smartDoor.unlock(WRONG_PIN);
        assertEquals(MAX_ATTEMPTS, smartDoor.getFailedAttempts());
    }

    @Test
    public void testBlocked(){
        smartDoor.lock();
        smartDoor.unlock(WRONG_PIN);
        smartDoor.unlock(WRONG_PIN);
        smartDoor.unlock(WRONG_PIN);
        assertTrue(smartDoor.isBlocked());
    }

    @Test
    public void testCheckAttemptsAfterUnlockCorrect(){
        smartDoor.lock();
        smartDoor.unlock(WRONG_PIN);
        smartDoor.unlock(PIN_DOOR);
        assertAll(
                () -> assertFalse(smartDoor.isLocked()),
                () -> assertEquals(FAILED_ATTEMPTS, smartDoor.getFailedAttempts())
        );
    }

    @Test
    public void testReset(){
        smartDoor.reset();
        assertAll(
                () -> assertEquals(FAILED_ATTEMPTS, smartDoor.getFailedAttempts()),
                () -> assertFalse(smartDoor.isBlocked()),
                () -> assertFalse(smartDoor.isLocked()),
                () -> assertThrows(IllegalStateException.class, () -> smartDoor.lock())
        );
    }
}
