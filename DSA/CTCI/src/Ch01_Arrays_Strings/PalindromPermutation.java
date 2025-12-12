package Ch01_Arrays_Strings;

import java.util.HashMap;

public class PalindromPermutation {

	
	static boolean checkPP(String s1) {
		
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		char[] carray=s1.toCharArray();
		int count1=0;
		boolean isPP=true;
		for(int k=0;k<carray.length;k++)
		{
			if(!map.containsKey(carray[k])) map.put(carray[k], 1);
			else map.put(carray[k], map.get(carray[k])+1);
		}
		
		for(char c: map.keySet())
		{
			if(map.get(c)==2) continue;
			else if(map.get(c)==1 && count1==0)
				{count1++; continue;}
			else {isPP=false; break;} 
		}
		return isPP;
		
	}
	
	static int getCharNumber(char c)
	{
		int lower=Character.getNumericValue('a');
		int upper=Character.getNumericValue('z');
		int cnumber=Character.getNumericValue(c);
		if(cnumber>=lower && cnumber<=upper) return cnumber-lower;
		
		return -1;
	}
	
	static int[] createFrequencyTable(char charr[]) {
		int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		
		for(char c : charr) {
			int x= getCharNumber(c);
			if(x!=-1)
			{
				table[x]++;
			}
		}
		
		return table;
	}
	
	static boolean checkPP2(String s1) {
		//make a character frequency table
		int[] table= createFrequencyTable(s1.toCharArray());
		int countOdd=0;
		
		for(int i=0;i<table.length;i++)
		{
			if(table[i]%2==1)
				countOdd++;
			else
				countOdd--;
		}
		
		return countOdd<=1;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(checkPP("Zeus was deified, saw Suez".toLowerCase().replaceAll("\\s+","")));
		
		System.out.println(checkPP2("Zeus was deified, saw Suez"));
		System.out.println(checkPP2("Ratzs live on no evil starz"));
		
		System.out.println(Character.getNumericValue('A'));
	}

}
