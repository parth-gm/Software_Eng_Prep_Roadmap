package strings;

import java.util.Scanner;

public class LongestPalindromSubString {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		System.out.println(longestPalindromSubBasic(s));
		System.out.println(longestPalOptimized(sc.next()));

	}

	private static int longestPalOptimized(String s) {
		int max = 0;
		for(int i=0;i<s.length();i++) {
			int l = i-1;
			int r = i+1;
			while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
				l--;
				r++;
			}
			max = Math.max(max, r-l-1);
			
			l = i;
			r = i+1;
			while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
				l--;
				r++;
			}
			
			max = Math.max(max, r-l-1);
			
		}
		
		return max;
		
		
		
	}
	
	//O(n^3) Approach
	private static int longestPalindromSubBasic(String s) {
		int max = -1;
		for(int i=0;i<s.length();i++) {
			for(int j=i;j<s.length();j++) {
				int len = j-i+1;
				if (checkPal(s.substring(i, j+1))) {
					max = Math.max(max, len);
				}
			}
		}
		return max;
	}

	private static boolean checkPal(String substring) {
		// TODO Auto-generated method stub
		int i =0, j= substring.length()-1;
		while(i<=j) {
			if(substring.charAt(i)!=substring.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
