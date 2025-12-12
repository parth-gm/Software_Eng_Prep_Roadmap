package practice;

public class AllSubsequence {

	
	static String[] findSubsequence(String str)
	{
		if(str.length()==0) {
			String ans[]= {""};
			return ans;
		}
		String smallAns[]=findSubsequence(str.substring(1));
		String ans[]=new String[2*smallAns.length];
		
		for(int i=0;i<smallAns.length;i++) {
			
			ans[i]=smallAns[i];
			
		}
		for(int i=0;i<smallAns.length;i++) {
			ans[i+smallAns.length]=str.charAt(0)+smallAns[i];
		}
		
		return ans;
		
		
		
	}
	
	public static void main(String[] args) {
		
		for(String s:findSubsequence("abcd")) {
			
			System.out.println(s);
			
		}

	}

}
