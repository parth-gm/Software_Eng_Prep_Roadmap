package code;

import java.util.ArrayList;
import java.util.Arrays;

public class NoOfWaysToFormAmount {

	static int getNumberOfWays(int[] denominations, int numD, int remainAmount, int[][] dp, ArrayList<Integer> ways){
		System.out.println(ways +","+remainAmount+","+numD);
		if(remainAmount==0){
			System.out.println(ways);
			dp[numD][remainAmount] = 1;
			return 1;
		}

		if(numD<=0 || remainAmount<0){
			return 0;
		}

		
		
		if(dp[numD][remainAmount]!=-1) {
			return dp[numD][remainAmount];
		}

		if(denominations[numD-1]<=remainAmount) {
			ways.add(denominations[numD-1]);
			int includeWays = getNumberOfWays(denominations, numD, remainAmount-denominations[numD-1], dp, ways);
			ways.remove(ways.size()-1);
			int excludeWays = getNumberOfWays(denominations, numD-1, remainAmount, dp, ways);
			dp[numD][remainAmount] = includeWays + excludeWays;
			return dp[numD][remainAmount];

		}
		dp[numD][remainAmount] = getNumberOfWays(denominations, numD-1, remainAmount, dp, ways);
		return dp[numD][remainAmount];
		
	}
	
	public static void main(String[] args) {
		int amount = 4;
		
		int[] denominations = {1, 2};
		
	
		
		int[][] dp= new int[denominations.length+1][amount+1];
		
		for(int i=0;i<denominations.length+1;i++) {
			Arrays.fill(dp[i], -1);
		}
		ArrayList<Integer> arrl = new ArrayList<Integer>();
		System.out.println(getNumberOfWays(denominations, denominations.length, amount, dp, arrl));
		
		int[] dpnew = new int[amount+1];
		Arrays.fill(dpnew, -1);
		System.out.println(getNumberOfWaysOptimized(denominations, 0, amount, dpnew));
	}
	
	public static int getNumberOfWaysOptimized(int[] denominations, int curP, int remainAmount, int[] dp) {
		
		if(remainAmount<0)
			return 0;
		
		if(remainAmount==0)
			return 1;
		
		if(dp[remainAmount]!=-1)
			return dp[remainAmount];
		
		int ans = 0;
		
		for(int i=0;i<denominations.length;i++) {
			ans = ans + getNumberOfWaysOptimized(denominations, curP+1, remainAmount-denominations[i], dp);
		}
		dp[remainAmount] = ans;
		return ans;
	}
	
}
