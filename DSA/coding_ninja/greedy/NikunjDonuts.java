package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class NikunjDonuts {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int tests = sc.nextInt();
		while(tests-->0) {
			
			int n = sc.nextInt();
			int carray[] = new int[n];
			for(int i=0;i<n;i++) {
				carray[i] = sc.nextInt();
			}
			
			Arrays.sort(carray);
			long min_sum = 0;
			for(int i=n-1,j=0;i>=0;i--,j++) {
				
				min_sum+=(long)carray[i]*Math.pow(2, j);
			}
			System.out.println(min_sum);
		}

	}

}
