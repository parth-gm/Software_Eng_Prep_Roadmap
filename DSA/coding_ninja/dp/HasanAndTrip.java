package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HasanAndTrip {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		while(tests-->0) {
			
			int n = sc.nextInt();
			Pair[] pairs = new Pair[n];
			for(int i=0;i<n;i++) {
				pairs[i] = new Pair(sc.nextInt(), sc.nextInt(), sc.nextInt());				
			}
			double[] output = new double[n];
			Arrays.fill(output, Integer.MIN_VALUE);
			System.out.printf("%.6f%n", getMaximumScore(pairs, n-1, 0, output));
			//System.out.print(getMaximumScore(pairs, n-1, 0));
			
		}

	}
	
	private static double getMaximumScore(Pair[] pairs, int end, int start, double[] output) {
		
		if(start == end) {
			return pairs[end].fi;
		}
		
		int dstart = start;
		double max = Integer.MIN_VALUE;
		if(output[dstart]!=Integer.MIN_VALUE)
			return output[dstart];
		
		for(int i=start+1;i<=end;i++) {
			double distance =  calculateDistance(dstart, i, pairs) ;
			
		//	System.out.println("start= "+dstart+"Calling ("+i+", "+end+")");
			//System.out.println("Distance:" + distance);
			double score = getMaximumScore(pairs, end, i, output) + (pairs[dstart].fi - distance) ;
			
			max = Math.max(max, score);
		}
		//System.out.println("Max Score: "+max);
		output[dstart] = max;
		return max;
	}

	private static double calculateDistance(int dstart, int i, Pair[] pairs) {
		
		return Math.sqrt((Math.pow(pairs[i].x-pairs[dstart].x, 2))+(Math.pow(pairs[i].y-pairs[dstart].y, 2)));
		
	}

	
}

class Pair{
	
	int x, y, fi;
	
	public Pair(int x, int y, int fi) {
		this.x =x;
		this.y =y;
		this.fi =fi;
	}
	
}
