package time_space;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TripletSum {

	static ArrayList<Integer[]> get2SumList(int[] arr, int start, int end, int target){
		ArrayList<Integer[]> arrl = new ArrayList<>();
		
		while(start<end) {
			int sum = arr[start] + arr[end];
			if(sum<target) {
				start++;
			}else if(sum>target) {
				end--;
			}else {
				Integer[] temp = {arr[start], arr[end]};
				arrl.add(temp);
				start++;
				end--;
			}
		}
		return arrl;
	
	}
	
	static int get2SumListDup(int[] arr, int start, int end, int target){
		int count=0;
//		HashMap<Integer, Integer> hmap = new HashMap<>();
//		for(int i=start;i<end;i++) {
//			if(hmap.containsKey(target-arr[i])) {
//				count+=hmap.get(target-arr[i]);
//			}
//			hmap.put(arr[i], hmap.getOrDefault(hmap.get(arr[i]), 0)+1);
//		}
//		return count;
		
		while(start<end) {
			int sum = arr[start] + arr[end];
			if(sum<target) {
				start++;
			}else if(sum>target) {
				end--;
			}else 
			{
				if(arr[start]==arr[end]) {
					int totalEle = end-start+1;
					count+=(totalEle*(totalEle-1)/2);
					return count;
				}
				else {
					int rcount=0, lcount=0;
					while(end>start && arr[end]==arr[end-1])
					{	
						end--;
						rcount++;
					}
					while(end>start && arr[start]==arr[start+1]) {
						start++;
						lcount++;
					}
					
					count+=(lcount+1)*(rcount+1);
					
				}
				end--;
				start++;
			}
		}
		return count;
	}
	
	static int get3SumListDup(int[] arr, int target){
		
		int count=0;
		Arrays.sort(arr);
		for(int i=0;i<arr.length-2;i++) {
			int newTarget =  target - arr[i];
			count +=  get2SumListDup(arr, i+1, arr.length-1,newTarget);
		
		}
		return count;
		
	}
	
	static ArrayList<Integer[]> get3SumList(int[] arr, int target){
		
		ArrayList<Integer[]> arrl = new ArrayList<>();
		Arrays.sort(arr);
		for(int i=0;i<arr.length-2;i++) {
			if(i!=0 && arr[i]==arr[i-1])
				continue;
			int newTarget =  target - arr[i];
			ArrayList<Integer[]>  twoSumOp =  get2SumList(arr, i+1, arr.length-1,newTarget);
			for(Integer[] temp: twoSumOp) {
				Integer[] op = {arr[i], temp[0], temp[1], };
				arrl.add(op);
			}
		
		}
		return arrl;
		
	}
	public static void main(String[] args) {
		//int arr[] = {6, 1, 6, 5, 3, 2, 5, 0, 5, 6, 0 };
		//int arr[]= {2, -5, 8 ,-6, 0, 5, 10, 11, -3};
		int arr[]= {2,2,2,2,2};
		
		ArrayList<Integer[]> arrl = get3SumList(arr,5);
		for(Integer[] ans:arrl) {
			System.out.println(Arrays.toString(ans));
		}
		
		System.out.println(get3SumListDup(arr, 6));
		
	}	

}
