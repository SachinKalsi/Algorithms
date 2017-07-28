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
        LinkedList linkedList = new LinkedList();

        Node start = linkedList.createDLL(array);
        System.out.println("Before reverse");
        linkedList.displayDLL(start, true);
        start = linkedList.reverseDLL(start);
        System.out.println();
        System.out.println("After reverse");
        linkedList.displayDLL(start, true);

    }

}
