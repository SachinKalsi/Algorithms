package Array;

/**
 * Created by kalsi on 01/08/17.
 */
public class SubsetSum {
    // given a array & a number n  , check is there any subset of the array whose sum = n
    public static void main(String[] args) {
        new SubsetSum().demo();
    }

    private void demo() {
        int[] array = {3, 34, 4, 12, 5, 2};
        int sum = 21;
        // using brute force => isSubsetPossible
        if (isSubsetPossibleUsingDP(array, sum)) {
            System.out.println("Possible");
        } else {
            System.out.println("not possible");
        }
    }

    private boolean isSubsetPossibleUsingDP(int[] array, int sum) {
        int arrayLength = array.length;
        boolean[][] sumArray = new boolean[arrayLength + 1][sum + 1];
        for (int i = 0; i < sumArray[0].length; i++) {
            sumArray[0][i] = false;
        }
        for (int i = 0; i < sumArray.length; i++) {
            sumArray[i][0] = true;
        }

        for (int i = 1; i <= arrayLength; i++) {
            for (int j = 1; j <= sum; j++) {
                sumArray[i][j] = sumArray[i - 1][j];
                if (j >= array[i - 1]) {
                    sumArray[i][j] = sumArray[i - 1][j] || sumArray[i - 1][j - array[i - 1]];
                }
            }
        }
        return sumArray[arrayLength][sum];
    }

    private boolean isSubsetPossible(int[] array, int sum) {
        int arrayLength = array.length;
        int totalPossibleSubsets = 1 << arrayLength;
        for (int i = 0; i < totalPossibleSubsets; i++) {
            int totalSum = 0;
            for (int j = 0; j < arrayLength; j++) {
                if ((1 & (i >> j)) != 0) {
                    totalSum += array[j];
                }
            }
            if (totalSum == sum) {
                return true;
            }
        }
        return false;
    }
}
