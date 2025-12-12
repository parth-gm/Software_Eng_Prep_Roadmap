package dp;

public class EditDistance {

	public static void main(String[] args) {
		
		String s1 = "abc";
		String s2 = "abc";
		
		System.out.println(getMinEditDist(s1, 0, s2, 0));
		

	}

	private static int getMinEditDist(String s1, int i, String s2, int j) {
		
		if(i==s1.length() && j==s2.length()) {
			return 0;
		}
		
		if(i==s1.length() && j!=s2.length())
		{
			return s2.length()-j;
		}
		
		if(j==s2.length() && i!=s1.length())
		{
			return s1.length()-i;
		}
		
		if(s1.charAt(i)==s2.charAt(j))
		{
			return getMinEditDist(s1, i+1, s2, j+1);
		}
		
		int ans1 = Math.min(1+getMinEditDist(s1, i, s2, j+1), 1+getMinEditDist(s1, i+1, s2, j));
		int ans2 = Math.min(ans1, 1+getMinEditDist(s1, i+1, s2, j+1));
		return ans2;
	}

}
