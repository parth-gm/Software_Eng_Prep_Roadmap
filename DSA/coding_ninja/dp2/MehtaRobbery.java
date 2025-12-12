package dp2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MehtaRobbery {
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			int n = sc.nextInt();
			int w = sc.nextInt();
			
			long[] values = new long[n];
			long[] weights = new long[n];
			
			for(int i=0;i<n;i++) {
				values[i] = sc.nextInt();
			}
			
			for(int i=0;i<n;i++) {
				weights[i] = sc.nextInt();
			}
			
			Pair[] pairs = new Pair[n];
			for(int i=0;i<n;i++) {
				pairs[i] = new Pair(values[i], weights[i]);
			}
			
			Arrays.sort(pairs, new Comparator<Pair>() {

				@Override
				public int compare(Pair o1, Pair o2) {
					
					return (int)(o1.value - o2.value);
				}
			});
			
			
			int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
			
			long[][][] dp = new long[2][n+1][w+1];
			
			for(int i=0;i<2;i++) {
				for(int j=0;j<=n;j++) {
					for(int k=0;k<=w;k++) {
						dp[i][j][k] = 0;
						
					}
				}
			}
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=w;j++) {
					dp[0][i][j] = dp[0][i-1][j];
					if(j>=pairs[i-1].weight) {
						dp[0][i][j] = Math.max(dp[0][i-1][j], dp[0][i-1][(int)(j-pairs[i-1].weight)] + pairs[i-1].value);
					}
				}
			}
			
			
			for(int prime = 1;prime<=10;prime++) {
				int p = prime%2;
				for(int i=1;i<=n;i++) {
					for(int j=1;j<=w;j++) {
						dp[p][i][j] = dp[p][i-1][j];
						if(j>=pairs[i-1].weight) {
							dp[p][i][j] = Math.max(dp[p][i-1][j],
									Math.max(dp[p][i-1][(int)(j-pairs[i-1].weight)] + pairs[i-1].value, dp[p^1][i-1][(int)(j-pairs[i-1].weight)] + pairs[i-1].value * primes[prime-1]));
						}
					}
				}
				
			}
			
			
			
			System.out.println(dp[0][n][w]);
			
		}
		
	}

}

class Pair{
	long value, weight;
	public Pair(long value, long weight) {
		this.value = value;
		this.weight = weight;
	}
}
