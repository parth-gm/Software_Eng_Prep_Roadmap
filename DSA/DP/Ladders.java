package DP;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ladders {

    //Time=O(3^n)
    static int ways(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        int ans;
        ans = ways(n - 1) + ways(n - 2) + ways(n - 3);
        return ans;
    }

    //Time=O(k^n)
    static int ways2(int n, int k) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += ways2(n - i, k);
        }
        return ans;
    }

    static int ways2(int n, int k, int[] dp) {
        if (n == 0) {
            dp[n] = 1;
            return 1;
        }
        if (n < 0)
            return 0;
        if(dp[n]==-1) {
            int ans = 0;
            for (int i = 1; i <= k; i++) {
                ans += ways2(n - i, k);
            }
            dp[n] = ans;
        }

        return dp[n];
    }


    //Bootom Up O(nk)
    static int waysBU(int n, int k) {
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int step = 1; step <= n; step++) {
            dp[step] = 0;
            for (int j = 1; j <= k; j++) {
                if (step - j >= 0)
                    dp[step] += dp[step - j];
            }
        }
        return dp[n];
    }

    //Bootom Up O(n)
    static int waysBUV2(int n, int k) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;


        for (int step = 2; step <= n; step++) {
            if (step - 1 - k >= 0)
                dp[step] = 2 * dp[step - 1] - dp[step - 1 - k];
            else
                dp[step] = 2 * dp[step - 1];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println();
        System.out.println(ways(4));
        System.out.println(ways2(3, 2));
        System.out.println(ways2(4, 3));
        System.out.println("BootomUp in O(kN): " + waysBU(4, 3));
        System.out.println("BootomUp in O(N): " + waysBUV2(4, 3));
    }

}
