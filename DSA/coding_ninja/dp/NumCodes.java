package dp;

import java.util.Scanner;

public class NumCodes {

	static int num_codes(int[] arr, int size) {
		
		if(size==0 || size==1)
			return 1;
		
		int output = num_codes(arr, size-1);
		
		if(arr[size-2]*10+arr[size-1] <=26) {
			output+= num_codes(arr, size-2);
		}
		return output;
		
	}

	static int num_codes2(int[] arr, int size) {
		
		if(size==0 || size==1)
			return 1;
		
		if(arr[size]>0)
			return arr[size];
		
		int output = num_codes2(arr, size-1);
		if(arr[size-2]*10+arr[size-1] <=26) {
			output+= num_codes2(arr, size-2);
		}
		arr[size] = output;
		
		return output;
		
	}
	static final int moduloBy = 1000000007;
	
	static long num_codes_itr(int[] input, int size) {
		
		long[] arr = new long[size+1];
		
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i=2;i<=size;i++) {
			if(input[i-1]==0 && input[i-2]==0)
				return 0;
			arr[i] = arr[i-1];
			if(input[i-2]*10+input[i-1]<=26)
				arr[i] = (arr[i]%moduloBy + arr[i-2]%moduloBy)%moduloBy;
				
		}
		
		
		return arr[size];
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		while(n-->0) {
			String s = sc.next();
			int[] arr = new int[s.length()];
			for(int i=0;i<s.length();i++) {
				
				arr[i] = Integer.parseInt(s.charAt(i)+"");
				
			}
			System.out.println(num_codes_itr(arr, s.length()));
		}
		
		
	}

}
