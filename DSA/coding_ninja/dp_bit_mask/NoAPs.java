package dp_bit_mask;
import java.util.Arrays;
import java.util.Scanner;

class NoAPs {
    
    static final int MAX = 1001;
    static final int modulo_by = 1000000007;

    static long numofAP(int a[], int n)
    {
        
        // initializing the minimum value and
        // maximum value of the array.
        int minarr = +2147483647;
        int maxarr = -2147483648;

        // Finding the minimum and maximum
        // value of the array.
        for (int i = 0; i < n; i++) {
            minarr = Math.min(minarr, a[i]);
            maxarr = Math.max(maxarr, a[i]);
        }

        // dp[i] is going to store count of 
        // APs ending with arr[i].
        // sum[j] is going to store sun of 
        // all dp[]'s with j as an AP element.
        long dp[] = new long[n];
        long sum[] = new long[MAX];

        // Initialize answer with n + 1 as 
        // single elements and empty array 
        // are also DP.
        int ans = n + 1;

        // Traversing with all common 
        // difference.
        for (int d = (minarr - maxarr); 
                d <= (maxarr - minarr); d++) 
        {
            Arrays.fill(sum, 0);

            // Traversing all the element 
            // of the array.
            for (int i = 0; i < n; i++) {
                
                // Initialize dp[i] = 1.
                dp[i] = 1;

                // Adding counts of APs with
                // given differences and a[i] 
                // is last element.
                // We consider all APs where 
                // an array element is previous 
                // element of AP with a particular
                // difference
                if (a[i] - d >= 1 && 
                             a[i] - d <= 1000)
                    dp[i] += sum[a[i] - d]%modulo_by;

                ans += (dp[i] - 1)%modulo_by;
                sum[a[i]] += dp[i]%modulo_by;
            }
        }

        return ans%modulo_by;
    }
    
    // Driver code
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
        	arr[i] = sc.nextInt();
        }
        
        System.out.println(numofAP(arr, n));
    }
}
