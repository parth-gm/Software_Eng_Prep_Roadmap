package array;

import java.util.HashMap;

public class CountPairWithKSum {

	public static void main(String[] args) {
		
		int[] arr ={10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
//		int[] arr = {1,2, 2,4,4, 3, 3, 2,3};
		System.out.println(getCountofPairs(arr, 11));

	}

	private static int getCountofPairs(int[] arr, int K) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
//		for(int i=0;i<arr.length;i++) {
//			
//		}
		int count =0;
		for(int i=0;i<arr.length;i++) {
			
			if(map.get(K-arr[i])!=null) {
				count+=map.get(K-arr[i]);
			}
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
//			if(arr[i]==(K-arr[i])) {
//				count--;
//			}
//			
		}
		return count;
		
	}

}
