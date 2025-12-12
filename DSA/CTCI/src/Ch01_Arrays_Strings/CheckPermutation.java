package Ch01_Arrays_Strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CheckPermutation {

	
	static boolean checkPermutation(String givenStr, String tocheckStr)
	{
		//Implementation first NlogN
		
		/*
		char givens[]=givenStr.toCharArray();
		char checks[]=tocheckStr.toCharArray();
		
		Arrays.sort(givens);
		Arrays.sort(checks);
		givenStr=new String(givens);
		tocheckStr=new String(givens);
		
		if(givenStr.equals(tocheckStr)) return true;
		else return false;
		*/
		
		//Implementation using hashmap 
		/*
		HashMap<Character, Integer> mapgiven=new HashMap<Character, Integer>();
		HashMap<Character, Integer> mapcheck=new HashMap<Character, Integer>();
		
		
		if(givenStr.length()!=tocheckStr.length())
			return false;
		
		for(int i=0;i<givenStr.length();i++)
		{
			char c= givenStr.charAt(i);
			
			if(!mapgiven.containsKey(c)) mapgiven.put(c, 1);
			else mapgiven.put(c, mapgiven.get(c)+1);
			
		}
		
		for(int i=0;i<tocheckStr.length();i++)
		{
			char c= tocheckStr.charAt(i);
			
			if(!mapcheck.containsKey(c)) mapcheck.put(c, 1);
			else mapcheck.put(c, mapcheck.get(c)+1);
			
		}
		
		if(mapgiven.equals(mapcheck)) return true;
		else return false;
		
		*/
		
		//Implementation using single array

		if(givenStr.length()!=tocheckStr.length())
			return false;
		
		
		int array[]=new int[128];
		
		for(int i=0;i<givenStr.length();i++)
		{
			array[givenStr.charAt(i)]++;
		}
		
		for(int j=0;j<givenStr.length();j++)
		{
			array[tocheckStr.charAt(j)]--;
			if(array[tocheckStr.charAt(j)]<0) return false;
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPermutation("sss", "sss"));
	}

}
