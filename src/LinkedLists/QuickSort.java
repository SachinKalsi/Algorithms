package LinkedLists;

/**
 * Created by kalsi on 29/07/17.
 */
public class QuickSort {
    LinkedList LL;

    public static void main(String[] args) {
        new QuickSort().demo();
    }

    private void demo() {
        int[] array1 = {30, 1, 9, 5, 4, 7};
        Node ll = LinkedList.createSLL(array1);
        quick_sort(ll, 0, array1.length - 1);
        LinkedList.displayDLL(ll, false);
    }

    private void quick_sort(Node ll, int start, int end) {
        if (start < end) {
            int mid = quick(ll, start, end);
            quick_sort(ll, start, mid - 1);
            quick_sort(ll, mid + 1, end);
        }
    }

    private int quick(Node ll, int start, int end) {
        int previous = start - 1;
        Node pivot = LinkedList.getNthNode(ll, end);
        for (int i = start; i < end; i++) {
            if (LinkedList.getNthNode(ll, i).data < pivot.data) {
                swap(ll, ++previous, i);
            }
        }
        swap(ll, ++previous, end);
        return previous;
    }

    private void swap(Node ll, int i, int j) {
        if (i != j) {
            Node start = LinkedList.getNthNode(ll, i);
            Node end = LinkedList.getNthNode(ll, j);
            start.data = start.data + end.data;
            end.data = start.data - end.data;
            start.data = start.data - end.data;
        }
    }
}
