package leetcode;

public class CountAndSay {

	/*dd
	 * Input: n = 4
		Output: "1211"
		Explanation:
		countAndSay(1) = "1"
		countAndSay(2) = say "1" = one 1 = "11"
		countAndSay(3) = say "11" = two 1's = "21"
		countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
	 * 
	 */
	
	static String countAndSay(int n) {
		String ans = "1";
		for(int i=1;i<n;i++) {
			ans= formString(ans);
		}
		return ans;
	}
	
	static String formString(String s) {
		
		char previousChar = '\0';
		StringBuilder sb = new StringBuilder("");
		int count=1;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==previousChar) {
				count++;
			}else {
				if(previousChar!='\0')
				{
					sb.append(count);
					sb.append(previousChar);
				}
				count=1;
			}
			previousChar = s.charAt(i);
			
		}
		
		
		sb.append(count);
		sb.append(previousChar);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}

}
