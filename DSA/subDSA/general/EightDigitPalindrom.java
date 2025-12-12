package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.io.*;
public class EightDigitPalindrom {

	public static void main(String[] args) {
		
		
		 List<Integer> al = new ArrayList<Integer>();
	        al.add(10);
	        al.add(20);
	        al.add(30);
	        al.add(40);
	  
	        // ArrayList to Array Conversion
	        long[] arr = al.stream().mapToLong(i -> i).toArray();
	        System.out.println(arr[0]);
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

//		for(int i=1;i<=9;i++) {
//			for(int j=0;j<=9;j++) {
//				for(int k=0;k<=9;k++) {
//					for(int l=0;l<=9;l++) {
//						String s = ""+i+j+k+l+l+k+j+i;
//						System.out.println(s);
//					}
//				}
//			}
//		}

	}

}
