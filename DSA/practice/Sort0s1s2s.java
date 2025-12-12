package practice;

public class Sort0s1s2s {

	static void sort(int[] arr) {
		
		int m=0,l=0,h=arr.length-1;
		
		while(m<=h) {
			
			if(arr[m]==0) {
				
				int temp=arr[m];
				arr[m]=arr[l];
				arr[l]=temp;
			
				l++;
				m++;
				
			}else if(arr[m]==1) {
				m++;
			}
			else {
				int temp=arr[m];
				arr[m]=arr[h];
				arr[h]=temp;
				h--;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			
			System.out.println(arr[i]);
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {0,1,2,0,1,2};
		sort(arr);
	}

}
