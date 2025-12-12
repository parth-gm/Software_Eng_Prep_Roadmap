package TenDaysCode;

import java.util.Scanner;

public class Hulk {

	static int countSteps(int n) {

		
		int no=n,count=0;
		while(no>0) {
			if(no%2==1)
				count++;
			no=no/2;
		}
		
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	
		int noTest=sc.nextInt();
		
		for(int i=0;i<noTest;i++) {
			int n=sc.nextInt();
			System.out.println(countSteps(n));
		}
		
	}

}
