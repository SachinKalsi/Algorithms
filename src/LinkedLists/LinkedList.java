package LinkedLists;

/**
 * Created by kalsi on 29/07/17.
 */
public class LinkedList {

    public static Node createSLL(int[] array) {
        if (array.length == 0) {
            return null;
        }
        Node start = new Node(array[0]);
        Node current = start;
        for (int i = 1; i < array.length; i++) {
            current.right = new Node(array[i]);
            current = current.right;
        }
        return start;

    }

    public static Node createDLL(int[] array) {
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

    public static void displayDLL(Node start, boolean displayReverse) {
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

    public static Node reverseDLL(Node start) {
        Node node = reverse(start);
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private static Node reverse(Node n) {
        if (n == null) {
            return null;
        }
        Node next = reverse(n.right);
        Node temp = n.left;
        n.left = next;
        n.right = temp;
        return n;
    }

    public static Node merge(Node first, Node second) {
        if (first == null || second == null) {
            return first == null ? second : first;
        }
        Node temp = null;

        if (first.data > second.data) {
            temp = second;
            second = first;
            first = temp;
        }
        Node finalNode = first;
        while (first != null && second != null) {
            temp = first.right;
            if (temp == null) {
                first.right = second;
                break;
            }
            if ((first.data < second.data) && (second.data < temp.data)) {
                first.right = second;
                second = second.right;
                first.right.right = temp;
                first = first.right;
            } else {
                first = first.right;
            }
        }
        return finalNode;
    }

    public static int getLength(Node node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.right;
        }
        return length;
    }

    public static Node getNthNode(Node node, int n) {
        Node nthNode = null;
        int count = 0;
        while (node != null) {
            if (count == n) {
                nthNode = node;
                break;
            }
            count++;
            node = node.right;
        }
        return nthNode;
    }
}
