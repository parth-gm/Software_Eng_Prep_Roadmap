package dp;

public class LongestPalindrom {
		
	public static String longestPalindrome(String s) {
		if(s.length()==0) {
			return "";
		}
		
	    String longestPal = ""+s.charAt(0);
	    int maxLength = 1;
	    
	    
	    
		for(int i=1;i<s.length();i++) {
			
			int leftDiff = i;
			int rightDiff = s.length()-i-1;
//			int diff = leftDiff<rightDiff?leftDiff:rightDiff;
		
			String odd = "", even= "";
			
			if(i<=(s.length()/2)) {
				
				System.out.println("odd:"+(i-leftDiff)+","+(i+leftDiff+1));
				System.out.println("even:"+(i-leftDiff)+","+(i+leftDiff));
				
				
				odd = checkPal(s.substring(i-leftDiff, i+leftDiff+1));
				even = checkPal(s.substring(i-leftDiff, i+leftDiff));
			
			}else {
				
				System.out.println("odd:"+(i-rightDiff)+","+(i+rightDiff+1));
				System.out.println("even:"+(i-rightDiff-1)+","+(i+rightDiff+1));
				
				odd = checkPal(s.substring(i-rightDiff, i+rightDiff+1));
				even = checkPal(s.substring(i-rightDiff-1, i+rightDiff+1));
			
			}
			
			
			
			String currentMaxLenString = odd.length()<even.length()?even:odd;
			
			if(currentMaxLenString.length()>maxLength)
			{
				maxLength = currentMaxLenString.length();
				longestPal = currentMaxLenString;
			}
			
			
		}
		
	     return longestPal;   
	}
	
	public static String checkPal(String s) {
		if(s.length()==1)
			return ""+s.charAt(0);
		
		int left = (s.length()/2)-1;
		int right = (s.length()%2)==0?s.length()/2:(s.length()/2)+1;
		
		while(left>=0) {
			
			if(s.charAt(left)!=s.charAt(right)) {	
				return s.substring(left+1, right);
			}
			left--;
			right++;
			
		}
		return s.substring(left+1, right);
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(longestPalindrome("abba"));

	}

}
