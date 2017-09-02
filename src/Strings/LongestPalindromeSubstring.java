package Strings;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by kalsi on 02/09/17.
 * http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
 * O(n^2) time & O(1) space
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        new LongestPalindromeSubstring().demo();
    }

    private void demo() {
        String s = "zabbap";
        System.out.println("Longest Palindrom substring (DP): " + longest(s));
        System.out.println("Longest Palindrom substring (Without DP): " + longestWithoutDP(s));
    }

    private String longestWithoutDP(String s) {
        String longestSubstring = s.substring(0, 1);
        String temp;
        for (int i = 1; i < s.length(); i++) {
            // odd length

            temp = longestPalidrome(s, i, i);
            if (temp.length() > longestSubstring.length()) {
                longestSubstring = temp;
            }
            //even length
            temp = longestPalidrome(s, i - 1, i);
            if (temp.length() > longestSubstring.length()) {
                longestSubstring = temp;
            }
        }
        return longestSubstring;
    }

    private String longestPalidrome(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        String temp = "";
        if (start == end) {
            temp = s.charAt(start) + "";
            start--;
            end++;
        } else if (s.charAt(start) == s.charAt(end)) {
            temp = s.charAt(start) + "" + s.charAt(start);
            start--;
            end++;
        }
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                sb.append(s.charAt(end));
            } else {
                break;
            }
            start--;
            end++;
        }
        return sb.reverse().toString() + temp + sb.reverse().toString();
    }

    private String longest(String s) {
        boolean[][] matrix = new boolean[s.length()][s.length()];
        int maxLength = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            matrix[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                maxLength = 2;
                start = i;
                matrix[i][i + 1] = true;
            }
        }
        for (int length = 3; length <= s.length(); length++) {
            for (int i = 0; i < s.length() - length + 1; i++) {
                int j = length + i - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    matrix[i][j] = matrix[i + 1][j - 1];
                    if (matrix[i][j]) {
                        start = i;
                        maxLength = length;
                    }

                }

            }

        }
        return s.substring(start, start + maxLength);
    }
}
