package codesignal;

import java.util.HashMap;

public class FirstNonRepeatingChar {

    static char getFirstNonRepeate(String s){

        HashMap<Character,Integer> hm=new HashMap<>();

        for(int i=0;i<s.length();i++){

            if(hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            }else{
                hm.put(s.charAt(i),1);
            }
        }
        for(char c:hm.keySet()){
            if(hm.get(c)==1){
                return c;
            }
        }
        return '_';
    }

    static char getFirstNonRepeatev1(String s){
        int[] char_counts=new int[26];
        for(char c:s.toCharArray()){
            char_counts[c-'a']++;
        }
        for(char c:s.toCharArray()){
            if(char_counts[c-'a']==1){
                return  c;
            }
        }


        return '_';
    }

    static char getFirstNonRepeatev2(String s){
        for(char c:s.toCharArray()){
            if(s.indexOf(c)==s.lastIndexOf(c)){
                return c;
            }
        }

        return '_';
    }


    public static void main(String[] args) {

        System.out.println(getFirstNonRepeatev2("abcabcabcd"));

    }

}
