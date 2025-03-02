package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {

    private final int MAX_CAPACITY;
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
        if(!(this.circularQueue.size() == this.MAX_CAPACITY))
            this.circularQueue.add(value);
    }

    @Override
    public int size(){
        return this.circularQueue.size();
    }

}
