package strings;

import java.util.HashMap;
import java.util.Map;

public class LogestPalByConcatTwoChar {

	public static int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int lenOfLongPal = 0;
        for(int i=0;i<words.length;i++){
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        boolean isSameLetterOccurred = false;
        System.out.println(map);
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            char first = key.charAt(0);
            char second = key.charAt(1);
            if(first==second && value==1 && isSameLetterOccurred){
                isSameLetterOccurred = true;
                continue;
            }
            String reverse = new String(first+second+"");
            System.out.println(key);
            System.out.println(value);
            System.out.println(reverse);
            
            System.out.println(key.equals(reverse));
            System.out.println(map.getOrDefault(reverse, 0));
            
            
            lenOfLongPal += 2*Math.min(value, map.getOrDefault(second+first+"", 0));
        }
        return lenOfLongPal/2;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"lc","cl","gg"};
		System.out.println(longestPalindrome(strs));
	}

}
