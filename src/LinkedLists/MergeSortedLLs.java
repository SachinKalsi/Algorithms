package LinkedLists;

/**
 * Created by kalsi on 29/07/17.
 */
public class MergeSortedLLs {
    public static void main(String[] args) {
        new MergeSortedLLs().mergeLists();
    }

    private void mergeLists() {
        // Lets assume that the LL are disjoint
        int[] array1 = {7, 11};
        int[] array2 = {2, 4, 6, 8, 10, 12};
        LinkedList LL = new LinkedList();
        Node first = LL.createDLL(array1);
        Node second = LL.createDLL(array2);
        System.out.println("First LL");
        LL.displayDLL(first, false);
        System.out.println("Second LL");
        LL.displayDLL(second, false);
        first = LL.merge(first, second);
        System.out.println("After merge");
        LL.displayDLL(first, false);
    }
}
