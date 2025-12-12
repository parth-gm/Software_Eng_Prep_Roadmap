package dp;

public class WordBreak {

	public static void main(String[] args) {
		
		String s = "applepenapple";
		String[] wordDict = {"apple","pen"};

		System.out.println(isWordPossibleToForm(s, wordDict));
	}

	private static boolean isWordPossibleToForm(String s, String[] wordDict) {
		System.out.println(s);
		if(s.length()==0) {
			return true;
		}
		
		for(String word:wordDict) {
			
			if(s.startsWith(word)) {
				if(isWordPossibleToForm(s.substring(word.length()), wordDict)) {
					return true;
				}
			}
			
		}
		return false;
		
	}

}
