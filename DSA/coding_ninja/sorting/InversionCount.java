package Sorting;

public class InversionCount {
	static long inversionCount=0;
    public static long getInversions(long arr[], int n) {
        int  start = 0, end=n-1;
//        System.out.println(start+" " + end);
        return applyMergeSort(arr, start, end);
    }
	
	static long applyMergeSort(long[] arr, int  start, int end) {
		//System.out.println(start + " " + end);
		if(start<end) {
        	int mid = start + (end - start)/2;
        	long curLeft = applyMergeSort(arr, start, mid);
//        	System.out.println("applyMerge("+start+", "+mid+")");
        	long curRight = applyMergeSort(arr, mid+1, end);
//        	System.out.println("applyMerge("+(mid+1)+", "+end+")");
        	long out=mergeAndGetInversions(arr, start, mid, end);
//        	System.out.println("mergeAndGetInversions("+start +", "+ mid+", "+ end+")");
//        	System.out.println("Intet: "+out);
        	return curLeft + curRight + out;
        	
        }
		return 0;
		
	}

	 static long mergeAndGetInversions(long[] arr, int start, int mid, int end) {
		int lsize = mid-start +1;
		int rsize = end - mid;
		long larr[] = new long[lsize];
		long rarr[] = new long[rsize];
		
		for(int i=0;i<lsize;i++) {
			larr[i] =  arr[i+start];
		}
		
		for(int i=0;i<rsize;i++) {
			rarr[i] =  arr[i+mid+1];
		}
		
		int lptr = 0 ,rptr = 0 ; 
		int index = start;
		long tempIcount = 0;
		while(lptr<lsize && rptr<rsize) {
			
			if(larr[lptr] > rarr[rptr]) {
				arr[index] = rarr[rptr];
				rptr++;
				
				tempIcount+= (lsize - lptr);
			
			}
			else {
				arr[index] = larr[lptr];
				lptr++;
				
			}
			index++;
		}
		
		while(lptr<lsize)
			arr[index++] =  larr[lptr++];
		
		while(rptr<rsize)
			arr[index++] =  rarr[rptr++];
		
		
		
		return tempIcount;
	}

	public static void main(String[] args) {
		long[] arr= {2,5,1,3,4};
		System.out.println(getInversions(arr, 5));

	}

}
