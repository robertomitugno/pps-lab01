package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {

    private static List<Integer> circularQueue;

    CircularQueueImpl() {
        circularQueue = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return circularQueue.isEmpty();
    }

    @Override
    public void add(int value) {
        circularQueue.add(value);
    }

}
