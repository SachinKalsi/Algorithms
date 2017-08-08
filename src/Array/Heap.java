package Array;

/**
 * Created by kalsi on 07/08/17.
 */
public class Heap {
    public static void main(String[] args) {
        new Heap().demo();
    }

    private void demo() {
        int[] array = {16, 4, 10, 14, 7, 9, 3, 28, 1};
        int[] heapAray = buildHeap(array);
        displayHeap(heapAray);
        addItem(heapAray, 25);
//        displayHeap(heapAray);
    }

    private int[] buildHeap(int[] array) {
        int[] heapArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            heapArray[i + 1] = array[i];
        }

        for (int i = heapArray.length / 2; i >= 1; i--) {
            heapify(heapArray, i);
        }

        return heapArray;
    }

    private void heapify(int[] heapArray, int i) {
        int left = i * 2;
        int right = left + 1;
        int maxElementIndex = i;
        if (left >= heapArray.length) {
            return;
        }
        if (right < heapArray.length) {
            int tempIndex = left;
            if (heapArray[right] > heapArray[left]) {
                tempIndex = right;
            }

            if (heapArray[tempIndex] > heapArray[i]) {
                maxElementIndex = tempIndex;
            }
        } else if (heapArray[left] > heapArray[i]) {
            maxElementIndex = left;
        }
        if (maxElementIndex != i) {
            heapArray[maxElementIndex] = heapArray[maxElementIndex] + heapArray[i];
            heapArray[i] = heapArray[maxElementIndex] - heapArray[i];
            heapArray[maxElementIndex] = heapArray[maxElementIndex] - heapArray[i];
            heapify(heapArray, maxElementIndex);
        }

    }

    private void displayHeap(int[] array) {
        for (int i = 1; i < array.length; i++) System.out.print(array[i] + "\t");
        System.out.println();

    }

    private void addItem(int[] heapAray, int n) {
    }
}
