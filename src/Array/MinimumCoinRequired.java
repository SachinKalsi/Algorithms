package Array;

/**
 * Created by kalsi on 04/09/17.
 */
public class MinimumCoinRequired {
    public static void main(String[] args) {
        new MinimumCoinRequired().demo();
    }

    private void demo() {
        int coins[] = {9, 6, 5, 1};
        int value = 11;
        System.out.println("minimum coins required: " + minimum(coins, value));
    }

    private int minimum(int[] coins, int value) {
        int[] table = new int[value + 1];
        table[0] = 0;
        for (int i = 1; i <= value; i++) {
            table[i] = Integer.MAX_VALUE;
        }
        for (int v = 1; v <= value; v++) {
            for (int coin = 0; coin < coins.length; coin++) {
                if (coins[coin] <= v) {
                    int r = table[v - coins[coin]];
                    if (r != Integer.MAX_VALUE && r + 1 < table[v]) {
                        table[v] = r + 1;
                    }
                }
            }
        }
        return table[value];
    }
}
