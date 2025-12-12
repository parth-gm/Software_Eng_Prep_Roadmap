package recursion;

import java.util.ArrayList;

public class AllPermutations {

	static void getAllPermutations(ArrayList<Integer> inputArr, int n, int current, ArrayList<Integer> permutations) {
		
		if(current==n) {
			System.out.println(permutations);
			return;
		}
		
		for(int j=0;j<=permutations.size();j++) {
			permutations.add(j, inputArr.get(current));
			getAllPermutations(inputArr, n, current+1, permutations);
			permutations.remove(j);
		}
		
	}
	/*
	 *[1] 
	 *[12, 21] 
	 *[312, 132, 123, 321, 231, 213] 
	 * 
	 * 
	 * 
	 */
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> permutations = new ArrayList<>();
		ArrayList<Integer> inputArr = new ArrayList<Integer>();
		inputArr.add(1);
		inputArr.add(2);
		inputArr.add(3);
		inputArr.add(4);
		getAllPermutations(inputArr, inputArr.size(), 0, permutations);

	}

}
