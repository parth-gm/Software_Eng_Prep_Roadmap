package Ch01_Arrays_Strings;

import java.util.HashMap;
import java.util.Scanner;

public class IsUnique {

	
	static boolean isUnique(String str)
	{
		if(str.length()>128) {
			return false;
		}
		
		boolean[] bool=new boolean[128];
		for(int i=0;i<str.length();i++) {
			int index=str.charAt(i);
			System.out.println(bool[index]);
			if(bool[index]) return false;
			bool[index]=true;
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		String checkS=scn.next();
	
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		boolean isUnique=true;
		char[] checkchar=checkS.toCharArray(); 
		for(char c:checkchar) {
			if(!map.containsKey(c)) {
				map.put(c,1);
			}
			else {
				if(map.get(c)==1)
				{
					isUnique=false;
				}
			}
		}
		
		System.out.println(isUnique(checkS));
		
	}

}
