	package adv_recursion;

import java.util.Scanner;

public class RecurStringLength {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(getLength(str));
		System.out.println(removeX(str));
		System.out.println(replaceX(str,'c', 'x'));
		System.out.println(removeConsDup(str));

	}

	static int getLength(String str) {
		if(str.equals(""))
			return 0;
		
		return 1+ getLength(str.substring(1));
		
	}

	static String removeX(String str) {
		if(str.equals(""))
			return "";
		
		if(str.charAt(0)!='X') {
			return str.charAt(0) + removeX(str.substring(1));
		}else {
			
			
			return removeX(str.substring(1));
		}		
		
	}
	
	static String replaceX(String str, char x, char c) {
		
		if(str.length()==0)
			return str;
		
		char y = str.charAt(0);
		if(str.charAt(0)==x) {
			y = c;
			str = y+ str.substring(1);
		}
		
		return y + replaceX(str.substring(1), x, c);
	}
	
	static String removeConsDup(String str) {
		
		if(str.length()<=1)
			return str;
		
		if(str.charAt(0)==str.charAt(1))
		{
			return removeConsDup(str.substring(1));
		}
		else
			return str.charAt(0) + removeConsDup(str.substring(1));
		
	}
	
}
