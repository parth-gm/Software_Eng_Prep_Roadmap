package nick_white;

public class KadaneMaxSumSubArray {

	
	static int kadaneAlgo(int[] arr) {
		
		int maxsum=arr[0];
		int cursum=maxsum;
		
		for(int i=1;i<arr.length;i++) {
			
			cursum=Math.max(arr[i], cursum+arr[i]);
			maxsum=Math.max(maxsum, cursum);
			
		}
		
		return maxsum;
		
	}
	
	static int findMaxSubArray(int[] inArr) {
		int maxsum=Integer.MIN_VALUE;
		for(int i=0;i<inArr.length-1;i++) {
			int cursum=inArr[i];
			int sum=cursum;
			for(int j=i+1;j<inArr.length;j++) {
				sum=sum+inArr[j];
				//System.out.println(sum);
				if(cursum<sum){
					cursum=sum;
				}
			}
			//System.out.println("final itr "+cursum);
			if(cursum>maxsum)
				maxsum=cursum;
		}
		
		return maxsum;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inArr= {1,2,3};
		System.out.println(findMaxSubArray(inArr));
		System.out.println(kadaneAlgo(inArr));
	}

}
