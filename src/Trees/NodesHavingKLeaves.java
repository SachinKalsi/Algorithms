package Trees;

/**
 * Created by kalsi on 30/08/17.
 * Implement a function which returns list of all nodes in a binary tree having a given number
 of leaves, say k .
 http://www.geeksforgeeks.org/print-nodes-binary-tree-k-leaves/
 */
public class NodesHavingKLeaves {
    public static void main(String[] args) {
        new NodesHavingKLeaves().demo();
    }

    private void demo() {
        Node n = new Node(1);
        //left
        n.left = new Node(2);
        n.left.left = new Node(5);
        n.left.right = new Node(6);
        n.left.left.left = new Node(9);
        n.left.left.right = new Node(10);

        //right
        n.right = new Node(4);
        n.right.left = new Node(7);
        n.right.right = new Node(8);
        n.right.left.left = new Node(11);
        n.right.left.right = new Node(12);
        displayNodes(n, 3);
    }

    private int displayNodes(Node n, int k) {
        if (n == null) {
            return 0;
        }
        if (n.left == null && n.right == null) {
            return 1;
        }
        int temp = displayNodes(n.left, k) + displayNodes(n.right, k);
        if (temp == k) {
            System.out.println(n.data);
        }
        return temp;

    }
}
