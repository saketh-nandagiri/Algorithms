package com.stanford.week7;

import com.stanford.week6.MinHeap;

public class SumOfMedians {

    int sum = 0;
    MinHeap<Integer> higherHeap; // will store higher half
    MaxHeap<Integer> lowerHeap; // will store lower half

    public SumOfMedians () {
        higherHeap = new MinHeap<>();
        lowerHeap = new MaxHeap<>();
    }

    public void addNumber (int number) {

        // if this is the first number, put it in lower half
        if (this.sum == 0) {
            lowerHeap.add(number);
            sum += number;
            return;
        }

        // if number is less than max of lower half, put in maxHeap
        if (number <= lowerHeap.peek())
            lowerHeap.add(number);
        else
            higherHeap.add(number);

        // balance the heaps if needed
        if (Math.abs(Math.subtractExact(higherHeap.getSize(), lowerHeap.getSize())) >= 2) {
            int lowerHeapSize = lowerHeap.getSize();
            int higherHeapSize = higherHeap.getSize();
            int temp;

            if (lowerHeapSize > higherHeapSize) {
                temp = lowerHeap.poll();
                higherHeap.add(temp);
            } else {
                temp = higherHeap.poll();
                lowerHeap.add(temp);
            }
        }

        // get median
        int median = getMedian();

        // add the median to the sum
        sum += median;
    }

    private int getMedian() {
        int median;
        if (lowerHeap.getSize() == higherHeap.getSize()) {
            median = lowerHeap.peek();
        } else if (lowerHeap.getSize() > higherHeap.getSize()) {
            median = lowerHeap.peek();
        } else
            median = higherHeap.peek();

        return median;
    }

}
