package language_tools;

import java.util.HashMap;

public class PairZero {

	public static int PairSum(int[] input, int size) {
		
		HashMap<Integer, Integer> hmap = new HashMap<>();
		int count=0;
		for(int i=0;i<size;i++) {
			
			if(hmap.containsKey(-1*input[i])) {
				count+=hmap.get(-1*input[i]);
			}
			
			hmap.put(input[i], hmap.getOrDefault(input[i], 0)+1);
			
		}
        
		return count;
        
        
	}
	
	public static void main(String[] args) {
		
		int[] arr = {-1,2, 1, -2, 2, -2};
		System.out.println(PairSum(arr, arr.length));

	}

}
