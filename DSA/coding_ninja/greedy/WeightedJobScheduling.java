package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WeightedJobScheduling {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Activity[] activities = new Activity[N];

		for(int i=0;i<N;i++) {
			activities[i] = new Activity(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(activities, new Comparator<Activity>() {

			@Override
			public int compare(Activity t1, Activity t2) {
				// TODO Auto-generated method stub
				return t1.depart - t2.depart;
			}
			
		});	
		
//		for(Activity a: activities) {
//			System.out.println(a.depart);
//		}
		
		long[] dp = new long[N];
		dp[0] = activities[0].profit;
		for(int i=1;i<N;i++) {
			int joinedActivityIndex = getUpperBound(activities, 0, i, activities[i].start);
				
//			while(j>=0) {
//				
//				
//				if(activities[j].depart <= activities[i].start) {
//					joinedActivityIndex = j;
//					break;
//				}
//				j--;
//			}
			long includeProfit = activities[i].profit;
			if (joinedActivityIndex!=-1){
				includeProfit += dp[joinedActivityIndex];
			}
			
			long excludeProfit = dp[i-1];
			dp[i] = Math.max(includeProfit, excludeProfit);
		}
		System.out.println(dp[N-1]);
		System.out.println(Arrays.toString(dp));
	}

	private static int getUpperBound(Activity[] activities, int start, int end, int startTime) {
		
		while(start<end) {
			int mid = start+(end-start)/2;
			if(startTime < activities[mid].depart) {
				end = mid;
				
			}else
			{
				start = mid+1;
			}
		}
		return start - 1;
	}
	
	

}

class Activity{
	
	int start, depart, profit;
	
	public Activity(int start, int depart, int profit) {
		this.start = start;
		this.depart = depart;
		this.profit = profit;
	}
	
}