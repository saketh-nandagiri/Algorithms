package com.stanford.week7;

import com.stanford.week6.MinHeap;
import com.stanford.week6.Vertex;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    MaxHeap<Integer> integerMaxHeap;

    @Test
    void testEmptyHeap() {
        integerMaxHeap = new MaxHeap<>();
        assertThrows(IllegalArgumentException.class, () -> integerMaxHeap.peek());
    }

    @Test
    void testHeapPeek() {
        integerMaxHeap = new MaxHeap<>();
        Arrays.asList(100, 1, 200, 5, 10).stream()
                .forEach(number -> integerMaxHeap.add(number));

        assertTrue(integerMaxHeap.peek() == 200, "Min heap should return 200 for peek");
    }

    @Test
    void testHeapPoll() {
        integerMaxHeap = new MaxHeap<>();
        Arrays.asList(100, 1, 200, 5, 10).stream()
                .forEach(number -> integerMaxHeap.add(number));
        integerMaxHeap.poll();
        int result = integerMaxHeap.poll();
        assertTrue(result == 100, "Min heap should return 100 for second poll");
    }

    @Test
    void testHeapSize() {
        integerMaxHeap = new MaxHeap<>();
        Arrays.asList(100, 1, 200, 5, 10).stream()
                .forEach(number -> integerMaxHeap.add(number));
        integerMaxHeap.poll();
        integerMaxHeap.poll();
        integerMaxHeap.poll();

        assertTrue(integerMaxHeap.getSize() == 2, "Max heap should have 2 elements left");
    }
}