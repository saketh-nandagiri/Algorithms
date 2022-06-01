package com.stanford.week6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        Arrays.asList(100, 1, 200, 5, 10).stream()
                        .forEach(number -> minHeapIntegers.add(number));

        assertTrue(minHeapIntegers.peek() == 1, "Min heap should return 1 for peek");
    }

    @Test
    void testHeapPeek() {
        minHeapVertices = new MinHeap();
        Arrays.asList(100, 1, 200, 5, 10).stream()
                .forEach(number -> minHeapVertices.add(new Vertex(number)));

        assertTrue(minHeapVertices.peek().getValue() == 1, "Min heap should return 1 for peek");
    }

    @Test
    void testHeapPoll() {
        minHeapVertices = new MinHeap();
        Arrays.asList(200, 150, 4, 3, 1).stream()
                .forEach(number -> minHeapVertices.add(new Vertex(number)));
        minHeapVertices.poll();

        assertTrue(minHeapVertices.peek().getValue() == 3, "Min heap should return 3 for poll");
    }

    @Test
    void testHeapSize() {
        minHeapVertices = new MinHeap();
        Arrays.asList(200, 150, 4, 3, 1).stream()
                .forEach(number -> minHeapVertices.add(new Vertex(number)));
        minHeapVertices.poll();
        minHeapVertices.poll();
        minHeapVertices.poll();

        assertTrue(minHeapVertices.getSize() == 2, "Min heap should have 2 elements left");
    }

}