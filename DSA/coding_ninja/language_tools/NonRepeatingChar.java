package language_tools;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class NonRepeatingChar {

	static char nonRepeatingChar(String str) {
		
		LinkedHashMap<Character, Integer> lhmap = new LinkedHashMap<>();
		for(int i=0;i<str.length();i++) {
			
			lhmap.put(str.charAt(i), lhmap.getOrDefault(str.charAt(i), 0)+1);
		}
		Iterator<Character> itr = lhmap.keySet().iterator();
		System.out.println(lhmap);
		while(itr.hasNext()) {
			char key = itr.next();
			if(lhmap.get(key)==1) {
				return key;
				
			}
		}
		
	
		return str.charAt(0);
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(nonRepeatingChar("abbacb"));
	}

}
