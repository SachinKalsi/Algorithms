package LinkedLists;

/**
 * Created by kalsi on 30/07/17.
 */
public class DetectLoop {
    public static void main(String[] args) {
        new DetectLoop().demo();
    }

    private void demo() {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        Node start = LinkedList.createSLL(array1);
        Node last = LinkedList.getNthNode(start, array1.length - 1);
        Node intermediate = LinkedList.getNthNode(start, 0);
        last.right = intermediate; // comment this line to remove the loop
        Node loopNode = detectLoop(start);
        if (loopNode == null) {
            System.out.println("No loop detected");
        } else {
            System.out.println("loop detected at " + loopNode.data);
        }
    }

    private Node detectLoop(Node start) {
        Node slowNode = start;
        Node fastNode = start;
        while (slowNode != null && fastNode != null && fastNode.right != null) {
            slowNode = slowNode.right;
            fastNode = fastNode.right.right;
            if (slowNode == fastNode) {
                break;
            }
        }
        if (slowNode != null && fastNode != null && fastNode.right != null) {
            slowNode = start;
            while(slowNode != fastNode) {
                slowNode = slowNode.right;
                fastNode = fastNode.right;
            }
            return slowNode;
        }
        return null;
    }
}
