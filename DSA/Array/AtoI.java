package questions;

public class AtoI {

	static int atoI(String str)
	{
		str = str.strip();
		int result=0;
		if(str.length() == 0 )
			return result;
		
		int sign = str.charAt(0)=='-'?-1:+1;
		
		for(int i=0;i<str.length();i++) {
			
			if(i==0 && (str.charAt(i)=='+' || str.charAt(i)=='-'))
				continue;
			
			if( str.charAt(i)>='0' && str.charAt(i)<='9')
			{
				if(result > Integer.MAX_VALUE / 10 ||
	                    (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10))
					return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
				else
					result = result*10 + (str.charAt(i)-'0');
			}
			else {
				return sign*result;
			}
			
		}
		
		return sign*result;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="42"; //42
		String s1="  -42" ;//-42
		String s2 = "4193 with words"; //4193
		String s3 = "words and 987";
		String s4 =  "-91283472332"; // -2147483648
		String s5 ="  -0012a42";
		String s6 ="2147483648";
		System.out.println(atoI(s6));
		
		

	}

}
