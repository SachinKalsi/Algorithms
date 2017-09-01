package Trees;

import java.util.ArrayList;

/**
 * Created by kalsi on 01/09/17.
 */
public class LevelOrder {
    public static void main(String[] args) {
        new LevelOrder().demo();
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
        displayLevelOrder(n);
    }

    private void displayLevelOrder(Node n) {
        if (n == null) {
            return;
        }
        ArrayList<Node> parents = new ArrayList<Node>();
        parents.add(n);
        System.out.println(n.data);
        while (!parents.isEmpty()) {
            ArrayList<Node> tempParents = new ArrayList<Node>();
            for (Node parent : parents) {
                if (parent.left != null) {
                    System.out.print(parent.left.data + "\t");
                    tempParents.add(parent.left);
                }
                if (parent.right != null) {
                    System.out.print(parent.right.data + "\t");
                    tempParents.add(parent.right);
                }
            }
            parents  = tempParents;
            System.out.println();
        }
    }
}
