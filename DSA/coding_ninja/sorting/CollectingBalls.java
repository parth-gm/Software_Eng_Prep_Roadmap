package Sorting;

import java.util.PriorityQueue;
import java.util.Scanner;

public class CollectingBalls {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int noTest = sc.nextInt();
		while(noTest-->0) {
			long no = sc.nextLong();
			System.out.println(findmink(no));
		}
		
		
	}

	private static long findmink(long no) {
		// TODO Auto-generated method stub
		long start=1, end=no, ans =1;
		while(start<=end) {
			long mid = (start+end)/2;
			if(checkSatisfy(no, mid)) {
				ans = mid;
				end = mid -1;
			
			}else {
				start = mid +1;
			}
		}
		return ans;
	}

	private static boolean checkSatisfy(long no, long mid) {
	
		long intial = no, ballSharma = 0, ballSingh = 0;
		while(no>=mid) {
			ballSharma+=mid;
			no = no-mid;
			ballSingh += (no/10);
			no = no-(no/10);
			if(ballSingh>=(intial/2))
				return false;
		}
		return true;
	}
	
}
