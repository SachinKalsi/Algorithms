package Array;

/**
 * Created by kalsi on 06/08/17.
 * . Numbers in array are repeated twice except one number which is present just once. Find
 * the one
 */
public class FindException {
    public static void main(String[] args) {
        new FindException().demo();
    }

    private void demo() {
        int[] array = {2, 2, 11, 12, 11};
        findException(array);

    }

    private void findException(int[] array) {
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = sum ^ array[i];
        }
        System.out.println("number which has repeated one time is " + sum);
    }
}
