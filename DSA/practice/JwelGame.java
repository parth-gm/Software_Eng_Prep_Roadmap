package practice;

public class JwelGame {

	 public static int getMaxScore(String jewels) {
		    // Write your code here
		 
		 
		 char stack[]=new char[jewels.length()];
		 
		 int i=0;
		 int count=0;
		 for(int j=0;j<jewels.length();j++) {
			 
			 
			 char current_char=jewels.charAt(j);
			 
			 if(i>0 && stack[i-1]==current_char) {
				 i--;
				 count++;
			 }else {
				 stack[i]=current_char;
				 i++;
			 }

		 }
		 
		 return count;
		
		        

	 }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getMaxScore("abcd"));
		
		
	}

}
