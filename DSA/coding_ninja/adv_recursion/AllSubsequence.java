package adv_recursion;

public class AllSubsequence {

	
	
	static int allSubsequenceRec(String str, String[] output) {
		
		if(str.length()==0) {
			output[0] ="";
			return 1;
		}
		
		String smallerString = str.substring(1);
		int smallOutLen = allSubsequenceRec(smallerString, output);
		
		for(int i=0;i<smallOutLen;i++) {
			output[i+smallOutLen] = str.charAt(0)+output[i];
		}
		return smallOutLen*2;
		
	}
	
	static void printAllSubseqV2(String input, String output) {
		
		if(input.length()==0) {
			System.out.println(output);
			return;
		}
		
		printAllSubseqV2(input.substring(1), output);
		printAllSubseqV2(input.substring(1), output+input.charAt(0));
		
	}
	
	public static void main(String[] args) {
		String test = "abcd";
		
		printAllSubseqV2(test, "");
		
		
		
//		int len = (int)Math.pow(2, test.length());
//		String output[] = new String[len];
//		allSubsequenceRec(test, output);
//		for(String s:output) {
//			System.out.println(s);
//		}
	}

}
