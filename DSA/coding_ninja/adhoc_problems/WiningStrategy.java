package adhoc_problems;

import java.util.Scanner;

public class WiningStrategy {

	
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		int noTests = sc.nextInt();
		while(noTests-->0) {
			int n = sc.nextInt();
			int[] arr= new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
				
			}
			checkWiningStrategy(arr, n);
		}
		

	}

	private static void checkWiningStrategy(int[] arr, int n) {
		int count=0;
		for(int i=n-1;i>=2;i--) {
			
			if(arr[i]==(i+1)) {
				continue;
			}
			else if(Math.abs(arr[i]-(i+1))<=2){
				if(arr[i-1] == (i+1)) {
					count++;
					int tmp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = tmp;
				}else if(arr[i-2]==(i+1)) {
					count+=2;
					arr[i-2] = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = i+1;
				}else {
					System.out.println("NO");
					return;
				}
			}else {
				System.out.println("NO");
				return;
			}
		}
		if(arr[0]==2 && arr[1]==1) {
			count++;
			System.out.println("YES");
			System.out.println(count);
		}else if(arr[0]==1 && arr[1]==2) {
			System.out.println("YES");
			System.out.println(count);
		}
		else {
			System.out.println("NO");
		}
	}

}
