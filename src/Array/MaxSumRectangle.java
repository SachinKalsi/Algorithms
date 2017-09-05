package Array;

import java.awt.event.KeyAdapter;

/**
 * Created by kalsi on 05/09/17.
 * https://www.youtube.com/watch?v=yCQN096CwWM
 * Maximum Sum Rectangular Submatrix in Matrix dynamic programming/2D kadane
 */
public class MaxSumRectangle {
    class Kadane {
        int max, start, end;

        public Kadane(int m) {
            max = m;
            start = 0;
            end = 0;
        }
    }

    public static void main(String[] args) {
        new MaxSumRectangle().demo();

    }

    private void demo() {
        int[][] matrix = {
        {2, 1, -3, -4, 5},
        {0, 6, 3, 4, 1},
        {2, -2, -1, 4, -5},
        {-3, 3, 1, 0, 3}};
        displayMaxSumRectangle(matrix);

    }

    private void displayMaxSumRectangle(int[][] matrix) {
        Kadane kd = new Kadane(0);
        Integer maxSum = null, rowFirst = null, rowSecond = null, colFirst = null, colSecond = null;
        int[] kadaneArray = new int[matrix.length];
        for (int l = 0; l < matrix[0].length; l++) {
            setKadaneArray(kadaneArray);
            for (int r = l; r < matrix[0].length; r++) {
                copy(matrix, kadaneArray, r);
                searchMaxLengthSubArray(kadaneArray, kd);
                if (maxSum == null || kd.max > maxSum) {
                    maxSum = kd.max;
                    colFirst = l;
                    colSecond = r;
                    rowFirst = kd.start;
                    rowSecond = kd.end;
                }

            }
        }
        System.out.println("Max Sum is " + maxSum);
        System.out.println("The rectangle is");
        for (int i = rowFirst; i <= rowSecond; i++) {
            for (int j = colFirst; j <= colSecond; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void copy(int[][] matrix, int[] kadaneArray, int r) {
        for (int i = 0; i < kadaneArray.length; i++) {
            kadaneArray[i] += matrix[i][r];
        }
    }

    private void setKadaneArray(int[] kadaneArray) {
        for (int i = 0; i < kadaneArray.length; i++) {
            kadaneArray[i] = 0;

        }
    }

    private void searchMaxLengthSubArray(int[] array, Kadane kd) {
        kd.max = array[0];
        kd.start = kd.end = 0;
        int currentMax = array[0];
        int start = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > currentMax + array[i]) {
                currentMax = array[i];
                start = i;
            } else {
                currentMax = currentMax + array[i];
            }
            if (currentMax > kd.max) {
                kd.max = currentMax;
                kd.start = start;
                kd.end = i;
            }

        }
    }
}
