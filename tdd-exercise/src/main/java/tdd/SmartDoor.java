package tdd;

public class SmartDoor implements SmartDoorLock {

    private boolean doorLocked = false;

    @Override
    public void setPin(int pin) {

    }

    @Override
    public void unlock(int pin) {
        doorLocked = false;
    }

    @Override
    public void lock() {
        doorLocked = true;
    }

    @Override
    public boolean isLocked() {
        return doorLocked;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
