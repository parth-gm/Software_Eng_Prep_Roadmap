package practice;

import java.util.Scanner;

public class LongestPalindrom {

	static String longestPalindrom(String s) {
		
		
		int length=s.length();
		int[][] dp= new int[length][length];
		int maxlen=1,from=0,end=0;
		
		for(int i=0;i<length;i++)
		{
			dp[i][i]=1;
		}
		
		for(int i=0;i<length-1;i++) {
			if(s.charAt(i)==s.charAt(i+1))
			{
				dp[i][i+1]=1;
				maxlen=2;
				from=i;
				end=i+1;
			}
		}

//		for(int i=0;i<length;i++) {
//			for(int j=0;j<length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
//
//		System.out.println();
		
		
		for(int i=2;i<length;i++) {
			
			for(int j=0;j<length-i;j++) {
				//System.out.println(j+" "+(i+j));
				if(s.charAt(j)==s.charAt(i+j) && dp[j+1][(i+j)-1]==1) {
					dp[j][i+j]=1;
					maxlen=i+1;
					from=j;
					end=i+j;
				}
				else {
					dp[j][i+j]=0;
				}
				
			}
			
		}
		
			
//		for(int i=0;i<length;i++) {
//			for(int j=0;j<length;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		//System.out.println("Length: "+maxlen+" Longest Palindrom from: "+from+" "+end);
		return s.substring(from,end+1);

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		String s=sc.next();
		
		System.out.println(longestPalindrom(s));
		
		
		
		
		
	}

}
