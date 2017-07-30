package LinkedLists;

/**
 * Created by kalsi on 30/07/17.
 */
public class ReverseSLL {
    public static void main(String[] args) {
        new ReverseSLL().demo();
    }

    private void demo() {
        int[] array = {1, 2, 3, 4, 5};
        Node start = LinkedList.createSLL(array);
        System.out.println("Before reverse");
        LinkedList.displayDLL(start, false);
        start = LinkedList.reverseSLL(start);
        System.out.println();
        System.out.println("After reverse");
        LinkedList.displayDLL(start, false);
    }
}
