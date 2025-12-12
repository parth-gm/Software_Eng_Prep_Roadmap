package practice;

import java.util.Scanner;

public class Atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		String s=sc.next();
		boolean isValid=true;
		int result=0,p=0;
		for(int i=0;i<s.length();i++) {
			
			if((s.charAt(i)-'0')>=1 && (s.charAt(i)-'0')<=9) {
				result= ((10*result)+(s.charAt(i)-'0'));
				p++;
			
			}else {
				isValid=false;
				break;
			}

			
		}
		
		if(isValid) {
			System.out.println(result);
		}else {
			System.out.println("Not convertible");
		}
		
		
	}

}
