package strings;

public class PatternMatch {

	public static void main(String[] args) {
		String s = "ilovecodingd";
		String p = "coding";
		
		System.out.println(isMatch(s, p));
		
	}
	
	//O(n*m) basic approach
	static boolean isMatch(String s, String p) {
		
		for(int i=0;i<=(s.length()-p.length());i++) {
			boolean isFound = true;
			for(int j=0;j<p.length();j++) {
				if(s.charAt(i+j)!=p.charAt(j)) {
					isFound = false;
					break;
					
				}	
			}
			if(isFound) {
				return true;
			}
			
		}
		
		
		return false;
	}
	
}
