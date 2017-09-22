package Array;

/**
 * Created by kalsi on 05/08/17.
 * Find equilibrium index in array.
 * Its the index i where sum till i from 0th index = sum from ith
 index to last index
 Time: O(n)
 */
public class Equilibrium {
    public static void main(String[] args) {
        new Equilibrium().demo();
    }

    private void demo() {
        int[] array = {-7, 1, 5, 2, -4, 3, 0};
        int index = getEquilibrium(array);
        if (index != -1) {
            System.out.println("Equilibrium found at: " + index);
        } else {
            System.out.println("No equilibrium found");
        }

    }

    private int getEquilibrium(int[] array) {
        int totalSum = 0, sumSoFar = 0;
        for (int i = 0; i < array.length; i++) {
            totalSum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            int right = totalSum - array[i] - sumSoFar;
            if(right == sumSoFar) {
                return i;
            }
            sumSoFar += array[i];

        }
        return -1;
    }
}
