package array;

public class AlternativeSequenceCheck {

	
	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 3, 5};
		
//		System.out.println(checkAlternativeSequence(arr));
		System.out.println(countAlternativeSequence(arr));
		
		
		
		
	}

	private static boolean checkAlternativeSequence(int[] arr) {
		
		boolean isIncreasing = true;
		
		for(int i=1, j=0;i<arr.length;i++, j++) {
			
			
			if(j!=0 && (isIncreasing && arr[i]>arr[j]) || (!isIncreasing && arr[i]<arr[j]))
				return false;
			
			if(arr[i]>arr[j]) {
				isIncreasing = true;
			}else {
				isIncreasing = false;
			}
			
		}
		return true;
	}
	
	private static int countAlternativeSequence(int[] arr) {
		
		int count=0;
		for(int i=0;i<arr.length;i++) {
			
			int prev = i==0?1:0;
			int cur = i==0?2:1;
			int intial = i==0?1:0;
			boolean isPossible = true;
			boolean isIncreasing = false;
			for(;cur<arr.length;cur++) {
				if(cur==i)
					continue;
				
				if(prev!=intial && ((isIncreasing && arr[prev]<arr[cur]) || (!isIncreasing && arr[prev]>arr[cur]))) {
					isPossible = false;
					break;
				}
				
				if(arr[prev]<arr[cur]) {
					isIncreasing = true;
				}else {
					isIncreasing = false;
				}
				
				prev = cur;
				
			}
			System.out.println(isPossible);
			if(isPossible)
				count++;
		}
		return count;
	}
	
}
