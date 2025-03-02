package tdd;

import java.util.ArrayList;
import java.util.List;

public class CircularQueueImpl implements CircularQueue {

    private static List<Integer> queue;

    CircularQueueImpl() {
        queue = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
