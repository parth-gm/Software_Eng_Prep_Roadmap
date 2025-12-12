package recursion;

import java.util.ArrayList;

public class PalindromPartitioning {

	static void partitionRecursion(String str, ArrayList<String> arrl) {
		
		if(str.length()==0) {
			System.out.println(arrl);
			return;
		}
		
		for(int i=1;i<=str.length();i++) {
			
			String partString = str.substring(0, i);
			if(isPalindrom(partString)) {
				arrl.add(partString);
				partitionRecursion(str.substring(i), arrl);
				arrl.remove(arrl.size()-1);
			}
			
		}
		
		
		
	}
	
	private static boolean isPalindrom(String partString) {
		int len = partString.length();
		if(len==0 || len==1)
			return true;
		int l = 0, r = len-1;
		while(l<r) {
			if(partString.charAt(l)!=partString.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}

	public static void main(String[] args) {
		
		System.out.println(isPalindrom("aba"));
		ArrayList<String> res = new ArrayList<String>();
		
		partitionRecursion("aaab", res);
		
	}

}
