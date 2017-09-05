package Strings;

/**
 * Created by kalsi on 05/09/17.
 * <p>
 * Given two strings and operations edit, delete and add, how many minimum operations would it take to convert one string to another string.
 * <p>
 * https://www.youtube.com/watch?v=We3YDTzNXEk
 */
public class EditDistance {
    public static void main(String[] args) {
        new EditDistance().demo();
    }

    private void demo() {
        String s1 = "abcdef";
        String s2 = "azced";
        System.out.println("The minimum operations required: " + minimumOperations(s1, s2));
    }

    private int minimumOperations(String s1, String s2) {
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            matrix[i][0] = i;
        }
        for (int i = 0; i <= s2.length(); i++) {
            matrix[0][i] = i;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = 1 + min(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i][j - 1]);
                }

            }
        }
        System.out.println("Matrix Display");
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix[s1.length()][s2.length()];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
