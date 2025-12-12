package dp;

public class HouseRobbers {

	 public int rob(int[] nums) {
		 int[] dp = new int[nums.length];
		 return utility(nums, 0, dp);
		 
	 }
	
	private int utility(int[] nums, int cur, int[] dp) {
		
		if(cur>=nums.length)
		{
			return 0;
		}
		
		if(dp[cur]!=-1)
			return dp[cur];
		
		
		int ans1=0, ans2=0;
		
		ans1 = nums[cur]+ utility(nums, cur+2, dp);
		
		ans2 = utility(nums, cur+1, dp);
		
		dp[cur] =  Math.max(ans1, ans2);
		return dp[cur];
	}

	public static void main(String[] args) {
		// ed method stub

	
	}

}
