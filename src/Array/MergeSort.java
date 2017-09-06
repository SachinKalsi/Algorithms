package Array;

import java.util.Arrays;

/**
 * Created by kalsi on 06/09/17.
 */
public class MergeSort {
    public static void main(String[] args) {
        new MergeSort().demo();
    }

    private void demo() {
        int[] array = {9,6,5,4,3,2};
        mergeSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private void mergeSort(int[] array) {
        mergeSortUtil(array, 0, array.length - 1);
    }

    private void mergeSortUtil(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortUtil(array, low, mid);
            mergeSortUtil(array, mid + 1, high);
            int[] array1 = Arrays.copyOfRange(array, low, mid + 1);
            int[] array2 = Arrays.copyOfRange(array, mid + 1, high + 1);
            merge(array, array1, array2, low);
        }
    }

    private void merge(int[] array, int[] array1, int[] array2, int low) {
        int i = 0, j = 0;
        while (i < array1.length || j < array2.length) {
            if (i == array1.length || (j != array2.length && array1[i] > array2[j])) {
                array[low] = array2[j];
                j++;
            } else if (j == array2.length || (i != array1.length && array1[i] < array2[j])) {
                array[low] = array1[i];
                i++;
            }
            low++;
        }
    }
}
