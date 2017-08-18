package Array;

import java.util.HashMap;

/**
 * Created by kalsi on 18/08/17.
 * The cost of a stock on each day is given in an array, find the max profit that you can make by
 buying and selling in those days. For example, if the given array is {100, 180, 260, 310, 40,
 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3. Again buy on
 day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, then profit
 cannot be earned at all.
 */
public class MaxProfit {
    public static void main(String[] args) {
        new MaxProfit().demo();
    }

    private void demo() {
        int[] array = {100, 30, 15, 10, 8, 2, 0};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        getMaxProfit(array, map);
        if(map.isEmpty()){
            System.out.println("No profits found!!");
        } else {
            System.out.println("MAX profits can be earned by: ");
            for(Integer key: map.keySet()) {
                System.out.println("buying on " + key + " selling on " + map.get(key));
            }
        }
    }

    private void getMaxProfit(int[] array, HashMap<Integer, Integer> map) {
        Integer start = 0;
        int max = 0;
        Integer end = null;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                if (end != null) {
                    map.put(start, end);
                }
                end = null;
                max = 0;
                start = i;

            } else if ((array[i] - array[start]) > max) {
                end = i;
                max = array[i] - array[start];
            }
        }
        if (end != null) {
            map.put(start, end);
        }

    }
}
