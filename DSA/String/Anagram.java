package hackerrank;

public class Anagram {

    public  static final  int NUMBER_LETTERS=26;

    public  static int getDelta(int[] arr1,int[] arr2){

        if(arr1.length!=arr2.length)
            return -1;
        int delta=0;
        for(int i=0;i<arr1.length;i++){
            int diff=Math.abs(arr1[i]-arr2[i]);
            delta+=diff;
        }
        return  delta;
    }

    public static int[] getCharCounts(String s){
        int[] charCounts=new int[NUMBER_LETTERS];

        for(char c:s.toCharArray()){
            charCounts[c-'a']++;
        }
        return  charCounts;

    }

    public static void main(String[] args) {

        int[] s1=getCharCounts("hello");
        int[] s2=getCharCounts("billion");

        System.out.println(getDelta(s1,s2));

    }

}
