package recursion;

import java.util.ArrayList;
import java.util.HashMap;

public class MobileKeyPad {

	static HashMap<Integer, String> map = new HashMap<>() {{
		put(2,"abc");
		put(3, "def");
		put(4, "ghi");
		put(5, "jkl");
		put(6, "mno");
		put(7, "pqrs");
		put(8, "tuv");
		put(9, "wxyz");
	}};
	
	
	
	public static void main(String[] args) {
		String keys = "234";
		int N = 3;
		ArrayList<String> words = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		allPossibleWords(0, N,  sb, words, keys);
		System.out.println(words);
		
	}



	private static void allPossibleWords(int current, int n, StringBuffer sb, ArrayList<String> words, String keys) {
		
		if(current==n) {
			words.add(sb.toString());
			return;
		}
		
		for(int i=0;i<map.get(keys.charAt(current)-'0').length();i++) {
			sb.append(map.get(keys.charAt(current)-'0').charAt(i));
			allPossibleWords(current+1, n, sb, words, keys);
			sb.deleteCharAt(sb.length()-1);
		}
		
		
	}
	
}
