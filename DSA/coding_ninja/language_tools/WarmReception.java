package language_tools;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WarmReception {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}

		int[] drr=new int[n];
		for(int i=0;i<n;i++) {
			drr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		Arrays.sort(drr);
		int j=0, chairs=0;
		for(int i=0;i<n;i++) {
			
			if(arr[i]<drr[j]) {
				chairs++;
				continue;
			}
			j++;
		}
		System.out.println(chairs);
		
	}

}
