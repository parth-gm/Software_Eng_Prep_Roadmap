package Ch_05_Bit_Manupilation;

import java.util.Scanner;

public class Insertion {

	
	static int insertion(int i,int j,int N,int M) {
		
		
		if(i>j||j>=32||i<0) {
			return 0;
		}
		
		int allones=~0;
		
		int left=(j<31)?allones<<(j+1):0;
		
		System.out.println("left: "+Integer.toBinaryString(left));
		
		int right=(1<<i)-1;//OR ~(allones<<i)
		
		
		System.out.println("right: "+Integer.toBinaryString(right));
		
		int mask=left|right;
		
		System.out.println("mask: "+Integer.toBinaryString(mask));
		
		int newN=mask&N;
		
		System.out.println("newN: "+Integer.toBinaryString(newN));	
		
		return newN|(M<<i);
		
	}
	
	public static void main(String[] args) {
	
		Scanner	sc=new Scanner(System.in);
		
		String N=sc.next();
		String M=sc.next();
		
		int i=sc.nextInt();
		int j=sc.nextInt();
		
		int output=insertion(i, j, Integer.parseInt(N, 2), Integer.parseInt(M, 2));
		
		System.out.println(Integer.toBinaryString(output));
		
		
	}
	
	
	
	
	
}
