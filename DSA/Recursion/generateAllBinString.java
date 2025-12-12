package gfg;

public class generateAllBinString {

	
	static void generateAll(int[] arr,int n,int i) {
		
		if(i==n) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[j]);
			}
			System.out.println();
			return;
		}
		
		arr[i]=0;
		generateAll(arr, n, i+1);

		arr[i]=1;
		generateAll(arr, n, i+1);

		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[4];
		generateAll(arr,4, 0);
	}

}
