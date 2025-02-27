package tdd;

public class SmartDoor implements SmartDoorLock {

    private boolean doorLocked = false;
    private int maxAttempts;
    private int failedAttempts;
    private boolean pinIsSetted;


    public SmartDoor(int maxAttempts, int failedAttempts) {
        this.maxAttempts = maxAttempts;
        this.failedAttempts = failedAttempts;
    }

    @Override
    public void setPin(int pin) {
        pinIsSetted = true;
    }

    @Override
    public void unlock(int pin) {
        doorLocked = false;
    }

    @Override
    public void lock() {
        if (!pinIsSetted) {
            throw new IllegalStateException("Pin not set");
        }
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
        return this.maxAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
