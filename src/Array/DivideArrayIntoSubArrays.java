package Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kalsi on 03/08/17.
 */
public class DivideArrayIntoSubArrays {
    public static void main(String[] args) {
//        Divide a given array into two subarray (not necessary to be continuous) such that difference
//        between sum of both array is minimum.
        new DivideArrayIntoSubArrays().demo();
    }

    private void demo() {
        int[] array = { 25, 21, 20, 17, 8};
        divideArray(array);
    }

    private void divideArray(int[] array) {
        int totalSum = 0;
        int subArrayMaxSum = 0;
        Arrays.sort(array);
        for (int i : array) {
            totalSum += i;
        }
        subArrayMaxSum = totalSum / 2;
        ArrayList<Integer> subArray = new ArrayList<Integer>();
        for (int i = array.length - 1; i >= 0; i--) {
//        for (int i = 0; i < array.length; i++) {
            if (array[i] <= subArrayMaxSum) {
                subArrayMaxSum -= array[i];
                subArray.add(array[i]);
            }
        }
        System.out.println("Sub array 1:");
        for (int i : subArray) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("Sub array 2:");
        for (int i : array) {
            if (!subArray.contains(i)) {
                System.out.print(i + "\t");
            }
        }

    }
}
