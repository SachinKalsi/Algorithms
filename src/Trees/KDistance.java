package Trees;

import java.util.ArrayList;

/**
 * Created by kalsi on 31/08/17.
 * http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 * Print all nodes at distance k from a given node
 */
public class KDistance {
    public static void main(String[] args) {
        new KDistance().demo();
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
                        3      10
                     1    6        14
                        4   7   13
        *
        * */
        findKDistanceNodes(n, n.left, 2);
    }

    private void findKDistanceNodes(Node root, Node target, int k) {
        findKNodesDownwards(target, k);
//        findKNodesUpwards(root, target, k);
    }

    private void findKNodesUpwards(Node root, Node target, int k) {
        ArrayList<Node> path = new ArrayList<Node>();
        Boolean pathFound = false;
        findPathFromRootToTarget(root, target, path, pathFound);
    }

    private void findPathFromRootToTarget(Node root, Node target, ArrayList<Node> al, Boolean pathFound) {
        if (root != null && !pathFound) {

            al.add(root);
            findPathFromRootToTarget(root.left, target, al, pathFound);
            if (root == target) {
                pathFound = true;
                return;
            }

            findPathFromRootToTarget(root.right, target, al, pathFound);
            if (!pathFound) {
                al.remove(al.size() - 1);
            }

        }
    }

    private void findKNodesDownwards(Node target, int k) {
        if (target == null) {
            return;
        }
        if (k == 0) {
            System.out.println(target.data);
        }
        k--;
        findKNodesDownwards(target.left, k);
        findKNodesDownwards(target.right, k);

    }
}

