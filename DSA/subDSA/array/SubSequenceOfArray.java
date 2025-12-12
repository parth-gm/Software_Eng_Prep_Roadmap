package array;

import java.util.Arrays;
import java.util.List;

public class SubSequenceOfArray {

	public static void main(String[] args) {
//		String[] arr = {"un","iq","ue"};
		String[] arr = {"cha","r","act","ers"};
//		String[] arr = {"aa", "bb"};
		List<String> list = Arrays.asList(arr);
		getAllSubSequence(list, 0, "");
		System.out.println(maxUniqueLength);
//		getAllSubSequence("abcd", "");

	}

	 static boolean isUnique(String a, String b) {
			char[] arr = new char[26];
			for(int i=0;i<a.length();i++) {
				if(arr[a.charAt(i)-'a']>0){
	                return false;
	            }else{
	                arr[a.charAt(i)-'a']++;
	            }
			}
			for(int i=0;i<b.length();i++) {
				if(arr[b.charAt(i)-'a']>0) {
					return false;
				}else{
	                arr[b.charAt(i)-'a']++;
	            }
			}
			return true;
	}
	
	static int maxUniqueLength = -1;
	private static void getAllSubSequence(List<String> list, int cur, String form) {
		
		if(cur==list.size()) {
			maxUniqueLength = Math.max(maxUniqueLength, form.length());
			return;
		}
		if(isUnique(form, list.get(cur)))
			getAllSubSequence(list, cur+1, form+list.get(cur));
		getAllSubSequence(list, cur+1, form);
		
	}

	private static void getAllSubSequence(String string, String form) {
		
		if(string.length()==0)
		{
			System.out.println(form);
			return;
		}
		
		getAllSubSequence(string.substring(1), form+string.charAt(0));
		getAllSubSequence(string.substring(1), form);
		
		
	}

}
