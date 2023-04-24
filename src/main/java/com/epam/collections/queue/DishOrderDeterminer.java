package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= numberOfDishes; i++)
            deque.add(i);
        while (!deque.isEmpty()) {
            for (int j = 0; j < everyDishNumberToEat - 1; j++)
                deque.add(deque.remove());
            res.add(deque.remove());
        }
        return res;
    }
}
