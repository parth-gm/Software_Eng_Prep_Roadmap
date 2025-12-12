package numbertheory2;

import java.util.HashMap;
import java.util.Scanner;

public class CardGame {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		long k = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) 
		{
			arr[i] = sc.nextInt();	
			
			
		}
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		get_prime_factors(12, map);
//		System.out.println(map);
		System.out.println(no_ways(arr, n, k));
	
	}

	private static long no_ways(long[] arr, int n, long k) {
		HashMap<Integer, Integer>  primesK = new HashMap<>();
		get_prime_factors(k, primesK);
		
		HashMap<Integer, Integer> curMap = new HashMap<Integer, Integer>();
		System.out.println(primesK);
		long nways=0;
		int i=0;
		for(int j=0;j<n;j++) {
			
			
			while(i<n) {
				add_to_map(arr[i], curMap);
				
				if(checkDivisible(curMap, primesK)) {
					System.out.println(n-i);
					nways+=(n-i);
					i++;
					break;
				}
				i++;
			}
			remove_from_map(arr[j], curMap);
		}
		return nways;
	}

	private static boolean checkDivisible(HashMap<Integer, Integer> curMap, HashMap<Integer, Integer> primesK) {
		
		for(int pk:primesK.keySet()){
			if(curMap.getOrDefault(pk, 0)<primesK.get(pk)) {
				return false;
			}
		}
		
		return true;
	}

	private static void add_to_map(long no, HashMap<Integer, Integer> primeMap) {
		for(int i=2;i*i<=no;i++) {
			int count=0;
			while(no%i==0) {
				no=no/i;
				count++;
			}
			if(count>0)
				primeMap.put(i , primeMap.getOrDefault(i, 0)+count);
		}
		if(no>1) {
			primeMap.put((int)no, primeMap.getOrDefault((int)no, 0)+1);
		}
		
	}
	
	private static void remove_from_map(long no, HashMap<Integer, Integer> primeMap) {
		
		for(int i=2;i*i<=no;i++) {
			int count=0;
			while(no%i==0) {
				no=no/i;
				count++;
			}
			if(count>0)
				primeMap.put(i , primeMap.get(i)-count);
		}
		if(no>1) {
			primeMap.put((int)no, primeMap.get((int)no)-1);
		}
		
	}
	
	private static void get_prime_factors(long no, HashMap<Integer, Integer> primeMap) {
		for(int i=2;i*i<=no;i++) {
			int count=0;
			while(no%i==0) {
				no=no/i;
				count++;
			}
			
			if(count>0)
				primeMap.put(i , count);
		}
		if(no>1) {
			primeMap.put((int)no, 1);
		}
		
	}
}
