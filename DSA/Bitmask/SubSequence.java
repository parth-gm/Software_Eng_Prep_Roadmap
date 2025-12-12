package bitmasking;

import org.w3c.dom.ls.LSOutput;

public class SubSequence {

    static void filterChars(String str,int no){

        int i=0;
        while (no>0){
            if ((no & 1) != 0) {
                System.out.print(str.charAt(i));
            }
            i++;
            no=no>>1;
        }
        System.out.println();

    }

    static void generateSubsets(String str){
        int len=str.length();
        int range=(1<<len)-1;
        for(int i=0;i<=range;i++){
            filterChars(str,i);
        }
    }

    public static void main(String[] args) {
        generateSubsets("abc");
    }

}
