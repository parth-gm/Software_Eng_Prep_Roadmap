package array;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

	static String encode(List<String> strList) {
		StringBuffer sb = new StringBuffer();
		for(String str: strList) {
			sb.append(str.length()+"#");
			sb.append(str);
		}
		
		return sb.toString();
		
	}
	

	static List<String> decode(String str) {
		List<String> ls = new ArrayList<String>();
		
		StringBuffer sb = new StringBuffer();
		int idx = 0;
		StringBuffer lenS = new StringBuffer();
		
		while(idx< str.length()) {
			int lenLast = str.indexOf('#', idx);
			
			int lenInt = Integer.parseInt(str.substring(idx, lenLast));
			
			ls.add(str.substring(lenLast+1, lenLast+lenInt+1));
			idx = lenLast+lenInt+1;
			System.out.println(idx);
			lenS.setLength(0);
		}
		
		return ls;
		
	}
	
	public static void main(String[] args) {
		List<String> encodeLs = new ArrayList<>();
		encodeLs.add("abc");
		encodeLs.add("def");
		encodeLs.add("ghi");
		
		String encoded = encode(encodeLs);
		System.out.println(encoded);
		System.out.println(decode(encoded));
		

	}

}
