package Array;

/**
 * Created by kalsi on 04/09/17.
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * <p>
 * For example, for N = 4 and S = {1,2,3},
 * there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChange {
    public static void main(String[] args) {
        new CoinChange().demo();
    }

    private void demo() {
        int[] array = {25, 10, 5};
        int sum = 30;
        System.out.println("Total solutions: " + totalSolutions(array, sum));
    }

    private int totalSolutions(int[] array, int sum) {
        int[][] matrix = new int[array.length + 1][sum + 1];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = 0;
        }
        for (int i = 1; i <= array.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if (array[i - 1] > s) {
                    matrix[i][s] = matrix[i - 1][s];
                } else {
                    // including coin
                    int x = (s % array[i - 1] == 0) ? 1 : 0;
                    x += matrix[i - 1][s - array[i - 1]];

                    //not including
                    int y = matrix[i - 1][s];
                    matrix[i][s] = x + y;
                }

            }

        }
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//
//        }
        return matrix[array.length][sum];
    }
}
