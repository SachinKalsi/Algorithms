package Array;

/**
 * Created by kalsi on 06/08/17.
 * Find the Minimum length Unsorted Subarray, sorting which makes the complete array
 * sorted
 */
public class FindMinLengthOfArray {

    public static void main(String[] args) {
        new FindMinLengthOfArray().demo();
    }

    private void demo() {
        int[] array = {0, 1, 15, 25, 6, 7, 30, 40, 50};
        findMinLength(array);
    }

    private void findMinLength(int[] array) {
        int start = -1, end = -1;
        Integer min = null, max = null;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                if (start == -1) {
                    start = i;
                }
                end = i + 1;
                if (min == null) {
                    min = array[end];
                    max = array[i];
                } else {
                    min = Math.min(min, array[end]);
                    max = Math.max(max, array[i]);
                }
            }
        }

        if (start == -1) {
            System.out.println("The array is already sorted");
            return;
        }
        for (int i = start - 1; i >= 0; i--) {
            if (array[i] > min) {
                start = i;
            }
        }

        for (int i = end + 1; i < array.length; i++) {
            if (array[i] < max) {
                end = i;
            }

        }
        System.out.println("Min Unsorted Subarray length: " + (end - start + 1));
        System.out.println("From index: " + start + " to index: " + end);

    }
}
