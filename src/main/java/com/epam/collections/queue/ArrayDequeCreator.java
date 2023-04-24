package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    private final ArrayDeque<Integer> res = new ArrayDeque<>();

    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        res.add(firstQueue.remove());
        res.add(firstQueue.remove());
        res.add(secondQueue.remove());
        res.add(secondQueue.remove());
        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {
            oneStep(firstQueue);
            oneStep(secondQueue);
        }
        return res;
    }

    private void oneStep(Queue<Integer> queue) {
        queue.add(res.removeLast());
        res.add(queue.remove());
        if (queue.isEmpty())
            return;
        res.add(queue.remove());
    }
}
