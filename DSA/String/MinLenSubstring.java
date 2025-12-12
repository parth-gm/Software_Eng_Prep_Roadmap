package gfg;

import java.util.HashMap;
/*
Given two strings:

str → the source string

pat → the pattern string

Find the smallest substring of str that contains all the characters of pat including duplicates.
*/


public class MinLenSubstring {

    static String findMatch(String str, String pat) {

        //HashMap<Character,Integer> strHash=new HashMap<Character, Integer>();
        int[] strHash = new int[256];
        int[] patHash = new int[256];

        //HashMap<Character,Integer> patHash=new HashMap<Character, Integer>();

//		for(int i=0;i<str.length();i++) {
//			strHash.put(str.charAt(i),strHash.getOrDefault(strHash.get(str.charAt(i))+1, 1));
//		}

        for (int i = 0; i < pat.length(); i++) {
            patHash[pat.charAt(i)]++;
        }

        int min = Integer.MAX_VALUE;
        int start = 0, front = -1;
        int count = 0;

        for (int j = 0; j < str.length(); j++) {

            strHash[str.charAt(j)]++;

            if (patHash[str.charAt(j)] > 0 && strHash[str.charAt(j)] < patHash[str.charAt(j)]) ;
            {
                count++;
            }
            if (count == pat.length()) {
                while (patHash[str.charAt(start)] == 0 || patHash[str.charAt(start)] < strHash[str.charAt(start)]) {

                    if (patHash[str.charAt(start)] < strHash[str.charAt(start)]) {
                        strHash[str.charAt(start)]--;
                    }
                    start++;

                }
                int len = j - start + 1;
                if (min > len) {
                    min = len;
                    front = start;
                }

            }

        }
        System.out.println(start + " " + min);

        return front == -1 ? "" : str.substring(front, front + min);


    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(findMatch("this is a test string", "tist"));
    }

}
