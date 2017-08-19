package Array;

/**
 * Created by kalsi on 19/08/17.
 * You are given a one dimensional array that may contain both positive and negative integers,
 * find the sum of contiguous subarray of numbers which has the largest sum. For example, if
 * the given array is {-2, -5, 6, -2, -3, 1, 5, -6}, then the maximum subarray sum is 7
 */
public class LargestSum {
    public static void main(String[] args) {
        new LargestSum().demo();
    }

    private void demo() {
        int[] array = {-2, -3, -4, 10, -2, 3, -5, -3};
        System.out.println("Max Sum: " + maxSum(array));
        System.out.println("Max Sum: " + maxSumSingleLoop(array)); // in a single loop,
    }

    private int maxSumSingleLoop(int[] array) {
        int maxSoFar = array[0];
        int currentMax = array[0];
        int start = 0, end = 0, s = 0;
        for (int i = 1; i < array.length; i++) {
//            currentMax = Math.max(array[i], currentMax + array[i]);
            if (array[i] > (currentMax + array[i])) {
                currentMax = array[i];
                s = i;
            } else {
                currentMax = currentMax + array[i];
            }
//            maxSoFar = Math.max(maxSoFar, currentMax);
            if (maxSoFar < currentMax) {
                maxSoFar = currentMax;
                start = s;
                end = i;
            }
        }
        System.out.println("start: " + start + " end: " + end);
        return maxSoFar;
    }

    private int maxSum(int[] array) {
        //check if all elements are negative
        int maxSoFar = array[0];
        Boolean isAllNegative = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                isAllNegative = false;
                break;
            }
            if (maxSoFar < array[i]) {
                maxSoFar = array[i];
            }
        }
        if (isAllNegative) {
            return maxSoFar;
        }

        // Kadane
        maxSoFar = 0;
        int currentMax = 0;
        int start = 0, end = 0, s = 0;
        for (int i = 0; i < array.length; i++) {
            currentMax = currentMax + array[i];
            if (currentMax < 0) {
                currentMax = 0;
                s = i + 1;
            } else if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
                start = s;
                end = i;
            }
        }
        System.out.println("start: " + start + " end: " + end);
        return maxSoFar;
    }

}
