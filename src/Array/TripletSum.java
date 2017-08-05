package Array;

/**
 * Created by kalsi on 05/08/17.
 * Find a triplet that sum to a given value
 * Credits: http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 */
public class TripletSum {
    public static void main(String[] args) {
        new TripletSum().demo();
    }

    private void demo() {
        int[] array = {12, 3, 4, 1, 6, 9};
        find3Numbers(array, 24);
    }

    private boolean find3Numbers(int[] array, int n) {
        quicksort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            int start = i + 1;
            int end = array.length - 1;
            while (start < end) {
                int sum = array[i] + array[start] + array[end];
                if (sum == n) {
                    System.out.println("Triplet found: " + array[i] + ", " + array[start] + ", " + array[end]);
                    return true;
                } else if (sum < n) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        System.out.println("No triplet found");
        return false;
    }

    private void quicksort(int[] array, int start, int end) {
        if (start < end) {
            int p = partition(array, start, end);
            quicksort(array, start, p - 1);
            quicksort(array, p + 1, end);
        }
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int j = start - 1;
        int i = start;

        for (; i < end; i++) {
            if (array[i] < pivot) {
                j++;
                if (i != j) {
                    array[i] = array[i] + array[j];
                    array[j] = array[i] - array[j];
                    array[i] = array[i] - array[j];
                }
            }
        }
        ++j;
        if (end != j) {
            array[j] = array[j] + array[end];
            array[end] = array[j] - array[end];
            array[j] = array[j] - array[end];

        }

        return j;
    }
}
