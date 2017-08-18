package Array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by kalsi on 17/08/17.
 * Given an array of integers, sort the array according to frequency of elements. For example, if
 * the input array is {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}, then modify the array to {3, 3, 3, 3, 2, 2, 2,
 * 12, 12, 4, 5}.
 */
public class SortAccordingToFrequency {
    public static void main(String[] args) {
        new SortAccordingToFrequency().demo();
    }

    private void demo() {
        Integer[] array = {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12};
        sort(array);
        display(array);
    }

    private void sort(Integer[] array) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        countFrequency(array, map);
        Arrays.sort(array, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1) == map.get(o2)) {
                    return 0;
                }
                return map.get(o1) > map.get(o2) ? -1 : 1;
            }
        });
    }

    private void countFrequency(Integer[] array, HashMap<Integer, Integer> map) {
        for (Integer i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
    }

    private void display(Integer[] array) {
        for (Integer i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
