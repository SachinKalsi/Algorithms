package Array;

/**
 * Created by kalsi on 08/08/17.
 * Find peak element in array. A[i] is peak element, a[i-1] < a[i] > a[i+1].. For corner elements
 * a[0] is peak, if a[0] > a[1] or a[length-1] > a[length-2] then a[length-1] is peak. There can be
 * many peaks in array. Find anyone.
 * O(logn)
 */
public class FindPeak {
    public static void main(String[] args) {
        new FindPeak().demo();
    }

    private void demo() {
        int[] array = {1, -1, 2, 4, 1, 0};
        System.out.println("The index of peak element is " + getPeakElementIndex(array, 0, array.length - 1));
    }

    private int getPeakElementIndex(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (
        (mid == 0 && (array[mid + 1] <= array[mid])) ||
        (mid == array.length - 1 && (array[mid - 1] <= array[mid])) ||
        (mid > 0 && (array[mid + 1] <= array[mid]) && (array[mid - 1] <= array[mid]))
        ) {
            return mid;
        }
        if (mid > 0 && (array[mid - 1] > array[mid])) {
            return getPeakElementIndex(array, low, mid - 1);
        }
        return getPeakElementIndex(array, mid + 1, high);
    }

}
