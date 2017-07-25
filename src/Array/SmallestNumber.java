package Array;

/**
 * Created by kalsi on 25/07/17.
 */

/**
 * smallest number whose digits multiply to a given number n
 * */
public class SmallestNumber {
    public static void main(String[] args) {
        int n = 300;
        new SmallestNumber().findSmallest(n);
    }

    private void findSmallest(int n) {
        if (n < 10) {
            System.out.println(n + 10);
            return;
        }
        int maxDigits = 50;
        int[] digits = new int[maxDigits];
        int i = 9;
        int j = 0;

        while (i > 1) {
            while (n % i == 0) {
                n = n / i;
                digits[j] = i;
                j++;
            }
            i--;
        }
        if (n > 10) {
            System.out.println("Not possible");
        } else {
            while (--j >= 0) {
                System.out.print(digits[j]);
            }
        }
    }
}
