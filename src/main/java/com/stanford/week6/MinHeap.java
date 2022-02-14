package com.stanford.week6;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {
    private List<T> heap;
    private int size;

    public MinHeap() {
        heap = new ArrayList<>();
        size = 0;
    }

    public void add (T entry) {
        heap.add(entry);
        size++;
        heapifyUp();
    }

    public T peek () {
        if (size == 0) throw new IllegalArgumentException();
        return heap.get(0);
    }

    // removes the element from the heap
    public T poll () {
        if (size == 0) throw new IllegalArgumentException();
        T element = heap.get(0);

        if (heap.size() == 1)
            return element;

        heap.set(0, heap.remove(--size));
        heapifyDown();

        return element;
    }

    private void heapifyUp() {
        int localIndex = size - 1;
        while (hasParent(localIndex)) {
            if (heap.get(getParentIndex(localIndex)).compareTo(heap.get(localIndex)) == 1) {
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
        while (hasLeftIndex(localIndex))  {
            smallestIndex = getLeftIndex(localIndex);
            int rightIndex = getRightIndex(localIndex);
            if (rightIndex <= size - 1) {
                if (heap.get(smallestIndex).compareTo(heap.get(rightIndex)) == 1)
                    smallestIndex = getRightIndex(localIndex);
            }
            if (heap.get(localIndex).compareTo(heap.get(smallestIndex)) == 1)
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

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
    
    private boolean hasParent(int index) {

        if (index <= 0)
            return false;

        return getParentIndex(index) >= 0;
    }

    private int getParentIndex(int index) {
       return (index - 1) / 2;
    }

    public int getSize() {
        return size;
    }

    public void remove(Vertex targetVertex) {
        int targetIndex = searchHeap(targetVertex);
        swap(targetIndex, size - 1);
        heap.remove(--size);
        if (targetIndex == 0)
            heapifyDown();
        heapifyUp();
    }

    private int searchHeap(Vertex v) {
        int index = heap.indexOf(v);
        return index;
    }
}
