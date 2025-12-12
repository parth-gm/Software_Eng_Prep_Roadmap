package Sorting;

import java.io.*;
import java.util.*;

class Pair{
	int start, end;
	public Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class ChefRestarunt {

	public static int index(int arr[],int start,int end,int value)
	{
	    if(start<=end)
	    {
	        int mid=(start+end)/2;
	        if(arr[mid]==value)
	        return mid;
	        if(arr[mid]>value)
	        return index(arr,start,mid-1,value);
	        return index(arr,mid+1,end,value);
	        
	    }
	    return start-1;
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	
	
	public static void main(String[] args) {
		try {
			FastScanner sc = new FastScanner();
			int noTest = sc.nextInt();
			
			for(int i=0;i<noTest;i++) {
				int N = sc.nextInt();
				int M = sc.nextInt();
	
				int[] intervals = new int[2*N];
				
				for(int j=0;j<2*N;j++) {
					intervals[j] = sc.nextInt();
				}
				Arrays.sort(intervals);
				
				
				for(int k=0;k<M;k++) {
					int x = sc.nextInt();
					if(x>=intervals[intervals.length-1])
						System.out.println("-1");
					else if(x<intervals[0]) {
						System.out.println(intervals[0]-x);
					}
					else {
						int pos = index(intervals, 0, intervals.length-1, x);
						if((pos%2)==0) {
							System.out.println("0");
						}
						else {
							System.out.println(intervals[pos+1]-x);
						}
					}
				}
				
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}

//	static int findWaitingTime(Pair[] intervals, int n, int tofind) {
//	
//		int start = 0, end = n-1, ans = n;
//		while(start<=end){
//			int mid =  start + (end-start)/2;
//			
//			if(intervals[mid].start == tofind || intervals[mid].start > tofind)
//			{
//				ans = mid;
//				end = mid -1;
//			}else if(intervals[mid].start <tofind)
//			{
//				start = mid+1;
//			}
//		}
//		
//		if((ans==n && tofind>=intervals[n-1].end) )
//			return -1;
//		else if(ans>0 && intervals[ans-1].end>tofind)
//			return 0;
//		
//		return intervals[ans].start - tofind;
//		
//	}

}
