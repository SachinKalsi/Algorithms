package StacksAndQueues;

/**
 * Created by kalsi on 22/08/17.
 * Find the next smallest element on right side for every element a[i] in array a[].
 * O(n) time & O(n) space
 */
public class GetNextSmallest {
    public static void main(String[] args) {
        new GetNextSmallest().demo();
    }

    private void demo() {
        int[] array = {2,45,23,91,8,239};
        // 5, 5, 6, 6, 6, 7
        int[] result = getNextSmallest(array);
        display(result);
    }

    private void display(int[] result) {
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i] + "\t");
        }
    }

    private int[] getNextSmallest(int[] array) {
        int[] stack = new int[array.length];
        int top = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (top == -1) {
                stack[++top] = array[i];
            } else {
                int min = Math.min(array[i], stack[top]);
                stack[++top] = min;
            }
        }
        return stack;
    }
}
