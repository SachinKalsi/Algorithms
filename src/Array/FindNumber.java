package Array;

import java.util.HashMap;

/**
 * Created by kalsi on 20/08/17.
 * Find number which is repeated more than n/2 times in array where n is length
 * of array. Extension: Now find element which is repeated more than n/4 times, n/8 times and
 * so on.
 * with O(nlog(n)) Time & O(n) space
 */
public class FindNumber {
    public static void main(String[] args) {
        new FindNumber().demo();
    }

    private void demo() {
//        A A A C C B B C C C B C C
        int[] array = {1, 1, 1, 3, 3, 1, 3, 2, 3, 3, 3, 2, 3, 3};
        count(array);
    }

    /**
     * @param array
     * @param element: element to be counted
     * @param count
     * @return: true, if n is repeated more than count times,
     * false, otherwise
     */
    private Boolean isNTimes(int[] array, int element, int count) {
        int totalCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                totalCount++;
            }
            if (totalCount > count) {
                return true;
            }
        }
        return false;
    }

    private void count(int[] array) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int n = array.length / 2;
        while (n >= 1) {
            Integer currentElement = null;
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (!map.containsKey(array[i])) {
                    if (currentElement == null) {
                        currentElement = array[i];
                        count = 1;
                    } else if (currentElement == array[i]) {
                        count++;
                    } else {
                        count--;
                    }
                    if (count == 0) {
                        currentElement = null;
                        count = 0;
                    }
                }
            }

            if (currentElement == null || !isNTimes(array, currentElement, n)) {
                System.out.println("No element found more than " + n + " times!!");
                break;
            }
            map.put(currentElement, true);
            System.out.println(currentElement + " is repeated minimum of " + n + " times.");
            n = n / 2;
        }
    }
}
