package Trees;

/**
 * Created by kalsi on 29/08/17.
 * Create BST from sorted array
 */
public class CreateBST {
    public static void main(String[] args) {
        new CreateBST().demo();

    }

    private void demo() {
        int[] array = {3, 5, 6, 7, 8, 9, 10};
        Node n = createBST(array);
        inorder(n);
    }

    private void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.print(n.data + "\t");
            inorder(n.right);
        }
    }

    private Node createBST(int[] array) {
        return createBST(array, 0, array.length - 1);
    }

    private Node createBST(int[] array, int start, int end) {
        if (end >= start) {
            int mid = (start + end) / 2;
            Node n = new Node(array[mid]);
            n.left = createBST(array, start, mid - 1);
            n.right = createBST(array, mid + 1, end);
            return n;
        }
        return null;
    }
}
