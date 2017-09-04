package Strings;

/**
 * Created by kalsi on 04/09/17.
 * https://www.youtube.com/watch?v=CE2b_-XfVDk
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        new LongestIncreasingSubsequence().demo();
    }

    private void demo() {
        int[] array = {3, 4, -1, 0, 6, 2, 3};
        System.out.println("length of longest increasing subsequence: " + longest(array)); // Using DP
    }

    private int longest(int[] array) {
        int[] temp = new int[array.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = 1;
        }

        int maxLength = 1;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    temp[i] = Math.max(temp[j] + 1, temp[i]);
                }

            }
            if (temp[i] > maxLength) {
                maxLength = temp[i];
            }

        }
        return maxLength;
    }
}
