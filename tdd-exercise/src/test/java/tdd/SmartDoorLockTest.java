package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    @Test
    public void testLockInitial() {
        SmartDoor smartDoor = new SmartDoor();
        assertFalse(smartDoor.isLocked());
    }

}
