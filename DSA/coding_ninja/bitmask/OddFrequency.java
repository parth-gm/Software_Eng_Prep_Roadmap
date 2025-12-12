package bit_mask;

import java.util.Scanner;

public class OddFrequency {

	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		while(tests-->0) {
			
			int n = sc.nextInt();
			int xorsum = 0;
			for(int i=0;i<n;i++) {
				
				xorsum = xorsum^sc.nextInt();
				
			}
			System.out.println(xorsum);
			
		}
		
	}

}
