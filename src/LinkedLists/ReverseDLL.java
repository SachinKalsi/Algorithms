package LinkedLists;

/**
 * Created by kalsi on 28/07/17.
 */
public class ReverseDLL {
    public static void main(String[] args) {
        new ReverseDLL().demo();
    }

    private void demo() {
        int[] array = {1, 2, 3, 4, 5};
        Node start = LinkedList.createDLL(array);
        System.out.println("Before reverse");
        LinkedList.displayDLL(start, true);
        start = LinkedList.reverseDLL(start);
        System.out.println();
        System.out.println("After reverse");
        LinkedList.displayDLL(start, true);
    }
}
