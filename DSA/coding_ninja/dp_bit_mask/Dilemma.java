package dp_bit_mask;

import java.util.ArrayList;
import java.util.Scanner;


//Wrong Solution:
public class Dilemma {

	
	static int  minimumTouchesRequired(int n, ArrayList<String> v ) {
		
		int[][] dp = new int[105][1<<12];
		
//		for(int i=0;i<v.get(0).length();i++) {
//			for(int j=0;j<(1<<(n+1));j++) {
//				dp[i][j] = Integer.MAX_VALUE;
//			}
//		}
		
		return find_touches(v.get(0).length()-1, (1<<n)-1, v, dp);
	}
	
	private static int find_touches(int pos, int mask, ArrayList<String> v, int[][] dp) {
		
		if(((mask&(mask-1))==0) && mask!=0){
			return 0;
		}
		
		if((pos<0)||(mask==0)) {
			return 10000;
		}
		
		if(dp[pos][mask]!=0) {
			return dp[pos][mask];
		}
		
		int newmask1 =0;
		int newmask2 = 0;
		int touches =0;
		
		for(int i=0;i<v.size();i++) {
			if((mask&(1<<i))==1) {
				touches++;
				if(v.get(i).charAt(pos) == '0') {
					newmask1 |= (1<<i);
				}else {
					newmask2 |= (1<<i);
				}
			}
		}
		int ans1 = find_touches(pos-1, newmask1, v, dp) + 
				find_touches(pos-1, newmask2, v, dp) +
				touches;
		int ans2 = find_touches(pos-1, mask, v, dp);
		int ans  = Math.min(ans1, ans2);
		dp[pos][mask] = ans;
		return ans;
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int noStrings = sc.nextInt();
			ArrayList<String> arrl = new ArrayList<>(noStrings);
			for(int i=0;i<noStrings;i++)
			{
				arrl.add(sc.next());
			}
			System.out.println(minimumTouchesRequired(noStrings, arrl));
		}

	}

}
