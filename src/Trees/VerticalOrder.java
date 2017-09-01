package Trees;

import java.util.*;

/**
 * Created by kalsi on 01/09/17.
 * http://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
 */
public class VerticalOrder {
    class CustomValue {
        int value;

        public CustomValue(int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        new VerticalOrder().demo();
    }

    private void demo() {

        Node n = new Node(8);
        // left
        n.left = new Node(3);
        n.left.left = new Node(1);
        n.left.right = new Node(6);
        n.left.right.left = new Node(4);
        n.left.right.right = new Node(7);

        //right
        n.right = new Node(10);
        n.right.right = new Node(14);
        n.right.right.left = new Node(13);

        /*
                                    8
                        3                    10
                  1             6                       14
                           4        7              13
        *
        * */
        displayVerticalOrder(n);
    }

    private void displayVerticalOrder(Node n) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        CustomValue min = new CustomValue(0);
        CustomValue max = new CustomValue(0);
        calculateHorizontalDistance(n, hm, min, max, 0);
        for (int i = min.value; i <= max.value; i++) {
            ArrayList<Integer> al = hm.get(i);
            for (int item : al) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }

    private void calculateHorizontalDistance(Node node, HashMap<Integer, ArrayList<Integer>> hm, CustomValue min, CustomValue max, int level) {
        if (node != null) {
            if (level > max.value) {
                max.value = level;
            }
            if (level < min.value) {
                min.value = level;
            }
            if (!hm.containsKey(level)) {
                hm.put(level, new ArrayList<Integer>(Arrays.asList(node.data)));
            } else {
                ArrayList<Integer> al = hm.get(level);
                al.add(node.data);
                hm.put(level, al);
            }
            calculateHorizontalDistance(node.left, hm, min, max, level - 1);
            calculateHorizontalDistance(node.right, hm, min, max, level + 1);
        }
    }
}
