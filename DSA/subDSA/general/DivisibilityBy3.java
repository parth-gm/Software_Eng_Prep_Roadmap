package  test;

public class DivisibilityBy3 {
	
	public static int getSumOfDigits(String s) {
		int n = Integer.parseInt(s);
		int sum =0;
		while(n>0) {
			sum+=n%10;
			n = n/10;
		}
		return sum;
	}
	
	public static int solution(String S) {
	      
		  int sumOfdigits = getSumOfDigits(S);
		  int result = sumOfdigits%3==0?1:0;
		  for(int i=0;i<S.length();i++) {
			  
			  
			  int currentDigit = Character.getNumericValue(S.charAt(i));
			  int remainSum = sumOfdigits - currentDigit; 
			  for(int d = 0;d<=9;d++) {
				  if(currentDigit==d)
					  continue;
				
				  if((remainSum+d)%3==0)
					  result++;
				  
			  }
			  
		  }
		  
		  return result;
	  }
	
	public static int solutionOptimized(String S) {

		int sumOfdigits = getSumOfDigits(S);

		int sum = 0; 
		
		if(sumOfdigits%3==0)
		{
			for(int i=0;i<S.length();i++) {
				
				if((Character.getNumericValue(S.charAt(i))%3)!=0) {
					sum+=3;
				}
				else 
				{
					sum+=4;
				}
			}
			sum = sum - S.length() +1;
		}
		else {
			for(int i=0;i<S.length();i++) {
								
				if((Character.getNumericValue(S.charAt(i))%3)==(sumOfdigits%3)) {
					sum+=4;
				}
				else 
				{
					sum+=3;
				}
			}
		}
		return sum;
		
	}
	  
	  public static void main(String[] args) {
//		  System.out.println(getSumOfDigits("1111"));
//		  System.out.println(Integer.parseInt("02"));
		  System.out.println(solution("0081"));
		  System.out.println(solution("022"));
		  System.out.println(solution("55"));
		  System.out.println(solution("0"));
		  
		  
		  System.out.println(solutionOptimized("0081"));
		  System.out.println(solutionOptimized("022"));
		  System.out.println(solutionOptimized("55"));
		  System.out.println(solutionOptimized("0"));
	  
	  }
}
