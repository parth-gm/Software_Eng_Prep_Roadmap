package DP;

import java.util.Arrays;

public class Fibonacci {
    static int fib(int n) {
        if (n == 1 || n == 0)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    //Top Down APproach
    static int topdowndp(int n, int[] dp) {
        if (n == 1 || n == 0) {
            dp[n] = n;
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        } else {
            dp[n] = topdowndp(n - 1, dp) + topdowndp(n - 2, dp);
            return dp[n];
        }

    }

//Bottom Up Approach

    static int fibbottomup(int n) {
        int[] dp = new int[100];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }


    public static void main(String[] args) {

        int[] dp = new int[100];
        Arrays.fill(dp, -1);


//		System.out.println(topdowndp(40, dp));
//		System.out.println(fib(40));
        System.out.println(fibbottomup(20));
    }

}
