package LinkedLists;

/**
 * Created by kalsi on 29/07/17.
 */
public class LinkedList {
    public Node createDLL(int[] array) {
        if (array.length == 0) {
            return null;
        }
        Node main = new Node(array[0]);
        Node previous = main;
        Node current = null;

        for (int i = 1; i < array.length; i++) {
            current = new Node(array[i]);
            current.left = previous;
            current.right = null;
            previous.right = current;
            previous = current;
        }
        return main;
    }

    public void displayDLL(Node start, boolean displayReverse) {
        if (start == null) {
            System.out.println("The linked list is empty!!");
            return;
        }
        while (start.right != null) {
            System.out.print(start.data + "\t");
            start = start.right;
        }
        System.out.println(start.data);
        if (displayReverse) {
            while (start != null) {
                System.out.print(start.data + "\t");
                start = start.left;
            }
        }
    }

    public Node reverseDLL(Node start) {
        Node node = reverse(start);
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node reverse(Node n) {
        if(n == null){
            return null;
        }
        Node next = reverse(n.right);
        Node temp = n.left;
        n.left = next;
        n.right = temp;
        return n;
    }
}
