package tdd;

public class SmartDoor implements SmartDoorLock {

    private boolean doorLocked = false;
    private boolean isBlocked = false;
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
        if (this.pin == pin) {
            this.doorLocked = false;
            this.failedAttempts = 0;
        } else {
            if (++this.failedAttempts >= this.maxAttempts) {
                this.isBlocked = true;
            }
        }
    }

    @Override
    public void lock() {
        if (this.pin == null) {
            throw new IllegalStateException("Pin not set");
        }
        this.doorLocked = true;
    }

    @Override
    public boolean isLocked() {
        return this.doorLocked;
    }

    @Override
    public boolean isBlocked() {
        return this.isBlocked;
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
        this.pin = null;
        this.doorLocked = false;
        this.isBlocked = false;
        this.failedAttempts = 0;
    }
}
