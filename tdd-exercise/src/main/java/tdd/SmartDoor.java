package tdd;

public class SmartDoor implements SmartDoorLock {

    private boolean doorLocked = false;
    private int maxAttempts;
    private int failedAttempts;
    private Integer pin;


    public SmartDoor(int maxAttempts, int failedAttempts) {
        this.maxAttempts = maxAttempts;
        this.failedAttempts = failedAttempts;
    }

    @Override
    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public void unlock(int pin) {
        if(this.pin == pin) {
            doorLocked = false;
        } else {
            failedAttempts++;
        }
    }

    @Override
    public void lock() {
        if (pin == null) {
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
        return this.failedAttempts;
    }

    @Override
    public void reset() {
        pin = null;
    }
}
