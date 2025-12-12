package dp;

import java.util.Scanner;

public class RoyAndCoinBoxes {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		while(tests-->0) {
			int n = sc.nextInt();
			int[] coin_boxs = new int[n];
			int m = sc.nextInt();
			
			int[] kstart = new int[n];
			int[] kend = new int[n];
			
			
			for(int i=0;i<m;i++) {
				int left = sc.nextInt();
				int right = sc.nextInt();
				
				kstart[left-1]++;
				kend[right-1]++;
				
			}
			
			coin_boxs[0] = kstart[0];
			int max = coin_boxs[0];
			for(int i=1;i<n;i++) {
				coin_boxs[i] = coin_boxs[i-1] + (kstart[i] - kend[i-1]); 
				max = Math.max(max, coin_boxs[i]);
			}
			
			int[] no_coins = new int[max+1];
			
			for(int i=0;i<n;i++) {
				no_coins[coin_boxs[i]]++;
			}
			
			
			for(int i=max-1;i>=0;i--) {
				no_coins[i] += no_coins[i+1]; 
			}

			int no_queries = sc.nextInt();
			for(int i=0;i<no_queries;i++) {
				int q = sc.nextInt();
				if(q>max) {
					System.out.println(0);
					continue;
				}
				
				System.out.println(no_coins[q]);
			}
			
		}

	}

}
