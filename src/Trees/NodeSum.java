package Trees;

/**
 * Created by kalsi on 30/08/17.
 * Replace each node with the sum of all greater nodes in a given BST
 */
public class NodeSum {
    int sum = 0;

    public static void main(String[] args) {
        new NodeSum().demo();
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
        sumNode(n);
        inorder(n);
    }

    private void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.data + "\t");
            inorder(n.right);
        }
    }

    private void sumNode(Node n) {
        if (n != null) {
            sumNode(n.right);
            sum +=  n.data;
            n.data = sum-n.data;
            sumNode(n.left);
        }
    }

}
