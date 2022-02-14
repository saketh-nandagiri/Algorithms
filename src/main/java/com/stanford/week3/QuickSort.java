package com.stanford.week3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> integerList = new ArrayList<>();
        String fileName = "src/com/week3/numbers.txt";
        Files.lines(Paths.get(fileName)).forEachOrdered((e) -> integerList.add(Integer.valueOf(e)));
        int[] intArray = integerList.stream().mapToInt(i -> i).toArray();
        //int[] intArray = {9,6,4,3};
        long comparisons = getQuickSortComparisons(intArray, 0, intArray.length - 1);
        System.out.println(comparisons);
    }

    private static long getQuickSortComparisons(int[] intArray, int start, int end) {

        if (end - start < 1 || start > end)
           return 0;
        
        // for part 2
        //swap(intArray, end, start);
        // for part 1
        //int pivot = intArray[start];
        // for part 3
        setPivot(intArray, start, end);
        int pivot = intArray[start];
        int i = start + 1;
        int comparisons = end - start;
        for (int j = start + 1; j <= end; j++) {
            if (intArray[j] < pivot) {
                swap(intArray, j, i);
                i = i + 1;
            }
        }
        swap(intArray, start, i-1);

        comparisons += getQuickSortComparisons(intArray, start, i-2);
        comparisons += getQuickSortComparisons(intArray, i, end);

        return comparisons;
    }

    private static void setPivot(int[] intArray, int start, int end) {
        int firstElement = intArray[start];
        int lastElement = intArray[end];
        int middleIndex = start + ((end - start) / 2);
        int middleElement = intArray[middleIndex];

        int median = getMedian(firstElement, middleElement, lastElement);

        if (firstElement == median)
            return;

        if (lastElement == median) {
            swap(intArray, end, start);
            return;
        }

        swap(intArray, middleIndex, start);

    }

    private static int getMedian(int firstElement, int middleElement, int lastElement) {
        int[] temp = {firstElement, middleElement, lastElement};
        Arrays.sort(temp);
        return temp[1];
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}
