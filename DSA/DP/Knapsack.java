package DP;

import java.util.Arrays;

public class Knapsack {

    static int knapsack(int wts[], int prices[], int N, int W) {
        if (N == 0 || W == 0) {
            return 0;
        }

        int inc = 0, exc = 0;

        //Including current item
        if (wts[N - 1] <= W)
            inc = prices[N - 1] + knapsack(wts, prices, N - 1, W - wts[N - 1]);

        //Excluding the current item
        exc = 0 + knapsack(wts, prices, N - 1, W);

        return Math.max(inc, exc);


    }


    static int knapsackDP(int wt[], int price[], int N, int W) {

        int[][] dp = new int[N + 1][W + 1];
        //Arrays.fill(dp, 0);
        for (int n = 0; n <= N; n++) {
            for (int w = 0; w <= W; w++) {

                if (n == 0 || w == 0)
                    dp[n][w] = 0;
                else { 
                    int inc = 0, exc = 0;
                    if (wt[n - 1] <= w)
                        inc = price[n - 1] + dp[n - 1][w - wt[n - 1]];//for bounded knapsack dp[n-1] and dp[n] for unbounded kanpsack

                    exc = dp[n - 1][w];

                    dp[n][w] = Math.max(inc, exc);
                }

            }
        }

        for (int[] row : dp) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        return dp[N][W];


    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int wts[] = {2, 2, 3, 1};
        int prices[] = {5, 20, 100, 30};
        int N = 4;
        int W = 5;
        System.out.println(knapsack(wts, prices, N, W));
        System.out.println(knapsackDP(wts, prices, N, W));
    }

}
