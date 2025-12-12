package time_space;

import java.util.Arrays;
import java.util.Scanner;

public class ProductWithoutDiv {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int noTest = sc.nextInt();
		
		
		for(int i=0;i<noTest;i++) {
			int n = sc.nextInt();
			long[] prodArr = new long[n];
			int arr[] = new int[n];
			for(int j=0;j<n;j++) {
				arr[j] = sc.nextInt();
			}
			long lp =1;
			for(int k=0;k<n;k++) {
				prodArr[k] =lp;
				lp = arr[k]*lp;
			}
			long rp =1;
			for(int k=n-1;k>=0;k--) {
				prodArr[k] =rp*prodArr[k];
				rp = arr[k]*rp;
			}
			
			System.out.println(Arrays.toString(prodArr));
		}
		
	}

}
