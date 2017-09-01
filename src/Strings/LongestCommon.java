package Strings;

import java.util.ArrayList;

/**
 * Created by kalsi on 31/08/17.
 */
public class LongestCommon {
    class Index {
        int i, j, max;

        public Index() {
            i = 0;
            j = 0;
            max = 0;
        }
    }

    public static void main(String[] args) {
        String s1 = "abcdaf";
        String s2 = "zbcdf";
        new LongestCommon().findLongestCommon(s1, s2);
    }

    private void findLongestCommon(String s1, String s2) {
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = 0;
        }
        Index index = new Index();
        longest("substring", s1, s2, matrix, index);
        System.out.println("Length of Longest Common Substring: " + index.max);
        printSubstring(matrix, index, s1, s2);
        index.max = 0;
        longest("subsequence", s1, s2, matrix, index);
        System.out.println("Length of Longest Common Subsequence: " + index.max);
        printSubsequence(matrix, s1, s2); // Not working
    }

    private void printSubsequence(int[][] matrix, String s1, String s2) {
        ArrayList<Character> al = new ArrayList<Character>();
        StringBuilder sb = new StringBuilder();
        printSubsequence(matrix, s1, s2, matrix.length - 1, matrix[0].length - 1, sb);

    }

    private void printSubsequence(int[][] matrix, String s1, String s2, int m, int n, StringBuilder sb) {
        if (m == 0 || n == 0) {
            System.out.print("Subsequence is: " + sb.reverse().toString());
            return;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            sb.append(s1.charAt(m - 1));
            m--;
            n--;
            printSubsequence(matrix, s1, s2, m, n, sb);
        } else if (matrix[m - 1][n] >= matrix[m][n - 1]) {
            m--;
            printSubsequence(matrix, s1, s2, m, n, sb);

        } else {
            n--;
            printSubsequence(matrix, s1, s2, m, n, sb);
        }
    }

    private void printSubstring(int[][] matrix, Index index, String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        while (matrix[index.i][index.j] != 0) {
            if (s1.charAt(index.i - 1) == s2.charAt(index.j - 1)) {
                sb.append(s1.charAt(index.i - 1));
            }

            index.i--;
            index.j--;
        }
        System.out.println("substring is: " + sb.reverse().toString());
    }

    private void longest(String type, String s1, String s2, int[][] matrix, Index index) {
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (type.equals("substring")) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }
                if (matrix[i][j] > index.max) {
                    index.max = matrix[i][j];
                    index.i = i;
                    index.j = j;
                }

            }

        }
    }

}
