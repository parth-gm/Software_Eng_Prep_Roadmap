package adv_recursion;

import java.util.HashMap;
import java.util.Scanner;

public class ReturnKeyPadCode {

	private static int recursiveSol(int n, String[] output, String[] strMap) {
		if(n==0) {
			output[0] = "";
			return 1;
		}
		
		int smallN = n/10;
		int smallLen = recursiveSol(smallN, output, strMap);
		int charsLen = strMap[n%10].length();
		
		for(int j=1;j<charsLen;j++)
		{
			
			for(int i=0;i<smallLen;i++) {
		
			
				output[i+(smallLen*j)] = output[i]; 
			
			}
		}
		int count=0, index=0;
		for(int i=0;i<charsLen*smallLen;i++) {
			if(count==smallLen)
			{
				index++;
				count=0;
			}
			output[i] = output[i]+ strMap[n%10].charAt(index);
			count++;
		}
		return charsLen*smallLen;
	}
	
	static void printKeyPadV2(int n, String output, String[] strMap) {
		
		if(n==0) {
			System.out.println(output);
			return;
		}
		
		String mapStr = strMap[n%10];
		
		for(int i=0;i<mapStr.length();i++) {
			printKeyPadV2(n/10, mapStr.charAt(i)+output, strMap);
		}
		
	}
	
	public static void main(String[] args) {
		
		String strMap[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};		
		Scanner sc = new Scanner(System.in);
		int noTests = sc.nextInt();
		while(noTests-->0) {
			int n = sc.nextInt();
			
			printKeyPadV2(n, "", strMap);
			
//			String[] output = new String[1000000];
//			int len = recursiveSol(n, output, strMap);
//			for(int i=0;i<len;i++) {
//				System.out.println(output[i]);
//			}
		}
		
		
	}

	

}
