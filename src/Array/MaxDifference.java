package Array;

/**
 * Created by kalsi on 19/08/17.
 * . Maximum difference in two elements in arrays such that the larger elements appear on
 right-side.
 */
public class MaxDifference {
    public static void main(String[] args) {
        new MaxDifference().demo();
    }

    private void demo() {
        int[] array = {2, -3, 10, 6, 4, 8, 11};
        System.out.println("Max difference is " + getMaxDifference(array));
    }

    private int getMaxDifference(int[] array) {
        int maxSoFar = 0;
        int min = array[0];
        int start = 0, end = 0, s = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                s = i;
            }
            if ((array[i] - min) > maxSoFar) {
                maxSoFar = (array[i] - min);
                start = s;
                end = i;
            }
        }
        System.out.println("start index: " + start + " end index: " + end);

        return maxSoFar;
    }
}
