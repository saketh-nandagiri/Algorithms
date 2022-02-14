package com.week6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    private MinHeap minHeap;

    @Test
    void testEmptyHeap() {
        minHeap = new MinHeap();
        assertThrows(IllegalArgumentException.class, () -> minHeap.peek());
    }

    @Test
    void testHeapPeek() {
        minHeap = new MinHeap();
        minHeap.add(200);
        minHeap.add(150);
        minHeap.add(1);
        minHeap.add(4);
        minHeap.add(3);

        assertTrue(minHeap.peek() == 1, "Min heap should return 1 for peek");
    }

    @Test
    void testHeapPoll() {
        minHeap = new MinHeap();
        minHeap.add(200);
        minHeap.add(150);
        minHeap.add(4);
        minHeap.add(3);
        minHeap.add(1);
        minHeap.poll();

        assertTrue(minHeap.peek() == 3, "Min heap should return 3 for poll");
    }

    @Test
    void testHeapSize() {
        minHeap = new MinHeap();
        minHeap.add(200);
        minHeap.add(150);
        minHeap.add(4);
        minHeap.add(3);
        minHeap.add(1);
        minHeap.poll();
        minHeap.poll();
        minHeap.poll();

        assertTrue(minHeap.getSize() == 2, "Min heap should have 2 elements left");
    }

}