package Strings;

/**
 * Created by kalsi on 01/09/17.
 * http://www.geeksforgeeks.org/?p=19155
 */
public class LongestPalindromSubsequence {
    public static void main(String[] args) {
        new LongestPalindromSubsequence().demo();
    }

    private void demo() {
        String s = "BBABCBCAB";
        System.out.println(longest(s, 0, s.length() - 1));
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
