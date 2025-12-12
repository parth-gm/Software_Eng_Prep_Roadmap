package DP;

public class coinsNeeded {

	static int coinsNeed(int coins[],int amount,int n) {
		if(amount==0)
			return 0;
		int ans=Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++) {
			if(amount-coins[i]>=0) {
				//System.out.println("amount: "+(amount-coins[i]));
				int smallerAns=coinsNeed(coins, amount-coins[i], n);
				//System.out.println(smallerAns);
				
//				if(smallerAns<ans)
//					ans=smallerAns+1;
//				
				if(smallerAns!=Integer.MAX_VALUE)
					ans=Math.min(smallerAns+1, ans);
			}
		}
		return ans;
		
	}
	
	
	static int coinNeedDP(int coins[],int amount,int n) {
		int[] dp=new int[amount+1];
		
		for(int i=0;i<=amount;i++)
			dp[i]=Integer.MAX_VALUE;
		
		dp[0]=0;
		
		for(int rupay=1;rupay<=amount;rupay++) {
			
			for(int i=0;i<n;i++) {
				if(coins[i]<=rupay) {
					int smallerAns=dp[rupay-coins[i]];
					if(smallerAns!=Integer.MAX_VALUE)
						dp[rupay]=Math.min(smallerAns+1, dp[rupay]);
				}
			}
			
		}
		
		return dp[amount];
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int us_coins[]= {1,7,10};
		int n=3;
		int amount=15;
		System.out.println(coinsNeed(us_coins, amount, n));
		int indian_coins[]= {1,2,5,10,50};
		
		int paisa=39;
		//System.out.println(coinsNeed(indian_coins, paisa, 5));
		
		System.out.println(coinNeedDP(indian_coins, paisa, 5));
		
	}

}
