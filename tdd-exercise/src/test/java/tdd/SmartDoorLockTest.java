package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private static final int PIN_DOOR = 1234;
    SmartDoor smartDoor;

    @BeforeEach
    void beforeEach(){
        smartDoor = new SmartDoor();
    }

    @Test
    public void testLockInitial() {
        smartDoor = new SmartDoor();
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void testLock(){
        smartDoor = new SmartDoor();
        smartDoor.setPin(PIN_DOOR);
        smartDoor.lock();
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testUnlock(){
        smartDoor = new SmartDoor();
        smartDoor.setPin(PIN_DOOR);
        smartDoor.lock();
        smartDoor.unlock(PIN_DOOR);
        assertFalse(smartDoor.isLocked());
    }

}
