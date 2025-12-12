package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution2 {


	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter total no of Cities:");
		int noNodes=sc.nextInt();
		
//		HashSet<String> set=new HashSet<String>(noNodes);
//		
		int[][] graph=new int[noNodes][noNodes];
		
		System.out.println("Enter total no of edges:");
		int noedge=sc.nextInt();
		
		System.out.println("Enter All Connected Edges:");
		for(int i=0;i<noedge;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			graph[a][b]=1;
			graph[b][a]=1;
				
		}
		
		//findHamiltaonCycle(0);
		
		
		
		
	}

}
