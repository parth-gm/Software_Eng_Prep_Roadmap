package language_tools;

import java.util.ArrayList;
import java.util.HashSet;

public class LongestConsucativeSeq {

	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		
		ArrayList<Integer> ansList = new ArrayList<>();
        HashSet<Integer> hset = new HashSet<>();
        for(int i=0;i<arr.length;i++) {
        	hset.add(arr[i]);
        }
        int max=0;
        for(int i=0;i<arr.length;i++) {
        	if(!hset.contains(arr[i]-1)) {
        		
        		int currentNo = arr[i];
        		int count = 1;
        		while(hset.contains(currentNo+1)) {
        			
        			currentNo+=1;
        			count++;
        		}
        		if(count>max) {
        			ansList.clear();
        			ansList.add(arr[i]);
        			ansList.add(currentNo);
        		}
        		
        		max = Math.max(count, max);
        		
        	}
        }
        return ansList;
        
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		System.out.println(longestConsecutiveIncreasingSequence(arr));
	}

}
