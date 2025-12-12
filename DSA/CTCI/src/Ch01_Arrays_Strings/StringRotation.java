package Ch01_Arrays_Strings;

public class StringRotation {

	
	static boolean isSubString(String str,String sub) {
		return str.contains(sub);
	}
	
	static boolean isRotation(String s1,String s2) {
		if(s1.length()!=s2.length()) return false;
		
		String news2=s2.concat(s2);
		return isSubString(news2, s1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isRotation("wakerbottle", "tlewaterbot"));
	}

}
