package practice;

public class isSubSequence {

	
	static boolean isSubSequence(String s,String t) {
		
		int counter=0;
		for(int i=0;i<t.length();i++) {
			
			if(s.charAt(counter)==t.charAt(i))
			{
				counter++;
			}
			if(counter==s.length()) return true;
		}
		return false;
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isSubSequence("abcd","ahbgdcccccc"));
		

	}

}
