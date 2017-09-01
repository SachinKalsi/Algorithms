package Strings;

/**
 * Created by kalsi on 01/09/17.
 * http://www.geeksforgeeks.org/?p=19155
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestPalindromicSubsequence.java
 * https://www.youtube.com/watch?v=_nCsPn7_OgI&t=1s
 */
public class LongestPalindromSubsequence {
    public static void main(String[] args) {
        new LongestPalindromSubsequence().demo();
    }

    private void demo() {
        String s = "BBABCBCAB";
        System.out.println("Recursion: " + longest(s, 0, s.length() - 1));
        System.out.println("Dynamic Programming: " + longestDP(s));
    }

    private int longestDP(String s) {
        int[][] matrix = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            matrix[i][i] = 1;
        }
        for (int length = 2; length <= s.length(); length++) {
            for (int i = 0; i <= s.length() - length; i++) {
                int j = i + length - 1;
                if (length == 2 && s.charAt(i) == s.charAt(j)) {
                    matrix[i][j] = 2;
                } else if (s.charAt(i) == s.charAt(j)) {
                    matrix[i][j] = 2 + matrix[i + 1][j - 1];
                } else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i + 1][j]);
                }
            }
        }
        displaySubsequence(s, matrix);
        return matrix[0][s.length() - 1];
    }

    private void displaySubsequence(String s, int[][] matrix) {
        int i = 0;
        int j = matrix.length - 1;
        StringBuilder sb = new StringBuilder();
        while (i != j) {
            if (s.charAt(i) == s.charAt(j)) {
                sb.append(s.charAt(i));
                i++;
                j--;
            } else {
                if (matrix[i + 1][j] > matrix[i][j - 1]) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(sb.toString() + s.charAt(i) + sb.reverse().toString());
    }

    private int longest(String s, int start, int end) {
        if (start == end) {
            return 1;
        }
        if (start + 1 == end && s.charAt(start + 1) == s.charAt(end)) {
            return 2;
        }
        if (s.charAt(start) == s.charAt(end)) {
            return longest(s, start + 1, end - 1) + 2;
        }

        return Math.max(longest(s, start + 1, end), longest(s, start, end - 1));

    }
}
