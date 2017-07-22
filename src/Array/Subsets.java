package Array;

/**
 * Created by kalsi on 22/07/17.
 */
public class Subsets {
    public static void main(String[] args) {
        char[] array = {'a', 'b', 'c'};
        Subsets set = new Subsets();
        set.printSubsets(array);
    }

    private void printSubsets(char[] set) {
        int n = set.length;
        int totalSubsets = 1 << n;
        for (int i = 0; i < totalSubsets; i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j))  > 0) {
                    System.out.print(set[j] + " ");
                }
            }
            System.out.println(" }");

        }


    }
}
