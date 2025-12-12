package language_tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class removeDuplicates {

	static List<Integer> removeDuplicates(List<Integer> ls){
		
//		HashSet<Integer> hs = new HashSet<>();
//		ArrayList<Integer> resultArr = new ArrayList<>();
//		for(int ele: ls) {
//			if(!hs.contains(ele)) {
//				resultArr.add(ele);
//			}
//		}
		
		ArrayList<Integer> resultArr = new ArrayList<>();
		Collections.sort(ls);
		int prev = Integer.MIN_VALUE;
		for(int ele:ls) {
			if(ele!=prev) {
				resultArr.add(ele);
			}
			prev = ele;
		}
		
		return resultArr;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4,5,1,5,2};
		List<Integer> arrl = new ArrayList<Integer>();
		for(int ele:arr) {
			arrl.add(ele);
		}
		System.out.println(removeDuplicates(arrl));

	}

}
