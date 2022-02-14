package com.week6;

import java.util.Arrays;

public class MinHeap {

    private int capacity = 10;
    private int[] heap;
    private int size;

    public MinHeap() {
        heap = new int[capacity];
        size = 0;
    }

    public void add (int number) {
        ensureExtraCapacity();
        heap[size++] = number;
        heapifyUp();
    }

    public int peek () {
        if (size == 0) throw new IllegalArgumentException();
        return heap[0];
    }

    // removes the element from the heap
    public int poll () {
        if (size == 0) throw new IllegalArgumentException();
        int element = heap[0];
        heap[0] = heap[--size];
        heapifyDown();

        return element;
    }

    private void heapifyUp() {
        int localIndex = size - 1;
        while (hasParent(localIndex)) {
            if (heap[getParentIndex(localIndex)] > heap[localIndex]) {
                swap(getParentIndex(localIndex), localIndex);
                localIndex = getParentIndex(localIndex);
                continue;
            }
            break;
        }
    }

    private void heapifyDown() {
        int localIndex = 0;
        int smallestIndex;
        while (hasLeftIndex(localIndex) && (heap[getLeftIndex(localIndex)] < heap[localIndex] || heap[getRightIndex(localIndex)] < heap[localIndex])) {
            smallestIndex = getLeftIndex(localIndex);
            if (heap[smallestIndex] > heap[getRightIndex(localIndex)])
                smallestIndex = getRightIndex(localIndex);
            swap(localIndex, smallestIndex);
            localIndex = smallestIndex;
        }
    }

    private boolean hasLeftIndex(int localIndex) {
        return 2 * localIndex + 1 < size;
    }

    /* Helper Methods */

    private static int getLeftIndex (int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private static int getRightIndex (int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getParentIndex(int index) {
       return (index - 1) / 2;
    }

    public int getSize() {
        return size;
    }
}
