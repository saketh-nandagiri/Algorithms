package com.stanford.week6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    private MinHeap<Vertex> minHeapVertices;
    private MinHeap<Integer> minHeapIntegers;

    @Test
    void testEmptyHeap() {
        minHeapVertices = new MinHeap();
        assertThrows(IllegalArgumentException.class, () -> minHeapVertices.peek());
    }

    @Test
    void testHeapIntegers() {
        minHeapIntegers = new MinHeap();
        minHeapIntegers.add(100);
        minHeapIntegers.add(1);
        minHeapIntegers.add(200);
        minHeapIntegers.add(5);
        minHeapIntegers.add(10);

        assertTrue(minHeapIntegers.peek() == 1, "Min heap should return 1 for peek");
    }

    @Test
    void testHeapPeek() {
        minHeapVertices = new MinHeap();
        minHeapVertices.add(new Vertex(100));
        minHeapVertices.add(new Vertex(1));
        minHeapVertices.add(new Vertex(200));
        minHeapVertices.add(new Vertex(5));
        minHeapVertices.add(new Vertex(10));

        assertTrue(minHeapVertices.peek().getValue() == 1, "Min heap should return 1 for peek");
    }

    @Test
    void testHeapPoll() {
        minHeapVertices = new MinHeap();
        minHeapVertices.add(new Vertex(200));
        minHeapVertices.add(new Vertex(150));
        minHeapVertices.add(new Vertex(4));
        minHeapVertices.add(new Vertex(3));
        minHeapVertices.add(new Vertex(1));
        minHeapVertices.poll();

        assertTrue(minHeapVertices.peek().getValue() == 3, "Min heap should return 3 for poll");
    }

    @Test
    void testHeapSize() {
        minHeapVertices = new MinHeap();
        minHeapVertices.add(new Vertex(200));
        minHeapVertices.add(new Vertex(150));
        minHeapVertices.add(new Vertex(4));
        minHeapVertices.add(new Vertex(3));
        minHeapVertices.add(new Vertex(1));
        minHeapVertices.poll();
        minHeapVertices.poll();
        minHeapVertices.poll();

        assertTrue(minHeapVertices.getSize() == 2, "Min heap should have 2 elements left");
    }

}