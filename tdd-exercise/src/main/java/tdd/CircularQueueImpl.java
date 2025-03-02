package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {

    private final int CAPACITY;
    private static List<Integer> circularQueue;

    CircularQueueImpl(int maxCapacity) {
        circularQueue = new ArrayList<>(3);
        CAPACITY = maxCapacity;
    }

    @Override
    public boolean isEmpty() {
        return circularQueue.isEmpty();
    }

    @Override
    public void add(int value) {
        if(!(circularQueue.size() == CAPACITY))
            circularQueue.add(value);
    }

    @Override
    public int size(){
        return circularQueue.size();
    }

}
