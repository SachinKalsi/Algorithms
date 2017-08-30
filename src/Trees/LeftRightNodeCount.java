package Trees;

/**
 * Created by kalsi on 30/08/17.
 * each node in a tree has to contain count of left branch nodes & right branch nodes
 */
public class LeftRightNodeCount {
    CustomNode node = null;

    class CustomNode {
        int data;
        CustomNode left;
        CustomNode right;
        int leftCount;
        int rightCount;

        public CustomNode(int d) {
            data = d;
            leftCount = 0;
            rightCount = 0;
        }
    }

    public static void main(String[] args) {

        new LeftRightNodeCount().demo();
    }

    private void demo() {
        int[] array = {40, 30, 10, 50, 60, 70,11};
        /*      40
    30           50
  10                60
     11                 70
    * */

        for (int i : array) {
            insert(i);
        }
        display(node);
    }

    private void display(CustomNode node) {
        if (node != null) {
            display(node.left);
            System.out.println("data: " + node.data + " left: " + node.leftCount + " right: " + node.rightCount);
            display(node.right);
        }
    }

    private void insert(CustomNode node, int data) {
        if (node != null) {
            if (data > node.data) {
                node.rightCount++;
                if (node.right == null) {
                    node.right = new CustomNode(data);
                } else {
                    insert(node.right, data);
                }
            } else {
                node.leftCount++;
                if (node.left == null) {
                    node.left = new CustomNode(data);
                } else {
                    insert(node.left, data);
                }
            }

        }

    }

    private void insert(int data) {
        if (node == null) {
            node = new CustomNode(data);
            return;
        }
        insert(node, data);
    }


}
