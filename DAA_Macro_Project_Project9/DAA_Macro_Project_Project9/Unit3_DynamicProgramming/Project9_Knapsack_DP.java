import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] profits = {3, 4, 5, 6};
        int capacity = 10;

        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        profits[i - 1] + dp[i - 1][w - weights[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("0/1 Knapsack using Dynamic Programming");
        System.out.println("======================================");
        System.out.println("Capacity: " + capacity);

        System.out.println("\nItems:");
        for (int i = 0; i < n; i++) {
            System.out.println("Item " + (i + 1) +
                    " -> Weight: " + weights[i] +
                    ", Profit: " + profits[i]);
        }

        System.out.println("\nDP Table:");
        System.out.print("     ");
        for (int w = 0; w <= capacity; w++) {
            System.out.printf("%4d", w);
        }
        System.out.println();

        for (int i = 0; i <= n; i++) {
            System.out.printf("%4d ", i);
            for (int w = 0; w <= capacity; w++) {
                System.out.printf("%4d", dp[i][w]);
            }
            System.out.println();
        }

        System.out.println("\nMaximum Profit: " + dp[n][capacity]);

        System.out.println("\nSelected Items:");
        int w = capacity;

        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.println("Item " + i +
                        " -> Weight: " + weights[i - 1] +
                        ", Profit: " + profits[i - 1]);
                w -= weights[i - 1];
            }
        }
    }
}
