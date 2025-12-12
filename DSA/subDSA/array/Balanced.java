package array;


import java.io.*;
import java.util.*;
 
public class Balanced {
 
    static int BalancedStringBySwapping(String s)
    {
    	int close = 0, maxClose = 0 ;
    	for(char c: s.toCharArray()) {
    		if(c=='(') {
    			close--;
    		}
    		else
    		{
    			close++;
    		}
    		maxClose = Math.max(maxClose, close);
    		
    	}
       
    	if(close!=0)
    		return -1;
    	
    	return (maxClose+1)/2;
    	
    }
 
// Driver code
    public static void main(String[] args)
    {
 
        String s = "(())))(()(";
        System.out.println(BalancedStringBySwapping(s));
    }
 
}