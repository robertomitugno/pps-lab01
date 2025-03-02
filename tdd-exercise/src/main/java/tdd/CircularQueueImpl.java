package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {

    private final int MAX_CAPACITY;
    private final int OLDEST_VALUE = 0;
    private static List<Integer> circularQueue;

    CircularQueueImpl(int size) {
        this.circularQueue = new ArrayList<>(size);
        this.MAX_CAPACITY = size;
    }

    @Override
    public boolean isEmpty() {
        return this.circularQueue.isEmpty();
    }

    @Override
    public void add(int value) {
        if(this.circularQueue.size() == MAX_CAPACITY) {
            remove();
            this.circularQueue.add(OLDEST_VALUE, value);
        }else {
            this.circularQueue.add(value);
        }
    }

    @Override
    public int size(){
        return this.circularQueue.size();
    }

    @Override
    public int getCapacity() {
        return this.MAX_CAPACITY;
    }

    @Override
    public void remove() {
        this.circularQueue.remove(OLDEST_VALUE);
    }

    @Override
    public int get(int i) {
        return this.circularQueue.get(i);
    }


}
