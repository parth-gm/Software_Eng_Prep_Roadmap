package questions;

import java.util.HashMap;
import java.util.TreeMap;

public class Int2Roman {
	
	static String int2Roman(int number)
	{
		TreeMap<Integer, String> hm =new TreeMap<>();
		hm.put(1, "I");
		hm.put(4, "IV");
		hm.put(5, "V");
		hm.put(9, "IX");
		hm.put(10, "X");
		hm.put(40, "XL");
		hm.put(50, "L");
		hm.put(90, "XC");
		hm.put(100, "C");
		hm.put(400, "CD");
		hm.put(500, "D");
		hm.put(900, "CM");
		hm.put(1000, "M");
		
		StringBuilder sb =new StringBuilder();
		while(number>0)
		{
			Integer op = hm.floorKey(number);
			sb.append(hm.get(op));
			number = number - op;
		}
		return sb.toString();

		
	}
	
	public static void main(String args[])
	{
		System.out.println(int2Roman(76));
	}

}
