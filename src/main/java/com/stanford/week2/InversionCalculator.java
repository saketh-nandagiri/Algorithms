package com.week2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class InversionCalculator {

    public static void main (String[] args) throws IOException {

        ArrayList<Integer> integerList = new ArrayList<>();
        String fileName = "src/com/week2/numbers.txt";
        Files.lines(Paths.get(fileName)).forEachOrdered((e) -> integerList.add(Integer.valueOf(e)));
        
        ArrayDataHolder array_inversions = getInversions(integerList.stream().mapToInt(i -> i).toArray());
        System.out.println(array_inversions.getInversions());
    }

    private static ArrayDataHolder getInversions(int[] arr) {
        // base case
        if (arr.length == 1)
            return new ArrayDataHolder(arr, 0);

        ArrayDataHolder leftArrayPlusInversions = getInversions(Arrays.copyOfRange(arr, 0, arr.length / 2));
        ArrayDataHolder rightArrayPlusInversions = getInversions(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
        ArrayDataHolder splitInversions = getSplitInversions(leftArrayPlusInversions, rightArrayPlusInversions);

        return splitInversions;
    }

    private static ArrayDataHolder getSplitInversions(ArrayDataHolder leftArrayPlusInversions, ArrayDataHolder rightArrayPlusInversions) {
        long inversion_running_total = leftArrayPlusInversions.getInversions() + rightArrayPlusInversions.getInversions();
        int[] leftArray = leftArrayPlusInversions.getArr();
        int[] rightArray = rightArrayPlusInversions.getArr();

        int[] finalArray = new int[leftArray.length + rightArray.length];

        int i = 0;
        int j = 0;
        int k;

        for (k = 0; k < finalArray.length; k++) {

            if ( i == leftArray.length  || j == rightArray.length)
                break;

            if (leftArray[i] <= rightArray[j]) {
                finalArray[k] = leftArray[i];
                i++;
            } else {
                finalArray[k] = rightArray[j];
                inversion_running_total += leftArray.length - i;
                j++;
            }
        }

        if ( i == leftArray.length) {
            copyArrayElements(rightArray, j, finalArray, k);
        } else
            copyArrayElements(leftArray, i, finalArray, k);

        return new ArrayDataHolder(finalArray, inversion_running_total);
    }

    private static void copyArrayElements(int[] inputArr, int inputStartIndex, int[] finalArr, int finalStartIndex) {
        for (int i = inputStartIndex; i < inputArr.length; i++) {
            finalArr[finalStartIndex] = inputArr[i];
            finalStartIndex++;
        }
    }
}
