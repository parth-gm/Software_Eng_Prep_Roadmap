package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * Java Program sort an integer array using radix sort algorithm.
 * input: [80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50]
 * output: [0, 10, 20, 30, 40, 50, 50, 60, 70, 80, 90]
 * 
 * Time Complexity of Solution:
 *     Best Case O(n); Average Case O(n); Worst Case O(n^2).
 * 
 */

public class BuckeSort {

	private static int[] hash(int[] input) {
	    int m = input[0];
	    for (int i = 1; i < input.length; i++) {
	      if (m < input[i]) {
	        m = input[i];
	      }
	    }
	    return new int[] { m, (int) Math.sqrt(input.length) };
	  }

	  private static int hash(int i, int[] code) {
	    return (int) ((double) i / code[0] * (code[1] - 1));
	  }

	
	public static void bucketSort(int[] input) {
		final int[] code=hash(input);
		System.out.println("MAX and NO of BUCKETS "+code[0]+" "+code[1]);
		
		List[] buckets=new List[code[1]];
		
		for (int i = 0; i < code[1]; i++) {
		      buckets[i] = new ArrayList();
		 }
		
		for (int i : input) {
		      buckets[hash(i, code)].add(i);
		 }
		System.out.println(buckets[0].toString());
		System.out.println(buckets[1].toString());
		System.out.println(buckets[2].toString());
		
		    // sort each bucket O(n)
	    for (List bucket : buckets) {
	      Collections.sort(bucket);
	    }

		System.out.println(buckets[0].toString());
		System.out.println(buckets[1].toString());
		System.out.println(buckets[2].toString());
		
		int count=0;
		for(int i=0;i<buckets.length;i++) {
			int itr=0;
			while(itr<buckets[i].size()) {
				input[count]=(int)buckets[i].get(itr);
				count++;
				itr++;
			}
		}
		
	}
	
  public static void main(String[] args) {

    System.out.println("Bucket sort in Java");
    int[] input = { 80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50 };

    System.out.println("integer array before sorting");
    System.out.println(Arrays.toString(input));

    // sorting array using radix Sort Algorithm
    bucketSort(input);

    System.out.println("integer array after sorting using bucket sort algorithm");
    System.out.println(Arrays.toString(input));

  }


}


