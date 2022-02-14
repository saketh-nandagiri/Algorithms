package com.week2;

public class ArrayDataHolder {

    private int[] arr;
    private long inversions;

    public ArrayDataHolder(int[] arr,  long inversions) {
        this.arr = arr;
        this.inversions = inversions;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public long getInversions() {
        return inversions;
    }

    public void setInversions(int inversions) {
        this.inversions = inversions;
    }
}
