package Array;

import java.util.Arrays;

/**
 * Created by kalsi on 04/08/17.
 * Problem: Find number of inversions in an array. Inversion: a pair where a[i] > a[j] and i <j in O(nlogn)
 * CREDIT: https://stackoverflow.com/questions/337664/counting-inversions-in-an-array
 * Marek Kirejczyk
 */
public class NumberOfInversions {
    public static void main(String[] args) {
        new NumberOfInversions().demo();

    }

    private void demo() {
        int[] array = {2, 4, 1, 3, 5};
        System.out.println("Number of inversions: " + countInversions(array));
    }

    private int countInversions(int[] array) {
        if (array.length < 2) {
            return 0;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return countInversions(left) + countInversions(right) + merge(array, left, right);
    }

    private int merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, count = 0;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                array[i+j] = right[j];
                j++;
            } else if (j == right.length) {
                array[i+j] = right[i];
                i++;
            } else if (left[i] <= right[j]) {
                array[i+j] = left[i];
                i++;
            } else {
                count += left.length-i;
                array[i+j] = right[j];
                j++;

            }
        }
        return count;
    }
}
