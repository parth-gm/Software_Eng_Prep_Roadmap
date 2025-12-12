package language_tools;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HussainSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			int noEle = sc.nextInt();
			int noQuery = sc.nextInt();
			long[] arr= new long[noEle];		
			
			for(int i=0;i<noEle;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			int rptr = arr.length -1;
			Queue<Long> queue = new LinkedList<>();
			int curCount = 0;
			for(int i=1;i<=noQuery;i++) {
				int value = sc.nextInt();
				long ans = Long.MIN_VALUE;
				while(curCount<value) {
					
					if(rptr>=0 && (queue.isEmpty() || (queue.peek()<=arr[rptr])))
					{
						ans= arr[rptr];
						rptr--;	
					}else {
						long first=queue.poll();
						ans = first;
					}
					System.out.println(ans/2);
					queue.add(ans/2);
					curCount++;
				}
				
				System.out.println(ans);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
