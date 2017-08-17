package Array;

/**
 * Created by kalsi on 08/08/17.
 * There are 0’s and 1’s in array. Bring all 0’s on even positions and 1’s at odd positions. If 1’s or
 * 0’s are more, leave the remaining as it is after arranging at even/odd positions.
 */
public class ArrangeOneAndZeros {
    public static void main(String[] args) {
        new ArrangeOneAndZeros().demo();
    }

    private void demo() {
        int[] array = {0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1};
        System.out.println("O's are at even & 1's are at odd");
        System.out.println("I/P:");
        display(array);
        arrangeBinary(array);
        System.out.println("O/P:");
        display(array);
    }

    private void arrangeBinary(int[] array) {
        int i = 0; // 0
        int j = 1; // 1
        while (i < array.length && j < array.length) {
            while (i < array.length && array[i] != 1) {
                i += 2;
            }
            while (j < array.length && array[j] != 0) {
                j += 2;
            }
            if (i < array.length && j < array.length) {
                swap(array, i, j);
            }
        }
        int temp = i;
        while (i < array.length) {
            if (array[i] == 1) {
                while (i < array.length && array[i] == 1) {
                    i += 2;
                }
                if (i < array.length) {
                    swap(array, temp, i);
                    temp = i;
                }
            } else {
                i += 2;
            }
        }
        temp = j;
        while (j < array.length) {
            if (array[j] == 0) {
                while (j < array.length && array[j] == 0) {
                    j += 2;
                }
                if (j < array.length) {
                    swap(array, temp, j);
                    temp = j;
                }
            } else {
                j += 2;
            }
        }
    }

    private void swap(int[] array, int k, int i) {
        array[k] = array[k] + array[i];
        array[i] = array[k] - array[i];
        array[k] = array[k] - array[i];
    }

    private int getIndex(int[] array, int n, int number) {
        for (int i = n + 1; i < array.length; i++) {
            if (array[i] == number) {
                return i;

            }

        }
        return -1;
    }

    private void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
