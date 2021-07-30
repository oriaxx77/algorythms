package com.oriaxx77.algorythm.practice;

import java.util.Arrays;

public class BinarySearch {

    public int search(int[] numbers, int target) {
        return search(numbers, 0, numbers.length-1, target);
    }

    private int search(int[] numbers, int startIndex, int endIndex, int target) {
        if (startIndex > endIndex)
            return -1;

        int midIndex = startIndex + (endIndex-startIndex)/2;
        int mid = numbers[midIndex];

        if (target == mid) {
            return midIndex;
        } else if (target > mid) {
            return search(numbers, midIndex+1, endIndex, target);
        } else {
            return search(numbers, startIndex, midIndex, target);
        }
    }

}
